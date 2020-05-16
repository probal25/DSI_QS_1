package com.probal.enums;

public enum VehicleTypeEnum {
    NORMAL("Normal"),
    SPORTS( "Sports"),
    HEAVY( "Heavy");
    String value;

    VehicleTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
