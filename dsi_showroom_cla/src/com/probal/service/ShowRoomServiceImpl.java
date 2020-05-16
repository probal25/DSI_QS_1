package com.probal.service;

import com.probal.enums.VehicleTypeEnum;
import com.probal.model.showroom.ShowRoom;
import com.probal.model.vehicles.Vehicle;
import com.probal.repository.ShowRoomRepository;
import com.probal.repository.ShowRoomRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ShowRoomServiceImpl implements ShowRoomService {
    private static ShowRoomService instance;
    private ShowRoomRepository showRoomRepository;

    @Override
    public void addVehicle(Vehicle vehicle) {
        System.out.println("Adding vehicle");
        showRoomRepository.create(vehicle);
    }

    @Override
    public void removeVehicle(String modelNumber) {
        showRoomRepository.delete(modelNumber);
    }

    @Override
    public ShowRoom getCurrentShowroomSituation() {
        ShowRoom showRoom = showRoomRepository.getShowroom();
        int noOfSportsCars = (int) showRoom.getVehicleList()
                .stream()
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(VehicleTypeEnum.SPORTS.getValue()))
                .count();
        int expectedVisitorNow = (20*noOfSportsCars) + showRoom.getExpectedVisitors();
        showRoom.setExpectedVisitors(expectedVisitorNow);
        return showRoom;
    }

    @Override
    public List<Vehicle> getListOfVehicles() {
         return showRoomRepository.getVehicles();
    }

    private ShowRoomServiceImpl() {
        this.showRoomRepository = ShowRoomRepositoryImpl.getInstance();
    }

    public static ShowRoomService getInstance(){
        instance = instance == null ? new ShowRoomServiceImpl() : instance;
        return instance;
    }
}
