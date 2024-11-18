package com.example.sportsapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClubsResponse {
    private List<Club> teams;

    public List<Club> getTeams() {
        return teams;
    }

    public void setTeams(List<Club> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "ClubsResponse{" +
                "teams=" + teams +
                '}';
    }
}