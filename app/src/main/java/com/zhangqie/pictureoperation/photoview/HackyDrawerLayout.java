package com.zhangqie.pictureoperation.photoview;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.MotionEvent;


public class HackyDrawerLayout extends DrawerLayout {

    public HackyDrawerLayout(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
