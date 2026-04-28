package utilty;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsUtil {
    static WebDriver driver;


    WaitsUtil(WebDriver driver) {
        WaitsUtil.driver = driver;

    }


    // ---------------- IMPLICIT WAIT ----------------
    public static void implicitWait(WebDriver driver, int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }


    // ---------------- EXPLICIT WAIT ----------------
    public static WebElement waitForVisibility(
            WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(
            WebDriver driver,
            WebElement element,
            int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPresence(
            WebDriver driver,
            By locator,
            int seconds) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Hard Wait Method
    public static void hardWait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ---------------- TEXT TO BE PRESENT ----------------
    public static boolean waitForTextToBePresent(
            WebDriver driver,
            WebElement element,
            String text,
            int seconds) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(seconds));

        return wait.until(
                ExpectedConditions.textToBePresentInElement(element, text)
        );
    }

    public static boolean waitForInvisibility(
            WebDriver driver,
            WebElement element,
            int seconds) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(seconds));

        return wait.until(
                ExpectedConditions.invisibilityOf(element)
        );
    }

// ---------------- GENERIC FLUENT WAIT ----------------

    public static WebElement fluentWaitForElement(
            WebDriver driver,
            By locator,
            int timeoutSeconds,
            int pollingSeconds) {

        FluentWait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(timeoutSeconds))
                        .pollingEvery(Duration.ofSeconds(pollingSeconds))
                        .ignoring(NoSuchElementException.class)
                        .ignoring(StaleElementReferenceException.class);

//        return wait.until(ExpectedConditions.elementToBeClickable(locator));


        return wait.until(driver1 -> driver1.findElement(locator));

    }

    public static WebElement fluentWaitForClickable(
            WebDriver driver,
            WebElement element,
            int timeoutSeconds,
            int pollingSeconds) {

        FluentWait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(timeoutSeconds))
                        .pollingEvery(Duration.ofSeconds(pollingSeconds))
                        .ignoring(NoSuchElementException.class)
                        .ignoring(StaleElementReferenceException.class);

        return wait.until(driver1 -> {
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }
            return null;
        });


    }

}

