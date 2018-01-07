package prachi14075.iiitd.ac.in.sportsmanagementapp.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.UpcomingEventsTagDTO;

public class UpcomingEventsTagAdapter extends RecyclerView.Adapter<UpcomingEventsTagAdapter.ViewHolder>{

    Context mContext;
    private ArrayList<UpcomingEventsTagDTO> mUpcomingEventsTagDTOArrayList;

    public UpcomingEventsTagAdapter(Context mContext, ArrayList<UpcomingEventsTagDTO> mUpcomingEventsTagDTOArrayList) {
        this.mContext = mContext;
        this.mUpcomingEventsTagDTOArrayList = mUpcomingEventsTagDTOArrayList;
    }

    @Override
    public UpcomingEventsTagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_upcoming_events, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UpcomingEventsTagAdapter.ViewHolder holder, int position) {
        final UpcomingEventsTagDTO upcomingEventsTagDTO = mUpcomingEventsTagDTOArrayList.get(position);
        holder.tagName.setText(upcomingEventsTagDTO.getTagname());
    }

    @Override
    public int getItemCount() {
        return mUpcomingEventsTagDTOArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView  tagName;
        ViewHolder(View itemView) {
            super(itemView);
            tagName = (TextView) itemView.findViewById(R.id.item_category_upcoming_events_tag_name);
        }
    }
}
