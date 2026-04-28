package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.WaitsUtil;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='nav-cart-text-container']")
    private WebElement cart;


    public void onToCart() {
        WaitsUtil.waitForClickable(driver, cart, 10);
        cart.click();
        driver.switchTo().alert();
    }


}
