package com.example.study.util.application;

import android.app.Application;
import android.content.Context;

/**
 * @创建者： zx
 * @创建时间： Application 上午9:13
 * 描述：
 */
public class StudyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
