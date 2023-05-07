package io.github.muammercaki.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.appium.java_client.AppiumBy.*;

public class LoginScreen extends BaseScreen {

    private final By headerTextLocator = xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView");
    private final By usernameInputFieldLocator = accessibilityId("test-Username");
    private final By passwordInputFieldLocator = accessibilityId("test-Password");
    private final By loginButtonLocator = accessibilityId("test-LOGIN");

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return getText(headerTextLocator);
    }

    public void doLogin(String username, String password) {
        sendKeys(usernameInputFieldLocator, username);
        sendKeys(passwordInputFieldLocator, password);
        click(loginButtonLocator);
    }
}