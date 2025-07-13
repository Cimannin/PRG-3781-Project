package com.bcwellness;

import java.sql.*;
//this is for the database connection
public class DBConnection {
    public static Connection getConnection() throws Exception{
      String url = "jdbc:postgresql://localhost:5432/wellness";
      String username = "postgres";
      String password = "Admin123";

      Class.forName("org.postgresql.Driver");
      return DriverManager.getConnection(url, username, password);
    }
}
