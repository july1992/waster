package com.vily.waste.widgt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vily.waste.R;

/**
 * description :
 * Author : Vily
 * Date : 2019/06/24
 * Time : 22:25
 */

public class LinearUI extends LinearLayout {

    private LayoutInflater mInflater;
    private Context mContext;
    private View mView;
    private ImageView mIv_icon;
    private TextView mTv_title;

    public LinearUI(Context context) {
        this(context,null);
    }

    public LinearUI(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    @SuppressLint("RestrictedApi")
    public LinearUI(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        initView();

        if(attrs!=null){

             final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.LinearUI, defStyleAttr, 0);

            String content = a.getString(R.styleable.LinearUI_home_content);
            if(!TextUtils.isEmpty(content)){
                setContent(content);
            }
            Drawable icon = a.getDrawable(R.styleable.LinearUI_home_icon);
            if(icon!=null){
                setDrawable(icon);
            }

            a.recycle();

        }
    }

    public void setDrawable(Drawable icon) {

        if(mIv_icon!=null){
            mIv_icon.setImageDrawable(icon);
        }
    }

    public void setContent(String content) {

        if(mTv_title!=null){
            mTv_title.setText(content);
        }
    }

    private void initView() {

        if (mView == null) {
            mInflater = LayoutInflater.from(mContext);
            mView = mInflater.inflate(R.layout.ui_linear, this,true);
            mIv_icon = mView.findViewById(R.id.iv_icon);
            mTv_title = mView.findViewById(R.id.tv_title);
        }


    }
}
