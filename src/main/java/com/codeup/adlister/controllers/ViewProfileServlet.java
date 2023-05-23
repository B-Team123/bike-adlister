package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.UsersAddress;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.UserAddress;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ObjectMapper mapper = new ObjectMapper();

    if (request.getSession().getAttribute("user") == null) {
      response.sendRedirect("/login");
      return;
    }
    User user = (User) request.getSession().getAttribute("user");
    UserAddress users_address = (UserAddress) request.getSession().getAttribute("address");

    if (users_address != null) {
      String street = users_address.getStreetAddress();
      String city = users_address.getCity();
      String state = users_address.getState();
      request.setAttribute("street", street);
      request.setAttribute("city", city);
      request.setAttribute("state", state);
    }

    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users_address));
    user.setAddress(users_address);

    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));

    String username = user.getUsername();
    String email = user.getEmail();
    String phoneNumber = user.getPhoneNumber();
    String avatar_url = user.getAvatarURL();
    String city = user.getAddress().getCity();
    String state = user.getAddress().getState();
    String zip = user.getAddress().getZipCode();


    if (avatar_url == null) {
      avatar_url = "https://dummyimage.com/600x400/979797/000&text=Click+to+upload+/+edit+your+profile+photo";
    }

    request.setAttribute("username", username);
    request.setAttribute("email", email);
    request.setAttribute("phoneNumber", phoneNumber);
    request.setAttribute("city", city);
    request.setAttribute("state", state);
    request.setAttribute("zip", zip);
    request.setAttribute("avatar_url", avatar_url);

    request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = (User) request.getSession().getAttribute("user");
    user.setAvatarURL(request.getParameter("photo"));
    user.setUsername(request.getParameter("edit_username"));
    user.setEmail(request.getParameter("edit_email"));
    user.setPhoneNumber(request.getParameter("edit_phone_number"));
    UserAddress users_address = (UserAddress) request.getSession().getAttribute("address");
    users_address.setCity(request.getParameter("edit_city"));
    users_address.setState(request.getParameter("edit_state"));
    users_address.setZipCode(request.getParameter("edit_zip"));
    user.setAddress(users_address);
    request.getSession().setAttribute("user", user);
    request.getSession().setAttribute("address", users_address);
    DaoFactory.getUsersDao().update(user);
    DaoFactory.getUsersAddressDao().findAddressByUserId(user.getId());
    response.sendRedirect("/profile");
  }
}
