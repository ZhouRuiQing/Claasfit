package com.bwie.week_3.mvp.model;

import com.bwie.week_3.bean.ShopClassBean;
import com.bwie.week_3.utils.HttpUtils;

import io.reactivex.Observable;

public class ShopCartModel {

    public  Observable<ShopClassBean> getShopCart(String cid){

        return HttpUtils.getInstance().api.getShopCart(cid);
    }
}
