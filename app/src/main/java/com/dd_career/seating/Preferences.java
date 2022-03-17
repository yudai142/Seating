package com.dd_career.seating;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

// 設定を取得する方法を提供する.
public class Preferences {
    public final class Key {
        public static final String GOOGLE_APPS_SCRIPT_URL = "google_apps_script_url";
        public static final String RECORDS_SHEET_GAS_URL = "records_sheet_gas_url";
        public static final String SEATS_SHEET_GAS_URL = "seats_sheet_gas_url";
        public static final String USERS_SHEET_GAS_URL = "users_sheet_gas_url";
        private Key() {}
    }
    private Context context;
    private SharedPreferences preferences;

    public Preferences(Context context) {
        this.context = context;
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getGoogleAppsScriptUrl() {
        return preferences.getString(Key.GOOGLE_APPS_SCRIPT_URL, null);
    }
}
