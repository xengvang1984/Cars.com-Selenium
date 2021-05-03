package com.cars.page;

import com.cars.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CarsPage extends BasePage {
    // URL
    public static final String CARS_URL = "https://www.cars.com";

    private static final DriverFactory DRIVER_FACTORY = new DriverFactory();

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
