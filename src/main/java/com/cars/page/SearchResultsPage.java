package com.cars.page;

import com.cars.selector.ElementSelector;
import com.cars.selector.SearchResultsSelector;
import org.testng.Assert;

/**
 * This class contains all the UI element selectors and functionalities for the search results page.
 */
public class SearchResultsPage extends CarsPage {
    private static final SearchResultsSelector NEW_USED_CAR_SEARCH_CRITERIA_NEW_RADIO_BTN = new SearchResultsSelector(SearchResultsSelector.NEW_USED_CAR_SEARCH_CRITERIA_NEW_RADIO_BTN);
    private static final SearchResultsSelector TRIM_SEARCH_CRITERIA_TOURING_8_PASSENGER_CHECKBOX = new SearchResultsSelector(SearchResultsSelector.TRIM_SEARCH_CRITERIA_TOURING_8_PASSENGER_CHECKBOX);
    private static final SearchResultsSelector CURRENT_SEARCH_CRITERIA = new SearchResultsSelector(SearchResultsSelector.CURRENT_SEARCH_CRITERIA);
    private static final SearchResultsSelector ALL_SEARCH_RESULTS = new SearchResultsSelector(SearchResultsSelector.ALL_SEARCH_RESULTS);
    private static final SearchResultsSelector SELECTED_RESULT_TITLE = new SearchResultsSelector(SearchResultsSelector.SELECTED_RESULT_TITLE);
    private static final SearchResultsSelector CHECK_AVAILABILITY_BTN = new SearchResultsSelector(SearchResultsSelector.CHECK_AVAILABILITY_BTN);
    private static final SearchResultsSelector CONTACT_FORM_FIRST_NAME_INPUT = new SearchResultsSelector(SearchResultsSelector.CONTACT_FORM_FIRST_NAME_INPUT);
    private static final SearchResultsSelector CONTACT_FORM_LAST_NAME_INPUT = new SearchResultsSelector(SearchResultsSelector.CONTACT_FORM_LAST_NAME_INPUT);
    private static final SearchResultsSelector CONTACT_FORM_EMAIL_INPUT = new SearchResultsSelector(SearchResultsSelector.CONTACT_FORM_EMAIL_INPUT);
    private static final SearchResultsSelector CALCULATOR_SECTION = new SearchResultsSelector(SearchResultsSelector.CALCULATOR_SECTION);


    public void clickNewUsedCarSearchCriteriaNewRadioBtn() {
        clickElementByElementSelector(NEW_USED_CAR_SEARCH_CRITERIA_NEW_RADIO_BTN);
        waitUntilPageIsFullyLoaded();
    }

    public void clickTrimCarSearchCriteriaTouring8PassengerCheckbox() {
        clickElementByElementSelector(TRIM_SEARCH_CRITERIA_TOURING_8_PASSENGER_CHECKBOX);
        waitUntilPageIsFullyLoaded();
    }

    public void verifyCurrentSearchCriteria(int indexPosition, String expectedText) {
        waitUntilPageIsFullyLoaded();
        if (indexPosition > 0) {
            indexPosition--;
        }
        String elementText = getAllElementsByElementSelector(CURRENT_SEARCH_CRITERIA).get(indexPosition).getText();
        Assert.assertTrue(elementText.contains(expectedText));
    }

    public void clickSearchResultByRowNumber(int rowNumber) {
        getAllElementsByElementSelectorAndClickElementByIndexPosition(ALL_SEARCH_RESULTS, rowNumber);
        waitUntilPageIsFullyLoaded();
    }

    public void verifySearchResultTitle(String expectedTitle) {
        verifyElementHasTextByElementSelector(SELECTED_RESULT_TITLE, expectedTitle);
    }

    public void verifyCheckAvailabilityBtnIsVisible() {
        waitUntilElementElementSelectorIsVisible(CHECK_AVAILABILITY_BTN);
    }

    public void fillContactFormFirstName(String firstName) {
        fillInputByElementSelector(CONTACT_FORM_FIRST_NAME_INPUT, firstName);
    }

    public void fillContactFormLastName(String lastName) {
        fillInputByElementSelector(CONTACT_FORM_LAST_NAME_INPUT, lastName);
    }

    public void fillContactFormEmail(String email) {
        fillInputByElementSelector(CONTACT_FORM_EMAIL_INPUT, email);
    }

    public void scrollToCalulatorSection() {
        moveToElementByElementSelector(CALCULATOR_SECTION, false);
    }

    public void goToCarsUrl() {
        getWebDriver().get(CARS_URL);
        waitUntilPageIsFullyLoaded();
    }
}
