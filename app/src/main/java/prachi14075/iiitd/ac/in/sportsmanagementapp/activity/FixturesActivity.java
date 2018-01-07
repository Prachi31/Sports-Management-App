package prachi14075.iiitd.ac.in.sportsmanagementapp.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.FixturesAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.FixturesDTO;

public class FixturesActivity extends AppCompatActivity {

    Toolbar mFixturesToolbar;
    RecyclerView mFixturesRecyclerView;
    ArrayList<FixturesDTO> mFixturesList;
    LinearLayoutManager mFixturesLayoutManager;
    FixturesAdapter mFixturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);
        initializeViews();
        setUpToolbar();
        setUpFixturesList();
    }

    private void setUpFixturesList() {
        mFixturesList          = new ArrayList<>();
        mFixturesAdapter       = new FixturesAdapter(getApplicationContext(), mFixturesList);
        mFixturesLayoutManager = new LinearLayoutManager(getApplicationContext());

        mFixturesRecyclerView .setLayoutManager(mFixturesLayoutManager);
        mFixturesRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mFixturesRecyclerView .setAdapter(mFixturesAdapter);
        addFixturesListData();
    }

    private void addFixturesListData() {
        FixturesDTO fixturesDTO = new FixturesDTO("Round 1", getResources().getDrawable(R.drawable.ic_arrow_down));
        mFixturesList.add(fixturesDTO);

        FixturesDTO fixturesDTO1 = new FixturesDTO("Round 2", getResources().getDrawable(R.drawable.ic_arrow_down));
        mFixturesList.add(fixturesDTO1);

        FixturesDTO fixturesDTO2 = new FixturesDTO("Semi-Finals", getResources().getDrawable(R.drawable.ic_arrow_down));
        mFixturesList.add(fixturesDTO2);

        FixturesDTO fixturesDTO3 = new FixturesDTO("Finals", getResources().getDrawable(R.drawable.ic_arrow_down));
        mFixturesList.add(fixturesDTO3);

        mFixturesAdapter.notifyDataSetChanged();
    }

    private void setUpToolbar() {
        mFixturesToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mFixturesToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    private void initializeViews() {
        mFixturesRecyclerView = (RecyclerView) findViewById(R.id.activity_fixtures_recycler_view);
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
