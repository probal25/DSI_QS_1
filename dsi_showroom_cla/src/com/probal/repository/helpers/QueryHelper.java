package com.probal.repository.helpers;

import com.probal.enums.VehicleTypeEnum;
import com.probal.model.vehicles.Heavy;
import com.probal.model.vehicles.Normal;
import com.probal.model.vehicles.Sports;
import com.probal.model.vehicles.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryHelper extends BaseQueryHelper {
    private static QueryHelper instance;

    private QueryHelper() {
    }
    public static QueryHelper getInstance(){
        instance = instance == null ? new QueryHelper() : instance;
        return instance;
    }

    public String createSportsCar(Sports sportsCar){
        String result="";
        Connection connection = this.openDBConnection();
        try{
            if(connection != null){
        //write db code here
                String sql = "INSERT INTO vehicle (v_type, model_no, engine_type, engine_power, tire_size, turbo)" +
                        " VALUES (? , ?, ?, ?, ?, ?)";
                PreparedStatement stm = connection.prepareStatement(sql);

                stm.setString(1, "Sports");
                stm.setString(2, sportsCar.getModelNumber());
                stm.setString(3, sportsCar.getEngineType());
                stm.setString(4, sportsCar.getEnginePower());
                stm.setDouble(5, sportsCar.getTireSize());
                stm.setDouble(6, sportsCar.getTurboSpeed());
                int rows = stm.executeUpdate();
                if(rows > 0) System.out.println("Sports vehicle added successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
            result = e.getMessage();
        }finally {
            this.closeDBConnection(connection);
        }
        return result;
    }

    public String createHeavyCar(Heavy heavyCar){
        String result="";
        Connection connection = this.openDBConnection();
        try{
            if(connection != null){
                //write db code here
                String sql = "INSERT INTO vehicle (v_type, model_no, engine_type, engine_power, tire_size, weight)" +
                        " VALUES (? , ?, ?, ?, ?, ?)";
                PreparedStatement stm = connection.prepareStatement(sql);

                stm.setString(1, "Heavy");
                stm.setString(2, heavyCar.getModelNumber());
                stm.setString(3, heavyCar.getEngineType());
                stm.setString(4, heavyCar.getEnginePower());
                stm.setDouble(5, heavyCar.getTireSize());
                stm.setDouble(6, heavyCar.getWeight());
                int rows = stm.executeUpdate();
                if(rows > 0) System.out.println("Heavy vehicle added successfully");

            }
        }catch (Exception e){
            e.printStackTrace();
            result = e.getMessage();
        }finally {
            this.closeDBConnection(connection);
        }
        return result;
    }

    public String createNormalCar(Normal normalCar){
        String result="";
        Connection connection = this.openDBConnection();
        try{
            if(connection != null){
                //write db code here
                //write db code here
                String sql = "INSERT INTO vehicle (v_type, model_no, engine_type, engine_power, tire_size)" +
                        " VALUES (? , ?, ?, ?, ?)";
                PreparedStatement stm = connection.prepareStatement(sql);

                stm.setString(1, "Normal");
                stm.setString(2, normalCar.getModelNumber());
                stm.setString(3, normalCar.getEngineType());
                stm.setString(4, normalCar.getEnginePower());
                stm.setDouble(5, normalCar.getTireSize());
                //stm.setDouble(6, heavyCar.getWeight());1
                int rows = stm.executeUpdate();
                if(rows > 0) {
                    System.out.println("Normal vehicle added successfully");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result = e.getMessage();
        }finally {
            this.closeDBConnection(connection);
        }
        return result;
    }

    public void removeVehicle(String model_no) {
        Connection connection = this.openDBConnection();

        try {
            if(connection != null) {
                String sql = "DELETE FROM vehicle WHERE model_no=?";
                PreparedStatement stm = connection.prepareStatement(sql);

                stm.setString(1, model_no);
                stm.executeUpdate();

                System.out.println("Record deleted successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeDBConnection(connection);
        }
    }

    public List<Vehicle> getAllVehicle() {
        Connection connection = this.openDBConnection();
        List<Vehicle> vehicleListFromDB = new ArrayList<>();
        try {
            if(connection != null) {
                String sql = "SELECT * FROM vehicle";
                Statement stm = connection.createStatement();

                ResultSet rs = stm.executeQuery(sql);
                //System.out.println("Type   Model   Engine   Power   Tire size   Turbo   Weight");

                while (rs.next()) {
                    Vehicle vehicleMapped = this.mapRSTopVehicleObject(rs);
                    if(vehicleMapped != null){
                        vehicleListFromDB.add(vehicleMapped);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeDBConnection(connection);
        }
        return vehicleListFromDB;
    }

    private Vehicle mapRSTopVehicleObject(ResultSet rs) throws Exception {
        String v_type = rs.getString("v_type");
        String m_no = rs.getString("model_no");
        String en_type = rs.getString("engine_type");
        String en_pow = rs.getString("engine_power");
        Double turbo = rs.getDouble("turbo");
        Double weight = rs.getDouble("weight");
        Double tireSize = rs.getDouble("tire_size");

        Vehicle vehicle = null;

        if(v_type.equalsIgnoreCase(VehicleTypeEnum.NORMAL.getValue())){
            vehicle = new Normal(m_no, en_type, en_pow, tireSize);
        }else if(v_type.equalsIgnoreCase(VehicleTypeEnum.SPORTS.getValue())){
            vehicle = new Sports(m_no, en_pow, tireSize, turbo);
        }else if(v_type.equalsIgnoreCase(VehicleTypeEnum.HEAVY.getValue())){
            vehicle = new Heavy(m_no, en_pow, tireSize, weight);
        }
        return vehicle;
    }
}
