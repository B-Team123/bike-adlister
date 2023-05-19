package com.codeup.adlister.dao;

import config.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static UsersAddress usersAddressDao;
    private static Features featuresDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
    public static UsersAddress getUsersAddressDao() {
        if (usersAddressDao == null) {
            usersAddressDao = new MySQLUsersAddrDao(config);
        }
        return usersAddressDao;
    }
    public static Features getFeaturesDao() {
        if (featuresDao == null) {
            featuresDao = new MySQLFeaturesDao(config);
        }
        return featuresDao;
    }
}
