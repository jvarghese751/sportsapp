package com.example.sportsapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LeagueDao {

    @Insert
    void insertAll(List<League> leagues);

    @Query("DELETE FROM leagues")
    void deleteAllLeagues();

    @Query("SELECT * FROM leagues")
    LiveData<List<League>> getAllLeagues();
}