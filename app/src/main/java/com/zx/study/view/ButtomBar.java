package com.zx.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;


import com.example.study.util.application.StudyApplication;

import java.util.ArrayList;

/**
 * @创建者： zx
 * @创建时间： 下午8:32
 * 描述：
 */
public class ButtomBar extends LinearLayout {

    private LinearLayout mLinearLayout;
    private int selectPosition = -1;
    public ArrayList<com.zx.study.view.BottomBarTab> mTabArrayList;
    public BottomBarSelectListener mListener;
    private LayoutParams mLayoutParams;

    public ButtomBar(Context context) {
        this(context, null);
    }

    public ButtomBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ButtomBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //初始化view
        initView();
    }

    private void initView() {
        setOrientation(HORIZONTAL);
        mLayoutParams = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLayoutParams.weight = 1;
        //设置第一个条目为选中状态
        if (selectPosition == -1) {
            selectPosition = 0;
        }
        mTabArrayList = new ArrayList<>();
    }

    public void addItem(com.zx.study.view.BottomBarTab tab) {

        if (tab != null) {
            mTabArrayList.add(tab);
            tab.setTabPosition(mTabArrayList.size());
            tab.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.setShowBottomBar(tab.getTabPosition()-1);
                    mTabArrayList.get(selectPosition).setSelected(false);
                    selectPosition = tab.getTabPosition() - 1;
                    tab.setTabSelected(true);
                }
            });

        }
        addView(tab, mLayoutParams);
    }


    public void setShowBottomBar(int selectItem) {
        selectPosition = selectItem - 1;
        mTabArrayList.get(selectPosition).setTabSelected(true);
    }

    /**
     * 将底部导航栏都设置为非选中状态
     *
     * @param list
     */
    public void setUnShowBottomBar(ArrayList<com.zx.study.view.BottomBarTab> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setTabSelected(false);
        }

    }

    public void setListener(BottomBarSelectListener listener) {
        this.mListener = listener;
    }

    public interface BottomBarSelectListener {
        void setShowBottomBar(int showPosition);

    }

}
