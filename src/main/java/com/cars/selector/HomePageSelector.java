package com.cars.selector;

/**
 * This class contains all the UI element css selectors values for the homepage.
 */
public class HomePageSelector implements ElementSelector {
    public static final String SEARCH_BY_MAKE_STOCK_TYPE_SELECT_OPTION = "select[name=\"stockType\"]";
    public static final String SEARCH_BY_MAKE_MAKE_TYPE_SELECT_OPTION = "select[name=\"makeId\"]";
    public static final String SEARCH_BY_MAKE_MODEL_TYPE_SELECT_OPTION = "select[name=\"modelId\"]";
    public static final String SEARCH_BY_MAKE_MAX_PRICE_SELECT_OPTION = "select[name=\"priceMax\"]";
    public static final String SEARCH_BY_MAKE_RADIUS_SELECT_OPTION = "select[name=\"radius\"]";
    public static final String SEARCH_BY_MAKE_ZIPCODE_INPUT = "input[name=\"zip\"]";
    public static final String SEARCH_BY_MAKE_SEARCH_BTN = "input[type=\"submit\"]";

    private String elementSelectorValue;

    public HomePageSelector(String elementSelectorValue) {
        this.elementSelectorValue = elementSelectorValue;
    }

    @Override
    public String getElementSelectorValue() {
        return elementSelectorValue;
    }
}
