package com.example.android_4.ui.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyMainViewPager extends ViewPager {

    private boolean enabled;
//    public MyMainViewPager(@NonNull Context context) {
//        super(context);
//    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.enabled){
            return super.onTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.enabled){
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    public MyMainViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.enabled = true;
    }
    public void setPagingEnabled(boolean enabled){
        this.enabled = enabled;
    }
}
