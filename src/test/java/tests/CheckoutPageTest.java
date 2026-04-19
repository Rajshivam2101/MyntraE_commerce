package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CheckoutPage;

import static base.BaseTest.getDriver;

public class CheckoutPageTest {

    WebDriver driver;

    @Test()
    public void CheckoutPageTest() {
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.proceedToCheckout();
    }

}
