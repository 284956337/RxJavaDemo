package com.plus.rxjavademo.app;

import android.app.Application;

/**
 * Created by zw on 2017/3/20.
 */
public class MyApplication extends Application {

    public static MyApplication APP_CONTEXT;

    @Override
    public void onCreate() {
        APP_CONTEXT = this;
        super.onCreate();
    }
}
