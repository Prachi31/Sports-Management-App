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
public class OngoingEventDetailsContactTabFragment extends Fragment {

    RecyclerView mFragmentOngoingEventDetailsContactTabRecyclerView;
    FrameLayout mFragmentOngoingEventDetailsContactTabContainer;
    ArrayList<ContactDetailsDTO> mFragmentOngoingEventDetailsContactTabList;
    LinearLayoutManager mFragmentOngoingEventDetailsContactTabLayoutManager;
    ContactDetailsAdapter mFragmentOngoingEventDetailsContactTabAdapter;

    public OngoingEventDetailsContactTabFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ongoing_event_details_contact_tab, container, false);
        initializeViews(view);
        setUpContactList();
        return view;
    }

    private void setUpContactList() {
        mFragmentOngoingEventDetailsContactTabList          = new ArrayList<>();
        mFragmentOngoingEventDetailsContactTabAdapter       = new ContactDetailsAdapter(getContext(), mFragmentOngoingEventDetailsContactTabList);
        mFragmentOngoingEventDetailsContactTabLayoutManager = new LinearLayoutManager(getContext());

        mFragmentOngoingEventDetailsContactTabRecyclerView .setLayoutManager(mFragmentOngoingEventDetailsContactTabLayoutManager);
        mFragmentOngoingEventDetailsContactTabRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mFragmentOngoingEventDetailsContactTabRecyclerView .setAdapter(mFragmentOngoingEventDetailsContactTabAdapter);
        addContactListData();
    }

    private void addContactListData() {
        ContactDetailsDTO contactDetailsDTO = new ContactDetailsDTO("Palaksh Pathak", "palaksh15153@iiitd.ac.in", "9999876545");
        mFragmentOngoingEventDetailsContactTabList.add(contactDetailsDTO);

        ContactDetailsDTO contactDetailsDTO2 = new ContactDetailsDTO("Prachi Singh", "prachi14075@iiitd.ac.in", "8860491682");
        mFragmentOngoingEventDetailsContactTabList.add(contactDetailsDTO2);

        ContactDetailsDTO contactDetailsDTO3 = new ContactDetailsDTO("Arushi Kumar", "arushi14023@iiitd.ac.in", "8867892782");
        mFragmentOngoingEventDetailsContactTabList.add(contactDetailsDTO3);

        mFragmentOngoingEventDetailsContactTabAdapter.notifyDataSetChanged();
    }

    private void initializeViews(View view) {
        mFragmentOngoingEventDetailsContactTabContainer    = (FrameLayout)  view.findViewById(R.id.fragment_ongoing_event_details_contact_tab_container);
        mFragmentOngoingEventDetailsContactTabRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_ongoing_event_details_contact_tab_recycler_view);
    }

}
