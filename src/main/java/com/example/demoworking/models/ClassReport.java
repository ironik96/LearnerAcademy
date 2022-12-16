package com.example.demoworking.models;

import com.example.demoworking.Database;

import java.sql.SQLException;
import java.util.List;

public class ClassReport {

    private final Class myClass;
    private final List<ClassSubject> subjects;
    private final List<Student> students;

    public ClassReport(Class myClass, List<ClassSubject> subjects, List<Student> students) {
        this.myClass = myClass;
        this.subjects = subjects;
        this.students = students;
    }

    public Class getMyClass() {
        return myClass;
    }

    public List<ClassSubject> getSubjects() {
        return subjects;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "ClassReport{" +
                "classId=" + myClass +
                ", subjects=" + subjects +
                ", students=" + students +
                '}';
    }
}
