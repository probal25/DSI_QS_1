package com.probal.helper;

import com.probal.model.showroom.ShowRoom;
import com.probal.model.vehicles.Heavy;
import com.probal.model.vehicles.Normal;
import com.probal.model.vehicles.Sports;
import com.probal.model.vehicles.Vehicle;

import java.util.List;

public class Printer {
    public void displayCars(List<Vehicle> vehicles) {
        if(vehicles!=null && vehicles.size() > 0){
            System.out.println("Type\tModel\tEngine\tPower\tTir size\tTurbo\tWeight");
            vehicles.forEach( vehicle -> {
                if(vehicle instanceof Sports){
                    Sports sportsCar = (Sports) vehicle;
                    System.out.println(sportsCar.getVehicleType()+"\t"+sportsCar.getModelNumber()+"\t"+
                            sportsCar.getEngineType() +"\t"+sportsCar.getEnginePower()+"\t"+sportsCar.getTireSize()+"\t"
                            +sportsCar.getTurboSpeed()+"\t"+"N/A");
                }else if (vehicle instanceof Heavy){
                    Heavy heavyCar = (Heavy) vehicle;
                    System.out.println(heavyCar.getVehicleType()+"\t"+heavyCar.getModelNumber()+"\t"+
                            heavyCar.getEngineType() +"\t"+heavyCar.getEnginePower()+"\t"+heavyCar.getTireSize()+"\t"
                            +"N/A"+"\t"+heavyCar.getWeight());
                }else{
                    Normal normalCar = (Normal) vehicle;
                    System.out.println(normalCar.getVehicleType()+"\t"+normalCar.getModelNumber()+"\t"+
                            normalCar.getEngineType() +"\t"+normalCar.getEnginePower()+"\t"+normalCar.getTireSize()+"\t"
                            +"N/A"+"\t"+"N/A");
                }
            });
        }else{
            System.out.println("No vehicles in showroom");
        }
    }
    public void displayShowroom(ShowRoom showRoom) {
        System.out.println("Expected Number Of Visitors: "+showRoom.getExpectedVisitors());
        this.displayCars(showRoom.getVehicleList());
    }
}
