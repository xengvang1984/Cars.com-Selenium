package com.cars.page;

import com.cars.DriverFactory;
import com.cars.selector.ElementSelector;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BasePage extends DriverFactory {

    public void selectOptionByElementSelectorAndExactOptionText(ElementSelector elementSelector, Object optionText) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        Select select = new Select(getWebDriver().findElement(By.cssSelector(elementSelector.getElementSelectorValue())));
        select.selectByVisibleText(String.valueOf(optionText));
    }

    public void selectOptionByElementSelectorAndOptionValue(ElementSelector elementSelector, Object optionText) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        Select select = new Select(getWebDriver().findElement(By.cssSelector(elementSelector.getElementSelectorValue())));
        select.selectByValue(String.valueOf(optionText));
    }

    public List<WebElement> getAllElementsByElementSelector(ElementSelector elementSelector) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        return getWebDriver().findElements(By.cssSelector(elementSelector.getElementSelectorValue()));
    }

    public void getAllElementsByElementSelectorAndClickElementByIndexPosition(ElementSelector elementSelector, int indexPosition) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        if (indexPosition > 0) {
            indexPosition--;
        }
        getWebDriver().findElements(By.cssSelector(elementSelector.getElementSelectorValue())).get(indexPosition).click();
    }

    public void clickElementByElementSelector(ElementSelector elementSelector) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        moveToElementByElementSelector(elementSelector, true);
    }

    public void fillInputByElementSelector(ElementSelector elementSelector, Object text) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        findElementByElementSelector(elementSelector).sendKeys(String.valueOf(text));
    }

    public void clearInputByElementSelector(ElementSelector elementSelector) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        findElementByElementSelector(elementSelector).clear();
    }

    public void waitUntilElementElementSelectorIsVisible(ElementSelector elementSelector) {
        WebElement element = getWebDriver().findElement(By.cssSelector(elementSelector.getElementSelectorValue()));
        WebDriverWait wait = new WebDriverWait(getWebDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyElementHasTextByElementSelector(ElementSelector elementSelector, String expectedText) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        String elementText = findElementByElementSelector(elementSelector).getText();
        Assert.assertEquals(elementText, expectedText);
    }

    public void waitUntilPageIsFullyLoaded() {
        new WebDriverWait(getWebDriver(), 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement findElementByElementSelector(ElementSelector elementSelector) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        return getWebDriver().findElement(By.cssSelector(elementSelector.getElementSelectorValue()));
    }

    public void moveToElementByElementSelector(ElementSelector elementSelector, boolean performClick) {
        waitUntilElementElementSelectorIsVisible(elementSelector);
        WebElement element = findElementByElementSelector(elementSelector);
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(element).perform();
        if (performClick) {
            element.click();
        }
    }

    public void takeScreenshot(String destinationFile) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot)getWebDriver());
        File screenFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(destinationFile);
        FileUtils.copyFile(screenFile, destFile);
    }
}

