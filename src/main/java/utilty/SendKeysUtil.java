package utilty;

import org.openqa.selenium.WebElement;

public class SendKeysUtil {

    public static void sendKeys(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            System.out.println("Unable to enter value: " + value + " into element");
            throw e;
        }
    }
}
