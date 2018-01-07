package prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.LoginActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.NotificationsActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.OngoingEventDetailsPagerAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin.OngoingEventDetailsPagerAdapterAdmin;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.OngoingEventsDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.utils.Constants;

public class OngoingEventDetailsActivityAdmin extends AppCompatActivity {

    ViewPager mOngoingEventDetailsViewPager;
    Toolbar  mOngoingEventDetailsToolbar;
    Toolbar   mOngoingEventDetailsToolbarBottom;
    PagerSlidingTabStrip mEventsSlidingTabs;
    OngoingEventDetailsPagerAdapterAdmin mTabsPagerAdapter;

    String mEventNameString;
    String mEventDaysLeft;
    String mEventStatus;
    int    mEventNumberTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_event_details_admin);
        initializeViews();
        setUpToolbar();
        getSupportActionBar().setElevation(0f);
        getParcelableData();
        putParcelableData();
        setUpPagerAdapter();
    }

    private void setUpPagerAdapter() {
        mTabsPagerAdapter = new OngoingEventDetailsPagerAdapterAdmin(getSupportFragmentManager(), getApplicationContext());
        mOngoingEventDetailsViewPager.setAdapter(mTabsPagerAdapter);
        mEventsSlidingTabs.setViewPager(mOngoingEventDetailsViewPager);
    }
    private void putParcelableData() {
        getSupportActionBar().setTitle(mEventNameString);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    private void getParcelableData() {
        Intent intent = getIntent();
        OngoingEventsDTO ongoingEventsDTO = intent.getExtras().getParcelable(Constants.INTENT_EXTRA_ONGOING_EVENT_DETAILS);
        mEventNameString = ongoingEventsDTO.getOngoingEventName();
        mEventDaysLeft   = ongoingEventsDTO.getOngoingEventDaysLeft();
        mEventStatus     = ongoingEventsDTO.getOngoingEventStatus();
        mEventNumberTags = ongoingEventsDTO.getOngoingEventNumberTags();
    }

    private void setUpToolbar() {
        mOngoingEventDetailsToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mOngoingEventDetailsToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.ic_drawer);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    private void initializeViews() {
        mOngoingEventDetailsToolbarBottom  = (Toolbar)  findViewById(R.id.activity_ongoing_event_details_toolbar);
        mOngoingEventDetailsViewPager      = (ViewPager)findViewById(R.id.activity_ongoing_event_details_viewpager_admin);
        mEventsSlidingTabs                 = (PagerSlidingTabStrip) findViewById(R.id.activity_ongoing_event_details_toolbar_tabs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * This method handles the events of the action bar (back button)
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action buttons
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent userProfileIntent = new Intent(this, LoginActivity.class);
                startActivity(userProfileIntent);
                return true;
            case R.id.action_notifications:
                Intent notificationsActivityIntent = new Intent(this, NotificationsActivity.class);
                startActivity(notificationsActivityIntent);
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
