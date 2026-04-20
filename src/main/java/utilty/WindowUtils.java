package utilty;


import drivermanager.DriverManager;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtils {

    private static WebDriver driver = DriverManager.getDriver();

    // Get current window ID
    public static String getParentWindow() {
        return driver.getWindowHandle();
    }

    // Switch to new window
    public static void switchToNewWindow(String parentWindow) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // Switch to specific window
    public static void switchToWindow(String windowId) {
        driver.switchTo().window(windowId);
    }

    // Switch to window by index
    public static void switchToWindowByIndex(int index) {
        Set<String> windows = driver.getWindowHandles();
        int i = 0;
        for (String window : windows) {
            if (i == index) {
                driver.switchTo().window(window);
                break;
            }
            i++;
        }
    }

    // Close current window
    public static void closeCurrentWindow() {
        driver.close();
    }

    // Switch back to parent
    public static void switchToParentWindow(String parentWindow) {
        driver.switchTo().window(parentWindow);
    }

    // Close all child windows
    public static void closeAllChildWindows(String parentWindow) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
    }


    public static void switchToWindow(WebDriver driver, String expectedUrlPart) {
        String parentHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();

        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains(expectedUrlPart)) {
                return;
            }
        }

        // If not found, switch back to parent
        driver.switchTo().window(parentHandle);
        throw new NoSuchWindowException("No window found with URL containing: " + expectedUrlPart);
    }
}