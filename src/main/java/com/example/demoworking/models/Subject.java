package com.example.demoworking.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Subject {
    private int id;
    private String title;

    public Subject(ResultSet set) throws SQLException {
        this.id = set.getInt("sbjct_id");
        this.title = set.getString("title");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String tableRowHtml(){
        return String.format("<tr><td>%d</td><td>%s</td></tr>",id,title);
    }
    public static String tableHeaderHtml(){
        return String.format("<tr><th>%s</th><th>%s</th></tr>","id","title");
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
