package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.WaitsUtil;

public class CheckoutPage extends BaseTest {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@id='desktop-ptc-button-']//span//input[@class='a-button-input']")
    private WebElement proceed;

    @FindBy(xpath = "//div[@id='nav-logo']")
    private WebElement backHomePage;


    public void proceedToCheckout() {
        WaitsUtil.waitForClickable(driver, proceed, 10);
        proceed.click();
    }

    public void backToHomePage() {
        WaitsUtil.waitForVisibility(driver, backHomePage, 10);
        backHomePage.click();
    }


}
