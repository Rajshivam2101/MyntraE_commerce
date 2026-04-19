package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {


    @Test()
    public void userLoginIntoApplication() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginDetails();
        loginPage.userName();
        loginPage.password();
    }
}
