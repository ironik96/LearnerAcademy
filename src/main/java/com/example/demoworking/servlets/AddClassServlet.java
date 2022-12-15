package com.example.demoworking.servlets;

import com.example.demoworking.Database;
import com.example.demoworking.models.Class;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

@WebServlet(name = "AddClassServlet", value = "/add-class")
public class AddClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = (Database) request.getSession().getAttribute("database");
        String className = request.getParameter("className");
        try {
            Class c = db.insertClass(className);
            request.setAttribute("classSuccess", "class inserted successfully");
            System.out.println("Inserted class: " + c);
        } catch (SQLException e) {
            Database.printSQLExceptionErrors(e);
            request.setAttribute("classError", "Failed to insert class");
        }
        request.getRequestDispatcher("class.jsp").forward(request, response);
    }


}
