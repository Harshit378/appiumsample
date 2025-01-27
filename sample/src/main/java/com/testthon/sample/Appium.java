package com.testthon.sample;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium {

	AndroidDriver<AndroidElement> driver;

	@BeforeClass
	public void setUp() throws Exception {

//location of the app
		File app = new File("F:\\Projects\\AppiumProject\\Flipkart_V6.15.apk");

		// To create an object of Desired Capabilities
		DesiredCapabilities capability = new DesiredCapabilities();
//OS Name
		capability.setCapability("device", "Android");
		capability.setCapability(CapabilityType.BROWSER_NAME, "");
//Mobile OS version. In My case its running on Android 4.2
		capability.setCapability(CapabilityType.VERSION, "9");
		//capability.setCapability("app", app.getAbsolutePath());
//To Setup the device name
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "HarshitEmulator");
		capability.setCapability("platformName", "Android");
//set the package name of the app
		capability.setCapability("app-package", "org.chromium.webview_shell");
		// set the Launcher activity name of the app
		capability.setCapability("app-activity", "org.chromium.webview_shell.WebViewBrowserActivity");
//driver object with new Url and Capabilities
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		
		
	}

	@Test
	public void testApp() throws MalformedURLException, InterruptedException {

		Thread.sleep(8000);
		
		System.out.println("App launched");
		// locate Add Contact button and click it

		WebElement addContactButton = driver.findElementByXPath(("org.chromium.webview_shell:id/url_field"));
		
		Thread.sleep(3000);
		
		addContactButton.click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@text='NONE OF THE ABOVE']")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("9652715670");
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@text='SIGN UP']")).click();
		
		Thread.sleep(3000);
	}
}