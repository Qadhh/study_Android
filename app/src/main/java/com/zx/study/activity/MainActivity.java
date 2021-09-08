package com.example.study.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;


import com.example.study.adapter.MainVp2Adapter;
import com.example.study.util.bean.FragmentBean;
import com.example.study.fragment.AddressBookFragment;
import com.example.study.fragment.FindFragment;
import com.example.study.fragment.MyFragment;
import com.example.study.fragment.WeiXInFragment;
import com.zx.study.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.vp)
    ViewPager2  vp;
    //    @BindView(R.id.vp)
    //    ViewPager   vp;


    private ArrayList<FragmentBean> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化数据
        initData();
        //设置ViewPager
        //vp.setAdapter(new MainAdapter(getSupportFragmentManager(), fragmentList));
        vp.setAdapter(new MainVp2Adapter( this,fragmentList));
        vp.setCurrentItem(0);
        rb1.setTextColor(Color.RED);
       /* vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb1.setTextColor(Color.RED);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        rb1.setTextColor(Color.BLACK);
                        rb2.setTextColor(Color.RED);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);
                        break;
                    case 2:
                        rb1.setTextColor(Color.BLACK);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.RED);
                        rb4.setTextColor(Color.BLACK);
                        break;
                    case 3:
                        rb1.setTextColor(Color.BLACK);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.RED);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            //onPageSelected
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        rb1.setTextColor(Color.RED);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        rb1.setTextColor(Color.BLACK);
                        rb2.setTextColor(Color.RED);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);
                        break;
                    case 2:
                        rb1.setTextColor(Color.BLACK);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.RED);
                        rb4.setTextColor(Color.BLACK);
                        break;
                    case 3:
                        rb1.setTextColor(Color.BLACK);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.RED);
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

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                vp.setCurrentItem(0);
                rb1.setTextColor(Color.RED);
                rb2.setTextColor(Color.BLACK);
                rb3.setTextColor(Color.BLACK);
                rb3.setTextColor(Color.BLACK);
                break;
            case R.id.rb2:
                vp.setCurrentItem(1);
                rb1.setTextColor(Color.BLACK);
                rb2.setTextColor(Color.RED);
                rb3.setTextColor(Color.BLACK);
                rb4.setTextColor(Color.BLACK);
                break;
            case R.id.rb3:
                vp.setCurrentItem(2);
                rb1.setTextColor(Color.BLACK);
                rb2.setTextColor(Color.BLACK);
                rb3.setTextColor(Color.RED);
                rb4.setTextColor(Color.BLACK);
                break;
            case R.id.rb4:
                vp.setCurrentItem(3);
                rb1.setTextColor(Color.BLACK);
                rb2.setTextColor(Color.BLACK);
                rb3.setTextColor(Color.BLACK);
                rb4.setTextColor(Color.RED);
                break;
        }
    }

}