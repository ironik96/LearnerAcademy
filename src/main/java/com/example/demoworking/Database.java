package com.example.demoworking;

import com.example.demoworking.models.*;
import com.example.demoworking.models.Class;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
        qry = String.format("INSERT INTO teacher(t_name) VALUES ('%s')", name);
        statement.executeUpdate(qry);
        return getMostRecentTeacher();
    }

    public Class insertClass(String name) throws SQLException {
        qry = String.format("INSERT INTO class(c_name) VALUES ('%s')", name);
        statement.executeUpdate(qry);
        return getMostRecentClass();
    }

    public Subject insertSubject(String title) throws SQLException {
        qry = String.format("INSERT INTO subject(title) VALUES ('%s')", title);
        statement.executeUpdate(qry);
        return getMostRecentSubject();
    }

    public Student insertStudent(String name, String classId) throws SQLException {
        qry = String.format("INSERT INTO student(stdnt_name, c_id) VALUES ('%s', %s)", name, classId);
        statement.executeUpdate(qry);
        return getMostRecentStudent();
    }

    public void insertClassSubject(String classId, String subjectId, String teacherId) {
        qry = String.format("INSERT INTO teacherclasssubject(c_id, sbjct_id, t_id) VALUES (%s,%s,%s)", classId, subjectId, teacherId);
        try {
            statement.executeUpdate(qry);
        } catch (SQLException e) {
            printSQLExceptionErrors(e);
        }

    }

    public List<Teacher> readTeachers() throws SQLException {
        resultSet = statement.executeQuery("select * from teacher");
        List<Teacher> teachers = new ArrayList<>();
        while (resultSet.next())
            teachers.add(new Teacher(resultSet));
        return teachers;
    }

    public List<Class> readClasses() throws SQLException {
        resultSet = statement.executeQuery("select * from class");
        List<Class> classes = new ArrayList<>();
        while (resultSet.next())
            classes.add(new Class(resultSet));
        return classes;
    }

    public List<Subject> readSubjects() throws SQLException {
        resultSet = statement.executeQuery("select * from subject");
        List<Subject> subjects = new ArrayList<>();
        while (resultSet.next())
            subjects.add(new Subject(resultSet));
        return subjects;
    }

    public List<Student> readStudents() throws SQLException {
        resultSet = statement.executeQuery("select s.*, c.c_name from student s JOIN class c ON s.c_id = c.c_id");
        List<Student> students = new ArrayList<>();
        while (resultSet.next())
            students.add(new Student(resultSet));
        return students;
    }

    public ClassReport classReport(int selectedClass) throws SQLException {
        return new ClassReport(classById(selectedClass), classSubjects(selectedClass), classStudents(selectedClass));
    }

    public Class classById(int classId) throws SQLException {
        qry = "SELECT * from class where c_id = " + classId;
        resultSet = statement.executeQuery(qry);
        resultSet.next();
        return new Class(resultSet);
    }

    public List<Student> classStudents(int classId) throws SQLException {
        qry = String.format("select s.*, c.c_name from student s JOIN class c ON s.c_id = c.c_id where s.c_id = %d", classId);
        resultSet = statement.executeQuery(qry);
        List<Student> students = new ArrayList<>();
        while (resultSet.next())
            students.add(new Student(resultSet));
        return students;
    }

    public List<ClassSubject> classSubjects(int classId) throws SQLException {
        qry = String.format("SELECT c.*, t.*, s.* FROM teacherclasssubject tcs JOIN class c on tcs.c_id = c.c_id JOIN teacher t on tcs.t_id = t.t_id JOIN SUBJECT s on tcs.sbjct_id = s.sbjct_id WHERE tcs.c_id = %d", classId);
        resultSet = statement.executeQuery(qry);
        List<ClassSubject> classSubject = new ArrayList<>();
        while (resultSet.next())
            classSubject.add(new ClassSubject(resultSet));
        return classSubject;
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

    private Student getMostRecentStudent() throws SQLException {
        qry = "select s.*, c.c_name from student s JOIN class c ON s.c_id = c.c_id where s.stdnt_id = (SELECT MAX(stdnt_id) from student)";
        resultSet = statement.executeQuery(qry);
        resultSet.next();
        return new Student(resultSet);
    }

    private Subject getMostRecentSubject() throws SQLException {
        qry = "SELECT * from subject where sbjct_id = (SELECT MAX(sbjct_id) from subject)";
        resultSet = statement.executeQuery(qry);
        resultSet.next();
        return new Subject(resultSet);
    }

    public static void printSQLExceptionErrors(SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
        e.printStackTrace();
    }
}
