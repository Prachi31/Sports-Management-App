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
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.UpcomingEventsItemAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.UpcomingEventsDTO;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingEventsFragment extends Fragment {

    RecyclerView mUpcomingEventsItemRecyclerView;
    FrameLayout  mUpcomingEventsItemContainer;
    ArrayList<UpcomingEventsDTO> mUpcomingEventsItemList;
    LinearLayoutManager mUpcomingEventsItemLinearLayoutManager;
    UpcomingEventsItemAdapter mUpcomingEventsItemAdapter;

    public UpcomingEventsFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_events, container, false);
        initializeViews(view);
        setUpEventsList();
        return view;
    }

    private void setUpEventsList() {
        mUpcomingEventsItemList        = new ArrayList<>();
        mUpcomingEventsItemAdapter     = new UpcomingEventsItemAdapter(getContext(), mUpcomingEventsItemList);
        mUpcomingEventsItemLinearLayoutManager = new LinearLayoutManager(getContext());

        mUpcomingEventsItemRecyclerView.setLayoutManager(mUpcomingEventsItemLinearLayoutManager);
        mUpcomingEventsItemRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mUpcomingEventsItemRecyclerView.setAdapter(mUpcomingEventsItemAdapter);
        addUpcomingEventsListData();
    }

    private void addUpcomingEventsListData() {
        //TODO Make network request to add data
        UpcomingEventsDTO upcomingEventsDTO1 = new UpcomingEventsDTO(
                "http://www.sportsudest.ro/wp-content/uploads/2016/07/8.fotbal.jpg",
                "Joga Bonito", "Football", "05", "register",2);
        mUpcomingEventsItemList.add(upcomingEventsDTO1);

        UpcomingEventsDTO upcomingEventsDTO2 = new UpcomingEventsDTO(
                "http://resources.specialolympics.org/uploadedImages/Sections/Sports-and-Games/Coaching_Guides/650xbasketball-nick-and-michael.jpg",
                "Hoopalot", "Basketball", "13", "register",2);
        mUpcomingEventsItemList.add(upcomingEventsDTO2);

        mUpcomingEventsItemAdapter.notifyDataSetChanged();
    }

    private void initializeViews(View view) {
        mUpcomingEventsItemRecyclerView   = (RecyclerView) view.findViewById(R.id.fragment_upcoming_events_recycler_view);
        mUpcomingEventsItemContainer      = (FrameLayout)  view.findViewById(R.id.fragment_upcoming_events_container);
    }

}
