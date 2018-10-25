package com.bwie.week_3.mvp.present;

import com.bwie.week_3.bean.Userinfo;
import com.bwie.week_3.ibase.IMyView;
import com.bwie.week_3.ibase.IShopCartView;
import com.bwie.week_3.mvp.model.ModelMain;
import com.bwie.week_3.mvp.model.MyModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyPresent extends BasePreseent<IShopCartView>{

    IMyView iMyView;
    MyModel myModel;

    public MyPresent(IMyView iMyView){

        this.iMyView=iMyView;
        myModel=new MyModel();
    }

    public void  getMy(String uid){

        myModel.getMy(uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Userinfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Userinfo userinfo) {

                        iMyView.success(userinfo);
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
