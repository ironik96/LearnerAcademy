package com.example.demoworking;

import java.sql.*;


public class DbConnect {
    private Connection conn;
    private final String DRIVER_URL = "com.mysql.cj.jdbc.Driver";
    private final String DATABASE_CONNECTION = "jdbc:mysql://localhost/learner_academy";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    public DbConnect() throws SQLException {
        try {
            Class.forName(DRIVER_URL);
            conn =
                    DriverManager.getConnection(DATABASE_CONNECTION, USERNAME, PASSWORD);
            System.out.println("Connected successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot load the driver " + e.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }
}
