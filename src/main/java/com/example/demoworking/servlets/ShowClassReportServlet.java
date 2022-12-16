package com.example.demoworking.servlets;

import com.example.demoworking.Database;
import com.example.demoworking.models.ClassReport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ShowClassReportServlet", value = "/class-report")
public class ShowClassReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = (Database) request.getSession().getAttribute("database");
        String selectedClass = request.getParameter("selectedClass");

        if(selectedClass.equals("0")){
            request.setAttribute("error", "select a class");
            request.getRequestDispatcher("classReport.jsp").forward(request, response);
            return;
        }

        try {
            ClassReport classReport = db.classReport(Integer.parseInt(selectedClass));
            System.out.println(classReport);
            request.setAttribute("classDetails", classReport);
        } catch (SQLException e) {
            Database.printSQLExceptionErrors(e);
        }
        request.getRequestDispatcher("aClassReport.jsp").forward(request, response);
    }


}
