package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartPageTest extends BaseTest {

    @Test()
    public void CartPageTest() {
        CartPage cartPage = new CartPage(getDriver());
        cartPage.onToCart();


    }
}
