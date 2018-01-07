package prachi14075.iiitd.ac.in.sportsmanagementapp.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;

public class RescheduleActivity extends AppCompatActivity {

    Toolbar mRescheduleToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reschedule);
    }

    private void setUpToolbar() {
        mRescheduleToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mRescheduleToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
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
