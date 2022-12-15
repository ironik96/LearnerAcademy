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

    public String tableRowHtml(){
        return String.format("<tr><td>%d</td><td>%s</td></tr>",id,name);
    }
    public static String tableHeaderHtml(){
        return String.format("<tr><th>%s</th><th>%s</th></tr>","id","name");
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
