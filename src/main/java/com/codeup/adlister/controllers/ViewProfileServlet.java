package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

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

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //generate profile information
        //get user id from session
        long userId = ((com.codeup.adlister.models.User) req.getSession().getAttribute("user")).getId();
        String userName = ((com.codeup.adlister.models.User) req.getSession().getAttribute("user")).getUsername();
        //get user ads
        req.setAttribute("ads", DaoFactory.getAdsDao().userAds(userId));
        //get user info
        req.setAttribute("user", DaoFactory.getUsersDao().findByUsername(userName));
        //get user address
        req.setAttribute("address", DaoFactory.getUsersAddressDao().findAddressByUserId(5L));

    }
}
