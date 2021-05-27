package com.cars.test;

public enum CarStockType {
    USED("Used Cars"),
    NEW("New Cars");

    private String carStockType;

    CarStockType(String carStockType) {
        this.carStockType = carStockType;
    }

    public String getValue() {
        return carStockType;
    }
}
