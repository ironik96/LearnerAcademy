package com.example.demoworking.servlets;

import com.example.demoworking.Database;
import com.example.demoworking.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddStudentServlet", value = "/add-student")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = (Database) request.getSession().getAttribute("database");
        String studentName = request.getParameter("studentName");
        String selectedClass = request.getParameter("selectedClass");

        if(selectedClass.equals("0")){
            request.setAttribute("studentError", "select a class");
            request.getRequestDispatcher("student.jsp").forward(request, response);
            return;
        }
        if(studentName.equals("")){
            request.setAttribute("studentError", "Enter a student name");
            request.getRequestDispatcher("student.jsp").forward(request, response);
            return;
        }
        try {
            Student student = db.insertStudent(studentName,selectedClass);
            request.setAttribute("studentSuccess", "student inserted successfully");
            System.out.println("Inserted student: " + student);
        } catch (SQLException e) {
            Database.printSQLExceptionErrors(e);
            request.setAttribute("studentError", "Failed to insert student");
        }
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }


}
