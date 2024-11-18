package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LeagueRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = new LeagueRepository(getApplication());

        findViewById(R.id.btnAddLeagues).setOnClickListener(view -> addLeaguesToDb());
        findViewById(R.id.btnSearchByLeague).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SearchClubsActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.btnSearchClubs).setOnClickListener(view -> {
            // Open a new activity or handle search
        });
    }

    private void addLeaguesToDb() {
        // First delete all existing leagues
        repository.deleteAllLeagues();

        // Create a list of new leagues
        List<League> leagues = new ArrayList<>();
        leagues.add(new League("4330", "Scottish Premier League", "Soccer", "Scottish Premiership, SPFL"));
        leagues.add(new League("4331", "German Bundesliga", "Soccer", "Bundesliga, Fußball-Bundesliga"));
        leagues.add(new League("4332", "Italian Serie A", "Soccer", "Serie A"));
        leagues.add(new League("4334", "French Ligue 1", "Soccer", "Ligue 1 Conforama"));
        leagues.add(new League("4335", "Spanish La Liga", "Soccer", "LaLiga Santander, La Liga"));
        leagues.add(new League("4336", "Greek Superleague Greece", "Soccer", ""));
        leagues.add(new League("4337", "Dutch Eredivisie", "Soccer", "Eredivisie"));
        leagues.add(new League("4338", "Belgian Pro League", "Soccer", "Jupiler Pro League"));

        // Insert the new leagues
        repository.insertLeagues(leagues);

        // Show a Toast message to notify the user
        Toast.makeText(this, "Leagues added to the database.", Toast.LENGTH_SHORT).show();
    }
}