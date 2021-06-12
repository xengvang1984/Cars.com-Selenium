package com.cars.page;

import com.cars.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * This is the application page that contains all the common UI element css selectors and functionalities that is used across the application.
 */
public class CarsPage extends BasePage {
    // URL
    public static final String CARS_URL = "https://www.cars.com";

    private static final DriverFactory DRIVER_FACTORY = new DriverFactory();

    @BeforeSuite
    public static void webDriverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void startWebDriver() {
        DRIVER_FACTORY.buildDriver();
    }

    @AfterTest
    public void quitDriver() {
        getWebDriver().quit();
    }


    public void goToCarsUrl() {
        getWebDriver().get(CARS_URL);
        waitUntilPageIsFullyLoaded();
    }
}
