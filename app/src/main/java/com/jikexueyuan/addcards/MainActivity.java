package com.jikexueyuan.addcards;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private int mItemHeight;
    private int mItemWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置gridView
        gridView = new GridView(this);
        gridView.setNumColumns(4);
        gridView.setHorizontalSpacing(10);
        gridView.setVerticalSpacing(10);
        setContentView(gridView);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            //每个item高度的和（除去间隔）
            mItemHeight = gridView.getMeasuredHeight() - (gridView.getVerticalSpacing() * 4);
            //每个item宽度的和（除去间隔）
            mItemWidth = gridView.getMeasuredWidth() - (gridView.getHorizontalSpacing() * 3);
            gridView.setAdapter(new MyAdapter(mItemHeight,mItemWidth));
        }
    }
}