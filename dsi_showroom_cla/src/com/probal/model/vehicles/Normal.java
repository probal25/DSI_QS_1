package com.probal.model.vehicles;

import com.probal.enums.VehicleTypeEnum;

public class Normal extends Vehicle {
    public Normal() {
    }

    public Normal(String modelNumber, String engineType, String enginePower, double tireSize) {
        super(modelNumber, engineType, enginePower, tireSize, VehicleTypeEnum.NORMAL.getValue());
    }
}
