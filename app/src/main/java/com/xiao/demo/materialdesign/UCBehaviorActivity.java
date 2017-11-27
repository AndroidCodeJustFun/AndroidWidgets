package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xiao on 2017/9/22.
 */

public class UCBehaviorActivity extends BaseActivity {

	public static final String TAG = "UCBehaviorActivity";

	@BindView(R.id.ucbehavior_tv_title)
	TextView tv_title;

	@BindView(R.id.ucbehavior_img)
	CircleImageView img;

	@BindView(R.id.ucbehavior_cb_mode)
	CheckBox cb_mode;

	public static void start(Context context) {
		Intent starter = new Intent(context, UCBehaviorActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_ucbehavior;
	}

	@Override
	public void initView() {
//		mToolbar.setTitle(TAG);
//		mToolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_18dp);
		tv_title.setText(TAG);
		cb_mode.setOnCheckedChangeListener((CompoundButton view, boolean checked) -> {
			img.setVisibility(checked ? View.GONE : View.VISIBLE);
			tv_title.setVisibility(checked ? View.VISIBLE : View.GONE);
		});
	}

	@Override
	public void initData() {

	}
}
