package prachi14075.iiitd.ac.in.sportsmanagementapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {

    static final String PREFS_FILE_NAME    = "prachi14075.iiitd.ac.in.sportsmanagementapp.sharedprefs.filename";
    static final String PREFS_KEY_USERNAME = "prachi14075.iiitd.ac.in.sportsmanagementapp.sharedprefs.key.username";
    static final String PREFS_KEY_PASSWORD = "prachi14075.iiitd.ac.in.sportsmanagementapp.sharedprefs.key.password";

    private SharedPreferences mSharedPrefs;

    public SharedPrefUtils(Context context) {
        mSharedPrefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Checks if a key has a value in the shared preferences file. Works ONLY for
     * strings saved in shared prefs
     *
     * @param key
     * @return
     */
    public boolean keyExists (String key) {
        if(mSharedPrefs.contains(key)) {
            if(mSharedPrefs.getString(key, null) != null || mSharedPrefs.getString(key, null).equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     *Function to write the input value of username field to shared preferences file
     * @param username: String value of the username field
     */
    public void saveUsernameToSharedPrefs(String username) {
        if(username != null || !(username.equals(""))) {
            mSharedPrefs.edit().putString(PREFS_KEY_USERNAME, username).apply();
        }
    }

    /**
     * Function to write the input value of password field to shared preferences file
     * @param password: String value of the password field
     */
    public void savePasswordToSharedPrefs(String password) {
        if(password != null || !(password.equals(""))) {
            mSharedPrefs.edit().putString(PREFS_KEY_PASSWORD, password).apply();
        }
    }

    public String getSavedUsername(){
        String Username = null;
        Username = mSharedPrefs.getString(PREFS_KEY_USERNAME,Username);
        return Username;
    }

    public String getSavedPassword(){
        String Password = null;
        Password = mSharedPrefs.getString(PREFS_KEY_PASSWORD,Password);
        return Password;
    }
}
