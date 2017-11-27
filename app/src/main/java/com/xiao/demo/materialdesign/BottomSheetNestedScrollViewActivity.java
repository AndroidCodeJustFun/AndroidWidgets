package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by xiao on 2017/9/13.
 */

public class BottomSheetNestedScrollViewActivity extends BaseActivity {

	public static final String TAG = "BottomSheetNestedScroll";

	@BindView(R.id.appbarlayout)
	AppBarLayout mAppBarLayout;

	@BindView(R.id.bottomsheet_fab)
	FloatingActionButton fab;

	@BindView(R.id.bottomsheet_nestedscrollview)
	NestedScrollView mNestedScrollView;

	public static void start(Context context) {
		Intent starter = new Intent(context, BottomSheetNestedScrollViewActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_bottomsheet_nestedscrollview;
	}

	@Override
	public void initView() {
		setTitle(TAG);
		BottomSheetBehavior behavior = BottomSheetBehavior.from(mNestedScrollView);
		showCurrentState(behavior.getState());
		if (behavior.getState() != BottomSheetBehavior.STATE_HIDDEN)
			behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
		fab.setOnClickListener(view ->
				behavior.setState(behavior.getState() != BottomSheetBehavior.STATE_COLLAPSED ? BottomSheetBehavior.STATE_COLLAPSED : BottomSheetBehavior.STATE_EXPANDED)
		);

	}

	@Override
	public void initData() {

	}

	public void showCurrentState(int state) {
		switch (state) {
			case BottomSheetBehavior.STATE_COLLAPSED:
				Log.e(TAG, "showCurrentState: STATE_COLLAPSED");
				break;
			case BottomSheetBehavior.STATE_DRAGGING:
				Log.e(TAG, "showCurrentState: STATE_DRAGGING");
				break;
			case BottomSheetBehavior.STATE_EXPANDED:
				Log.e(TAG, "showCurrentState: STATE_EXPANDED");
				break;
			case BottomSheetBehavior.STATE_HIDDEN:
				Log.e(TAG, "showCurrentState: STATE_HIDDEN");
				break;
			case BottomSheetBehavior.STATE_SETTLING:
				Log.e(TAG, "showCurrentState: STATE_SETTLING");
				break;
		}
	}
}
