package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Feature;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentSessionUser = (User) request.getSession().getAttribute("user");
        if (currentSessionUser != null) {
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/ads/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentSessionUser = (User) request.getSession().getAttribute("user");
        System.out.println(currentSessionUser.getId());
        if (currentSessionUser != null) {
            Ad ad = new Ad(
                    currentSessionUser.getId(),
                    request.getParameter("title"),
                    request.getParameter("description"),
                    request.getParameter("price"),
                    request.getParameter("size"),
                    request.getParameter("type")
            );


            DaoFactory.getAdsDao().insert(ad);
        }
        response.sendRedirect("/ads");
    }
}
