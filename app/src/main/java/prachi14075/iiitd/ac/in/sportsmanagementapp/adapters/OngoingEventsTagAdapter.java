package prachi14075.iiitd.ac.in.sportsmanagementapp.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.OngoingEventsTagDTO;

public class OngoingEventsTagAdapter  extends RecyclerView.Adapter<OngoingEventsTagAdapter.ViewHolder>{

    Context mContext;
    private ArrayList<OngoingEventsTagDTO> mOngoingEventsTagDTOArrayList;

    public OngoingEventsTagAdapter(Context mContext, ArrayList<OngoingEventsTagDTO> mOngoingEventsTagDTOArrayList) {
        this.mContext = mContext;
        this.mOngoingEventsTagDTOArrayList = mOngoingEventsTagDTOArrayList;
    }

    @Override
    public OngoingEventsTagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_upcoming_events, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OngoingEventsTagAdapter.ViewHolder holder, int position) {
        final OngoingEventsTagDTO upcmingEventsTagDTO = mOngoingEventsTagDTOArrayList.get(position);
        holder.tagName.setText(upcmingEventsTagDTO.getTagname());
    }

    @Override
    public int getItemCount() {
        return mOngoingEventsTagDTOArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tagName;
        ViewHolder(View itemView) {
            super(itemView);
            tagName = (TextView) itemView.findViewById(R.id.item_category_upcoming_events_tag_name);
        }
    }
}
