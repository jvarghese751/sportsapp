package com.example.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder> {

    private List<League> leagues = new ArrayList<>();

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_league, parent, false);
        return new LeagueViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueViewHolder holder, int position) {
        League league = leagues.get(position);
        holder.tvLeagueName.setText(league.getStrLeague());
        holder.tvSport.setText(league.getStrSport());
        holder.tvAlternateNames.setText(league.getStrLeagueAlternate());
    }

    @Override
    public int getItemCount() {
        return leagues.size();
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
        notifyDataSetChanged();
    }

    static class LeagueViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeagueName, tvSport, tvAlternateNames;

        public LeagueViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLeagueName = itemView.findViewById(R.id.tvLeagueName);
            tvSport = itemView.findViewById(R.id.tvSport);
            tvAlternateNames = itemView.findViewById(R.id.tvAlternateNames);
        }
    }
}