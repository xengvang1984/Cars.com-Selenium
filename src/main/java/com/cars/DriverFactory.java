package com.cars;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

/**
 * This class creates and gets the web driver that runs the UI tests.
 */
public class DriverFactory {

    private static WebDriver webDriver;

    public WebDriver buildDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver_90.0.4430.24.exe");
        webDriver = new ChromeDriver(getChromeOptions());
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            throw new NullPointerException("Webdriver is null. Please start a new webdriver.");
        }
        return webDriver;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.addArguments("user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        return options;
    }
}
