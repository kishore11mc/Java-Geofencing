package com.example.demo.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseProperties {
   static final String DB_URL = "jdbc:mysql://localhost/";
   static final String USER = "root";
   static final String PASS = "password";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "CREATE DATABASE ";
         stmt.executeUpdate(sql);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
