package com.example.sportsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("search_all_teams.php")
    Call<ClubsResponse> getClubsByLeague(@Query("l") String leagueName);
}