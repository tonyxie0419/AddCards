package com.jikexueyuan.addcards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by sveta on 2016/7/27.
 */
public class MyAdapter extends BaseAdapter {

    private int mHeight;
    private int mWidth;

    public MyAdapter(int mHeight, int mWidth) {
        this.mHeight = mHeight;
        this.mWidth = mWidth;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,
                    null);
            //设置单元宽高
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(mWidth / 4, mHeight / 5);
            convertView.setLayoutParams(params);
            convertView.setTag(new ViewHolder((TextView) convertView.findViewById(R.id.tvNumber)));
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.getTvNumber().setText((position + 1) + "");
        return convertView;
    }
}
