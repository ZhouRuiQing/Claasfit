package com.bwie.week_3.mvp.model;

import com.bwie.week_3.bean.ShopCartBean;
import com.bwie.week_3.utils.HttpUtils;

import io.reactivex.Observable;

public class ModelMain {

    public Observable<ShopCartBean> getShop(String cid){

        return HttpUtils.getInstance().api.getShop(cid);
    }
}
