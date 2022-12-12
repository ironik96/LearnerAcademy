package com.example.demoworking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
    private DbConnect db;
    private String qry;
    private Statement statement;
    private ResultSet resultSet;


    public Database() throws SQLException {
        db = new DbConnect();
        statement = db.getConn().createStatement();
    }

    void insertTeacher(String name) throws SQLException {
        String qry = String.format("INSERT INTO teacher(name) VALUES ('%s')",name);
        statement.executeUpdate(qry);
    }

    static void printSQLExceptionErrors(SQLException e){
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }

}
