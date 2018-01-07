package prachi14075.iiitd.ac.in.sportsmanagementapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.MyMatchesDTO;

public class MyMatchesAdapter extends RecyclerView.Adapter<MyMatchesAdapter.ViewHolder>{

    Context mContext;
    private ArrayList<MyMatchesDTO> mMyMatchesList;

    public MyMatchesAdapter(Context mContext, ArrayList<MyMatchesDTO> mMyMatchesList) {
        this.mContext = mContext;
        this.mMyMatchesList = mMyMatchesList;
    }

    @Override
    public MyMatchesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_matches, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyMatchesAdapter.ViewHolder holder, int position) {
        final MyMatchesDTO myMatchesDTO = mMyMatchesList.get(position);

        holder.teamOneNameText.setText(myMatchesDTO.getTeamOneName());
        holder.teamTwoNameText.setText(myMatchesDTO.getTeamTwoName());
        holder.matchDateText.setText(myMatchesDTO.getMatchDate());

        if(myMatchesDTO.getTeamOneScore().equals("NA") && myMatchesDTO.getTeamTwoScore().equals("NA")){
            holder.teamTwoScoreText.setVisibility(View.INVISIBLE);
            holder.teamOneScoreText.setVisibility(View.INVISIBLE);
            holder.hyphenText.setVisibility(View.INVISIBLE);
            holder.matchTimeText.setText(myMatchesDTO.getMatchTime());
        }
        else {
            holder.matchTimeText.setVisibility(View.INVISIBLE);
            holder.teamOneScoreText.setText(myMatchesDTO.getTeamOneScore());
            holder.teamTwoScoreText.setText(myMatchesDTO.getTeamTwoScore());

            if(Integer.parseInt(myMatchesDTO.getTeamOneScore())>Integer.parseInt(myMatchesDTO.getTeamTwoScore())){
                holder.teamOneColorLayout.setBackgroundColor(mContext.getResources().getColor(R.color.red));
                holder.teamTwoColorLayout.setBackgroundColor(mContext.getResources().getColor(R.color.green));
            }
            else if(Integer.parseInt(myMatchesDTO.getTeamOneScore())<Integer.parseInt(myMatchesDTO.getTeamTwoScore())){
                holder.teamOneColorLayout.setBackgroundColor(mContext.getResources().getColor(R.color.green));
                holder.teamTwoColorLayout.setBackgroundColor(mContext.getResources().getColor(R.color.red));
            }
            else {
                holder.teamOneColorLayout.setBackgroundColor(mContext.getResources().getColor(R.color.grey_light));
                holder.teamTwoColorLayout.setBackgroundColor(mContext.getResources().getColor(R.color.grey_light));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mMyMatchesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout teamOneColorLayout;
        LinearLayout teamTwoColorLayout;
        TextView     teamOneNameText;
        TextView     teamTwoNameText;
        TextView     teamOneScoreText;
        TextView     teamTwoScoreText;
        TextView     matchDateText;
        TextView     matchTimeText;
        TextView     hyphenText;

        ViewHolder(View itemView) {
            super(itemView);
            teamOneColorLayout = (LinearLayout) itemView.findViewById(R.id.item_my_matches_team_one_color_layout);
            teamTwoColorLayout = (LinearLayout) itemView.findViewById(R.id.item_my_matches_team_two_color_layout);
            teamOneNameText    = (TextView)     itemView.findViewById(R.id.item_my_matches_team_one_name);
            teamTwoNameText    = (TextView)     itemView.findViewById(R.id.item_my_matches_team_two_name);
            teamOneScoreText   = (TextView)     itemView.findViewById(R.id.item_my_matches_score_team_one);
            teamTwoScoreText   = (TextView)     itemView.findViewById(R.id.item_my_matches_score_team_two);
            matchDateText      = (TextView)     itemView.findViewById(R.id.item_my_matches_date);
            matchTimeText      = (TextView)     itemView.findViewById(R.id.item_my_matches_time);
            hyphenText         = (TextView)     itemView.findViewById(R.id.item_my_matches_score_hyphen);
        }
    }
}
