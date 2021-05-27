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
        SearchData searchData = buildSearchData();

        goToCarsUrl();
        HOME_PAGE.selectCarStockType(searchData.getCarStockType());
        HOME_PAGE.selectMakeType(searchData.getVehicleMake());
        HOME_PAGE.selectModelType(searchData.getVehicleModel());
        HOME_PAGE.selectMaxPrice(searchData.getMaxPrice());
        HOME_PAGE.selectRadius(searchData.getSearchRadiusMiles());
        HOME_PAGE.fillZipcode(searchData.getZipcode());
        HOME_PAGE.clickSearchBtn();

        String currentUrl = getWebDriver().getCurrentUrl();
        getWebDriver().quit();
        DRIVER_FACTORY.buildDriver();
        getWebDriver().get(currentUrl);

        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(1, "Clear All");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(2, "Maximum Price: $" + searchData);
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(3, searchData.getVehicleMake().getValue());
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(4, searchData.getVehicleModel().getValue());
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(5, "Used");

        SEARCH_RESULTS_PAGE.clickNewUsedCarSearchCriteriaNewRadioBtn();

        getWebDriver().quit();
        DRIVER_FACTORY.buildDriver();
        // Had to manually go to the updated url as it was not getting updated.
        getWebDriver().get("https://www.cars.com/for-sale/searchresults.action/?mdId=21729&mkId=20017&page=1&perPage=20&prMx=50000&rd=100&searchSource=GN_REFINEMENT&sort=relevance&stkTypId=28880&zc=60008");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(5, "New");

        SEARCH_RESULTS_PAGE.clickTrimCarSearchCriteriaTouring8PassengerCheckbox();
        getWebDriver().quit();
        DRIVER_FACTORY.buildDriver();
        // Had to manually go to the updated url as it was not getting updated.
        getWebDriver().get("https://www.cars.com/for-sale/searchresults.action/?mdId=21729&mkId=20017&page=1&perPage=20&prMx=50000&rd=100&searchSource=GN_REFINEMENT&sort=relevance&stkTypId=28880&trId=36434822&zc=60008");
        SEARCH_RESULTS_PAGE.verifyCurrentSearchCriteria(5, "Touring 8-Passenger");

        SEARCH_RESULTS_PAGE.clickSearchResultByRowNumber(2);
        SEARCH_RESULTS_PAGE.verifySearchResultTitle("2021 " + searchData.getVehicleMake().getValue()
                + " " + searchData.getVehicleModel().getValue() + " Touring 8-Passenger");
        SEARCH_RESULTS_PAGE.fillContactFormFirstName("Car");
        SEARCH_RESULTS_PAGE.fillContactFormLastName("Owner");
        SEARCH_RESULTS_PAGE.fillContactFormEmail("carowner@yahoo.com");
        SEARCH_RESULTS_PAGE.verifyCheckAvailabilityBtnIsVisible();
        SEARCH_RESULTS_PAGE.scrollToCalulatorSection();
        takeScreenshot("C:\\Users\\Xeng\\Pictures\\screenshot.jpg");
    }

    private SearchData buildSearchData() {
        SearchData searchData = new SearchData();
        searchData.setCarStockType(CarStockType.USED);
        searchData.setVehicleMake(VehicleMake.HONDA);
        searchData.setVehicleModel(VehicleModel.PILOT);
        searchData.setMaxPrice(50000L);
        searchData.setSearchRadiusMiles(100);
        searchData.setZipcode(60008);

        return searchData;
    }
}
