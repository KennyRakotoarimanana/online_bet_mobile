package com.example.onlinebet.models;

public class Team {
    int id;
    String name;
    String image;

    public Team(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
