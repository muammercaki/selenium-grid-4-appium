package io.github.muammercaki.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    public WebDriver driver;

    @BeforeMethod
    @Parameters(value = {"udid", "platformVersion"})
    public void setUp(String udid, String platformVersion) throws MalformedURLException {

        URL url = new URL("https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        final UiAutomator2Options options = new UiAutomator2Options().setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setApp(url)
                .fullReset()
                .setAppWaitActivity("com.swaglabsmobileapp.MainActivity");

        DRIVER_THREAD_LOCAL.set(new AndroidDriver(options));
        driver = DRIVER_THREAD_LOCAL.get();
    }

    @AfterMethod(alwaysRun = true)
    public synchronized void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
