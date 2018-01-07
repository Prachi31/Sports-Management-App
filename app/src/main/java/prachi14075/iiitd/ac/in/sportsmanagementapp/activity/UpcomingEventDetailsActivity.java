package prachi14075.iiitd.ac.in.sportsmanagementapp.activity;

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
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.UpcomingEventDetailsPagerAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.UpcomingEventsDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.utils.Constants;


public class UpcomingEventDetailsActivity extends AppCompatActivity {

    ViewPager mUpcomingEventDetailsViewPager;
    Toolbar   mUpcomingEventDetailsToolbar;
    Toolbar   mUpcomingEventDetailsToolbarBottom;
    PagerSlidingTabStrip mEventsSlidingTabs;
    UpcomingEventDetailsPagerAdapter mTabsPagerAdapter;

    String mEventNameString;
    String mEventDaysLeft;
    String mEventStatus;
    int    mEventNumberTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_event_details);
        initializeViews();
        setUpToolbar();
        getSupportActionBar().setElevation(0f);
        getParcelableData();
        putParcelableData();
        setUpPagerAdapter();
    }

    private void setUpPagerAdapter() {
        mTabsPagerAdapter = new UpcomingEventDetailsPagerAdapter(getApplicationContext(),getSupportFragmentManager());
        mUpcomingEventDetailsViewPager.setAdapter(mTabsPagerAdapter);
        mEventsSlidingTabs.setViewPager(mUpcomingEventDetailsViewPager);
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
        UpcomingEventsDTO upcomingEventsDTO = intent.getExtras().getParcelable(Constants.INTENT_EXTRA_UPCOMING_EVENT_DETAILS);
        mEventNameString = upcomingEventsDTO.getUpcomingEventName();
        mEventDaysLeft   = upcomingEventsDTO.getUpcomingEventDaysLeft();
        mEventStatus     = upcomingEventsDTO.getUpcomingEventStatus();
        mEventNumberTags = upcomingEventsDTO.getUpcomingEventNumberTags();
    }

    private void setUpToolbar() {
        mUpcomingEventDetailsToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mUpcomingEventDetailsToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.ic_drawer);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    private void initializeViews() {
        mUpcomingEventDetailsToolbarBottom  = (Toolbar)  findViewById(R.id.activity_upcoming_event_details_toolbar);
        mUpcomingEventDetailsViewPager      = (ViewPager)findViewById(R.id.activity_upcoming_event_details_viewpager);
        mEventsSlidingTabs                  = (PagerSlidingTabStrip) findViewById(R.id.activity_upcoming_event_details_toolbar_tabs);
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
