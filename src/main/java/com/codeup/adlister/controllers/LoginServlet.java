package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.*;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);


        //my answers
        if (user == null) {
            System.out.println("user is null");
            response.sendRedirect("/login");
            return;
        }

        boolean validAttempt = BCrypt.checkpw(password, user.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            request.setAttribute("error", "Invalid username/password");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

//exercise walkthrough
//        if (validAttempt(username, password, user)) {
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("/profile");
//        } else {
//            response.sendRedirect("/login");
//        }
//    }
//
//        public static boolean validAttempt (String username, String password, User user) {
//            if (user == null) {
//                return false;
//            }
//            if (user.getPassword().equals(password)) {
//                return true;
//            }
//            return false;
        }
    }
