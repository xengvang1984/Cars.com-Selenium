package com.cars.page;

import com.cars.selector.HomePageSelector;
import com.cars.test.CarStockType;
import com.cars.test.VehicleMake;
import com.cars.test.VehicleModel;

/**
 * This class contains all the UI element selectors and functionalities for the homepage.
 */
public class HomePage extends CarsPage {
    private static final HomePageSelector SEARCH_BY_MAKE_STOCK_TYPE_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_STOCK_TYPE_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_MAKE_TYPE_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_MAKE_TYPE_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_MODEL_TYPE_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_MODEL_TYPE_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_MAX_PRICE_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_MAX_PRICE_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_RADIUS_SELECT_OPTION = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_RADIUS_SELECT_OPTION);
    private static final HomePageSelector SEARCH_BY_MAKE_ZIPCODE_INPUT = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_ZIPCODE_INPUT);
    private static final HomePageSelector SEARCH_BY_MAKE_SEARCH_BTN = new HomePageSelector(HomePageSelector.SEARCH_BY_MAKE_SEARCH_BTN);

    public void selectCarStockType(CarStockType carStockType) {
        selectOptionByElementSelectorAndExactOptionText(SEARCH_BY_MAKE_STOCK_TYPE_SELECT_OPTION, carStockType.getValue());
    }

    public void selectMakeType(VehicleMake vehicleMake) {
        selectOptionByElementSelectorAndExactOptionText(SEARCH_BY_MAKE_MAKE_TYPE_SELECT_OPTION, vehicleMake.getValue());
    }

    public void selectModelType(VehicleModel vehicleModel) {
        selectOptionByElementSelectorAndExactOptionText(SEARCH_BY_MAKE_MODEL_TYPE_SELECT_OPTION, vehicleModel.getValue());
    }

    public void selectMaxPrice(long maxPrice) {
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
