package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;
import com.xiao.demo.materialdesign.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * RecyclerView  && ToolBar in APPBarLayout
 * toolbar 设置layout_ScrollFalgs  scroll||enterAlways
 * Created by xiao on 2017/9/11.
 */

public class CollapsedEffectsActivity extends BaseActivity {

	public static final String TAG = "CollapsedEffects";

	@BindView(R.id.recyclerview)
	RecyclerView recyclerView;

	@BindView(R.id.collapsing_toolbar)
	CollapsingToolbarLayout mCollapsingToolbarLayout;

	SimpleAdapter mAdapter;

	List<String> mDataList = new ArrayList<>();

	public static void start(Context context) {
		Intent starter = new Intent(context, CollapsedEffectsActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_collapsed_effects2;
	}

	@Override
	public void initView() {
		setTitle(TAG);
		mCollapsingToolbarLayout.setTitle(TAG);
		mAdapter = new SimpleAdapter(CollapsedEffectsActivity.this);
		recyclerView.setAdapter(mAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(CollapsedEffectsActivity.this));
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemViewCacheSize(5);
		recyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
			@Override
			public boolean onFling(int velocityX, int velocityY) {
				Log.e(TAG, "onFling:  velocityY = " + velocityY);
				return false;
			}
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
