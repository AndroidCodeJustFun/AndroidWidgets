package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by xiao on 2017/9/7.
 */

public class CustomViewActionBarActivity extends BaseActivity {

	@BindView(R.id.normalactionbar_cb_iconlogo)
	CheckBox cb_Iconlogo;
	@BindView(R.id.normalactionbar_tv_content)
	TextView tv_content;

	TextView tv_title;
	TextView tv_subtitle;
	ImageView img_back;
	ImageView img_icon;

	public static void start(Context context) {
		Intent starter = new Intent(context, CustomViewActionBarActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_normalactionbar;
	}

	@Override
	public void initView() {
		mActionBar = getSupportActionBar();
		View view = LayoutInflater.from(CustomViewActionBarActivity.this).inflate(R.layout.widget_customviewactionbar, null);
		tv_title = (TextView) view.findViewById(R.id.customactionbar_tv_title);
		tv_subtitle = (TextView) view.findViewById(R.id.customactionbar_tv_subtitle);
		img_back = (ImageView) view.findViewById(R.id.customactionbar_img_back);
		img_icon = (ImageView) view.findViewById(R.id.customactionbar_img_iconlogo);
		tv_title.setText("CustomViewActionBar");
		tv_subtitle.setText("LongLongLongLongLongSubTitle");
		img_back.setImageResource(R.mipmap.ic_arrow_back_white_24dp);
		img_back.setOnClickListener(v -> onBackPressed());
		img_icon.setImageResource(R.mipmap.ic_assessment_white_18dp);

		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayUseLogoEnabled(false);
		mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setDisplayShowCustomEnabled(true);
		mActionBar.setCustomView(view);

		mActionBar.show();
	}

	@Override
	public void initData() {
		cb_Iconlogo.setOnCheckedChangeListener((btn, b) -> {
			img_icon.setImageResource(b ? R.mipmap.ic_assessment_white_18dp : R.mipmap.ic_menu_white_18dp);
		});
		tv_content.setText("mActionBar = getSupportActionBar();\n" +
				"View view = LayoutInflater.from(CustomViewActionBarActivity.this).inflate(R.layout.widget_customviewactionbar, null);\n" +
				"ButterKnife.bind(view);\n" +
				"tv_title = view.findViewById(R.id.customactionbar_tv_title);\n" +
				"tv_subtitle = view.findViewById(R.id.customactionbar_tv_subtitle);\n" +
				"img_back = view.findViewById(R.id.customactionbar_img_back);\n" +
				"img_icon = view.findViewById(R.id.customactionbar_img_iconlogo);\n" +
				"tv_title.setText(\"CustomViewActionBar\");\n" +
				"tv_subtitle.setText(\"LongLongLongLongLongSubTitle\");\n" +
				"img_back.setImageResource(R.mipmap.ic_arrow_back_white_24dp);\n" +
				"img_back.setOnClickListener(v -> onBackPressed());\n" +
				"img_icon.setImageResource(R.mipmap.ic_assessment_white_18dp);\n" +
				"\n" +
				"mActionBar.setDisplayShowHomeEnabled(false);\n" +
				"mActionBar.setDisplayUseLogoEnabled(false);\n" +
				"mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);\n" +
				"mActionBar.setDisplayHomeAsUpEnabled(false);\n" +
				"mActionBar.setDisplayShowTitleEnabled(false);\n" +
				"mActionBar.setDisplayShowCustomEnabled(true);\n" +
				"mActionBar.setCustomView(view);\n" +
				"\n" +
				"mActionBar.show();");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu2, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.e(TAG, "onOptionsItemSelected: " + R.id.group1 + "  " + R.id.group2 + " " + item.getGroupId() + "  " + item.getItemId() + " " + item.getTitle());
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
				break;
			case android.R.id.icon:
				break;
			case android.R.id.title:
				break;
			default:
				Toast.makeText(this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
		}
		return super.onOptionsItemSelected(item);
	}
}
