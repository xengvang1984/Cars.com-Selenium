package com.cars.page;

import com.cars.selector.ElementSelector;
import com.cars.selector.HomePageSelector;

public class HomePage extends CarsPage {
    private static final HomePageSelector SEARCH_BY_MAKE_STOCK_TYPE_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_STOCK_TYPE_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_MAKE_TYPE_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_MAKE_TYPE_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_MODEL_TYPE_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_MODEL_TYPE_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_MAX_PRICE_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_MAX_PRICE_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_RADIUS_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_RADIUS_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_ZIPCODE_INPUT = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_ZIPCODE_INPUT);
    private static final HomePageSelector SEARCH_BY_MAKE_SEARCH_BTN = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_SEARCH_BTN);

    public void selectCarStockType(String stockType) {
        selectOptionByElementSelectorAndExactOptionText(SEARCH_BY_MAKE_STOCK_TYPE_SELECT_OPTION, stockType);
    }

    public void selectMakeType(String makeType) {
        selectOptionByElementSelectorAndExactOptionText(SEARCH_BY_MAKE_MAKE_TYPE_SELECT_OPTION, makeType);
    }

    public void selectModelType(String modelType) {
        selectOptionByElementSelectorAndExactOptionText(SEARCH_BY_MAKE_MODEL_TYPE_SELECT_OPTION, modelType);
    }

    public void selectMaxPrice(int maxPrice) {
        selectOptionByElementSelectorAndOptionValue(SEARCH_BY_MAKE_MAX_PRICE_SELECT_OPTION, maxPrice);
    }

    public void selectRadius(int radiusMiles) {
        selectOptionByElementSelectorAndOptionValue(SEARCH_BY_MAKE_RADIUS_SELECT_OPTION, radiusMiles);
    }

    public void fillZipcode(int zipcode) {
        clearInputByElementSelector(SEARCH_BY_MAKE_ZIPCODE_INPUT);
        fillInputByElementSelector(SEARCH_BY_MAKE_ZIPCODE_INPUT, zipcode);
    }

    public void clickSearchBtn() {
        clickElementByElementSelector(SEARCH_BY_MAKE_SEARCH_BTN);
        waitUntilPageIsFullyLoaded();
    }
}
