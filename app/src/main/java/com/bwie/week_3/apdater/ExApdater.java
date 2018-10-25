package com.bwie.week_3.apdater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bwie.week_3.R;
import com.bwie.week_3.bean.ShopClassBean;
import com.bwie.week_3.view.MyGridView;

import java.util.List;

import retrofit2.http.POST;

public class ExApdater extends BaseExpandableListAdapter {
    List<ShopClassBean.DataBean> list;

    public ExApdater(List<ShopClassBean.DataBean> beanList) {
        this.list = beanList;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=View.inflate(parent.getContext(), R.layout.group_item,null);
        }
        TextView group_name = convertView.findViewById(R.id.group_name);

        group_name.setText(list.get(groupPosition).getName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView==null){

            convertView=View.inflate(parent.getContext(),R.layout.grit_item,null);
        }

        MyGridView grid = convertView.findViewById(R.id.grid);
        List<ShopClassBean.DataBean.ListBean> list = this.list.get(groupPosition).getList();
        grid.setAdapter(new GridApdater(list));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
