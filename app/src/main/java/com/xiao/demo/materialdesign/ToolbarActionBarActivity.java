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
		tvContent.setText(new StringBuilder().append("View view = findViewById(R.id.toolbar_actionbar);\n").append("if (view != null) {\n").append("Log.e(TAG, \"initActionBar: \" + view.getClass());\n").append("mToolbar = (Toolbar) view;\n").append("if (mToolbar != null) {\n").append("mToolbar.setNavigationOnClickListener(v -> onBackPressed());\n").append("//mToolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_menu_white_24dp));\n").append("mTv_title = view.findViewById(R.id.toolbar_tv_title);\n").append("mLayoutMore = view.findViewById(R.id.toolbar_more);\n").append("setSupportActionBar(mToolbar);\n").append("mActionBar = getSupportActionBar();\n").append("mActionBar.setDisplayShowTitleEnabled(false);").toString());
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
