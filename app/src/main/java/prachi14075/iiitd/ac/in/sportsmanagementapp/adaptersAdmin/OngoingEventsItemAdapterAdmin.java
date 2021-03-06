package prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Objects;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin.AddEventActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin.EditEventActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin.OngoingEventDetailsActivityAdmin;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.OngoingEventsTagAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.OngoingEventsDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.OngoingEventsTagDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.utils.Constants;

public class OngoingEventsItemAdapterAdmin extends RecyclerView.Adapter<OngoingEventsItemAdapterAdmin.ViewHolder>{

    private Context mContext;
    private ArrayList<OngoingEventsDTO> mOngoingEventsDTOArrayList;
    public OngoingEventsItemAdapterAdmin(Context mContext, ArrayList<OngoingEventsDTO> mOngoingEventsDTOArrayList) {
        this.mContext = mContext;
        this.mOngoingEventsDTOArrayList = mOngoingEventsDTOArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ongoing_events, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final OngoingEventsDTO ongoingEventsDTO = mOngoingEventsDTOArrayList.get(position);

        holder  .ongoingEventName        .setText(ongoingEventsDTO.getOngoingEventName());
        holder  .ongoingEventType        .setText(ongoingEventsDTO.getOngoingEventType());
        holder  .ongoingEventDaysLeft    .setText(String.valueOf(ongoingEventsDTO.getOngoingEventDaysLeft()));
        holder  .ongoingEventsEditEvent  .setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_edit));
        int number_of_tags = ongoingEventsDTO.getOngoingEventNumberTags();

        String url = ongoingEventsDTO.getOngoingBackgroundImg();

        Glide
                .with(mContext)
                .load(url).centerCrop()
                .into(holder.ongoingEventsBackground);

        if(Objects.equals(String.valueOf(ongoingEventsDTO.getOngoingEventStatus()), "next match")){
            holder.ongoingEventStatus.setText("Days left for next match");
        }
        else if(Objects.equals(String.valueOf(ongoingEventsDTO.getOngoingEventStatus()), "finals")){
            holder.ongoingEventStatus.setText("Days left for finals");
        }

        holder.ongoingEventsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, OngoingEventDetailsActivityAdmin.class);
                intent.putExtra(Constants.INTENT_EXTRA_ONGOING_EVENT_DETAILS,ongoingEventsDTO);
                mContext.startActivity(intent);
            }
        });

        holder.ongoingEventsEditEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EditEventActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.ongoingEventsRecyclerView.setLayoutManager(holder.ongoingEventsTagLinearLayoutManager);
        holder.ongoingEventsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.ongoingEventsRecyclerView.setAdapter(holder.ongoingEventsTagAdapter);
        addOngoingEventsListData(holder, number_of_tags);
    }

    private void addOngoingEventsListData(ViewHolder holder, int number_of_tags) {

//        for(int i = 1; i <=number_of_tags; i++){
//
//        }
        OngoingEventsTagDTO ongoingEventsTagDTO = new OngoingEventsTagDTO("Women's");
        holder.ongoingEventsTagList.add(ongoingEventsTagDTO);

        holder.ongoingEventsTagAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mOngoingEventsDTOArrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView    ongoingEventName;
        TextView    ongoingEventType;
        TextView    ongoingEventDaysLeft;
        TextView    ongoingEventStatus;
        CardView    ongoingEventsCard;
        ImageView   ongoingEventsBackground;
        ImageView   ongoingEventsEditEvent;

        RecyclerView ongoingEventsRecyclerView;
        ArrayList<OngoingEventsTagDTO> ongoingEventsTagList;
        LinearLayoutManager ongoingEventsTagLinearLayoutManager;
        OngoingEventsTagAdapter ongoingEventsTagAdapter;

        ViewHolder(View itemView) {
            super(itemView);
            ongoingEventName     = (TextView) itemView.findViewById(R.id.item_ongoing_events_event_name);
            ongoingEventType     = (TextView) itemView.findViewById(R.id.item_ongoing_events_event_type);
            ongoingEventDaysLeft = (TextView) itemView.findViewById(R.id.item_ongoing_events_next_match_days);
            ongoingEventStatus   = (TextView) itemView.findViewById(R.id.item_ongoing_events_status);
            ongoingEventsCard    = (CardView) itemView.findViewById(R.id.item_ongoing_events_cardview);
            ongoingEventsRecyclerView       = (RecyclerView) itemView.findViewById(R.id.item_ongoing_events_category_recycler_view);
            ongoingEventsBackground         = (ImageView)    itemView.findViewById(R.id.item_ongoing_events_background);
            ongoingEventsEditEvent          = (ImageView)    itemView.findViewById(R.id.item_ongoing_events_check_image);

            ongoingEventsTagList        = new ArrayList<>();
            ongoingEventsTagAdapter     = new OngoingEventsTagAdapter(mContext, ongoingEventsTagList);
            ongoingEventsTagLinearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL, false);
        }
    }
}
