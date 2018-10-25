package com.bwie.week_3.mvp.model;

import com.bwie.week_3.bean.ShopCartBean;
import com.bwie.week_3.bean.Userinfo;
import com.bwie.week_3.utils.HttpUtils;

import io.reactivex.Observable;

public class MyModel {

    public  Observable<Userinfo> getMy(String uid){

        return HttpUtils.getInstance().api.getMy(uid);
    }
}
