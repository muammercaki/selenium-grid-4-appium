package io.github.muammercaki.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.appium.java_client.AppiumBy.*;

public class MainScreen extends BaseScreen {

    private final By openMenuButtonLocator = accessibilityId("test-Menu");
    private final By loginMenuItemCloseLocator = accessibilityId("test-Close");
    private final By afterLoginProductsLocator = xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView");

    public MainScreen(WebDriver driver) {
        super(driver);
    }

    public MainScreen openMenu() {
        click(openMenuButtonLocator);
        return this;
    }

    public void goToLoginPage() {
        click(loginMenuItemCloseLocator);
    }

    public String getProductListText() {
        return getText(afterLoginProductsLocator);
    }

}
