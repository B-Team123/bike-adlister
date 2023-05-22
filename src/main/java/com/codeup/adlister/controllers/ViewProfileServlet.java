package com.codeup.adlister.controllers;

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
        if (address != null){
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

        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("phoneNumber", phoneNumber);

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String avatar_url = request.getParameter("avatar_url");
        User user = (User) request.getSession().getAttribute("user");
        user.setAvatarURL(avatar_url);



    }
}
