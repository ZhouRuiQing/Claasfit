package com.bwie.week_3.utils;

import com.bwie.week_3.bean.ShopCartBean;
import com.bwie.week_3.bean.ShopClassBean;
import com.bwie.week_3.bean.Userinfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("product/getCatagory")
    Observable<ShopCartBean> getShop(@Query("cid") String cid);
    @GET("product/getProductCatagory")
    Observable<ShopClassBean> getShopCart(@Query("cid") String cid);
    @GET("user/getUserInfo")
    Observable<Userinfo> getMy(@Query("uid") String uid);
}
