package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by xiao on 2017/9/21.
 */

public class SimpleBehaviorActivity extends BaseActivity {

	public static final String TAG = "SimpleBehaviorActivity";

	@BindView(R.id.simplebehavior_btn)
	Button btn;
	@BindView(R.id.simplebehavior_tv_watcher)
	TextView tv_watcher;

	@BindView(R.id.simplebehavior_btn2)
	Button btn2;
	@BindView(R.id.simplebehavior_tv_watcher2)
	TextView tv_watcher2;


	public static void start(Context context) {
		Intent starter = new Intent(context, SimpleBehaviorActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_simplebehavior;
	}

	@Override
	public void initView() {
		setTitle(TAG);
		btn.setOnTouchListener((v, event) -> {
			switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE:
					v.setX(event.getRawX() - v.getWidth() / 2);
					v.setY(event.getRawY() - v.getHeight() / 2);
					break;
			}
			return false;
		});
		btn2.setOnTouchListener((v, event) -> {
			switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE:
//					v.setX(event.getRawX() - v.getWidth() / 2);
//					v.setY(event.getRawY() - v.getHeight() / 2);
					Log.e(TAG, "initView: " + v.getX() + "  " + v.getY());
					Log.e(TAG, "initView: " + (event.getRawX() - v.getWidth() / 2) + "  " + (event.getRawY() - v.getHeight() / 2));
					break;
			}
			return false;
		});
	}

	@Override
	public void initData() {

	}
}
