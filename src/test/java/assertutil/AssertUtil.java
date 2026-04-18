package assertutil;

import org.junit.Assert;

public class AssertUtil {

    // ---------------- EQUALS ----------------
    public static void assertEquals(
            String actual,
            String expected,
            String message) {

        Assert.assertEquals(message, expected, actual);

    }

    // ---------------- TRUE ----------------
    public static void assertTrue(
            boolean condition) {

        Assert.assertTrue(condition);
    }

    // ---------------- FALSE ----------------
    public static void assertFalse(
            boolean condition,
            String message) {

        Assert.assertFalse(message, condition);
    }

    // ---------------- NOT NULL ----------------
    public static void assertNotNull(
            Object object,
            String message) {

        Assert.assertNotNull(message, object);
    }

    // ---------------- FAIL ----------------
    public static void fail(String message) {
        Assert.fail(message);
    }
}