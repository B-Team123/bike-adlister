package config;

public class Config {
    public static String getUrl(){
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }
    public static String getUser(){
        return "root";
    }
    public static String getPassword(){
        return "codeup";
    }
}
