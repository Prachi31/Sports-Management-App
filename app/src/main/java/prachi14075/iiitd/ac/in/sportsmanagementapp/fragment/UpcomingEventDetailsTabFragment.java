package prachi14075.iiitd.ac.in.sportsmanagementapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.FixturesActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.MyMatchesActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.RegistrationActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin.EventActivityAdmin;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.UpcomingEventsTagAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.UpcomingEventsDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.UpcomingEventsTagDTO;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingEventDetailsTabFragment extends Fragment implements View.OnClickListener{

    TextView mEventNumStatus;
    TextView mEventTextStatus;
    TextView mEventLocation;
    RecyclerView mEventCategoryRecyclerView;
    Button mRegisterButton;
    FrameLayout mEventCategoryContainer;
    ArrayList<UpcomingEventsTagDTO> mEventCategoryList;
    LinearLayoutManager mEventCategoryLayoutManager;
    UpcomingEventsTagAdapter mEventCategoryAdapter;

    public UpcomingEventDetailsTabFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_upcoming_details_tab, container, false);
        initializeViews(view);
        setUpEventsList();
        setOnClickListener();
        return view;
    }

    private void setOnClickListener() {
        mRegisterButton.setOnClickListener(this);
    }

    private void setUpEventsList() {
        mEventCategoryList          = new ArrayList<>();
        mEventCategoryAdapter       = new UpcomingEventsTagAdapter(getContext(), mEventCategoryList);
        mEventCategoryLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        mEventCategoryRecyclerView .setLayoutManager(mEventCategoryLayoutManager);
        mEventCategoryRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mEventCategoryRecyclerView .setAdapter(mEventCategoryAdapter);
        addEventListData();
    }

    private void addEventListData() {
        UpcomingEventsTagDTO upcomingEventsTagDTO = new UpcomingEventsTagDTO("Women's");
        mEventCategoryList.add(upcomingEventsTagDTO);

        UpcomingEventsTagDTO upcomingEventsTagDTO1 = new UpcomingEventsTagDTO("Men's");
        mEventCategoryList.add(upcomingEventsTagDTO1);

        mEventCategoryAdapter.notifyDataSetChanged();
    }

    private void initializeViews(View view) {
        mEventNumStatus  = (TextView) view.findViewById(R.id.fragment_upcoming_event_details_tab_num_status);
        mEventTextStatus = (TextView) view.findViewById(R.id.fragment_upcoming_event_details_tab_text_status);
        mEventLocation   = (TextView) view.findViewById(R.id.fragment_upcoming_event_details_tab_location_name);
        mRegisterButton   = (Button)   view.findViewById(R.id.fragment_upcoming_event_details_tab_register_button);
        mEventCategoryRecyclerView = (RecyclerView)  view.findViewById(R.id.fragment_upcoming_event_details_tab_recycler_view);
        mEventCategoryContainer    = (FrameLayout)   view.findViewById(R.id.fragment_upcoming_event_details_tab_container);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.fragment_upcoming_event_details_tab_register_button:
                intent = new Intent(getContext(),RegistrationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
