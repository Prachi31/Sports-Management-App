package prachi14075.iiitd.ac.in.sportsmanagementapp.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.EventsPagerAdapter;

public class EventsActivity extends AppCompatActivity {

    ViewPager mEventsViewPager;
    Toolbar   mEventsToolbar;
    Toolbar   mEventsToolbarBottom;
    PagerSlidingTabStrip mEventsSlidingTabs;
    EventsPagerAdapter   mTabsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        initializeViews();
        setUpToolbar();
        getSupportActionBar().setElevation(0f);
        setUpPagerAdapter();
    }

    private void setUpPagerAdapter() {
        mTabsPagerAdapter = new EventsPagerAdapter(getApplicationContext(),getSupportFragmentManager());
        mEventsViewPager.setAdapter(mTabsPagerAdapter);
        mEventsSlidingTabs.setViewPager(mEventsViewPager);
    }

    private void setUpToolbar() {
        mEventsToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mEventsToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.ic_drawer);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    private void initializeViews() {
        mEventsViewPager       = (ViewPager) findViewById(R.id.activity_events_viewpager);
        mEventsToolbarBottom = (Toolbar) findViewById(R.id.activity_events_toolbar);
        mEventsSlidingTabs     = (PagerSlidingTabStrip) findViewById(R.id.activity_events_toolbar_tabs);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
