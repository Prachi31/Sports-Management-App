package prachi14075.iiitd.ac.in.sportsmanagementapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.utils.LoginUtils;

public class SplashActivity extends AppCompatActivity {

    static boolean mActivityVisible;
    static final String TAG = "PRACHI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            Intent openNextActivityIntent;
//            if(utils.isUserLoggedIn()){
                openNextActivityIntent = new Intent(SplashActivity.this,LoginActivity.class);
//            } else {
//                openNextActivityIntent = new Intent(SplashActivity.this,EventsActivity.class);
//            }
            startActivity(openNextActivityIntent);
//        }
        finish();
    }
}
