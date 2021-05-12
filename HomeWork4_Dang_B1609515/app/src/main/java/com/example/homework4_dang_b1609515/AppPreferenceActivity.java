package com.example.homework4_dang_b1609515;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
public class AppPreferenceActivity extends PreferenceActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("appPreferences");
        //---load the preferences from an XML file---
        addPreferencesFromResource(R.xml.myapppreferences);
    }
}
