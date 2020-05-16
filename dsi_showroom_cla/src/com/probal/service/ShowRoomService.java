package com.probal.service;

import com.probal.model.showroom.ShowRoom;
import com.probal.model.vehicles.Vehicle;

import java.util.List;

public interface ShowRoomService {
    void addVehicle(Vehicle vehicle);
    void removeVehicle(String modelNumber);
    ShowRoom getCurrentShowroomSituation();
    List<Vehicle> getListOfVehicles();
}
