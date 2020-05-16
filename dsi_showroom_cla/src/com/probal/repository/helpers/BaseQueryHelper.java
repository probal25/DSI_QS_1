package com.probal.repository.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseQueryHelper {
    protected Connection openDBConnection(){
        String host = "jdbc:mysql://localhost:3306/dsi_showroom?serverTimezone=UTC";
        String uName = "root";
        String uPass = "";
        try {
            return DriverManager.getConnection(host, uName, uPass);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected void closeDBConnection(Connection connection){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
                connection = null;
                System.gc();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
