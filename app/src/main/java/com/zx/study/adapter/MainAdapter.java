package com.example.study.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.study.bean.FragmentBean;

import java.util.ArrayList;


/**
 * @创建者： zx
 * @创建时间： 下午8:52
 * 描述：
 */
public class MainAdapter extends FragmentPagerAdapter {


    private ArrayList<FragmentBean> framentLiat;

    public MainAdapter(FragmentManager fm, ArrayList<FragmentBean> fragmentList) {
        super(fm);
        this.framentLiat = fragmentList;
    }

    /*public MainAdapter(  FragmentManager fm, ArrayList<FragmentBean> framentLiat) {
        super(fm);
        this.framentLiat = framentLiat;
    }*/

    /**
     * 返回每一页指定位置的Fragment对象
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return framentLiat.get(position).fragment;
    }

    /**
     * 返回有多少个Fragment
     *
     * @return
     */
    @Override
    public int getCount() {
        System.out.println("fragmentList=" + framentLiat);
        return framentLiat.size();
    }

}
