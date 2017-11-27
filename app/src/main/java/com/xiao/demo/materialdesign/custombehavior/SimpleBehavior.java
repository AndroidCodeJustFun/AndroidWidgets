package com.xiao.demo.materialdesign.custombehavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xiao on 2017/9/22.
 */

public class SimpleBehavior extends CoordinatorLayout.Behavior<TextView> {

	public static final String TAG = "SimpleBehavior";

	public SimpleBehavior() {
		super();
	}

	public SimpleBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams params) {
		super.onAttachedToLayoutParams(params);
		Log.e(TAG, "onAttachedToLayoutParams: ");
	}

	@Override
	public void onDetachedFromLayoutParams() {
		super.onDetachedFromLayoutParams();
		Log.e(TAG, "onDetachedFromLayoutParams: ");
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
		return dependency instanceof Button;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
		child.setText(dependency.getX() + "," + dependency.getY());
		child.setX(dependency.getX() + 200);
		child.setY(dependency.getY() + 200);
		return true;
	}

}

