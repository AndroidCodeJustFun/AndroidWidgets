package com.xiao.demo.base;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xiao.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiao on 2017/9/4.
 */

public abstract class BaseActivity extends AppCompatActivity {

	public static String TAG = BaseActivity.class.getSimpleName();

	protected TextView mTv_title;

	protected FrameLayout mLayoutMore;

	protected ActionBar mActionBar;

	protected Toolbar mToolbar;

//	@BindView(R.id.toolbar_actionbar)


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutRes());
		ButterKnife.bind(this);
		initActionBar();
//		handlerIntent();
		initView();
		initData();
	}

//	protected abstract void handlerIntent();

	protected void initActionBar() {
		View view = findViewById(R.id.toolbar_actionbar);
		if (view != null) {
//			Log.e(TAG, "initActionBar: " + view.getClass());
			mToolbar = (Toolbar) view;
			if (mToolbar != null) {
				mToolbar.setNavigationOnClickListener(v -> {
//					Log.e(TAG, "initActionBar: setNavigationOnClickListener");
					onBackPressed();
				});
//				mToolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_menu_white_24dp));
				mTv_title = (TextView) view.findViewById(R.id.toolbar_tv_title);
				mLayoutMore = (FrameLayout) view.findViewById(R.id.toolbar_more);
				setSupportActionBar(mToolbar);
				mActionBar = getSupportActionBar();
				mActionBar.setDisplayShowTitleEnabled(false);
//		if (mActionBar != null) {
//			mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//			mActionBar.setDisplayShowCustomEnabled(true);
//			mActionBar.setCustomView(R.layout.layout_actionbar);
//			mActionBar.setTitle("Title");
//			mActionBar.setSubtitle("SubTitle");
//			mActionBar.setDisplayShowHomeEnabled(true);
//			mActionBar.setIcon(R.mipmap.ima_text_close);
//		}
			}
		}
//		Log.e(TAG, "initActionBar: view is " + (view == null ? "  include layout is empty  " : view) + "  mToolbar is " + (mToolbar == null ? "mToolbar is null " : mToolbar) + "  mActionBar is " + (mActionBar == null ? "mActionBar is null " : mActionBar));
	}


	public abstract @LayoutRes
	int layoutRes();

	public abstract void initView();

	public abstract void initData();


	public void setHomeAsUpIndicator(int resId) {
		if (mActionBar != null) {
			mActionBar.setHomeAsUpIndicator(resId);
		}
	}

	public void setTitle(CharSequence title) {
		if (mTv_title != null) {
			mTv_title.setText(title);
		}
	}

	public void setBackgroundDrawable(Drawable d) {
		if (mToolbar != null) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
				mToolbar.setBackground(d);
			else
				mToolbar.setBackgroundDrawable(d);
		}
	}

	public void setDisplayOptions(int options, int mask) {
		if (mActionBar != null) {
			if (mask == 0)
				mActionBar.setDisplayOptions(options);
			else
				mActionBar.setDisplayOptions(options, mask);
		}
	}

	public void setDisplayShowCustomEnabled(boolean falg) {
		if (mActionBar != null) {
			mActionBar.setDisplayShowCustomEnabled(falg);
		}
	}

	public void setDisplayHomeAsUpEnabled(boolean falg) {
		if (mActionBar != null) {
			mActionBar.setDisplayHomeAsUpEnabled(falg);
		}
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) onBackPressed();
		return super.onOptionsItemSelected(item);
	}
}
