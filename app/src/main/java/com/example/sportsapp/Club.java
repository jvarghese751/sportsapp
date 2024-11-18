package com.example.sportsapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Club {
    @PrimaryKey
    @NonNull
    private String idTeam;

    private String strTeam;
    private String strTeamShort;
    private String strAlternate;
    private String intFormedYear;
    private String strLeague;
    private String idLeague;
    private String strStadium;
    private String strKeywords;
    private String strStadiumThumb;
    private String strStadiumLocation;
    private String intStadiumCapacity;
    private String strWebsite;
    private String strTeamLogo;

    // Getters and Setters

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamShort() {
        return strTeamShort;
    }

    public void setStrTeamShort(String strTeamShort) {
        this.strTeamShort = strTeamShort;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrKeywords() {
        return strKeywords;
    }

    public void setStrKeywords(String strKeywords) {
        this.strKeywords = strKeywords;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) {
        this.strStadiumLocation = strStadiumLocation;
    }

    public String getIntStadiumCapacity() {
        return intStadiumCapacity;
    }

    public void setIntStadiumCapacity(String intStadiumCapacity) {
        this.intStadiumCapacity = intStadiumCapacity;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public void setStrTeamLogo(String strTeamLogo) {
        this.strTeamLogo = strTeamLogo;
    }
}