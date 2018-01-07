package prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin;


import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.FixturesDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.MyMatchesDTO;

public class FixturesAdapterAdmin extends RecyclerView.Adapter<FixturesAdapterAdmin.ViewHolder>{

    Context mContext;
    private ArrayList<FixturesDTO> mFixtureRoundsList;
    int flag = 1;

    public FixturesAdapterAdmin(Context mContext, ArrayList<FixturesDTO> mFixtureRoundsList) {
        this.mContext = mContext;
        this.mFixtureRoundsList = mFixtureRoundsList;
    }

    @Override
    public FixturesAdapterAdmin.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fixtures_rounds, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FixturesAdapterAdmin.ViewHolder holder, int position) {
        final FixturesDTO fixturesDTO = mFixtureRoundsList.get(position);
        holder.roundName.setText(fixturesDTO.getRoundName());
        holder.roundArrow.setImageDrawable(fixturesDTO.getDropDownImage());
        holder.roundArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag == 0) {
                    holder.roundsRecyclerView.setVisibility(View.VISIBLE);
                    holder.roundArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_arrow_up));
                    flag = 1;
                }
                else {
                    holder.roundsRecyclerView.setVisibility(View.GONE);
                    holder.roundArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_arrow_down));
                    flag = 0;
                }
            }
        });

        holder.roundsRecyclerView .setLayoutManager(holder.matchLayoutManager);
        holder.roundsRecyclerView .setItemAnimator(new DefaultItemAnimator());
        holder.roundsRecyclerView .setAdapter(holder.matchDetailsAdapter);
        addFixturesListData(holder, position);

    }

    private void addFixturesListData(final FixturesAdapterAdmin.ViewHolder holder, int position) {
        MyMatchesDTO myMatchesDTO1 = new MyMatchesDTO("Chica Bonita","NA","06:30","09/4/17","NFCFC","NA","No");
        holder.matchDetailsList.add(myMatchesDTO1);

        MyMatchesDTO myMatchesDTO = new MyMatchesDTO("Chica Bonita","3","05:30","05/4/17","Luka Chuppi","4","Yes");
        holder.matchDetailsList.add(myMatchesDTO);

        MyMatchesDTO myMatchesDTO3 = new MyMatchesDTO("Chica Bonita","0","07:30","03/4/17","Lakers","0","Yes");
        holder.matchDetailsList.add(myMatchesDTO3);

        MyMatchesDTO myMatchesDTO4 = new MyMatchesDTO("Chica Bonita","2","01:30","02/4/17","Arsenal","1","Yes");
        holder.matchDetailsList.add(myMatchesDTO4);

        holder.matchDetailsAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mFixtureRoundsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView roundName;
        ImageView roundArrow;
        RecyclerView roundsRecyclerView;
        ArrayList<MyMatchesDTO> matchDetailsList;
        LinearLayoutManager     matchLayoutManager;
        FixtureDetailsAdapterAdmin   matchDetailsAdapter;

        ViewHolder(View itemView) {
            super(itemView);
            roundName           = (TextView)     itemView.findViewById(R.id.item_fixtures_rounds_round_name);
            roundArrow          = (ImageView)    itemView.findViewById(R.id.item_fixtures_rounds_dropdown_icon);
            roundsRecyclerView  = (RecyclerView) itemView.findViewById(R.id.item_fixtures_rounds_recycler_view);
            matchDetailsList    = new ArrayList<>();
            matchLayoutManager  = new LinearLayoutManager(mContext);
            matchDetailsAdapter = new FixtureDetailsAdapterAdmin(mContext,matchDetailsList);
        }
    }
}
