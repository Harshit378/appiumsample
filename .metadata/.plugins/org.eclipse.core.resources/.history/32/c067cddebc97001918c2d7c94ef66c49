package browser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public abstract class DriverManager {

	protected AndroidDriver<AndroidElement> driver;

	protected abstract void startService();

	protected abstract void stopService();

	protected abstract void createDriver();

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}

	}

	public AndroidDriver getDriver() {
		if (null == driver) {
			startService();
			createDriver();
		}
		return driver;
	}
}