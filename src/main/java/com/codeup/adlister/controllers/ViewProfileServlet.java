package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.UsersAddress;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.UserAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if (request.getSession().getAttribute("user") == null) {
      response.sendRedirect("/login");
      return;
    }
    User user = (User) request.getSession().getAttribute("user");
    UserAddress address = (UserAddress) request.getSession().getAttribute("address");
    if (address != null) {
      String street = address.getStreetAddress();
      String city = address.getCity();
      String state = address.getState();

      request.setAttribute("street", street);
      request.setAttribute("city", city);
      request.setAttribute("state", state);
    }

    String username = user.getUsername();
    String email = user.getEmail();
    String phoneNumber = user.getPhoneNumber();
    String avatar_url = user.getAvatarURL();

    if (avatar_url == null) {
      avatar_url = "https://dummyimage.com/600x400/979797/000&text=Click+to+upload+/+edit+your+profile+photo";
    }

    request.setAttribute("username", username);
    request.setAttribute("email", email);
    request.setAttribute("phoneNumber", phoneNumber);
    request.setAttribute("avatar_url", avatar_url);

    request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String city = request.getParameter("edit_city");
    String state = request.getParameter("edit_state");
    String zip = request.getParameter("edit_zip");
    User user = (User) request.getSession().getAttribute("user");
    UserAddress users_address = (UserAddress) request.getSession().getAttribute("user-address");
    user.setAvatarURL(request.getParameter("photo"));
    user.setUsername(request.getParameter("edit_username"));
    user.setEmail(request.getParameter("edit_email"));
    user.setPhoneNumber(request.getParameter("edit_phone_number"));
    users_address.setCity(request.getParameter("edit_city"));
    users_address.setState(request.getParameter("edit_state"));
    users_address.setZipCode(request.getParameter("edit_zip"));
    request.getSession().setAttribute("user", user);
    request.getSession().setAttribute("users_address", users_address);
    DaoFactory.getUsersDao().update(user, users_address);
    DaoFactory.getUsersAddressDao().update(users_address, user);
    response.sendRedirect("/profile");
  }
}
