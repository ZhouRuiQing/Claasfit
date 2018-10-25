package com.bwie.week_3.apdater;

import android.content.Context;

import com.bwie.week_3.MyActivity;
import com.bwie.week_3.bean.Userinfo;

public class MyApdater {
    Context context;
    Userinfo.DataBean bean;

    public MyApdater(Context context, Userinfo.DataBean bean) {
        this.context = context;
        this.bean = bean;

    }
}
