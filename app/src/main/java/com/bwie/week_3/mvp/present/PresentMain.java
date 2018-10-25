package com.bwie.week_3.mvp.present;

import android.util.Log;

import com.bwie.week_3.bean.ShopCartBean;
import com.bwie.week_3.ibase.IMainView;
import com.bwie.week_3.mvp.model.ModelMain;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresentMain extends BasePreseent<IMainView>{

    ModelMain modelMain;
    IMainView iMainView;

    public PresentMain(IMainView iMainView){

        this.iMainView=iMainView;
        modelMain=new ModelMain();
    }

    public void getShop(String cid){

        modelMain.getShop(cid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShopCartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopCartBean shopCartBean) {

                        iMainView.success(shopCartBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("xxx",e+"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
