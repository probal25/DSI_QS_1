package com.probal.model.vehicles;;

import com.probal.enums.EngineTypeEnum;
import com.probal.enums.VehicleTypeEnum;

public class Sports extends Vehicle {
    private double turboSpeed;

    public Sports(double turboSpeed) {
        this.turboSpeed = turboSpeed;
    }

    public Sports(String modelNumber, String enginePower, double tireSize, double turboSpeed) {
        super(modelNumber, EngineTypeEnum.OIL.getValue(), enginePower, tireSize, VehicleTypeEnum.SPORTS.getValue());
        this.turboSpeed = turboSpeed;
    }

    public double getTurboSpeed() {
        return turboSpeed;
    }

    public void setTurboSpeed(double turboSpeed) {
        this.turboSpeed = turboSpeed;
    }
}
