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
import prachi14075.iiitd.ac.in.sportsmanagementapp.adapters.MyMatchesAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.MyMatchesDTO;

public class MyMatchesActivity extends AppCompatActivity {

    RecyclerView mMyMatchesRecyclerView;
    LinearLayoutManager mMyMatchesLayoutManger;
    FrameLayout mMyMatchesContainer;
    ArrayList<MyMatchesDTO> mMyMatchesList;
    MyMatchesAdapter mMyMatchesAdapter;
    Toolbar mMyMatchesToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_matches);
        initializeViews();
        setUpToolbar();
        setUpMyMatchesList();
    }

    private void setUpMyMatchesList() {
        mMyMatchesList          = new ArrayList<>();
        mMyMatchesAdapter       = new MyMatchesAdapter(getApplicationContext(), mMyMatchesList);
        mMyMatchesLayoutManger  = new LinearLayoutManager(getApplicationContext());

        mMyMatchesRecyclerView .setLayoutManager(mMyMatchesLayoutManger);
        mMyMatchesRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mMyMatchesRecyclerView .setAdapter(mMyMatchesAdapter);
        addMyMatchesListData();
    }

    private void addMyMatchesListData() {
        MyMatchesDTO myMatchesDTO1 = new MyMatchesDTO("Chica Bonita","NA","06:30","09/4/17","NFCFC","NA","No");
        mMyMatchesList.add(myMatchesDTO1);

        MyMatchesDTO myMatchesDTO = new MyMatchesDTO("Chica Bonita","5","05:30","05/4/17","Luka Chuppi","2","Yes");
        mMyMatchesList.add(myMatchesDTO);

        MyMatchesDTO myMatchesDTO3 = new MyMatchesDTO("Chica Bonita","5","07:30","03/4/17","Lakers","2","Yes");
        mMyMatchesList.add(myMatchesDTO3);

        MyMatchesDTO myMatchesDTO4 = new MyMatchesDTO("Chica Bonita","5","01:30","02/4/17","Arsenal","2","Yes");
        mMyMatchesList.add(myMatchesDTO4);

        mMyMatchesAdapter.notifyDataSetChanged();
    }

    private void setUpToolbar() {
        mMyMatchesToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mMyMatchesToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    private void initializeViews() {
        mMyMatchesRecyclerView = (RecyclerView) findViewById(R.id.activity_my_matches_recycler_view);
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
