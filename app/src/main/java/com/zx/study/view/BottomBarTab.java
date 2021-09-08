package com.zx.study.view;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.zx.study.R;


/**
 * @创建者： zx
 * @创建时间： 下午4:59
 * 描述：
 */
public class BottomBarTab  extends FrameLayout {
    Context mContext;
    private ImageView mImageView;
    private TextView mTextView;
    private int mTabPosition = -1 ;
    private TextView mNumber;
    private int count;

    public BottomBarTab(@NonNull Context context,int icon,String title) {
        this(context,null,icon,title);
    }

    public BottomBarTab(@NonNull Context context, @Nullable AttributeSet attrs,int icon,String title) {
        this(context, attrs,-1,icon,title);
    }

    public BottomBarTab(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr,int icon ,String title) {
        super(context, attrs, defStyleAttr);

        //初始化view
        initView(context,icon, title);
    }

    private void initView(Context context,int icon,String title) {
       // this.mContext=context;
        final RelativeLayout layout = new RelativeLayout(context);
        layout.setHorizontalGravity(1);
        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);

        //图片
        mImageView = new ImageView(context);
        final RelativeLayout.LayoutParams ivparams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mImageView.setLayoutParams(ivparams);
        mImageView.setImageResource(icon);
        mImageView.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect));
        mImageView.setId(Integer.parseInt("1"));
        layout.addView(mImageView);

        //文字
        mTextView = new TextView(context);
        mTextView.setGravity(Gravity.CENTER);
        final RelativeLayout.LayoutParams tvparams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tvparams.addRule(RelativeLayout.BELOW, 1);
        mTextView.setLayoutParams(tvparams);
        mTextView.setTextColor(ContextCompat.getColor(context, R.color.tab_unselect));
        mTextView.setTextSize(18);
        mTextView.setText(title);

        layout.addView(mTextView);

        //数字
        mNumber = new TextView(context);
        mNumber.setGravity(Gravity.CENTER);
        final RelativeLayout.LayoutParams numberParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mNumber.setLayoutParams(tvparams);
        mNumber.setTextColor(ContextCompat.getColor(context, R.color.number_message));
        mNumber.setTextSize(18);
        numberParams.addRule(RelativeLayout.ALIGN_RIGHT,1);
        layout.addView(mNumber);

        addView(layout);

    }


    public void setTabSelected(Boolean isSelected){
        if(isSelected){
            mImageView.setColorFilter(ContextCompat.getColor(getContext(),R.color.select));
            mTextView.setTextColor(ContextCompat.getColor(getContext(),R.color.select));
        }else {
            mImageView.setColorFilter(ContextCompat.getColor(getContext(),R.color.black));
            mTextView.setTextColor(ContextCompat.getColor(getContext(),R.color.black));
        }
    }

    public void setTabPosition(int position) {
        this.mTabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    /**
     * 获取当前
     * @return
     */
    public int  getTabPosition() {
        return mTabPosition;
    }

    /**
     * 设置未读消息
     */
    public void setNnmberMessage(int number){
        if(number == 0 ){
            mNumber.setText(String.valueOf(number));
            mNumber.setVisibility(GONE);
        }else {
            mNumber.setVisibility(VISIBLE);
            if(number>99){
                mNumber.setText("99+");
            }else {
                mNumber.setText(String.valueOf(number));
            }
        }

    }
    /**
     * 获取未读消息
     */
    public int getNnmberMessage(){
        int count = 0;
        if(TextUtils.isEmpty(mNumber.getText())){
            return count;
        }
        if((mNumber.getText().toString()).equals("99+")){
            return 99;
        }
        try {
            count = Integer.valueOf(mNumber.getText().toString());
        } catch (Exception ignored) {
        }
        return count;

    }

}
