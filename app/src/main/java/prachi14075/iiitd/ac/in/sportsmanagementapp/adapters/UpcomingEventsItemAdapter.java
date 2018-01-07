package prachi14075.iiitd.ac.in.sportsmanagementapp.adapters;


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
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.UpcomingEventDetailsActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.UpcomingEventsTagDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.UpcomingEventsDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.utils.Constants;

public class UpcomingEventsItemAdapter extends RecyclerView.Adapter<UpcomingEventsItemAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<UpcomingEventsDTO> mUpcomingEventsDTOArrayList;

    public UpcomingEventsItemAdapter(Context context, ArrayList<UpcomingEventsDTO> upcomingEventsDTOs) {
        mContext = context;
        mUpcomingEventsDTOArrayList = upcomingEventsDTOs;
    }
    @Override
    public UpcomingEventsItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_upcoming_events, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UpcomingEventsItemAdapter.ViewHolder holder,   int position) {
        final UpcomingEventsDTO upcomingEventsDTO = mUpcomingEventsDTOArrayList.get(position);

        holder  .upcomingEventName       .setText(upcomingEventsDTO.getUpcomingEventName());
        holder  .upcomingEventType       .setText(upcomingEventsDTO.getUpcomingEventType());
        holder  .upcomingEventDaysLeft   .setText(String.valueOf(upcomingEventsDTO.getUpcomingEventDaysLeft()));
        holder  .upcomingEventsCheckImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_check_circle)); //if registered

        String url = upcomingEventsDTO.getBackgroundImg();

        Glide
                .with(mContext)
                .load(url).centerCrop()
                .into(holder.upcomingEventsBackground);

        int number_of_tags = upcomingEventsDTO.getUpcomingEventNumberTags();

        if(Objects.equals(String.valueOf(upcomingEventsDTO.getUpcomingEventStatus()), "register")){
            holder.upcomingEventStatus.setText("Days left to register");
        }
        else if(Objects.equals(String.valueOf(upcomingEventsDTO.getUpcomingEventStatus()), "start")){
            holder.upcomingEventStatus.setText("Days left to start");
        }

        holder.upcomingEventsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, UpcomingEventDetailsActivity.class);
                intent.putExtra(Constants.INTENT_EXTRA_UPCOMING_EVENT_DETAILS,upcomingEventsDTO);
                mContext.startActivity(intent);
            }
        });

        holder.upcomingEventsRecyclerView.setLayoutManager(holder.upcomingEventsTagLinearLayoutManager);
        holder.upcomingEventsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.upcomingEventsRecyclerView.setAdapter(holder.upcomingEventsTagAdapter);
        addUpcomingEventsListData(holder, number_of_tags);
    }

    private void addUpcomingEventsListData(UpcomingEventsItemAdapter.ViewHolder holder, int number_of_tags) {

//        for(int i = 1; i <=number_of_tags; i++){
//
//        }

        UpcomingEventsTagDTO upcomingEventsTagDTO = new UpcomingEventsTagDTO("Men's");
        holder.upcomingEventsTagList.add(upcomingEventsTagDTO);

        UpcomingEventsTagDTO upcomingEventsTagDTO1 = new UpcomingEventsTagDTO("Women's");
        holder.upcomingEventsTagList.add(upcomingEventsTagDTO1);

        holder.upcomingEventsTagAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mUpcomingEventsDTOArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView     upcomingEventName;
        TextView     upcomingEventType;
        TextView     upcomingEventDaysLeft;
        TextView     upcomingEventStatus;
        CardView     upcomingEventsCard;
        ImageView    upcomingEventsBackground;
        ImageView    upcomingEventsCheckImage;

        RecyclerView upcomingEventsRecyclerView;
        ArrayList<UpcomingEventsTagDTO> upcomingEventsTagList;
        LinearLayoutManager  upcomingEventsTagLinearLayoutManager;
        UpcomingEventsTagAdapter upcomingEventsTagAdapter;

        ViewHolder(View itemView) {
            super(itemView);
            upcomingEventName     = (TextView) itemView.findViewById(R.id.item_upcoming_events_event_name);
            upcomingEventType     = (TextView) itemView.findViewById(R.id.item_upcoming_events_event_type);
            upcomingEventDaysLeft = (TextView) itemView.findViewById(R.id.item_upcoming_events_next_match_days);
            upcomingEventStatus   = (TextView) itemView.findViewById(R.id.item_upcoming_events_status);
            upcomingEventsCard    = (CardView) itemView.findViewById(R.id.item_upcoming_events_cardview);
            upcomingEventsCheckImage   = (ImageView)    itemView.findViewById(R.id.item_upcoming_events_check_image);
            upcomingEventsBackground   = (ImageView)    itemView.findViewById(R.id.item_upcoming_events_background);
            upcomingEventsRecyclerView = (RecyclerView) itemView.findViewById(R.id.item_upcoming_events_category_recycler_view);

            upcomingEventsTagList        = new ArrayList<>();
            upcomingEventsTagAdapter     = new UpcomingEventsTagAdapter(mContext, upcomingEventsTagList);
            upcomingEventsTagLinearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL, false);
        }
    }
}
