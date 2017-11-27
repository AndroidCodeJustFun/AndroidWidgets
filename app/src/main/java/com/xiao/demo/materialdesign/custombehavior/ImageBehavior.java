package com.xiao.demo.materialdesign.custombehavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.xiao.demo.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xiao on 2017/9/25.
 */

public class ImageBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

	public static final String TAG = "ImageBehavior";

	private Context mContext;
	//头像的最终大小
	private float mCustomFinalHeight;

	//最终头像的Y
	private float mFinalAvatarY;

	private float mStartAvatarY;

	private float mStartAvatarX;

	private int mAvatarMaxHeight;

	public ImageBehavior() {
	}

	public ImageBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		if (attrs != null) {
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomBehavior);//获取缩小以后的大小
			mCustomFinalHeight = a.getDimension(R.styleable.CustomBehavior_finalHeight, 0);
			a.recycle();
		}
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {
		return dependency instanceof Toolbar;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {

		//初始化属性
//init(child, dependency);
		mFinalAvatarY = dependency.getHeight() / 2;
		if (mStartAvatarY == 0) {
			mStartAvatarY = dependency.getY();
			Log.e(TAG, "onDependentViewChanged: mStartAvatarY = " + mStartAvatarY);
		}
		if (mStartAvatarX == 0) {
			mStartAvatarX = child.getX();
			Log.e(TAG, "onDependentViewChanged: mStartAvatarX = " + mStartAvatarX);
		}

		if (mAvatarMaxHeight == 0) {
			mAvatarMaxHeight = child.getHeight();
			Log.e(TAG, "onDependentViewChanged:  mAvatarMaxHeight  = " + mAvatarMaxHeight);
		}
//child.setY(dependency.getY());

//让ImageView跟随toolbar垂直移动

		child.setY(dependency.getY() + dependency.getHeight() / 2 - mCustomFinalHeight / 2);

		float percent = dependency.getY() / mStartAvatarY;

		float x = mStartAvatarX * (1 + percent);
//		float x = mStartAvatarX * (1+ interpolator.getInterpolation(percent));

		Log.e(TAG, "percent = " + percent + " currentX " + x + "  " + child.getX());

//当toolbar 达到了位置，就不改变了。
		if (dependency.getY() > dependency.getHeight() / 2) {
			Log.e(TAG, "onDependentViewChanged: toolbar reach position");
			child.setX(x);
		} else {
			child.setX(mStartAvatarX + ((mAvatarMaxHeight - mCustomFinalHeight)) / 2);
			Log.e(TAG, "onDependentViewChanged: " + child.getX());
		}

		CoordinatorLayout.LayoutParams layoutParams =
				(CoordinatorLayout.LayoutParams) child.getLayoutParams();
		layoutParams.height = (int) ((mAvatarMaxHeight - mCustomFinalHeight) * percent + mCustomFinalHeight);
		layoutParams.width = (int) ((mAvatarMaxHeight - mCustomFinalHeight) * percent + mCustomFinalHeight);
//		Log.e(TAG, "onDependentViewChanged: " + layoutParams.height + "  " + layoutParams.width);
		child.setLayoutParams(layoutParams);

		if (percent == 0.5f) {
			Log.e(TAG, "onDependentViewChanged: " + child.getX() + "  " + child.getY() + "  " + child.getWidth() + "  " + child.getHeight());
		}

		return true;
	}
}
