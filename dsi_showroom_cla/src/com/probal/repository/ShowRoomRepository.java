package com.probal.repository;

import com.probal.model.showroom.ShowRoom;
import com.probal.model.vehicles.Vehicle;

import java.util.List;

public interface ShowRoomRepository {
    void create(Vehicle vehicle);
    void delete(String modelNumber);
    ShowRoom getShowroom();
    List<Vehicle> getVehicles();
}
