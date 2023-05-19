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
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // check if username already exists
        User user = DaoFactory.getUsersDao().findByUsername(username);

        // TODO: ensure the submitted information is valid
        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation))
                || user != null;
        //if input is invalid, send back to register page
        if (inputHasErrors) {
            try {
                response.sendRedirect("/register");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        // create and save a new user
        user = new User(username, email, BCrypt.hashpw(password, BCrypt.gensalt()));
        DaoFactory.getUsersDao().insert(user);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/profile");
    }
}
