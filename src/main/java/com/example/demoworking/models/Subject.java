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

    public String dropDownInput() {
        return String.format("<input class=\"select-box-subject__input\" type=\"radio\" id=\"%s\" value=\"%d\" name=\"selectedSubject\" checked=\"checked\"/>%n<p class=\"select-box-subject__input-text\">%s</p>", "subject"+id, id, title);
    }

    public String dropDownTitle() {
        return String.format("<li> <label class=\"select-box-subject__option\" for=\"%s\" aria-hidden=\"aria-hidden\">%s</label></li>", "subject"+id, title);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
