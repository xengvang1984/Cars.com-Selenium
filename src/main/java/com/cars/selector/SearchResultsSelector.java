package com.cars.selector;

/**
 * This class contains all the UI element css selectors values for the search results page.
 */
public class SearchResultsSelector implements ElementSelector {
    // UI ELEMENT CSS SELECTORS
    public static final String ALL_SEARCH_RESULTS = ".shop-srp-listings__listing";
    public static final String SELECTED_RESULT_TITLE = "h1.vehicle-info__title";
    public static final String CHECK_AVAILABILITY_BTN = "button[name=\"submit\"]";
    public static final String CONTACT_FORM_FIRST_NAME_INPUT = "input[name=\"fname\"]";
    public static final String CONTACT_FORM_LAST_NAME_INPUT = "input[name=\"lname\"]";
    public static final String CONTACT_FORM_EMAIL_INPUT = "input[name=\"email\"]";
    public static final String CALCULATOR_SECTION = "[data-linkname=\"calculate-payment\"]";
    public static final String CURRENT_SEARCH_CRITERIA = "ul.breadcrumbs li";
    public static final String NEW_USED_CAR_SEARCH_CRITERIA_NEW_RADIO_BTN = "label[for=\"stkTypId-28880\"]";
    public static final String TRIM_SEARCH_CRITERIA_TOURING_8_PASSENGER_CHECKBOX = "label[for=\"trId-36434822\"]";

    public SearchResultsSelector(String elementSelectorValue) {
        this.elementSelectorValue = elementSelectorValue;
    }

    private String elementSelectorValue;

    @Override
    public String getElementSelectorValue() {
        return elementSelectorValue;
    }
}
