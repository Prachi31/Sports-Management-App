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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;

public class RegistrationActivity extends AppCompatActivity {

    Toolbar     mRegistrationToolbar;
    RadioGroup  mTeamCategory;
    RadioButton mTeamCategoryOne;
    RadioButton mTeamCategoryTwo;
    EditText mTeamName;
    EditText mPlayerOneName;
    EditText mPlayerOneEmail;
    EditText mPlayerOneNumber;
    EditText mPlayerTwoEmail;
    EditText mPlayerTwoName;
    EditText mPlayerTwoNumber;
    EditText mPlayerThreeEmail;
    EditText mPlayerThreeName;
    EditText mPlayerThreeNumber;
    EditText mPlayerFourEmail;
    EditText mPlayerFourName;
    EditText mPlayerFourNumber;
    EditText mPlayerFiveEmail;
    EditText mPlayerFiveName;
    EditText mPlayerFiveNumber;
    Button   mPlayerNextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initializeViews();
        setUpToolbar();
        getSupportActionBar().setElevation(0f);
        setUpRegistrationList();
    }

    private void setUpRegistrationList() {

    }

    private void setUpToolbar() {
        mRegistrationToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mRegistrationToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    private void initializeViews() {
        mTeamName          = (EditText)    findViewById(R.id.registration_form1_team_name);
        mPlayerOneName     = (EditText)    findViewById(R.id.registration_form1_captain_name);
        mPlayerOneEmail    = (EditText)    findViewById(R.id.registration_form1_captain_email) ;
        mPlayerOneNumber   = (EditText)    findViewById(R.id.registration_form1_captain_number);
        mPlayerTwoName     = (EditText)    findViewById(R.id.registration_form1_player2_name);
        mPlayerTwoEmail    = (EditText)    findViewById(R.id.registration_form1_player2_email);
        mPlayerTwoNumber   = (EditText)    findViewById(R.id.registration_form1_player2_number);
        mPlayerThreeName   = (EditText)    findViewById(R.id.registration_form1_player3_name);
        mPlayerThreeEmail  = (EditText)    findViewById(R.id.registration_form1_player3_email);
        mPlayerThreeNumber = (EditText)    findViewById(R.id.registration_form1_player3_number);
        mPlayerFourName    = (EditText)    findViewById(R.id.registration_form1_player4_name);
        mPlayerFourEmail   = (EditText)    findViewById(R.id.registration_form1_player4_email);
        mPlayerFourNumber  = (EditText)    findViewById(R.id.registration_form1_player4_number);
        mPlayerFiveName    = (EditText)    findViewById(R.id.registration_form1_player5_name);
        mPlayerFiveEmail   = (EditText)    findViewById(R.id.registration_form1_player5_email);
        mPlayerFiveNumber  = (EditText)    findViewById(R.id.registration_form1_player5_number);
        mTeamCategory      = (RadioGroup)  findViewById(R.id.registration_form1_radiogroup);
        mTeamCategoryOne   = (RadioButton) findViewById(R.id.registration_form1_radio_male);
        mTeamCategoryTwo   = (RadioButton) findViewById(R.id.registration_form1_radio_female);
        mPlayerNextButton  = (Button)      findViewById(R.id.registration_form1_next_button);

        mPlayerNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTeamName.getText().toString().equals("")  || mPlayerOneName.getText().toString().equals("")                 ||
                        mPlayerOneEmail.getText().toString().equals("")    || mPlayerFiveNumber.getText().toString().equals("") ||
                        mPlayerOneNumber.getText().toString().equals("")   || mTeamName.getText().toString().equals("")         ||
                        mTeamName.getText().toString().equals("")          || mPlayerTwoName.getText().toString().equals("")    ||
                        mPlayerTwoEmail.getText().toString().equals("")    || mPlayerTwoNumber.getText().toString().equals("")  ||
                        mPlayerThreeName.getText().toString().equals("")   || mPlayerThreeEmail.getText().toString().equals("") ||
                        mPlayerThreeNumber.getText().toString().equals("") || mPlayerFourName.getText().toString().equals("")   ||
                        mPlayerFourEmail.getText().toString().equals("")   || mPlayerFourNumber.getText().toString().equals("") ||
                        mPlayerFiveName.getText().toString().equals("")    || mPlayerFiveEmail.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(mTeamCategoryOne.isChecked() || mTeamCategoryTwo.isChecked()) {
                        Intent intent = new Intent(getApplicationContext(), RegistrationActivityTwo.class);
                        startActivity(intent);
                    }
                }
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
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
