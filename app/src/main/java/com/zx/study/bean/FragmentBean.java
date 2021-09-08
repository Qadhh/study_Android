package com.example.study.bean;

import androidx.fragment.app.Fragment;

/**
 * @创建者： zx
 * @创建时间： 下午12:39
 * 描述：
 */
public class FragmentBean {
    public Fragment fragment;
    String title;

    public FragmentBean(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }
}
