package prachi14075.iiitd.ac.in.sportsmanagementapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingEventDetailsRulesTabFragment extends Fragment {

    TextView mFragmentUpcomingEventDetailsRulesTabTextview;

    public UpcomingEventDetailsRulesTabFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_event_details_rules_tab, container, false);
        initializeViews(view);
        setRulesData();
        return view;
    }

    private void setRulesData() {
        mFragmentUpcomingEventDetailsRulesTabTextview.setText(getResources().getString(R.string.rules_hand_ball));
    }

    private void initializeViews(View view) {
        mFragmentUpcomingEventDetailsRulesTabTextview = (TextView) view.findViewById(R.id.fragment_upcoming_event_details_rules_tab_text_view);
    }



}
