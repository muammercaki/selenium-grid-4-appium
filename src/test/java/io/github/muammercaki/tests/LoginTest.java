package io.github.muammercaki.tests;

import io.github.muammercaki.screens.LoginScreen;
import io.github.muammercaki.screens.MainScreen;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        MainScreen mainScreen = new MainScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        System.out.println(loginScreen.getHeaderText());
        assertThat(loginScreen.getHeaderText()).isEqualTo("LOGIN");
        loginScreen.doLogin("standard_user", "secret_sauce");
        mainScreen.openMenu().goToLoginPage();
        assertThat(mainScreen.getProductListText()).isEqualTo("PRODUCTS");
    }
}