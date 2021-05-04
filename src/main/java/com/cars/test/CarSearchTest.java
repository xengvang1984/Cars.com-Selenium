package com.cars.test;

import com.cars.DriverFactory;
import com.cars.page.CarsPage;
import com.cars.page.HomePage;
import com.cars.page.SearchResultsPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class CarSearchTest extends CarsPage {
    private static final HomePage HOME_PAGE = new HomePage();
    private static final SearchResultsPage SEARCH_RESULTS_PAGE = new SearchResultsPage();
    private static final DriverFactory DRIVER_FACTORY = new DriverFactory();

    @Test
    public void searchUsedCarsTest() throws IOException {
        goToCarsUrl();
        HOME_PAGE.selectCarStockType("Used Cars");
        HOME_PAGE.selectMakeType("Honda");
        HOME_PAGE.selectModelType("Pilot");
        HOME_PAGE.selectMaxPrice(50000);
        HOME_PAGE.selectRadius(100);
        HOME_PAGE.fillZipcode(60008);
        HOME_PAGE.clickSearchBtn();

        String currentUrl = getWebDriver().getCurrentUrl();
        getWebDriver().quit();
        DRIVER_FACTORY.buildDriver();
        getWebDriver().get(currentUrl);

        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(1, "Clear All");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(2, "Maximum Price: $50,000");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(3, "Honda");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(4, "Pilot");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(5, "Used");

        SEARCH_RESULTS_PAGE.clickNewUsedCarSearchCriteriaNewRadioBtn();

        getWebDriver().quit();
        DRIVER_FACTORY.buildDriver();
        // Had to manually go to the update url as it was not getting updated.
        getWebDriver().get("https://www.cars.com/for-sale/searchresults.action/?mdId=21729&mkId=20017&page=1&perPage=20&prMx=50000&rd=100&searchSource=GN_REFINEMENT&sort=relevance&stkTypId=28880&zc=60008");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(5, "New");

        SEARCH_RESULTS_PAGE.clickTrimCarSearchCriteriaTouring8PassengerCheckbox();
        getWebDriver().quit();
        DRIVER_FACTORY.buildDriver();
        // Had to manually go to the update url as it was not getting updated.
        getWebDriver().get("https://www.cars.com/for-sale/searchresults.action/?mdId=21729&mkId=20017&page=1&perPage=20&prMx=50000&rd=100&searchSource=GN_REFINEMENT&sort=relevance&stkTypId=28880&trId=36434822&zc=60008");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(5, "Touring 8-Passenger");

        SEARCH_RESULTS_PAGE.clickSearchResultByRowNumber(2);
        SEARCH_RESULTS_PAGE.verifySearchResultTitle("2021 Honda Pilot Touring 8-Passenger");
        SEARCH_RESULTS_PAGE.fillContactFormFirstName("Car");
        SEARCH_RESULTS_PAGE.fillContactFormLastName("Owner");
        SEARCH_RESULTS_PAGE.fillContactFormEmail("carowner@yahoo.com");
        SEARCH_RESULTS_PAGE.verifyCheckAvailabilityBtnIsVisible();
        SEARCH_RESULTS_PAGE.scrollToCalulatorSection();
        takeScreenshot("C:\\Users\\Flyboy\\Pictures\\screenshot.jpg");
    }
}
