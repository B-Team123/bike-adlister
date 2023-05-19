package com.codeup.adlister.models;

import java.util.List;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private double price;
    private String type;
    private String size;
    private List<Feature> features;

    public Ad(long id, String title, String description, String price, String type, String size) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = Double.parseDouble(price);
        this.type = type;
        this.size = size;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Ad(long id, long userId, String title, String description, double price, String type, String size, List<Feature> features) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.type = type;
        this.size = size;
        this.features = features;
    }

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }
    public Ad(long id, long userId, String title, String description, double price) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
    }
    public Ad(long id, long userId, String title, String description, double price, String type, String size) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
