package com.example.study.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @创建者： zx
 * @创建时间： 下午8:50
 * 描述：
 */
public class ApplicationFragment extends Fragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mTextView = new TextView(getActivity());
        mTextView.setText("应用");
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setTextSize(22);

        return mTextView;

    }
}
