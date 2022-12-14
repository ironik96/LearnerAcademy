package com.example.demoworking.servlets;

import com.example.demoworking.Database;
import com.example.demoworking.models.Class;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddClassServlet", value = "/add-class")
public class AddClassServlet extends HttpServlet {

    Database db;

    @Override
    public void init() throws ServletException {
        if (this.getServletConfig().getServletContext().getAttribute("database") != null)
            db = (Database) this.getServletConfig().getServletContext().getAttribute("database");
        else {
            try {
                db = new Database();
                this.getServletConfig().getServletContext().setAttribute("database", db);
            } catch (SQLException e) {
                Database.printSQLExceptionErrors(e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("className");
        try {
            Class c = db.insertClass(className);
            request.setAttribute("classSuccess", "class inserted successfully");
            System.out.println("Inserted class: " + c);
        } catch (SQLException e) {
            Database.printSQLExceptionErrors(e);
            request.setAttribute("classError", "Failed to insert class");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
