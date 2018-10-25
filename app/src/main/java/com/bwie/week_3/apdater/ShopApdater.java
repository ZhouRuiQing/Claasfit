package com.bwie.week_3.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.week_3.MainActivity;
import com.bwie.week_3.R;
import com.bwie.week_3.bean.ShopCartBean;

import java.util.List;

public class ShopApdater  extends RecyclerView.Adapter<MyViewHoder> {
    Context context;
    List<ShopCartBean.DataBean> list;

    public ShopApdater(Context context, List<ShopCartBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MyViewHoder hoder = new MyViewHoder(LayoutInflater.from(context).inflate(R.layout.recylerview_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, final int position) {

        holder.tv_item_name.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onCatagoryLisenter!=null){

                    onCatagoryLisenter.onNameClick(list.get(position).getCid());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnCatagoryLisenter {
        void onNameClick(int cid);
    }

    private OnCatagoryLisenter onCatagoryLisenter;

    public void setOnCatagoryLisenter(OnCatagoryLisenter onCatagoryLisenter) {
        this.onCatagoryLisenter = onCatagoryLisenter;
    }

}
