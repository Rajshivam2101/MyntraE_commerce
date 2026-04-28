package utilty;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorUtil {

    public static void jsClick(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
        WaitsUtil.implicitWait(driver, 15);
        js.executeScript("arguments[0].click;", element);

    }
}
