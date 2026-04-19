package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.SendKeysUtil;
import utilty.WaitsUtil;

import javax.xml.xpath.XPath;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement enterInputField;


    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement clickSubmitButton;

    public void clickSearchButton() {

        WaitsUtil.waitForClickable(driver, enterInputField, 10);
        enterInputField.click();

        WaitsUtil.waitForClickable(driver, enterInputField, 10);
        SendKeysUtil.sendKeys(enterInputField, "samsung");

        WaitsUtil.waitForClickable(driver, clickSubmitButton, 10);
        clickSubmitButton.click();
    }


}
