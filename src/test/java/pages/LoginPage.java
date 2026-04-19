package pages;


import configureloader.ConfigLoader;
import enumeration.ConfigKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.ActionUtil;
import utilty.WaitsUtil;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ MUST
    }


    @FindBy(xpath = "//div[@id='nav-link-accountList']")
    private WebElement accountList;

    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//a//span")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='ap_email_login']")
    private WebElement usernameInput;

    @FindBy(xpath = "//div//input[@id='ap_password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[@class='a-button-inner']//input")
    private WebElement submitButton;


    public void loginDetails() {

        WaitsUtil.waitForVisibility(driver, accountList, 10);
        ActionUtil.moveToElement(driver, accountList);

        WaitsUtil.waitForClickable(driver, accountList, 20);
        signInButton.click();

    }

    public void userName() {

        WaitsUtil.waitForClickable(driver, usernameInput, 10);
        String username = ConfigLoader.get(ConfigKey.USERNAME);
        usernameInput.sendKeys(username);

        WaitsUtil.waitForClickable(driver, submitButton, 10);
        submitButton.click();
    }

    public void password() {

        WaitsUtil.waitForClickable(driver, passwordInput, 10);
        String password = ConfigLoader.get(ConfigKey.PASSWORD);
        passwordInput.sendKeys(password);

        WaitsUtil.waitForClickable(driver, submitButton, 10);
        submitButton.click();
    }
}
