package com.example.sportsapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ClubRepository {
    private ClubDao clubDao;

    public ClubRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        clubDao = database.clubDao(); // This should refer to the DAO for Club objects
    }

    // Method to insert multiple clubs into the database
    public void insertClubs(List<Club> clubs) {
        AppDatabase.getDatabaseWriteExecutor().execute(() -> {
            clubDao.insertAll(clubs);  // Calls the insertAll method from ClubDao
        });
    }

    // Method to get all clubs from the database
    public LiveData<List<Club>> getAllClubs() {
        return clubDao.getAllClubs(); // Return LiveData for observation
    }
}