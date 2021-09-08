package com.example.study.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.study.bean.FragmentBean;

import java.util.ArrayList;

/**
 * @创建者： zx
 * @创建时间： 下午12:28
 * 描述：
 */
public class MainVp2Adapter extends FragmentStateAdapter {


    private ArrayList<FragmentBean> framentLiat;
    public MainVp2Adapter(@NonNull FragmentActivity fragment, ArrayList<FragmentBean> fragmentList) {
        super(fragment);
        this.framentLiat = fragmentList;
    }



    @NonNull

    @Override
    public Fragment createFragment(int position) {
        return framentLiat.get(position).fragment;
    }

    @Override
    public int getItemCount() {
        return  framentLiat.size();
    }


}
