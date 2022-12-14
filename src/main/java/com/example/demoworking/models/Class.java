package com.example.demoworking.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Class {
    private int id;
    private String name;

    public Class(ResultSet set) throws SQLException {
        this.id = set.getInt("c_id");
        this.name = set.getString("c_name");
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
