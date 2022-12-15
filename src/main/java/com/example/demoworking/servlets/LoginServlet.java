package com.example.demoworking.servlets;

import com.example.demoworking.Database;
import com.example.demoworking.models.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (!username.equals("admin")) {
            request.setAttribute("loginUsernameError", "username incorrect");
        }
        if (!password.equals("1234")) {
            request.setAttribute("loginPasswordError", "password incorrect");
        }
        if(!username.equals("admin") || !password.equals("1234")){
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        try {
            request.getSession().setAttribute("database", new Database());
        } catch (SQLException e) {
            Database.printSQLExceptionErrors(e);
        }
        response.sendRedirect("teacher.jsp");
    }
}
