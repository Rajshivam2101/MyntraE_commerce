package tests;


import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;


public class ProductDetailsTest extends BaseTest {


    @Test()
    public void productDetails() {
        ProductDetailsPage productDetailsTest = new ProductDetailsPage(getDriver());
        productDetailsTest.ItemList();
    }

}
