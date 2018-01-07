package prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.fragment.OngoingEventDetailsContactTabFragment;
import prachi14075.iiitd.ac.in.sportsmanagementapp.fragment.OngoingEventDetailsRulesTabFragment;
import prachi14075.iiitd.ac.in.sportsmanagementapp.fragmentAdmin.OngoingEventDetailsTabFragmentAdmin;

public class OngoingEventDetailsPagerAdapterAdmin extends FragmentPagerAdapter implements PagerSlidingTabStrip.CustomTabProvider{

    private Context mContext;
    private Fragment fragment = null;
    private final int[] mIconsList  = {R.drawable.ic_action_details, R.drawable.ic_action_document, R.drawable.ic_call};
    private final int[] mIconsLabel = {R.string.upcoming_event_details_tab_details, R.string.upcoming_event_details_tab_rules,
            R.string.upcoming_event_details_tab_contact};

    public OngoingEventDetailsPagerAdapterAdmin(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragment = new OngoingEventDetailsTabFragmentAdmin();
                break;
            case 1:
                fragment = new OngoingEventDetailsRulesTabFragment();
                break;
            case 2:
                fragment = new OngoingEventDetailsContactTabFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mIconsList.length;
    }

    @Override
    public View getCustomTabView(ViewGroup parent, int position) {
        LinearLayout customLayout  =  (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.custom_tab_events, parent, false);
        ImageView tabEarningsIcon  =  (ImageView)    customLayout.findViewById(R.id.custom_tab_events_icon);
        TextView tabEarningsLabel  =  (TextView)     customLayout.findViewById(R.id.custom_tab_events_label);
        tabEarningsIcon.setImageResource(mIconsList[position]);
        tabEarningsLabel.setText(mIconsLabel[position]);
        return customLayout;
    }

}
