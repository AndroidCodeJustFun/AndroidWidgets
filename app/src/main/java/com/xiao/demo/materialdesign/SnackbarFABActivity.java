package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;

/**
 * SnackBar  & FloatingActionButton
 * Created by xiao on 2017/9/9.
 */

public class SnackbarFABActivity extends BaseActivity {


	@BindView(R.id.coordinatelayout)
	CoordinatorLayout coordinatorLayout;

	@BindView(R.id.coordinatelayout_fab)
	FloatingActionButton fzb;

	@BindView(R.id.coordinatelayout_btn_show)
	Button btn_show;

	public static void start(Context context) {
		Intent starter = new Intent(context, SnackbarFABActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_snackbarfab;
	}

	@Override
	public void initView() {
		setTitle("CoordinatorLayoutActivity");
		btn_show.setOnClickListener(view -> Snackbar.make(coordinatorLayout, "Display SnackBar & FloatingActionButton", Snackbar.LENGTH_LONG).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
			@Override
			public void onDismissed(Snackbar transientBottomBar, int event) {
				super.onDismissed(transientBottomBar, event);
				Log.e(TAG, "SnackBar  onDismissed: ");
			}

			@Override
			public void onShown(Snackbar transientBottomBar) {
				super.onShown(transientBottomBar);
				Log.e(TAG, "SnackBar onShown: ");
			}
		}).setAction("Clicked on SnackBar", v -> {
			Toast.makeText(this, "Clicked on SnackBar", Toast.LENGTH_SHORT).show();
		}).show());
	}

	@Override
	public void initData() {

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.e(TAG, "onOptionsItemSelected: " + item.getItemId() + "  " + item.getTitle());
		return super.onOptionsItemSelected(item);
	}
}
