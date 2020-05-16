package com.probal.repository;

import com.probal.model.showroom.ShowRoom;
import com.probal.model.vehicles.Heavy;
import com.probal.model.vehicles.Normal;
import com.probal.model.vehicles.Sports;
import com.probal.model.vehicles.Vehicle;
import com.probal.repository.helpers.QueryHelper;

import java.util.List;

public class ShowRoomRepositoryImpl implements ShowRoomRepository {
    private static ShowRoomRepository repositoryInstance;

    @Override
    public void create(Vehicle vehicle) {
        if(vehicle instanceof Sports){
            QueryHelper.getInstance().createSportsCar((Sports) vehicle);
        }else if(vehicle instanceof Heavy){
            QueryHelper.getInstance().createHeavyCar((Heavy) vehicle);
        } else if(vehicle instanceof Normal) {
            QueryHelper.getInstance().createNormalCar((Normal) vehicle);
        }
        //execute db query
    }

    @Override
    public void delete(String modelNumber) {
        QueryHelper.getInstance().removeVehicle(modelNumber);
    }

    @Override
    public ShowRoom getShowroom() {
        ShowRoom showRoom = new ShowRoom();
        showRoom.setVehicleList(this.getVehicles());
        return showRoom;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return QueryHelper.getInstance().getAllVehicle();
    }

    private ShowRoomRepositoryImpl(){}

    public static ShowRoomRepository getInstance(){
        repositoryInstance = repositoryInstance == null ? new ShowRoomRepositoryImpl() : repositoryInstance;
        return repositoryInstance;
    }
}
