package prachi14075.iiitd.ac.in.sportsmanagementapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.OngoingEventsItemAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.OngoingEventsDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.UpcomingEventsDTO;

/**
 * A simple {@link Fragment} subclass.
 */
public class OngoingEventsFragment extends Fragment {

    RecyclerView mOngoingEventsItemRecyclerView;
    FrameLayout mOngoingEventsItemContainer;
    ArrayList<OngoingEventsDTO> mOngoingEventsItemList;
    LinearLayoutManager mOngoingEventsItemLinearLayoutManager;
    OngoingEventsItemAdapter mOngoingEventsItemAdapter;

    public OngoingEventsFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       
        View view = inflater.inflate(R.layout.fragment_ongoing_events, container, false);
        initializeViews(view);
        setUpEventsList();
        return view;
    }

    private void setUpEventsList() {
        mOngoingEventsItemList        = new ArrayList<>();
        mOngoingEventsItemAdapter     = new OngoingEventsItemAdapter(getContext(), mOngoingEventsItemList);
        mOngoingEventsItemLinearLayoutManager = new LinearLayoutManager(getContext());

        mOngoingEventsItemRecyclerView .setLayoutManager(mOngoingEventsItemLinearLayoutManager);
        mOngoingEventsItemRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mOngoingEventsItemRecyclerView .setAdapter(mOngoingEventsItemAdapter);
        addOngoingEventsListData();
    }

    private void addOngoingEventsListData() {
        OngoingEventsDTO ongoingEventsDTO1 = new OngoingEventsDTO(
                "http://www.sportsudest.ro/wp-content/uploads/2016/07/8.fotbal.jpg",
                "Joga Bonito", "Football", "02", "next match",1);
        mOngoingEventsItemList.add(ongoingEventsDTO1);

        OngoingEventsDTO ongoingEventsDTO2 = new OngoingEventsDTO(
                "http://resources.specialolympics.org/uploadedImages/Sections/Sports-and-Games/Coaching_Guides/650xbasketball-nick-and-michael.jpg",
                "Hoopalot", "Basketball", "03", "finals",1);
        mOngoingEventsItemList.add(ongoingEventsDTO2);

        mOngoingEventsItemAdapter.notifyDataSetChanged();
    }

    private void initializeViews(View view) {
        mOngoingEventsItemRecyclerView   = (RecyclerView) view.findViewById(R.id.fragment_ongoing_events_recycler_view);
        mOngoingEventsItemContainer      = (FrameLayout)  view.findViewById(R.id.fragment_ongoing_events_container);
    }

}
