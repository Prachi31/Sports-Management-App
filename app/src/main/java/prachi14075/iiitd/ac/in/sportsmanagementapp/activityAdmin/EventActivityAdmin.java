package prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.LoginActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.NotificationsActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.EventsPagerAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin.EventsPagerAdapterAdmin;

public class EventActivityAdmin extends AppCompatActivity {

    ViewPager mEventsViewPagerAdmin;
    Toolbar   mEventsToolbarAdmin;
    Toolbar   mEventsToolbarBottomAdmin;
    PagerSlidingTabStrip    mEventsSlidingTabsAdmin;
    EventsPagerAdapterAdmin mTabsPagerAdapterAdmin;
    FloatingActionButton    mAddEventButtonAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_event);
        initializeViews();
        setUpToolbar();
        getSupportActionBar().setElevation(0f);
        setUpPagerAdapter();
    }
    private void setUpPagerAdapter() {
        mTabsPagerAdapterAdmin = new EventsPagerAdapterAdmin(getApplicationContext(),getSupportFragmentManager());
        mEventsViewPagerAdmin.setAdapter(mTabsPagerAdapterAdmin);
        mEventsSlidingTabsAdmin.setViewPager(mEventsViewPagerAdmin);
    }

    private void setUpToolbar() {
        mEventsToolbarAdmin = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mEventsToolbarAdmin);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.ic_drawer);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    private void initializeViews() {
        mEventsViewPagerAdmin       = (ViewPager) findViewById(R.id.activity_events_viewpager_admin);
        mEventsToolbarBottomAdmin   = (Toolbar)   findViewById(R.id.activity_events_toolbar_admin);
        mEventsSlidingTabsAdmin     = (PagerSlidingTabStrip) findViewById(R.id.activity_events_toolbar_tabs_admin);
        mAddEventButtonAdmin        = (FloatingActionButton) findViewById(R.id.activity_events_add_button_admin);
        mAddEventButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActivityAdmin.this, AddEventActivity.class);
                startActivity(intent);
            }
        });
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
