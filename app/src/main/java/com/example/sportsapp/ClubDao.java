package com.example.sportsapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;



@Dao
public interface ClubDao {

    @Insert
    void insertAll(List<Club> clubs);

    @Query("SELECT * FROM Club")
    LiveData<List<Club>> getAllClubs(); // Query to fetch all clubs as LiveData
}