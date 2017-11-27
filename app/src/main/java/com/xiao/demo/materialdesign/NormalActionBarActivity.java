package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by xiao on 2017/9/7.
 */

public class NormalActionBarActivity extends BaseActivity {

	@BindView(R.id.normalactionbar_tv_content)
	TextView tvContent;

	@BindView(R.id.normalactionbar_cb_iconlogo)
	CheckBox cb_iconlogo;

	private ActionBar actionBar;

	public static void start(Context context) {
		Intent starter = new Intent(context, NormalActionBarActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_normalactionbar;
	}

	@Override
	public void initView() {
		actionBar = getSupportActionBar();
		actionBar.setTitle("LongLongLongLongLongTitle");
		actionBar.setSubtitle("SubTitle");
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setHomeAsUpIndicator(R.mipmap.ic_arrow_back_white_24dp);
		actionBar.setHomeActionContentDescription("description");
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setIcon(R.mipmap.ic_assessment_white_18dp);
		actionBar.setLogo(R.mipmap.ic_menu_white_24dp);
//		actionBar.setHomeButtonEnabled(true);
//		actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_USE_LOGO);
		actionBar.show();

		cb_iconlogo.setOnCheckedChangeListener((compoundButton, b) -> {
			cb_iconlogo.setText(b ? "显示Icon" : "显示Logo");
			actionBar.setDisplayUseLogoEnabled(!b);
		});

		actionBar.addOnMenuVisibilityListener(isVisible -> {
			Log.e(TAG, "initView: menu is visible " + isVisible);
		});

	}

	@Override
	public void initData() {
		tvContent.setText("actionBar = getSupportActionBar();\n" +
				"setTitle(\"Title\");\n" +
				"setSubtitle(\"SubTitle\");\n" +
				"setDisplayShowTitleEnabled(true);\n" +
				"setHomeAsUpIndicator(R.mipmap.ic_arrow_back_white_24dp);\n" +
				"setDisplayHomeAsUpEnabled(true);\n" +
				"setDisplayShowHomeEnabled(true);\n" +
				"setIcon(R.mipmap.ic_assessment_white_18dp);\n" +
				"setLogo(R.mipmap.ic_menu_white_24dp);\n" +
				"show();");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.toolbar_more, menu);
		getMenuInflater().inflate(R.menu.menu2, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		Log.e(TAG, "onMenuOpened: featureId = " + featureId + "  " + (menu == null ? "menu is null" : menu));
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Log.e(TAG, "onContextItemSelected: " + R.id.group1 + "  " + R.id.group2 + " " + item.getGroupId() + "  " + item.getItemId() + " " + item.getTitle());
		return super.onContextItemSelected(item);
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
