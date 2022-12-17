package com.example.demoworking.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher {
    private final int id;
    private String name;

    public Teacher(ResultSet set) throws SQLException {
        this.id = set.getInt("t_id");
        this.name = set.getString("t_name");
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

    public String dropDownInput() {
        return String.format("<input class=\"select-box-teacher__input\" type=\"radio\" id=\"%s\" value=\"%d\" name=\"selectedTeacher\" checked=\"checked\"/>%n<p class=\"select-box-teacher__input-text\">%s</p>", "teacher"+id, id, name);
    }

    public String dropDownTitle() {
        return String.format("<li> <label class=\"select-box-teacher__option\" for=\"%s\" aria-hidden=\"aria-hidden\">%s</label></li>", "teacher"+id, name);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
