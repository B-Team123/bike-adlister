package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Feature;
import com.mysql.cj.jdbc.Driver;
import config.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLFeaturesDao implements Features{
    private Connection connection = null;

    public MySQLFeaturesDao(Config config) {
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
    public List<Feature> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM adlister_db.features");
            ResultSet rs = stmt.executeQuery();
            return createFeaturesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all features.", e);
        }
    }

    @Override
    public Long insert(Feature feature) {
        try {
            String insertQuery = "INSERT INTO adlister_db.features(name) VALUES (?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, feature.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new feature.", e);
        }
    }

    @Override
    public List<Feature> findByAdId(long adId) {
        String query = "SELECT * FROM adlister_db.features feat " +
                "JOIN adlister_db.ads_feat_join afjoin ON feat.id = afjoin.feat_id_fk " +
                "JOIN adlister_db.ads ads ON afjoin.ad_id_fk = ads.id " +
                "WHERE ads.id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();
            return createFeaturesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding features for ad id: " + adId, e);
        }
    }

    private Feature extractFeature(ResultSet rs) throws SQLException {
        return new Feature(
                rs.getLong("id"),
                rs.getString("name")
        );
    }

    private List<Feature> createFeaturesFromResults(ResultSet rs) throws SQLException {
        List<Feature> Features = new ArrayList<>();
        while (rs.next()) {
            Features.add(extractFeature(rs));
        }
        return Features;
    }
}
