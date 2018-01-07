package prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin;

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
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.LoginActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activity.NotificationsActivity;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin.ContactCoordinatorsAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin.MatchTimingsAdapter;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.AddEventsDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.ContactDetailsDTO;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.MatchTimingsDTO;

public class AddEventActivity extends AppCompatActivity {

    Button   mAddEventButton;
    Toolbar  mAddEventToolbar;
    EditText mEventName;
    EditText mEventType;
    CheckBox mMensCheck;
    CheckBox mWomensCheck;
    CheckBox mMixedCheck;
    CheckBox mSinglesCheck;
    CheckBox mDoublesCheck;
    CheckBox mTeamCheck;
    EditText mRegisterStartDate;
    EditText mRegisterEndDate;
    EditText mEventStartDate;
    EditText mEventEndDate;
    EditText mEventStartTime;
    EditText mEventEndTime;
    EditText mCoordinatorName;
    EditText mCoordinatorEmail;
    EditText mCoordinatorContact;
    Button   mUploadRulesButton;
    LinearLayout mAddDurationLayout;
    LinearLayout mAddCoordinatorLayout;
    LinearLayout mEventTimeLayout;
    LinearLayout mCoordinatorLayout;
    RecyclerView mDurationRecyclerView;
    RecyclerView mCoordinatorRecyclerView;

    AddEventsDTO      mAddEventDTO;
    ContactDetailsDTO mContactDetailsDTO;
    MatchTimingsDTO   mMatchTimingsDTO;

    ArrayList<ContactDetailsDTO> mContactDetailsList;
    ArrayList<MatchTimingsDTO>   mMatchTimingsList;
    LinearLayoutManager          mAddEventLayoutManager;
    MatchTimingsAdapter          mMatchTimingsAdapter;
    ContactCoordinatorsAdapter mContactDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        initializeViews();
        setUpToolbar();
        setUpContactList();
        setUpTimingsList();
        setOnClickListener();
    }

    private void setOnClickListener() {
        mAddEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(     mEventName.getText().toString().equals("")          || mEventType.getText().toString().equals("")        ||
                        mRegisterStartDate.getText().toString().equals("")  || mRegisterEndDate.getText().toString().equals("")  ||
                        mEventStartDate.getText().toString().equals("")     || mEventEndDate.getText().toString().equals("")     ||
                        mEventStartTime.getText().toString().equals("")     || mEventEndTime.getText().toString().equals("")     ||
                        mCoordinatorName.getText().toString().equals("")    || mCoordinatorEmail.getText().toString().equals("") ||
                        mCoordinatorContact.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Please fill all the required fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(mMensCheck.isChecked() || mWomensCheck.isChecked() || mMixedCheck.isChecked()){
                        if (mSinglesCheck.isChecked() || mDoublesCheck.isChecked() || mTeamCheck.isChecked()){
                            Intent intent = new Intent(getApplicationContext(), EventActivityAdmin.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

        mAddCoordinatorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContactListData();
            }
        });

        mAddDurationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTimingsListData();
            }
        });
    }

    private void setUpTimingsList() {
        mMatchTimingsList             = new ArrayList<>();
        mMatchTimingsAdapter          = new MatchTimingsAdapter(getApplicationContext(), mMatchTimingsList);
        mAddEventLayoutManager        = new LinearLayoutManager(getApplicationContext());

        mDurationRecyclerView .setLayoutManager(mAddEventLayoutManager);
        mDurationRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mDurationRecyclerView .setAdapter(mMatchTimingsAdapter);
        addTimingsListData();
    }

    private void addTimingsListData() {
        MatchTimingsDTO matchTimingsDTO = new MatchTimingsDTO("","");
        mMatchTimingsList.add(matchTimingsDTO);
        mMatchTimingsAdapter.notifyDataSetChanged();
    }

    private void setUpContactList() {
        mContactDetailsList             = new ArrayList<>();
        mContactDetailsAdapter          = new ContactCoordinatorsAdapter(getApplicationContext(), mContactDetailsList);
        mAddEventLayoutManager          = new LinearLayoutManager(getApplicationContext());

        mCoordinatorRecyclerView .setLayoutManager(mAddEventLayoutManager);
        mCoordinatorRecyclerView .setItemAnimator(new DefaultItemAnimator());
        mCoordinatorRecyclerView .setAdapter(mContactDetailsAdapter);
        addContactListData();
    }

    private void addContactListData() {
        ContactDetailsDTO contactDetailsDTO = new ContactDetailsDTO("","","");
        mContactDetailsList.add(contactDetailsDTO);
        mContactDetailsAdapter.notifyDataSetChanged();
    }

    private void setUpToolbar() {
        mAddEventToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mAddEventToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    private void initializeViews() {
        mAddEventButton         = (Button)   findViewById(R.id.add_event_button);
        mUploadRulesButton      = (Button)   findViewById(R.id.add_event_rules_upload_button);
        mEventName              = (EditText) findViewById(R.id.add_event_name);
        mEventType              = (EditText) findViewById(R.id.add_event_type);
        mMensCheck              = (CheckBox) findViewById(R.id.check_men);
        mWomensCheck            = (CheckBox) findViewById(R.id.check_women);
        mMixedCheck             = (CheckBox) findViewById(R.id.check_mixed);
        mSinglesCheck           = (CheckBox) findViewById(R.id.check_singles);
        mDoublesCheck           = (CheckBox) findViewById(R.id.check_double);
        mTeamCheck              = (CheckBox) findViewById(R.id.check_team);
        mRegisterStartDate      = (EditText) findViewById(R.id.add_event_registration_start);
        mRegisterEndDate        = (EditText) findViewById(R.id.add_event_location_registration_end);
        mEventStartDate         = (EditText) findViewById(R.id.event_start_date);
        mEventEndDate           = (EditText) findViewById(R.id.event_end_date);
        mEventStartTime         = (EditText) findViewById(R.id.match_start_time);
        mEventEndTime           = (EditText) findViewById(R.id.match_end_time);
        mCoordinatorName        = (EditText) findViewById(R.id.add_event_name_coordinator);
        mCoordinatorEmail       = (EditText) findViewById(R.id.add_event_email_coordinator);
        mCoordinatorContact     = (EditText) findViewById(R.id.add_event_contact_coordinator);
        mAddDurationLayout      = (LinearLayout) findViewById(R.id.add_event_add_another_duration);
        mAddCoordinatorLayout   = (LinearLayout) findViewById(R.id.add_event_add_another_coordination);
        mEventTimeLayout        = (LinearLayout) findViewById(R.id.add_event_time_start_end);
        mCoordinatorLayout      = (LinearLayout) findViewById(R.id.add_event_coordinator_layout);
        mDurationRecyclerView   = (RecyclerView) findViewById(R.id.add_event_match_duration_recycler_view);
        mCoordinatorRecyclerView= (RecyclerView) findViewById(R.id.add_event_match_coordinator_recycler_view);
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
