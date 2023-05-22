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
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    public static void main(String[] args) {
        String bars = "bullhorns";
        String brakes = "disc";
        String bell = "bell";

        //construct csv style String
        String features = "";
        if (bars != null) {
            features += bars + ",";
        }
        if (brakes != null) {
            features += brakes + ",";
        }
        if (bell != null) {
            features += bell + ",";
        }
        //remove trailing comma
        features = features.substring(0, features.length() - 1);
        System.out.println(features);
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

//// Initialize the features list
//            List<Feature> barsInsert = new ArrayList<>();
//            List<Feature> brakesInsert = new ArrayList<>();
//            List<Feature> bellInsert = new ArrayList<>();
//
//            String bars = request.getParameter("bars");
//            String brakes = request.getParameter("brake-type");
//            String bell = request.getParameter("bell");



            DaoFactory.getAdsDao().insert(ad);
        }
        response.sendRedirect("/ads");
    }
}
