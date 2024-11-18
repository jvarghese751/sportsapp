package com.example.sportsapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "leagues")
public class League {

    @PrimaryKey
    @NonNull
    private String idLeague;

    private String strLeague;
    private String strSport;
    private String strLeagueAlternate; // Correct name of the field

    // Constructor to initialize the fields
    public League(String idLeague, String strLeague, String strSport, String strLeagueAlternate) {
        this.idLeague = idLeague;
        this.strLeague = strLeague;
        this.strSport = strSport;
        this.strLeagueAlternate = strLeagueAlternate;
    }

    // Getter and Setter methods

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate; // Use correct field name here
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate; // Use correct field name here
    }
}