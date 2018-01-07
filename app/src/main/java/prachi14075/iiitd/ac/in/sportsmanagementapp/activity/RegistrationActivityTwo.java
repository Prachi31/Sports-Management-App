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
import android.widget.RadioButton;
import android.widget.Toast;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;

public class RegistrationActivityTwo extends AppCompatActivity {

    Button  mSubmitButton;
    Toolbar mRegistrationToolbar;

    RadioButton mPref1Time1;
    RadioButton mPref1Time2;
    RadioButton mPref1Time3;
    RadioButton mPref1Time4;
    RadioButton mPref2Time1;
    RadioButton mPref2Time2;
    RadioButton mPref2Time3;
    RadioButton mPref2Time4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_two);
        initializeViews();
        setUpToolbar();
        getSupportActionBar().setElevation(0f);
        mSubmitButton = (Button) findViewById(R.id.submit_button);

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
        mPref1Time1   = (RadioButton) findViewById(R.id.registration_form2_time1);
        mPref1Time2   = (RadioButton) findViewById(R.id.registration_form2_time2);
        mPref1Time3   = (RadioButton) findViewById(R.id.registration_form2_time3);
        mPref1Time4   = (RadioButton) findViewById(R.id.registration_form2_time4);
        mPref2Time1   = (RadioButton) findViewById(R.id.registration_form2_time1_pref2);
        mPref2Time2   = (RadioButton) findViewById(R.id.registration_form2_time2_pref2);
        mPref2Time3   = (RadioButton) findViewById(R.id.registration_form2_time3_pref2);
        mPref2Time4   = (RadioButton) findViewById(R.id.registration_form2_time4_pref2);
        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPref1Time1.isChecked()     || mPref1Time2.isChecked() || mPref1Time3.isChecked() || mPref1Time4.isChecked()) {
                    if(mPref2Time1.isChecked() || mPref2Time2.isChecked() || mPref2Time3.isChecked() || mPref2Time4.isChecked()){
                        Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
                        Toast.makeText(getApplicationContext(), "You have registered successfully!", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please fill all the fields", Toast.LENGTH_SHORT).show();
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
