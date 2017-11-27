package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;
import com.xiao.demo.materialdesign.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiao on 2017/9/14.
 */

public class CustomFABBehaviorActivity extends BaseActivity {

	public static final String TAG = "CustomFABBehavior";

	@BindView(R.id.appbarlayout)
	AppBarLayout appBarLayout;

	@BindView(R.id.toolbar_actionbar)
	Toolbar toolbar;


	@BindView(R.id.recyclerview)
	RecyclerView mRecyclerView;

	@BindView(R.id.customfabbehavior_fab)
	FloatingActionButton fab;


	SimpleAdapter mAdapter;

	List<String> mDataList = new ArrayList<>();


	public static void start(Context context) {
		Intent starter = new Intent(context, CustomFABBehaviorActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_customfabbehavior;
	}

	@Override
	public void initView() {
		setTitle(TAG);
		mAdapter = new SimpleAdapter(CustomFABBehaviorActivity.this);
		mRecyclerView.setAdapter(mAdapter);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(CustomFABBehaviorActivity.this));
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setItemViewCacheSize(5);
		mRecyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
			@Override
			public boolean onFling(int velocityX, int velocityY) {
				Log.e(TAG, "onFling:  velocityY = " + velocityY);
				return false;
			}
		});
		fab.setOnClickListener(view -> {
			Toast.makeText(this, "Click on FAB", Toast.LENGTH_SHORT).show();
		});
	}

	@Override
	public void initData() {
		mAdapter.addItems(generateData());
	}

	public List<String> generateData() {
		int i1 = mDataList.isEmpty() ? 15 : 5;
		for (int i = 0; i < i1; i++) {
			mDataList.add("Item --- " + i);
		}
		return mDataList;
	}
}
