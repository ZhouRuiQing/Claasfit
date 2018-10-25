package com.bwie.week_3.ibase;

import com.bwie.week_3.bean.ShopCartBean;

public interface IMainView extends IBaseView {

    void success(ShopCartBean shopCartBean);
    void Error(String msg);
}
