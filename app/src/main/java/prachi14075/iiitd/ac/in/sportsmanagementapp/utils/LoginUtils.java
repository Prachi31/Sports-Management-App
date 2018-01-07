package prachi14075.iiitd.ac.in.sportsmanagementapp.utils;


import android.content.Context;

public class LoginUtils {
    private SharedPrefUtils mSharedPrefUtils;

    public LoginUtils(Context context) {
        mSharedPrefUtils = new SharedPrefUtils(context);
    }

    /**
     * This function returns true if user has been already logged into the app
     * by checking the shared preferences for its respective key
     *
     * @return
     */
    public boolean isUserLoggedIn() {
        return mSharedPrefUtils.keyExists(SharedPrefUtils.PREFS_KEY_USERNAME);
    }
}
