package com.bwie.week_3.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class Myapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
