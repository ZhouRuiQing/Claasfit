package com.bwie.week_3.mvp.present;

import com.bwie.week_3.bean.ShopClassBean;
import com.bwie.week_3.ibase.IShopCartView;
import com.bwie.week_3.mvp.model.ShopCartModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShopCartPresent extends BasePreseent<IShopCartView> {

    IShopCartView iShopCartView;
    ShopCartModel shopCartModel;

    public  ShopCartPresent(IShopCartView iShopCartView){
        this.iShopCartView=iShopCartView;
        shopCartModel=new ShopCartModel();
    }

    public void getShopCart(String cid){

        shopCartModel.getShopCart(cid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShopClassBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopClassBean shopClassBean) {

                        iShopCartView.success(shopClassBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
