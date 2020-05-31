package com.javaoneworld.paperdbdemo;

import android.app.Application;

import io.paperdb.Paper;

public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Paper.init(getApplicationContext());
    }
}
