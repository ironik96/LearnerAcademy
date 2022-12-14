package com.example.demoworking.servlets;

import com.example.demoworking.Database;
import com.example.demoworking.models.Subject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddSubjectServlet", value = "/add-subject")
public class AddSubjectServlet extends HttpServlet {

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
        String subjectTitle = request.getParameter("subjectTitle");
        try {
            Subject subject = db.insertSubject(subjectTitle);
            request.setAttribute("subjectSuccess", "Subject inserted successfully");
            System.out.println("inserted: " + subject);
        } catch (SQLException e) {
            Database.printSQLExceptionErrors(e);
            request.setAttribute("subjectError", "Failed to insert subject");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
