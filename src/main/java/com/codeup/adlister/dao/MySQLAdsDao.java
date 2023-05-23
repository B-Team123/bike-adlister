package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Feature;
import com.mysql.cj.jdbc.Driver;
import config.Config;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                Config.getUrl(),
                Config.getUser(),
                Config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        String insertQuery = "INSERT INTO adlister_db.ads(user_id, title, description, price, size, type) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setInt(4, ad.getPrice());
            stmt.setString(5, ad.getSize());
            stmt.setString(6, ad.getType());

            System.out.println(ad.getUserId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public List<Ad> userAds(Long userId) {
        return null;
    }

    @Override
    public List<Ad> filterByType(String type) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM adlister_db.ads WHERE type = ?");
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad for type: " + type, e);
        }
    }

    @Override
    public List<Ad> filterBySize(String size) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE size = ?");
            stmt.setString(1, size);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad for size: " + size, e);
        }
    }

    @Override
    public void removeAd(Long adId) {
        String deleteQuery = "DELETE FROM adlister_db.ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, adId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad with id: " + adId, e);
        }
    }

    @Override
    public Ad getAdById(Long adId) {
        String query = "SELECT * FROM adlister_db.ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad with id: " + adId, e);
        }
    }

    @Override
    public void update(Ad ad) {
        String updateQuery = "UPDATE adlister_db.ads SET title = ?, description = ?, price = ?, size = ?, type = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setInt(3, ad.getPrice());
            stmt.setString(4, ad.getSize());
            stmt.setString(5, ad.getType());
            stmt.setLong(6, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad with id: " + ad.getId(), e);
        }
    }

    @Override
    public List<Ad> searchAd(String search) {
        String searchQuery = "SELECT * FROM adlister_db.ads WHERE title LIKE ? OR description LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(searchQuery);
            stmt.setString(1, "%" + search + "%");
            stmt.setString(2, "%" + search + "%");
            ResultSet rs =  stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for ad with search: " + search, e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("price"),
                rs.getString("size"),
                rs.getString("type")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }






}
