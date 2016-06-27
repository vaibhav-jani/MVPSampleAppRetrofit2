package com.example.vaibhav.testmvp;

import android.app.Application;

/**
 * Created by vaibhav on 6/6/16.
 */
public class BaseApp extends Application {

    private static BaseApp instance;

    @Override
    public void onCreate() {

        super.onCreate();

        instance = this;
    }

    public static BaseApp getInstance() {

        return instance;
    }
}
