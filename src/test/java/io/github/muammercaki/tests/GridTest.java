package io.github.muammercaki.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {
    private final String gridUrl = "http://localhost:8888";

    @Test
    public void firefoxTest() throws MalformedURLException {
        URL gridUrl = new URL(this.gridUrl);
        RemoteWebDriver driver = new RemoteWebDriver(gridUrl, setOptions(new FirefoxOptions()));
        try {
            navigate(driver);
        } finally {
            driver.quit();
        }
    }

    public void navigate(RemoteWebDriver driver) {
        driver.get("https://teknasyon.com");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        assertThat(pageTitle).isEqualTo("Teknasyon");
    }

    private MutableCapabilities setOptions(MutableCapabilities options) {
        options.setCapability("se:recordVideo:", true);
        options.setCapability("se:timeZone:", "UTC +3");
        options.setCapability("se:screenResolution:", "1920x1080");
        options.setCapability("se:name:", "Selenium grid 4 sample test");
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        return options;
    }

}
