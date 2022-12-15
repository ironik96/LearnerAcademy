package com.example.demoworking.servlets;

import com.example.demoworking.Database;
import com.example.demoworking.models.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddTeacherServlet", value = "/add-teacher")
public class AddTeacherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = (Database) request.getSession().getAttribute("database");
        String teacherName = request.getParameter("teacherName");
        try {
            Teacher teacher = db.insertTeacher(teacherName);
            request.setAttribute("teacherSuccess", "Teacher inserted successfully");
            System.out.println("Inserted teacher: " + teacher);
        } catch (SQLException e) {
            Database.printSQLExceptionErrors(e);
            request.setAttribute("teacherError", "Failed to insert teacher");
        }
        request.getRequestDispatcher("teacher.jsp").forward(request, response);
    }


}
