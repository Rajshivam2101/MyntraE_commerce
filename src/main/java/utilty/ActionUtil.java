package utilty;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtil {

    // ---------------- EQUALS ----------------


    //==========================================Action Class Common Methods===================================
    public static void clickByAction(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .build()
                .perform();
    }

    public static void click(WebDriver driver, WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .click()
                .build()
                .perform();
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        new Actions(driver)
                .doubleClick(element)
                .build()
                .perform();
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        new Actions(driver)
                .contextClick(element)
                .build()
                .perform();
    }

    // ---------------- DRAG & DROP ----------------

    public static void dragAndDrop(
            WebDriver driver,
            WebElement source,
            WebElement target) {

        new Actions(driver)
                .dragAndDrop(source, target)
                .build()
                .perform();
    }

    // ---------------- KEYBOARD ACTIONS ----------------

    public static void sendKeys(
            WebDriver driver,
            WebElement element,
            String text) {

        new Actions(driver)
                .click(element)
                .sendKeys(text)
                .build()
                .perform();
    }

    public static void keyDown(
            WebDriver driver,
            Keys key) {

        new Actions(driver)
                .keyDown(key)
                .build()
                .perform();
    }

    public static void keyUp(
            WebDriver driver,
            Keys key) {

        new Actions(driver)
                .keyUp(key)
                .build()
                .perform();
    }

    public static void pressEnter(WebDriver driver) {
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    // ---------------- SCROLL ACTIONS ----------------

    public static void scrollToElement(
            WebDriver driver,
            WebElement element) {

        new Actions(driver)
                .scrollToElement(element)
                .build()
                .perform();
    }

    public static void scrollByOffset(WebDriver driver, int x, int y) {
        new Actions(driver).scrollByAmount(x, y).build().perform();
    }
}

