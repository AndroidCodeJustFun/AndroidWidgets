package com.xiao.demo.animation.interpolater;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;

/**
 * Description：
 * Created on 2017/7/20
 * Author : 萧
 */
public class MyLinearpolater extends LinearInterpolator {

    private static final String TAG = "MyLinearpolater";

    public MyLinearpolater() {
        super();
    }

    public MyLinearpolater(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public float getInterpolation(float input) {
        Log.e(TAG, "getInterpolation: " + input);
        return super.getInterpolation(input);
    }
}
