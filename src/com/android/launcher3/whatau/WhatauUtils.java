package com.android.launcher3.whatau;


public class WhatauUtils {

    public static final String HOME_CHANGE_GRID = "pref_change_home_grid_size";
    public static final String HOME_ROW = "pref_home_rows";
    public static final String HOME_COLUMN = "pref_home_columns";
    public static final String SHOW_PREDICTIONS_PREF = "pref_home_columns";

    public static void restartLauncher() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
