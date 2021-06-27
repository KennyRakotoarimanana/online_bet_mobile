package com.example.onlinebet.adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinebet.R;
import com.example.onlinebet.models.Match;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class ListMatchAdapter extends RecyclerView.Adapter<ListMatchAdapter.ViewHolder> {
    private Match[] listMatch;

    public ListMatchAdapter(Match[] listMatch) {
        this.listMatch = listMatch;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_match_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Log.d("Position", position+"");
        holder.getTitleTextView().setText(listMatch[position].getTitle());
        holder.getTeam1Name().setText(listMatch[position].getTeam1().getName());
        holder.getTeam2Name().setText(listMatch[position].getTeam2().getName());

        Picasso.get().load("https://www.jeunesfooteux.com/photo/art/grande/57357491-42506046.jpg?v=1624758181").into(holder.getTeam1Pic());
        Picasso.get().load("https://cdn.1min30.com/wp-content/uploads/2018/03/Logo-Bayern-Munich-1.jpg").into(holder.getTeam2Pic());
        /* holder.getTeam1Pic().setImageURI(Uri.parse("https://www.jeunesfooteux.com/photo/art/grande/57357491-42506046.jpg?v=1624758181"));
        holder.getTeam2Pic().setImageURI(Uri.parse("https://cdn.1min30.com/wp-content/uploads/2018/03/Logo-Bayern-Munich-1.jpg")); */
        holder.getTeam1Odd().setText(String.valueOf(listMatch[position].getOddTeam1()));
        holder.getTeam2Odd().setText(String.valueOf(listMatch[position].getOddTeam2()));
        holder.getNullOdd().setText(String.valueOf(listMatch[position].getOddNull()));
    }

    @Override
    public int getItemCount() {
        return listMatch.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView team1Name;
        TextView team2Name;
        CircularImageView team1Pic;
        CircularImageView team2Pic;
        Button team1Odd;
        Button team2Odd;
        Button nullOdd;

        public ViewHolder(View view) {
            super(view);
            titleTextView = (TextView) view.findViewById(R.id.fragment_match_card_title);
            team1Name = (TextView) view.findViewById(R.id.fragment_match_card_team1_name);
            team2Name = (TextView) view.findViewById(R.id.fragment_match_card_team2_name);
            team1Pic = (CircularImageView) view.findViewById(R.id.fragment_match_card_team1_pic);
            team2Pic = (CircularImageView) view.findViewById(R.id.fragment_match_card_team2_pic);
            team1Odd = (Button) view.findViewById(R.id.fragment_match_card_team1_odd);
            team2Odd = (Button) view.findViewById(R.id.fragment_match_card_team2_odd);
            nullOdd = (Button) view.findViewById(R.id.fragment_match_card_null_odd);
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public TextView getTeam1Name() {
            return team1Name;
        }

        public TextView getTeam2Name() {
            return team2Name;
        }

        public CircularImageView getTeam1Pic() {
            return team1Pic;
        }

        public CircularImageView getTeam2Pic() {
            return team2Pic;
        }

        public Button getTeam1Odd() {
            return team1Odd;
        }

        public Button getTeam2Odd() {
            return team2Odd;
        }

        public Button getNullOdd() {
            return nullOdd;
        }
    }
}
