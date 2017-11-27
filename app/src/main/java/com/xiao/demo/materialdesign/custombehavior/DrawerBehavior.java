package com.xiao.demo.materialdesign.custombehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xiao on 2017/9/22.
 */

public class DrawerBehavior extends CoordinatorLayout.Behavior<TextView> {

	public static final String TAG = "DrawerBehavior";

	private int mFrameMaxheight = 100;

	private int mStartY;

	public DrawerBehavior() {
	}

	public DrawerBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
		return dependency instanceof Toolbar;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
		if (mStartY == 0) {
			mStartY = (int) dependency.getY();
		}
		float percent = dependency.getY() / mStartY;
		float v = child.getHeight() * (1 - percent) - child.getHeight();
//		child.setY(v);
//		Log.e(TAG, "onDependentViewChanged:  mStartY = " + mStartY + "  dependency.getY()  = " + dependency.getY() + " percent  =  " + percent + "  v = " + v);
		child.setY(-child.getHeight() * percent);
		return true;
	}
}
