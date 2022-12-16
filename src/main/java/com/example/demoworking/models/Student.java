package com.example.demoworking.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private final int id;
    private String name;
    private Class c;

    public Student(ResultSet set) throws SQLException {
        this.id = set.getInt("stdnt_id");
        this.name = set.getString("stdnt_name");
        this.c = new Class(set);
    }

    public Class getC() {
        return c;
    }

    public void setC(Class c) {
        this.c = c;
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

    public String tableRowHtml() {
        return String.format("<tr><td>%d</td><td>%s</td><td>%d</td><td>%s</td></tr>", id, name, c.getId(), c.getName());
    }

    public static String tableHeaderHtml() {
        return String.format("<tr><th>%s</th><th>%s</th><th>%s</th><th>%s</th></tr>", "id", "name", "class id", "class name");
    }

    public String tableRowHtmlForClassReport() {
        return String.format("<tr><td>%s</td></tr>", name);
    }

    public static String tableHeaderHtmlForClassReport() {
        return String.format("<tr><th>%s</th></tr>", "Student");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
