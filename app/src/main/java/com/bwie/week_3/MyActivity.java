package com.bwie.week_3;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.week_3.bean.Userinfo;
import com.bwie.week_3.ibase.IMyView;
import com.bwie.week_3.mvp.present.MyPresent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyActivity extends AppCompatActivity implements IMyView {

    @BindView(R.id.icoe_image)
    ImageView icoeImage;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_name_es)
    TextView tvNameEs;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_time)
    TextView tvTime;
    private MyPresent myPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.bind(this);

        myPresent = new MyPresent(this);
        myPresent.getMy("71");

    }

    @Override
    public void success(Userinfo userinfo) {
        Userinfo.DataBean bean = userinfo.getData();

        icoeImage.setImageURI(Uri.parse(bean.getIcon()));
        tvName.setText(bean.getUsername());
        tvNameEs.setText(bean.getNickname());
        tvSex.setText(bean.getAge()+"");
        tvTime.setText(bean.getCreatetime());
    }
}
