package utilty;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static utilty.WaitsUtil.driver;

public class SelectUtil {


    //==========================================Select Class Common Methods===================================
    public static void selectRandomOption(WebElement dropdown) {

        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();

        if (options.size() <= 1) {
            throw new RuntimeException("Dropdown has no selectable options");
        }

        Random random = new Random();

        // Skip first option if it's like "Select"
        int randomIndex = random.nextInt(options.size() - 1) + 1;

        select.selectByIndex(randomIndex);

        System.out.println(options.get(randomIndex).getText());
    }


    // ---------------- DROPDOWN SELECT ----------------

    public static void selectByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // ---------------- CUSTOM LIST SELECT ----------------
    public static void selectFromList(
            List<WebElement> elements,
            String expectedText) {

        for (WebElement element : elements) {
            if (element.getText().trim().equalsIgnoreCase(expectedText)) {
                element.click();
                return;
            }
        }
        throw new RuntimeException(
                "Value '" + expectedText + "' not found in list");
    }

    //==================================AutoSelect==========================================
    public static void selectFromAutoSuggest(
            WebDriver driver,
            WebElement inputField,
            List<WebElement> suggestionList,
            String valueToSelect) {

        inputField.clear();
        inputField.sendKeys(valueToSelect);

        WaitsUtil.waitForVisibility(driver, suggestionList.get(0), 10);

        for (WebElement option : suggestionList) {
            String text = option.getText().trim();
            if (text.equalsIgnoreCase(valueToSelect)) {
                option.click();
                return;
            }
        }
        throw new RuntimeException(
                "Auto-suggest value not found: " + valueToSelect
        );
    }

    //==================================AutoSelect==========================================
    public void selectRandomFromAutocomplete(By inputField, By suggestionList) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Click and type something (optional)
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputField));
        input.click();

        // Wait for suggestions
        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionList));

        // Select random option
        Random random = new Random();
        int index = random.nextInt(options.size());

        WebElement selectedOption = options.get(index);

        String doctorName = selectedOption.getText();

        selectedOption.click();

        System.out.println("Selected Doctor: " + doctorName);
    }

    public static void selectDropdown(WebDriver driver, String id, String value) {
        WebElement element = driver.findElement(By.xpath("//td//select[@class=' dropdown'  and  @id='" + id + "']"));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectDropdownWithoutSpace(WebDriver driver, String id, String value) {
        WebElement element = driver.findElement(By.xpath("//td//select[@class='dropdown'  and  @id='" + id + "']"));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void enterText(WebDriver driver, String id, String value) {

        WebElement element = driver.findElement(By.xpath("//input[@class='field' and @name = '" + id + "']"));
        element.clear();
        element.sendKeys(value);
    }

    public static void enterTextField(WebDriver driver, String id, String value) {

        WebElement element = driver.findElement(By.xpath("//input[@class='filed' and @name = '" + id + "']"));
        element.clear();
        element.sendKeys(value);
    }

    public static void selectBedTypeWithAvailableBedsWards(WebDriver driver, WebElement dropdownElement) {

        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();

        for (int i = 1; i < options.size(); i++) {

            try {
                select = new Select(dropdownElement);
                select.selectByIndex(i);

                String bedTypeName = options.get(i).getText();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

                try {
                    // Alert = NO beds
                    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

                    System.out.println("No beds for: " + bedTypeName);
                    alert.accept();

                } catch (Exception e) {
                    // No alert = beds available → STOP
                    System.out.println("Bed available for: " + bedTypeName);
                    return;
                }

            } catch (Exception e) {
                System.out.println("Error selecting bed type: " + e.getMessage());
            }
        }

        //  Throw only AFTER loop completes
        throw new RuntimeException("No bed type with available beds found");
    }

    public static void handleAlert(WebDriver driver, String action) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            if (action.equalsIgnoreCase("accept")) {
                alert.accept();
            } else if (action.equalsIgnoreCase("dismiss")) {
                alert.dismiss();
            }

        } catch (TimeoutException e) {
            System.out.println("No alert present");
        }
    }

    public static void handleAlertIfPresent(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept(); // or alert.dismiss();
        } catch (TimeoutException e) {
            // No alert present, do nothing
            System.out.println("No alert present");
        }
    }
}
