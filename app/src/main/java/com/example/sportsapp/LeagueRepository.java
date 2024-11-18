package com.example.sportsapp;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LeagueRepository {
    private LeagueDao leagueDao;

    public LeagueRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        leagueDao = database.leagueDao();
    }

    // Method to delete all leagues from the database
    public void deleteAllLeagues() {
        AppDatabase.getDatabaseWriteExecutor().execute(() -> {
            leagueDao.deleteAllLeagues();  // Deletes all leagues from the database
        });
    }

    // Method to insert multiple leagues into the database
    public void insertLeagues(List<League> leagues) {
        AppDatabase.getDatabaseWriteExecutor().execute(() -> {
            leagueDao.insertAll(leagues);  // Calls the insertAll method from LeagueDao
        });
    }

    // Method to get all leagues from the database
    public LiveData<List<League>> getAllLeagues() {
        return leagueDao.getAllLeagues();
    }
}