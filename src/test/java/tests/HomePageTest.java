package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {


    @Test()
    public void getTitleHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.getTitle();
    }
}
