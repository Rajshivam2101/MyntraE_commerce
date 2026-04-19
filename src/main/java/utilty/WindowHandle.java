package utilty;

import java.util.Set;

import static drivermanager.DriverManager.driver;

public class WindowHandle {


    public static void switchToNewWindow() {
        String parent = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
}
