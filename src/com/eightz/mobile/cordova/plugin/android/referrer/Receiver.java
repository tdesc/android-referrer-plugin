package com.eightz.mobile.cordova.plugin.android.referrer;

import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import android.widget.Toast;
import android.util.Log;

public class Receiver extends BroadcastReceiver {

public static final String PREFS_NAME = "NativeStorage";
public static final String REFERRER = "referrer";

@Override
public void onReceive(Context context, Intent intent) {

    Bundle extras = intent.getExtras();
    if (extras != null) {

    	String referrerString = extras.getString("referrer");

        Toast.makeText(context, "REFERRER " + referrerString, Toast.LENGTH_SHORT).show();


        if (referrerString != null) {

           SharedPreferences mPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

    	    Editor edit = mPrefs.edit();
    	    edit.putString(REFERRER, referrerString);
    	    edit.commit();
        }
        Log.v(REFERRER, referrerString);
    }
}
 
} // end of class