package com.probal.enums;

public enum EngineTypeEnum {
    OIL(1, "Oil"),
    GAS(2, "Gas"),
    DIESEL(3, "Diesel");
    int code;
    String value;

    EngineTypeEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getEngineTypeValueByCode(int code){
        for(EngineTypeEnum typeEnum : EngineTypeEnum.values()){
            if(code == typeEnum.code){
                return typeEnum.value;
            }
        }
        return "";
    }
}
