package com.codeup.adlister.models;

public class Feature {
    private long id;
    private String name;

    public Feature() {
    }

    public Feature(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Feature(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
