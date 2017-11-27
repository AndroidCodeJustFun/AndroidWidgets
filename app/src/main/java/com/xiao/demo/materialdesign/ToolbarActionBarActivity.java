package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
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

public class ToolbarActionBarActivity extends BaseActivity {

	public static final String TAG = "ToolbarActionActivity";
	@BindView(R.id.normalactionbar_cb_iconlogo)
	CheckBox normalactionbarCbIconlogo;
	@BindView(R.id.normalactionbar_tv_content)
	TextView tvContent;

	public static void start(Context context) {
		Intent starter = new Intent(context, ToolbarActionBarActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_toolbar;
	}

	@Override
	public void initView() {
		setTitle(TAG);
		tvContent.setText("View view = findViewById(R.id.toolbar_actionbar);\n" +
				"if (view != null) {\n" +
				"Log.e(TAG, \"initActionBar: \" + view.getClass());\n" +
				"mToolbar = (Toolbar) view;\n" +
				"if (mToolbar != null) {\n" +
				"mToolbar.setNavigationOnClickListener(v -> onBackPressed());\n" +
				"//mToolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_menu_white_24dp));\n" +
				"mTv_title = view.findViewById(R.id.toolbar_tv_title);\n" +
				"mLayoutMore = view.findViewById(R.id.toolbar_more);\n" +
				"setSupportActionBar(mToolbar);\n" +
				"mActionBar = getSupportActionBar();\n" +
				"mActionBar.setDisplayShowTitleEnabled(false);");
	}

	@Override
	public void initData() {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu2, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.e(TAG, "onOptionsItemSelected: " + item.getTitle());
		Toast.makeText(this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
		if (item.getItemId() == android.R.id.home) onBackPressed();
		return super.onOptionsItemSelected(item);
	}


}
