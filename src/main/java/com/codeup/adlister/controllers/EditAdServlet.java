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

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentSessionUser = (User) req.getSession().getAttribute("user");
        String adIdParam = req.getParameter("adId");
        if (currentSessionUser != null) {
            Ad ad = DaoFactory.getAdsDao().getAdById(Long.parseLong(adIdParam));
            System.out.println(ad.getType());
            System.out.println(ad.getPrice());
            System.out.println(ad.getTitle());
            req.setAttribute("edit_ad", ad);
            req.getRequestDispatcher("/WEB-INF/ads/edit.jsp")
                    .forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/ads/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentSessionUser = (User) req.getSession().getAttribute("user");
        System.out.println(currentSessionUser.getId());
        String price = req.getParameter("price");
        if (currentSessionUser != null) {
            Ad ad = new Ad(
                    Long.parseLong(req.getParameter("id")),
                    currentSessionUser.getId(),
                    req.getParameter("title"),
                    req.getParameter("description"),
                    Integer.parseInt(req.getParameter("price")),
                    req.getParameter("type"),
                    req.getParameter("size")
            );
            DaoFactory.getAdsDao().update(ad);
        }
        resp.sendRedirect("/ads");
    }
}
