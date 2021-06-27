package com.example.onlinebet.models;

public class Match {
    int id;
    String title;
    Team team1;
    Team team2;
    double oddTeam1;
    double oddTeam2;
    double oddNull;

    public Match(String title, Team team1, Team team2, double oddTeam1, double oddTeam2, double oddNull) {
        this.title = title;
        this.team1 = team1;
        this.team2 = team2;
        this.oddTeam1 = oddTeam1;
        this.oddTeam2 = oddTeam2;
        this.oddNull = oddNull;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public double getOddTeam1() {
        return oddTeam1;
    }

    public double getOddTeam2() {
        return oddTeam2;
    }

    public double getOddNull() {
        return oddNull;
    }
}
