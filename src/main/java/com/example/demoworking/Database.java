package com.example.demoworking;

import com.example.demoworking.models.Class;
import com.example.demoworking.models.Subject;
import com.example.demoworking.models.Teacher;

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

    public Teacher insertTeacher(String name) throws SQLException {
        String qry = String.format("INSERT INTO teacher(t_name) VALUES ('%s')",name);
        statement.executeUpdate(qry);
        return getMostRecentTeacher();
    }

    public Class insertClass(String name) throws SQLException {
        String qry = String.format("INSERT INTO class(c_name) VALUES ('%s')",name);
        statement.executeUpdate(qry);
        return getMostRecentClass();
    }

    public Subject insertSubject(String title) throws SQLException {
        String qry = String.format("INSERT INTO subject(title) VALUES ('%s')",title);
        statement.executeUpdate(qry);
        return getMostRecentSubject();
    }

    private Teacher getMostRecentTeacher() throws SQLException {
        qry = "SELECT * from teacher where t_id = (SELECT MAX(t_id) from teacher)";
        resultSet = statement.executeQuery(qry);
        resultSet.next();
        return new Teacher(resultSet);
    }

    private Class getMostRecentClass() throws SQLException {
        qry = "SELECT * from class where c_id = (SELECT MAX(c_id) from class)";
        resultSet = statement.executeQuery(qry);
        resultSet.next();
        return new Class(resultSet);
    }

    private Subject getMostRecentSubject() throws SQLException {
        qry = "SELECT * from subject where sbjct_id = (SELECT MAX(sbjct_id) from subject)";
        resultSet = statement.executeQuery(qry);
        resultSet.next();
        return new Subject(resultSet);
    }

    public static void printSQLExceptionErrors(SQLException e){
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }

}
