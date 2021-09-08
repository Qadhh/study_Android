package com.zx.study.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import com.example.study.adapter.MainVp2Adapter;
import com.example.study.fragment.AddressBookFragment;
import com.example.study.fragment.FindFragment;
import com.example.study.fragment.MyFragment;
import com.example.study.fragment.WeiXInFragment;
import com.example.study.util.bean.FragmentBean;
import com.zx.study.R;
import com.zx.study.view.BottomBarTab;
import com.zx.study.view.ButtomBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager2 vp;
    @BindView(R.id.bb)
    ButtomBar bb;
    private ArrayList<FragmentBean> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        bb.addItem(new BottomBarTab(this, R.mipmap.message, "微信"));
        bb.addItem(new BottomBarTab(this, R.mipmap.addressbook, "通讯录"));
        bb.addItem(new BottomBarTab(this, R.mipmap.find, "发现"));
        bb.addItem(new BottomBarTab(this, R.mipmap.my, "我"));
        bb.setListener(new ButtomBar.BottomBarSelectListener() {
            @Override
            public void setShowBottomBar(int showPosition) {

                Toast.makeText(HomeActivity.this, "click:" + showPosition, Toast.LENGTH_LONG).show();
                vp.setCurrentItem(showPosition);
                //                switch (showPosition - 1) {
                //                    case 0:
                //                        vp.setCurrentItem(0);
                //                       // bb.setShowBottomBar(1);
                //                        break;
                //                    case 1:
                //                        vp.setCurrentItem(1);
                //                        //bb.setShowBottomBar(2);
                //                        break;
                //                    case 2:
                //                        vp.setCurrentItem(2);
                //                       // bb.setShowBottomBar(3);
                //                        break;
                //                    case 3:
                //                        vp.setCurrentItem(3);
                //                       // bb.setShowBottomBar(4);
                //                        break;
                //
                //                }
            }
        });
        //初始化数据
        initData();
        vp.setAdapter(new MainVp2Adapter(this, fragmentList));
        vp.setCurrentItem(0);
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            //onPageSelected
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {

                    case 0:
                        bb.setUnShowBottomBar(bb.mTabArrayList);
                        bb.setShowBottomBar(1);
                        break;
                    case 1:
                        bb.setUnShowBottomBar(bb.mTabArrayList);
                        bb.setShowBottomBar(2);
                        break;
                    case 2:
                        bb.setUnShowBottomBar(bb.mTabArrayList);
                        bb.setShowBottomBar(3);
                        break;
                    case 3:
                        bb.setUnShowBottomBar(bb.mTabArrayList);
                        bb.setShowBottomBar(4);
                        break;
                }
            }
        });
    }

    private void initData() {
        String[] stringArray = {"微信", "通讯录", "发现", "我"};
        fragmentList = new ArrayList<FragmentBean>();
        fragmentList.add(new FragmentBean(new WeiXInFragment(), stringArray[0]));
        fragmentList.add(new FragmentBean(new AddressBookFragment(), stringArray[1]));
        fragmentList.add(new FragmentBean(new FindFragment(), stringArray[2]));
        fragmentList.add(new FragmentBean(new MyFragment(), stringArray[3]));

    }

}