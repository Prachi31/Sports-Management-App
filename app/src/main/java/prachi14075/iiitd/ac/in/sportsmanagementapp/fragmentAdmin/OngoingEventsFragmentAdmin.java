package prachi14075.iiitd.ac.in.sportsmanagementapp.fragmentAdmin;


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
import prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin.OngoingEventsItemAdapterAdmin;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.OngoingEventsDTO;

/**
 * A simple {@link Fragment} subclass.
 */
public class OngoingEventsFragmentAdmin extends Fragment {

    RecyclerView mOngoingEventsItemRecyclerViewAdmin;
    FrameLayout mOngoingEventsItemContainerAdmin;
    ArrayList<OngoingEventsDTO> mOngoingEventsItemListAdmin;
    LinearLayoutManager mOngoingEventsItemLinearLayoutManagerAdmin;
    OngoingEventsItemAdapterAdmin mOngoingEventsItemAdapterAdmin;

    public OngoingEventsFragmentAdmin() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ongoing_events_fragment_admin, container, false);
        initializeViews(view);
        setUpEventsList();
        return view;
    }

    private void setUpEventsList() {
        mOngoingEventsItemListAdmin        = new ArrayList<>();
        mOngoingEventsItemAdapterAdmin     = new OngoingEventsItemAdapterAdmin(getContext(), mOngoingEventsItemListAdmin);
        mOngoingEventsItemLinearLayoutManagerAdmin = new LinearLayoutManager(getContext());

        mOngoingEventsItemRecyclerViewAdmin .setLayoutManager(mOngoingEventsItemLinearLayoutManagerAdmin);
        mOngoingEventsItemRecyclerViewAdmin .setItemAnimator(new DefaultItemAnimator());
        mOngoingEventsItemRecyclerViewAdmin .setAdapter(mOngoingEventsItemAdapterAdmin);
        addOngoingEventsListData();
    }

    private void addOngoingEventsListData() {
        OngoingEventsDTO ongoingEventsDTO1 = new OngoingEventsDTO(
                "http://www.sportsudest.ro/wp-content/uploads/2016/07/8.fotbal.jpg",
                "Joga Bonito", "Football", "05", "register",1);
        mOngoingEventsItemListAdmin.add(ongoingEventsDTO1);

        OngoingEventsDTO ongoingEventsDTO2 = new OngoingEventsDTO(
                "http://resources.specialolympics.org/uploadedImages/Sections/Sports-and-Games/Coaching_Guides/650xbasketball-nick-and-michael.jpg",
                "Hoopalot", "Basketball", "13", "register",1);
        mOngoingEventsItemListAdmin.add(ongoingEventsDTO2);

        mOngoingEventsItemAdapterAdmin.notifyDataSetChanged();
    }

    private void initializeViews(View view) {
        mOngoingEventsItemRecyclerViewAdmin   = (RecyclerView) view.findViewById(R.id.fragment_ongoing_events_recycler_view_admin);
        mOngoingEventsItemContainerAdmin      = (FrameLayout)  view.findViewById(R.id.fragment_ongoing_events_container_admin);
    }

}
