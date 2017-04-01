package com.xcapital.river.misc;

import android.content.Context;
import android.content.SharedPreferences;

import com.xcapital.river.BuildConfig;

/**
 * Created by kshivang on 07/03/17.
 *
 */

public class LocalDatabase {

    private static final String KEY_FIRST_RUN = "f";
    private static final String KEY_MOBILE_NO = "l";

    private SharedPreferences localDatabase;

    public LocalDatabase (Context context) {
        localDatabase = context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0);
    }

    public boolean checkFirstRun() {
        return localDatabase.getBoolean(KEY_FIRST_RUN, false) || setFirstRun();
    }

    private boolean setFirstRun() {
        localDatabase.edit().putBoolean(KEY_FIRST_RUN, true).apply();
        return false;
    }

    public boolean checkLogin() {
        return !localDatabase.getString(KEY_MOBILE_NO, "").isEmpty();
    }

    public void setLogin(String mobileNo) {
        localDatabase.edit().putString(KEY_MOBILE_NO, mobileNo).apply();
    }
}
