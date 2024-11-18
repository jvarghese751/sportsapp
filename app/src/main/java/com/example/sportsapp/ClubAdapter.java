package com.example.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {

    private List<Club> clubs = new ArrayList<>();

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_club, parent, false);
        return new ClubViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder holder, int position) {
        Club club = clubs.get(position);
        holder.tvName.setText(club.getStrTeam());
        holder.tvStadium.setText(club.getStrStadium());
        holder.tvYear.setText("Formed: " + club.getIntFormedYear());
        Glide.with(holder.itemView.getContext())
                .load(club.getStrTeamLogo())
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
        notifyDataSetChanged();
    }

    static class ClubViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvStadium, tvYear;
        ImageView ivLogo;

        public ClubViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvStadium = itemView.findViewById(R.id.tvStadium);
            tvYear = itemView.findViewById(R.id.tvYear);
            ivLogo = itemView.findViewById(R.id.ivLogo);
        }
    }
}