package base;

import drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        DriverManager.initDriver(browser);
        DriverManager.applicationOpen();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.close();
    }

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
