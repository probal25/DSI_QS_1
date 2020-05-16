package com.probal.model.vehicles;

import com.probal.enums.EngineTypeEnum;
import com.probal.enums.VehicleTypeEnum;

public class Heavy extends Vehicle {
    private double weight;

    public Heavy(double weight) {
        this.weight = weight;
    }

    public Heavy(String modelNumber, String enginePower, double tireSize, double weight) {
        super(modelNumber, EngineTypeEnum.DIESEL.getValue(), enginePower, tireSize, VehicleTypeEnum.HEAVY.getValue());
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
