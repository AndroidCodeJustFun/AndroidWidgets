package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;

public class ActionBarActivity extends BaseActivity {

	public static final String TAG = "ActionBarActivity";

	@BindView(R.id.actionbar_btn_actionbar)
	Button btnActionbar;
	@BindView(R.id.actionbar_btn_actionbar_customview)
	Button btnActionbarCustomview;
	@BindView(R.id.actionbar_btn_toolbar)
	Button btnToolbar;

	public static void start(Context context) {
		Intent starter = new Intent(context, ActionBarActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_action_bar;
	}

	@Override
	public void initView() {
		btnActionbar.setOnClickListener(view -> {
			NormalActionBarActivity.start(ActionBarActivity.this);
		});
		btnActionbarCustomview.setOnClickListener(view -> {
			CustomViewActionBarActivity.start(ActionBarActivity.this);
		});
		btnToolbar.setOnClickListener(view -> {
			ToolbarActionBarActivity.start(ActionBarActivity.this);
		});
		Log.e(TAG, "initActionBar: " + (mToolbar == null ? "mToolbar is null " : mToolbar) + "  " + (mActionBar == null ? "mActionBar is null " : mActionBar));
	}

	@Override
	public void initData() {
		setTitle("ActionBarActivity");
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.e(TAG, "onOptionsItemSelected: " + item.getTitle());
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
		if (item.getItemId() == android.R.id.home) onBackPressed();
		return super.onOptionsItemSelected(item);
	}
}
