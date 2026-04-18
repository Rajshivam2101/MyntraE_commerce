package pages;

import assertutil.AssertUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.SelectUtil;
import utilty.WaitsUtil;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ MUST
    }

    @FindBy(xpath = "//div//span[@class='b3wTlE']")
    private WebElement loginAlert;

    @FindBy(xpath = "//div[@class='a4jtpw']//div//h1")
    private WebElement validation;


    public void loginSkip() {
        try {
            WaitsUtil.waitForVisibility(driver, loginAlert, 10);
            loginAlert.click();
        } catch (Exception e) {
            System.out.println("Alert is handled");
        }
    }

    public void validateScreen() {
        SelectUtil.handleAlertIfPresent(driver);
        WaitsUtil.waitForVisibility(driver, validation, 10);
        String webSite = validation.getText();
        AssertUtil.assertEquals(webSite, "Flipkart: India's Ultimate One-Stop Online Shopping Destination", "pass");
        System.out.println("WebSite Name:" + webSite);

    }
}
