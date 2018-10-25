package com.bwie.week_3.apdater;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.week_3.R;
import com.bwie.week_3.bean.ShopClassBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridApdater extends BaseAdapter {
    List<ShopClassBean.DataBean.ListBean> list;

    public GridApdater(List<ShopClassBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {

            convertView = View.inflate(parent.getContext(), R.layout.child_item, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {

            holder= (ViewHolder) convertView.getTag();
        }

        holder.childImg.setImageURI(Uri.parse(list.get(position).getIcon()));
        holder.childName.setText(list.get(position).getName());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.child_img)
        SimpleDraweeView childImg;
        @BindView(R.id.child_name)
        TextView childName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
