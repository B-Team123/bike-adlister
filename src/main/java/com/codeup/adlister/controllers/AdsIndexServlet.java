package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentSessionUser = (User) request.getSession().getAttribute("user");
        if (currentSessionUser != null) {
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            User user = (User) request.getSession().getAttribute("user");
            long userId = user.getId();
            request.setAttribute("userId", userId);
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("adToDelete") != null) {
            long currentAdId = Long.parseLong(request.getParameter("adToDelete"));
            System.out.println("Ad ID to delete: " + currentAdId);
            DaoFactory.getAdsDao().removeAd(currentAdId);
            response.sendRedirect("/ads");
        } else if (request.getParameter("search") != null) {
                String searchText = request.getParameter("search");
                System.out.println("Search text: " + searchText);
                List<Ad> searchResults = DaoFactory.getAdsDao().searchAd(searchText);
                request.setAttribute("searchResults", searchResults);
                //send redirect to searchedAds.jsp
                request.getRequestDispatcher("/WEB-INF/ads/searchedAds.jsp").forward(request, response);

            }

    }
}
