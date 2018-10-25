package com.bwie.week_3.mvp.present;

import com.bwie.week_3.ibase.IBaseView;

public class BasePreseent <V extends IBaseView> {

    private V iv;

    public void attachView(V v) {
        this.iv = v;
    }

    public void dettachView() {
        this.iv = null;
    }

    public V getView(){
        return iv;
    }
}
