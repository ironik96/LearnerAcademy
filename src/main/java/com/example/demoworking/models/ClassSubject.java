package com.example.demoworking.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassSubject {
    private final Subject subject;
    private final Teacher teacher;

    public ClassSubject(ResultSet set) throws SQLException {
        this.subject = new Subject(set);
        this.teacher = new Teacher(set);
    }

    public Subject getSubject() {
        return subject;
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public String tableRowHtml(){
        return String.format("<tr><td>%s</td><td>%s</td></tr>",subject.getTitle(),teacher.getName());
    }
    public static String tableHeaderHtml(){
        return String.format("<tr><th>%s</th><th>%s</th></tr>","Subject","Teacher");
    }

    @Override
    public String toString() {
        return "ClassSubject{" +
                ", subject=" + subject +
                ", teacher=" + teacher +
                '}';
    }
}
