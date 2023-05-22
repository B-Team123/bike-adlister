package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp =  request.getParameter("username");
        String temp2 = request.getParameter("email");
        String temp3 = request.getParameter("password");
        String temp4 =  request.getParameter("number");
        request.setAttribute("username", temp);
        request.setAttribute("email", temp2);
        request.setAttribute("password", temp3);
        request.setAttribute("number", temp4);
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String passwordConfirmation = request.getParameter("confirm_password");
            // String bikeType = request.getParameter("type");

            // Check if username already exists
            User user = DaoFactory.getUsersDao().findByUsername(username);

            // Validate input
            boolean inputHasErrors = username.isEmpty()
                    || email.isEmpty()
                    || password.isEmpty()
                    || (!password.equals(passwordConfirmation))
                    || user != null;

            // If input is invalid, send back to register page with error message
            if (inputHasErrors) {
                request.setAttribute("error", "Invalid input. Please check your information.");
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }

            // Create and save a new user
            user = new User(username, email, BCrypt.hashpw(password, BCrypt.gensalt()));
            DaoFactory.getUsersDao().insert(user);
            request.getSession().setAttribute("user", user);

            response.sendRedirect("/profile");
        }
    }
//        // TODO: ensure the submitted information is valid
//        // TODO: create a new user based off of the submitted information
//        // TODO: if a user was successfully created, send them to their profile
