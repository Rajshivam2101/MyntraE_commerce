package drivermanager;

import enumeration.ConfigKey;
import configureloader.ConfigLoader;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilty.LoggerUtil;

public class DriverManager {
    @Getter
    public static WebDriver driver;

    public static void initDriver(String browser) {
        String brows = ConfigLoader.get(ConfigKey.BROWSER);
        openBrowser(brows);

    }

    public static void openBrowser(String BrowserName) {

        switch (BrowserName) {

            case "chrome":
                ChromeOptions chromeOptions = getChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = getEdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;


            case "firefox":
                FirefoxOptions firefoxOptions = getFirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;


            default:
                driver = new ChromeDriver(getChromeOptions());

        }
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-dev-shm-usage");
//        chromeOptions.addArguments("--disable-popup-blocking");
//        chromeOptions.addArguments("--disable-extensions");
//        chromeOptions.addArguments("--no-sandbox");

        return chromeOptions;

    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        return edgeOptions;

    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--start-maximized");
        return firefoxOptions;


    }

    public static void applicationOpen() {
        System.out.println("Application Started");
        String url = ConfigLoader.get(ConfigKey.URL);
        driver.get(url);
    }

//    public static void close() {
//
//        if (driver != null) {
//            LoggerUtil.info("Browser Closing");
//            driver.quit();
//
//
//        }
//    }

}

