package com.cars.test;

public class SearchData {
    private CarStockType carStockType;
    private VehicleMake vehicleMake;
    private VehicleModel vehicleModel;
    private Long maxPrice;
    private int searchRadiusMiles;
    private int zipcode;

    public CarStockType getCarStockType() {
        return carStockType;
    }

    public void setCarStockType(CarStockType carStockType) {
        this.carStockType = carStockType;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getSearchRadiusMiles() {
        return searchRadiusMiles;
    }

    public void setSearchRadiusMiles(int searchRadiusMiles) {
        this.searchRadiusMiles = searchRadiusMiles;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "SearchData{" +
                "carStockType=" + carStockType +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", maxPrice=" + maxPrice +
                ", searchRadiusMiles=" + searchRadiusMiles +
                ", zipcode=" + zipcode +
                '}';
    }
}
