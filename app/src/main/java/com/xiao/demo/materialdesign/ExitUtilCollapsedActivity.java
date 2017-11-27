package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;
import com.xiao.demo.materialdesign.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * scroll  | enterAlways | enterAlwaysCollapsed
 * Created by xiao on 2017/9/12.
 */

public class ExitUtilCollapsedActivity extends BaseActivity {

	public static final String TAG = ExitUtilCollapsedActivity.class.getSimpleName();

	@BindView(R.id.recyclerview)
	RecyclerView recyclerView;

	SimpleAdapter mAdapter;

	List<String> mDataList = new ArrayList<>();

	public static void start(Context context) {
		Intent starter = new Intent(context, ExitUtilCollapsedActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_enteralwayscollapsed;
	}

	@Override
	public void initView() {
		setTitle(TAG);
		ViewGroup.LayoutParams params = mToolbar.getLayoutParams();
		if (params instanceof AppBarLayout.LayoutParams) {
			((AppBarLayout.LayoutParams) params).setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
		}
		mAdapter = new SimpleAdapter(ExitUtilCollapsedActivity.this);
		recyclerView.setAdapter(mAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(ExitUtilCollapsedActivity.this));
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemViewCacheSize(5);
		recyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
			@Override
			public boolean onFling(int velocityX, int velocityY) {
				Log.e(TAG, "onFling:  velocityY = " + velocityY);
				return false;
			}
		});
		recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
				super.onScrollStateChanged(recyclerView, newState);
				Log.e(TAG, "onScrollStateChanged: newState  = " + newState + " recyclerView.getScrollState() = " + recyclerView.getScrollState());
			}

			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);
			}
		});
	}

	@Override
	public void initData() {
		mAdapter.addItems(generateData());
	}

	public List<String> generateData() {
		Random random = new Random();
		int i1 = 10 * (random.nextInt(10) + 1);
		for (int i = 0; i < i1; i++) {
			mDataList.add("Item --- " + i);
		}
		return mDataList;
	}

}
