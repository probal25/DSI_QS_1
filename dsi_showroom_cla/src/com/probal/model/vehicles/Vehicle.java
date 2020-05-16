package com.probal.model.vehicles;

public abstract class Vehicle {
    private String modelNumber;
    private String engineType;
    private String enginePower;
    private double tireSize;
    private String vehicleType;

    public Vehicle() {}
    public Vehicle(String modelNumber, String engineType, String enginePower, double tireSize, String vehicleType) {
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.vehicleType = vehicleType;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public double getTireSize() {
        return tireSize;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
