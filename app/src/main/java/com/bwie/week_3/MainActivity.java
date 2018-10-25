package com.bwie.week_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.week_3.apdater.ExApdater;
import com.bwie.week_3.apdater.ShopApdater;
import com.bwie.week_3.bean.ShopCartBean;
import com.bwie.week_3.bean.ShopClassBean;
import com.bwie.week_3.ibase.IMainView;
import com.bwie.week_3.ibase.IShopCartView;
import com.bwie.week_3.mvp.present.PresentMain;
import com.bwie.week_3.mvp.present.ShopCartPresent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView,IShopCartView {

    @BindView(R.id.Rexycler_View)
    RecyclerView Rexycler_View;
    @BindView(R.id.Expand_View)
    ExpandableListView ExpandView;
    @BindView(R.id.edt_sousuo)
    TextView edtSousuo;
    @BindView(R.id.img_my)
    ImageView imgMy;
    private PresentMain presentMain;
    private ShopCartPresent shopCartPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presentMain = new PresentMain(this);
        presentMain.getShop("1");

        shopCartPresent = new ShopCartPresent(this);
        shopCartPresent.getShopCart("1");

        imgMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void success(ShopCartBean shopCartBean) {

        Log.i("aaa", shopCartBean.getData().size() + "");
        List<ShopCartBean.DataBean> list = shopCartBean.getData();
        Rexycler_View.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        ShopApdater apdater = new ShopApdater(MainActivity.this, list);
        Rexycler_View.setAdapter(apdater);

        apdater.setOnCatagoryLisenter(new ShopApdater.OnCatagoryLisenter() {
            @Override
            public void onNameClick(int cid) {
                shopCartPresent.getShopCart(cid + "");
            }
        });

    }

    @Override
    public void Error(String msg) {

    }

    @Override
    public void success(ShopClassBean shopClassBean) {

        List<ShopClassBean.DataBean> beanList = shopClassBean.getData();

        if (beanList.size() == 0) {

            Toast.makeText(MainActivity.this, "该分类没有商品", Toast.LENGTH_LONG).show();
        } else {
            ExApdater exApdater = new ExApdater(beanList);
            ExpandView.setAdapter(exApdater);

            for (int i = 0; i < beanList.size(); i++) {

                ExpandView.expandGroup(i);
            }
        }
    }
}
