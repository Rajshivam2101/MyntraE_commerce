package tests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {

    @Epic("Authentication")
    @Feature("Login Feature")
    @Test(priority = 1)
    public void validateScreen() {
        HomePage homePage = new HomePage(getDriver());
        homePage.loginSkip();
        homePage.validateScreen();
    }
}
