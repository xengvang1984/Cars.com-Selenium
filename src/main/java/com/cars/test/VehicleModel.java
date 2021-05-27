package com.cars.test;

public enum VehicleModel {
    PILOT("Pilot"),
    CAMRY("Camry"),
    F150("F150");

    private String vehicleModel;

    VehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getValue() {
        return vehicleModel;
    }
}
