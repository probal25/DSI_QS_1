package com.probal.model.showroom;

import com.probal.model.vehicles.Vehicle;

import java.util.List;

public class ShowRoom {
    List<Vehicle> vehicleList;
    private Integer expectedVisitors;

    public ShowRoom() {
        this.expectedVisitors = 30;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Integer getExpectedVisitors() {
        return expectedVisitors;
    }

    public void setExpectedVisitors(Integer expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }
}
