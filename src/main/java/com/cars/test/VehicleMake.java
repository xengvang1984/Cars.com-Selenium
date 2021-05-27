package com.cars.test;

public enum VehicleMake {
    HONDA("Honda"),
    TOYOTA("Toyota"),
    JEEP("Jeep"),
    DODGE("Dodge"),
    FORD("Ford");

    private String vehicleMake;

    VehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getValue() {
        return vehicleMake;
    }
}
