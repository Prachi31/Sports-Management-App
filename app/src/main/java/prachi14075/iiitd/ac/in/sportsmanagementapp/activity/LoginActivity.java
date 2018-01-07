package prachi14075.iiitd.ac.in.sportsmanagementapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.activityAdmin.EventActivityAdmin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout mLoginParticipantButton;
    LinearLayout mLoginAdminButton;
    LinearLayout mLoginAdminLayout;
    TextView     mForgotPasswordText;
    TextView     mSkipLogin;
    Button       mLoginAdminHiddenButton;
    EditText     mUsernameField;
    EditText     mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
        hideAdminFields();
        setOnClickListeners();
    }

    private void hideAdminFields() {
        mLoginAdminHiddenButton.setVisibility(View.VISIBLE);
        mLoginAdminLayout.setVisibility(View.INVISIBLE);
//        mPasswordField.setVisibility(View.INVISIBLE);
//        mLoginAdminHiddenButton.setVisibility(View.INVISIBLE);
//        mForgotPasswordText.setVisibility(View.INVISIBLE);
    }

    private void showAdminFields() {
        mLoginAdminHiddenButton.setVisibility(View.INVISIBLE);
        mLoginAdminLayout.setVisibility(View.VISIBLE);
//        mPasswordField.setVisibility(View.VISIBLE);
//        mLoginAdminHiddenButton.setVisibility(View.VISIBLE);
//        mForgotPasswordText.setVisibility(View.VISIBLE);
    }

    private void setOnClickListeners() {
        mLoginAdminHiddenButton.setOnClickListener(this);
        mLoginParticipantButton.setOnClickListener(this);
        mLoginAdminButton       .setOnClickListener(this);
        mSkipLogin              .setOnClickListener(this);
    }

    private void initializeViews() {
        mLoginParticipantButton = (LinearLayout) findViewById(R.id.activity_login_participant_button);
        mLoginAdminButton       = (LinearLayout) findViewById(R.id.activity_login_admin_button);
        mLoginAdminLayout       = (LinearLayout) findViewById(R.id.activity_login_admin_login_layout);
        mForgotPasswordText     = (TextView)     findViewById(R.id.activity_login_admin_forgot_password);
        mLoginAdminHiddenButton = (Button)       findViewById(R.id.activity_login_admin_hidden_button);
        mUsernameField          = (EditText)     findViewById(R.id.activity_login_admin_login_username_field);
        mPasswordField          = (EditText)     findViewById(R.id.activity_login_admin_login_password_field);
        mSkipLogin              = (TextView)     findViewById(R.id.activity_login_skip);
    }

    @Override
    public void onClick(View view) {
        Intent nextActivityIntent;
        switch (view.getId()){
            case R.id.activity_login_participant_button:
                //TODO: google login
                nextActivityIntent = new Intent(LoginActivity.this, EventsActivity.class);
                startActivity(nextActivityIntent);
                break;
            case R.id.activity_login_admin_button:
                if(!(mUsernameField.getText().toString().equals("") || mPasswordField.getText().toString().equals(""))){
                    if(mUsernameField.getText().toString().equals("a") || mPasswordField.getText().toString().equals("a")){
                        nextActivityIntent = new Intent(LoginActivity.this, EventActivityAdmin.class);
                        startActivity(nextActivityIntent);
                    }
                }
                break;
            case R.id.activity_login_admin_hidden_button:
                showAdminFields();
                break;

            case R.id.activity_login_admin_forgot_password:
                //TODO: Think about the action
                break;
            case R.id.activity_login_skip:
                nextActivityIntent = new Intent(LoginActivity.this, EventsActivity.class);
                startActivity(nextActivityIntent);
                break;
        }
    }
}
