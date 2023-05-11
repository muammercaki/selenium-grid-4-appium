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
    // public WebDriver driver;
    public AndroidDriver driver;
    private final String gridUrl = "http://localhost:4444";

    @BeforeMethod
    @Parameters(value = {"udid", "platformVersion"})
    public void setUp(String udid, String platformVersion) throws MalformedURLException {
        URL gridUrl = new URL(this.gridUrl);
       // URL url = new URL("");
        final UiAutomator2Options options = new UiAutomator2Options().setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setApp("https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
                .fullReset()
                .setAppWaitActivity("com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(gridUrl, options);
//        DRIVER_THREAD_LOCAL.set(new AndroidDriver(options));
//        driver = DRIVER_THREAD_LOCAL.get();
    }

    @AfterMethod(alwaysRun = true)
    public synchronized void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
