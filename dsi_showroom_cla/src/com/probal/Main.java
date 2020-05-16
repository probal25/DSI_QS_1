package com.probal;

import com.probal.enums.EngineTypeEnum;
import com.probal.helper.Printer;
import com.probal.model.vehicles.Heavy;
import com.probal.model.vehicles.Normal;
import com.probal.model.vehicles.Sports;
import com.probal.model.vehicles.Vehicle;
import com.probal.service.ShowRoomService;
import com.probal.service.ShowRoomServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Car Showroom");
        System.out.println("1. Add car(Press 1)");
        System.out.println("2. Remove car(Press 2)");
        System.out.println("3. Display Cars(Press 3)");
        System.out.println("4. Display Showroom Details(Press 4)");


        Scanner scanner = new Scanner(System.in);
        ShowRoomService showRoomService = ShowRoomServiceImpl.getInstance();
        int actionTypeFromUser = scanner.nextInt();

        // Adding a vehicle

        if(actionTypeFromUser > 0){
            if(actionTypeFromUser == 1){

                System.out.println("------Vehicle Types-------");
                System.out.println("1. Normal (Press 1)");
                System.out.println("2. Sports (Press 2)");
                System.out.println("3. Heavy  (Press 3)");

                System.out.println("Press your vehicle type: ");

                int carTypeFromUser = scanner.nextInt();

                Vehicle vehicle = null;

                // Vehicle Type

                if(carTypeFromUser == 1){

                    Scanner scanner1 = new Scanner(System.in);

                    System.out.println("Model Number: ");
                    String modelNum = scanner1.nextLine();

                    System.out.println("Engine types: OIL(press 1) Gas(press 2) Diesel(press 3)");
                    String engineTypeCodeFromUserStr = scanner1.nextLine();
                    int engineTypeCodeFromUser = Integer.parseInt(engineTypeCodeFromUserStr);

                    System.out.println("Engine Power: ");
                    String enginePow = scanner1.nextLine();

                    System.out.println("Tire size: ");
                    String tireSizeStr = scanner1.nextLine();
                    double tireSize = Double.parseDouble(tireSizeStr);

                    //int engineTypeCodeFromUser = 1;
                    vehicle = new Normal(
                            modelNum,
                            EngineTypeEnum.getEngineTypeValueByCode(engineTypeCodeFromUser),
                            enginePow,
                            tireSize
                    );
                }else if(carTypeFromUser == 2){
                    Scanner scanner1 = new Scanner(System.in);
                    // user input turbo speed

                    System.out.println("Model Number: ");
                    String modelNum = scanner1.nextLine();

                    System.out.println("Engine Power: ");
                    String enginePow = scanner1.nextLine();

                    System.out.println("Tire size: ");
                    double tireSize = scanner1.nextDouble();

                    System.out.println("Turbo Speed: ");
                    double turboSpeed = scanner1.nextDouble();

                    vehicle = new Sports(
                            modelNum,
                            enginePow,
                            tireSize,
                            turboSpeed
                    );
                }else if(carTypeFromUser == 3){
                    Scanner scanner1 = new Scanner(System.in);
                    // user input weight
                    System.out.println("Model Number: ");
                    String modelNum = scanner1.nextLine();

                    System.out.println("Engine Power: ");
                    String enginePow = scanner1.nextLine();

                    System.out.println("Tire size: ");
                    double tireSize = scanner1.nextDouble();

                    System.out.println("Weight : ");
                    double weight = scanner1.nextDouble();


                    vehicle = new Heavy(
                            modelNum,
                            enginePow,
                            tireSize,
                            weight
                    );
                }
                if(vehicle!=null){
                    System.out.println("proceeding");
                    showRoomService.addVehicle(vehicle);
                }else{
                    System.out.println("Unable to add empty vehicle");
                }
            }else if(actionTypeFromUser == 2){
                Scanner scanner1 = new Scanner(System.in);

                System.out.println("Proceeding to delete vehicle");
                System.out.println("Enter your Model no: ");
                String modelNumberFromUser = scanner1.nextLine();
                showRoomService.removeVehicle(modelNumberFromUser);
            }else if(actionTypeFromUser == 3) {
                System.out.println("Details of the vehicle");
                new Printer().displayCars(showRoomService.getListOfVehicles());
            }else if(actionTypeFromUser == 4) {
                new Printer().displayShowroom(showRoomService.getCurrentShowroomSituation());
            }
        }
    }
}
