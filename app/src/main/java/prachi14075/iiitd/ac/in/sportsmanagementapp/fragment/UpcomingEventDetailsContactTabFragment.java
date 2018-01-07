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
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.ContactDetailsAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.ContactDetailsDTO;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingEventDetailsContactTabFragment extends Fragment {

    RecyclerView mFragmentUpcomingEventDetailsContactTabRecyclerView;
    FrameLayout mFragmentUpcomingEventDetailsContactTabContainer;
    ArrayList<ContactDetailsDTO> mFragmentUpcomingEventDetailsContactTabList;
    LinearLayoutManager mFragmentUpcomingEventDetailsContactTabLayoutManager;
    ContactDetailsAdapter mFragmentUpcomingEventDetailsContactTabAdapter;

    public UpcomingEventDetailsContactTabFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_event_details_contact_tab, container, false);
        initializeViews(view);
        setUpContactsList();
        return view;
    }

    private void setUpContactsList() {
        mFragmentUpcomingEventDetailsContactTabList          = new ArrayList<>();
        mFragmentUpcomingEventDetailsContactTabAdapter       = new ContactDetailsAdapter(getContext(), mFragmentUpcomingEventDetailsContactTabList);
        mFragmentUpcomingEventDetailsContactTabLayoutManager = new LinearLayoutManager(getContext());

        mFragmentUpcomingEventDetailsContactTabRecyclerView .setLayoutManager(mFragmentUpcomingEventDetailsContactTabLayoutManager);
        mFragmentUpcomingEventDetailsContactTabRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mFragmentUpcomingEventDetailsContactTabRecyclerView .setAdapter(mFragmentUpcomingEventDetailsContactTabAdapter);
        addContactListData();
    }

    private void addContactListData() {
        ContactDetailsDTO contactDetailsDTO = new ContactDetailsDTO("Palaksh Pathak", "palaksh15153@iiitd.ac.in", "9999876545");
        mFragmentUpcomingEventDetailsContactTabList.add(contactDetailsDTO);

        ContactDetailsDTO contactDetailsDTO2 = new ContactDetailsDTO("Prachi Singh", "prachi14075@iiitd.ac.in", "8860491682");
        mFragmentUpcomingEventDetailsContactTabList.add(contactDetailsDTO2);

        ContactDetailsDTO contactDetailsDTO3 = new ContactDetailsDTO("Arushi Kumar", "arushi14023@iiitd.ac.in", "8867892782");
        mFragmentUpcomingEventDetailsContactTabList.add(contactDetailsDTO3);

        mFragmentUpcomingEventDetailsContactTabAdapter.notifyDataSetChanged();
    }

    private void initializeViews(View view) {
        mFragmentUpcomingEventDetailsContactTabContainer   = (FrameLayout)  view.findViewById(R.id.fragment_upcoming_event_details_contact_tab_container);
        mFragmentUpcomingEventDetailsContactTabRecyclerView= (RecyclerView) view.findViewById(R.id.fragment_upcoming_event_details_contact_tab_recycler_view);
    }

}
