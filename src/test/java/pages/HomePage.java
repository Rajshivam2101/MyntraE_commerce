package pages;

import assertutil.AssertUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.WaitsUtil;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ MUST
    }

    @FindBy(xpath = "//span[@class='a-size-base a-color-base']")
    private WebElement title;



    public void getTitle() {

        try {
            WaitsUtil.waitForVisibility(driver, title, 10);
            AssertUtil.assertEquals(title.getText(), "You are on amazon.com. You can also shop on Amazon India for millions of products with fast local delivery.", "Pass");
            System.out.println("Title: " + title.getText());
        } catch (Exception e) {
            System.out.println("Title is not found");
        }
    }


}
