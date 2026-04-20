package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.WaitsUtil;

import java.util.List;


public class ProductDetailsPage {
    WebDriver driver;


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal']/h2")
    private List<WebElement> itemList;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;


    public void ItemList() {
        for (WebElement itemLists : itemList) {

            WaitsUtil.waitForClickable(driver, itemLists, 10);
            itemLists.click();

            WaitsUtil.waitForClickable(driver, addToCartButton, 10);
            addToCartButton.click();
        }

    }
}

