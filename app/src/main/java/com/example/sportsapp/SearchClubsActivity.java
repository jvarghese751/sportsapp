package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchClubsActivity extends AppCompatActivity {

    private EditText etLeagueName;
    private Button btnRetrieveClubs, btnSaveClubs;
    private RecyclerView rvClubs;
    private ClubAdapter adapter;
    private List<Club> retrievedClubs;

    private ClubRepository clubRepository;  // Use ClubRepository instead of LeagueRepository

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clubs);

        etLeagueName = findViewById(R.id.etLeagueName);
        btnRetrieveClubs = findViewById(R.id.btnRetrieveClubs);
        btnSaveClubs = findViewById(R.id.btnSaveClubs);
        rvClubs = findViewById(R.id.rvClubs);

        clubRepository = new ClubRepository(getApplication()); // Initialize ClubRepository

        rvClubs.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ClubAdapter();
        rvClubs.setAdapter(adapter);

        btnRetrieveClubs.setOnClickListener(v -> fetchClubs());
        btnSaveClubs.setOnClickListener(v -> saveClubsToDatabase());
    }

    private void fetchClubs() {
        String leagueName = etLeagueName.getText().toString().trim();
        if (leagueName.isEmpty()) {
            Toast.makeText(this, "Please enter a league name", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set up logging interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .client(client)  // Add the custom OkHttpClient with logging
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        apiService.getClubsByLeague(leagueName).enqueue(new Callback<ClubsResponse>() {
            @Override
            public void onResponse(Call<ClubsResponse> call, Response<ClubsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ClubsResponse clubsResponse = response.body();

                    // Log the entire response for debugging
                    Log.d("SearchClubsActivity", "API Response: " + clubsResponse.toString());

                    // Check if teams are present
                    if (clubsResponse.getTeams() != null && !clubsResponse.getTeams().isEmpty()) {
                        retrievedClubs = clubsResponse.getTeams();
                        adapter.setClubs(retrievedClubs); // Update the adapter
                        Log.d("SearchClubsActivity", "Found " + retrievedClubs.size() + " clubs.");
                    } else {
                        Log.e("SearchClubsActivity", "No clubs found in the response.");
                        Toast.makeText(SearchClubsActivity.this, "No clubs found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("SearchClubsActivity", "Error response: " + response.message());
                    Toast.makeText(SearchClubsActivity.this, "Failed to fetch clubs", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClubsResponse> call, Throwable t) {
                Toast.makeText(SearchClubsActivity.this, "Failed to fetch clubs", Toast.LENGTH_SHORT).show();
                t.printStackTrace();  // Print the stack trace for better debugging
            }
        });
    }

    private void saveClubsToDatabase() {
        if (retrievedClubs == null || retrievedClubs.isEmpty()) {
            Toast.makeText(this, "No clubs to save", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(() -> {
            clubRepository.insertClubs(retrievedClubs);  // Use ClubRepository to insert clubs
            runOnUiThread(() -> Toast.makeText(this, "Clubs saved to database", Toast.LENGTH_SHORT).show());
        }).start();
    }
}