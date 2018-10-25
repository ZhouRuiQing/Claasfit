package com.bwie.week_3.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.week_3.R;

class MyViewHoder extends RecyclerView.ViewHolder {

    public final TextView tv_item_name;

    public MyViewHoder(View itemView) {
        super(itemView);

        tv_item_name = itemView.findViewById(R.id.tv_item_name);
    }
}
