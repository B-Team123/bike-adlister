package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.*;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.codeup.adlister.models.UserAddress;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String temp = request.getParameter("username");
    String temp2 = request.getParameter("password");
    request.setAttribute("username", temp);
    request.setAttribute("password", temp2);

    if (request.getSession().getAttribute("user") != null) {
      response.sendRedirect("/profile");
      return;
    }
    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    request.setAttribute("username", username);
    request.setAttribute("password", password);

    User user = DaoFactory.getUsersDao().findByUsername(username);


    //logic for sticky form if user is null
    if (user == null) {
      System.out.println("user is null");
      request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
      return;
    }
    //logic for sticky form if password is null
    if (password == null) {
      System.out.println("password is null");
      request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
      return;
    }

    boolean validAttempt = BCrypt.checkpw(password, user.getPassword());

    if (validAttempt) {
      request.getSession().setAttribute("user", user);
      UserAddress users_address = DaoFactory.getUsersAddressDao().findAddressByUserId(user.getId());
      request.getSession().setAttribute("address", users_address);
      response.sendRedirect("/profile");
    } else {
      request.setAttribute("error", "Invalid username/password");
      request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
  }
}
