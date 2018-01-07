package prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.MatchTimingsDTO;

public class MatchTimingsAdapter extends RecyclerView.Adapter<MatchTimingsAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<MatchTimingsDTO> mMatchTimingsArrayList;

    public MatchTimingsAdapter(Context mContext, ArrayList<MatchTimingsDTO> mMatchTimingsArrayList) {
        this.mContext = mContext;
        this.mMatchTimingsArrayList = mMatchTimingsArrayList;
    }

    @Override
    public MatchTimingsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_add_event_duration, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MatchTimingsDTO matchTimingsDTO = mMatchTimingsArrayList.get(position);
        holder.matchStartTime.setText(matchTimingsDTO.getStartTime());
        holder.matchEndTime  .setText(matchTimingsDTO.getEndTime());
    }

    @Override
    public int getItemCount() {
        return mMatchTimingsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        EditText matchStartTime;
        EditText matchEndTime;
        public ViewHolder(View itemView) {
            super(itemView);
            matchStartTime = (EditText) itemView.findViewById(R.id.match_start_time);
            matchEndTime   = (EditText) itemView.findViewById(R.id.match_end_time);

        }
    }
}
