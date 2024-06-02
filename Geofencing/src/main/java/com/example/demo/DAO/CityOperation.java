package com.example.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityOperation {
	 

	    public boolean checkcityexist(String city, Connection con) {
	        try (PreparedStatement ps = con.prepareStatement("SELECT city_id FROM CityDetails WHERE city_name = ?")) {
	            ps.setString(1, city.toLowerCase());
	            
	            try (ResultSet rs = ps.executeQuery()) {
	                return rs.next();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
}

//need to create another method latlong

public latLong getCityCoordinates(String city, Connection dbconnection) {
    String coordinates=null;
    String query = "SELECT latitude, longitude FROM CityDetails WHERE city_name = ?";
    try (PreparedStatement sc = dbconnection.prepareStatement(query)) {
        sc.setString(1, city.toLowerCase());
        ResultSet resultSet = sc.executeQuery();
        if (resultSet.next()) {
            double latitude = resultSet.getDouble("latitude");
            double longitude = resultSet.getDouble("longitude");
            latLong la=new latLong(latitude, longitude);
           return la;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}