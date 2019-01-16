package com.android.launcher3.whatau;


public class WhatauUtils {

    public static final String HOME_CHANGE_GRID = "pref_change_home_grid_size";
    public static final String HOME_ROW = "pref_home_rows";
    public static final String HOME_COLUMN = "pref_home_columns";


    public static final String KEY_APP_SUGGESTIONS = "pref_app_suggestions";
    public static final String DRAWER_CHANGE_GRID = "pref_change_drawer_grid_size";
    public static final String DRAWER_ROW = "pref_drawer_rows";
    public static final String DRAWER_COLUMN = "pref_drawer_columns";

    public static void restartLauncher() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
