package com.xiao.demo.customview;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

/**
 * Created by xiao on 2017/9/25.
 */

public class CustomViewActivity extends BaseActivity {

	public static final String TAG = "CustomViewActivity";

	public static void start(Context context) {
		Intent starter = new Intent(context, CustomViewActivity.class);
		context.startActivity(starter);
		TextView tv;
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_customview;
	}

	@Override
	public void initView() {

	}

	@Override
	public void initData() {

	}
}
