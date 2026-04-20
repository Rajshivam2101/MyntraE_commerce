

package utilty;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtils {

    private static final Robot robot;

    static {
        try {
            robot = new Robot();
            robot.setAutoDelay(100);
        } catch (AWTException e) {
            throw new RuntimeException("Robot class initialization failed");
        }
    }

    // Press a single key
    public static void pressKey(int key) {
        robot.keyPress(key);
        robot.keyRelease(key);
    }

    // Type a string (basic)
    public static void typeString(String text) {
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }

    // CTRL + key (like Ctrl+C, Ctrl+V)
    public static void pressCtrlPlusKey(int key) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(key);
        robot.keyRelease(key);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    // ALT + key
    public static void pressAltPlusKey(int key) {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(key);
        robot.keyRelease(key);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    // ENTER key
    public static void pressEnter() {
        pressKey(KeyEvent.VK_ENTER);
    }

    // TAB key
    public static void pressTab() {
        pressKey(KeyEvent.VK_TAB);
    }

    // ESC key
    public static void pressEscape() {
        pressKey(KeyEvent.VK_ESCAPE);
    }

    // File upload using clipboard (important use-case)
    public static void uploadFile(String filePath) {
        try {
            // Copy path to clipboard
            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            // CTRL + V
            pressCtrlPlusKey(KeyEvent.VK_V);

            // ENTER
            pressEnter();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

