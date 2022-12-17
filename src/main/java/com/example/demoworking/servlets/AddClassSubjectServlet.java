package com.example.demoworking.servlets;

import com.example.demoworking.Database;
import com.example.demoworking.models.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddClassSubjectServlet", value = "/add-class-subject")
public class AddClassSubjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = (Database) request.getSession().getAttribute("database");
        String classId = request.getParameter("classId");
        String selectedSubject = request.getParameter("selectedSubject");
        String selectedTeacher = request.getParameter("selectedTeacher");

        db.insertClassSubject(classId,selectedSubject,selectedTeacher);

        response.sendRedirect("class-report?selectedClass="+classId);
    }
}
