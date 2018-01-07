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
public class OngoingEventDetailsRulesTabFragment extends Fragment {

    TextView mFragmentOngoingEventDetailsRulesTabTextview;

    public OngoingEventDetailsRulesTabFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ongoing_event_details_rules_tab, container, false);
        initializeViews(view);
        setUpRulesData();
        return view;
    }

    private void setUpRulesData() {
        mFragmentOngoingEventDetailsRulesTabTextview.setText(getResources().getString(R.string.rules_hand_ball));
    }

    private void initializeViews(View view) {
        mFragmentOngoingEventDetailsRulesTabTextview = (TextView) view.findViewById(R.id.fragment_ongoing_event_details_rules_tab_text_view);
    }

}
