package com.codeup.adlister.dao;

import com.codeup.adlister.models.UserAddress;
import com.mysql.cj.jdbc.Driver;
import config.Config;

import java.sql.*;

public class MySQLUsersAddrDao implements UsersAddress{
    private Connection connection = null;

    public MySQLUsersAddrDao(Config config) {
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
    public UserAddress findByCity(String city) {
        String query = "SELECT * FROM adlister_db.users_address WHERE city = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, city);
            return extractUserAddress(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user by city: " + city, e);
        }
    }

    @Override
    public Long insert(UserAddress address) {
        String query = "Insert into adlister_db.users_address (street_address, city, state, zip_code) values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, address.getStreetAddress());
            stmt.setString(2, address.getCity());
            stmt.setString(3, address.getState());
            stmt.setString(4, address.getZipCode());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private UserAddress extractUserAddress(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new UserAddress(
                rs.getLong("id"),
                rs.getString("street_address"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("zip_code")
        );
    }
}
