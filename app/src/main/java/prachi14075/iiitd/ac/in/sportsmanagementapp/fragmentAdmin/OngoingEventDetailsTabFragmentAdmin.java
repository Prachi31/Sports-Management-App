package prachi14075.iiitd.ac.in.sportsmanagementapp.fragmentAdmin;


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
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.RescheduleActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin.FixturesActivityAdmin;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.OngoingEventsTagAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.OngoingEventsTagDTO;

/**
 * A simple {@link Fragment} subclass.
 */
public class OngoingEventDetailsTabFragmentAdmin extends Fragment implements View.OnClickListener {

    TextView mEventNumStatus;
    TextView mEventTextStatus;
    TextView mEventLocation;
    Button   mFixturesButton;
    Button   mRescheduleBtn;
    RecyclerView mEventCategoryRecyclerView;
    FrameLayout mEventCategoryContainer;
    ArrayList<OngoingEventsTagDTO> mEventCategoryList;
    LinearLayoutManager mEventCategoryLayoutManager;
    OngoingEventsTagAdapter mEventCategoryAdapter;

    public OngoingEventDetailsTabFragmentAdmin() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ongoing_event_details_tab_fragment_admin, container, false);
        initializeViews(view);
        setUpEventsList();
        setOnClickListener();
        return view;
    }

    private void setOnClickListener() {
        mFixturesButton.setOnClickListener(this);
        mRescheduleBtn.setOnClickListener(this);
    }

    private void setUpEventsList() {
        mEventCategoryList          = new ArrayList<>();
        mEventCategoryAdapter       = new OngoingEventsTagAdapter(getContext(), mEventCategoryList);
        mEventCategoryLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        mEventCategoryRecyclerView .setLayoutManager(mEventCategoryLayoutManager);
        mEventCategoryRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mEventCategoryRecyclerView .setAdapter(mEventCategoryAdapter);
        addEventListData();
    }

    private void addEventListData() {
        OngoingEventsTagDTO ongoingEventsTagDTO = new OngoingEventsTagDTO("Women's");
        mEventCategoryList.add(ongoingEventsTagDTO);

        OngoingEventsTagDTO ongoingEventsTagDTO1 = new OngoingEventsTagDTO("Men's");
        mEventCategoryList.add(ongoingEventsTagDTO1);

        mEventCategoryAdapter.notifyDataSetChanged();
    }

    private void initializeViews(View view) {
        mEventNumStatus  = (TextView) view.findViewById(R.id.fragment_ongoing_event_details_tab_num_status);
        mEventTextStatus = (TextView) view.findViewById(R.id.fragment_ongoing_event_details_tab_text_status);
        mEventLocation   = (TextView) view.findViewById(R.id.fragment_ongoing_event_details_tab_location_name);
        mFixturesButton  = (Button)   view.findViewById(R.id.fragment_ongoing_event_details_tab_fixtures_button);
        mEventCategoryRecyclerView = (RecyclerView)  view.findViewById(R.id.fragment_ongoing_event_details_tab_recycler_view);
        mEventCategoryContainer    = (FrameLayout)   view.findViewById(R.id.fragment_ongoing_event_details_tab_container);
        mRescheduleBtn             = (Button) view.findViewById(R.id.reschedule_btn);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.fragment_ongoing_event_details_tab_fixtures_button:
                intent = new Intent(getContext(),FixturesActivityAdmin.class);
                startActivity(intent);
                break;
            case R.id.reschedule_btn:
                intent = new Intent(getContext(),RescheduleActivity.class);
                startActivity(intent);
                break;
        }
    }

}
