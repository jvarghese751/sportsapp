package com.example.sportsapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Club.class}, version = 1, exportSchema = false)
public abstract class SportsDatabase extends RoomDatabase {

    // Provide access to the DAO
    public abstract ClubDao clubDao();
}