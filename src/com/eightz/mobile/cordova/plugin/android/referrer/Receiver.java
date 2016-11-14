package com.eightz.mobile.cordova.plugin.android.referrer;

import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import android.util.Log;

public class Receiver extends BroadcastReceiver {

public static final String PREFS_NAME = "NativeStorage";
public static final String REFFERER = "refferer";

@Override
public void onReceive(Context context, Intent intent) {

    Bundle extras = intent.getExtras();
    if (extras != null) {

    	String referrerString = extras.getString("referrer");
        if (referrerString != null) {

           SharedPreferences mPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

    	    Editor edit = mPrefs.edit();
    	    edit.putString(REFFERER, referrerString);
    	    edit.commit();
        }
    }
}
 
} // end of class