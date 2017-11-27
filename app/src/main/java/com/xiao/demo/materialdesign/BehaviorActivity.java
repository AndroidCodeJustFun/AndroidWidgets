package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by xiao on 2017/9/21.
 */

public class BehaviorActivity extends BaseActivity {

	public static final String TAG = "BehaviorActivity";

	@BindView(R.id.behavior_btn_simplebehavior)
	Button btn_simplebehavior;

	@BindView(R.id.behavior_btn_ucbehavior)
	Button btn_ucbehavior;


	public static void start(Context context) {
		Intent starter = new Intent(context, BehaviorActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_behavior;
	}

	@Override
	public void initView() {
		setTitle(TAG);
		btn_simplebehavior.setOnClickListener(view -> SimpleBehaviorActivity.start(BehaviorActivity.this));
		btn_ucbehavior.setOnClickListener(view -> UCBehaviorActivity.start(BehaviorActivity.this));
	}

	@Override
	public void initData() {

	}
}
