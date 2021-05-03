package com.cars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

/**
 * This class creates and gets the web driver that runs the UI tests.
 */
public class DriverFactory {

    private static WebDriver webDriver;

    public WebDriver buildDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver_90.0.4430.24.exe");
        webDriver = new ChromeDriver();
        return webDriver;
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            throw new NullPointerException("Webdriver is null. Please start a new webdriver.");
        }
        return webDriver;
    }
}
