package com.ardityoc.scribdviewer.utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;

public class SharedPreferences {

    public static final String SHARED_PREFS_MAIN = "SHARED_PREFS_MAIN";
    public static final String SHARED_PREFS_ONBOARD = "SHARED_PREFS_ONBOARD";

    public static final String id = "id";
    public static final String name = "name";

    public static void saveID(String scribdID, Context context){
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_MAIN, MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(id, scribdID);
        editor.apply();
    }

    public static void saveName(String nama, Context context){
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_ONBOARD, MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(name, nama);
        editor.apply();
    }

    public static String loadName(Context context){
        final android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_ONBOARD, MODE_PRIVATE);

        String[] splitName = sharedPreferences.getString(name, "").split("\\s+");
        return splitName[0];
    }

    public static String loadID(Context context){
        final android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_MAIN, MODE_PRIVATE);

        return sharedPreferences.getString(id, "");
    }

}
