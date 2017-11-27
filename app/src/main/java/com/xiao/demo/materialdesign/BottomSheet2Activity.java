package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;
import com.xiao.demo.materialdesign.adapter.ImageTextAdapter;
import com.xiao.demo.materialdesign.items.Item;
import com.xiao.demo.materialdesign.items.RecyclerNormalBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiao on 2017/9/13.
 */

public class BottomSheet2Activity extends BaseActivity {

	public static final String TAG = "BottomSheetWithRecycler";

	@BindView(R.id.main_content)
	CoordinatorLayout mCoordinatorLayout;

	@BindView(R.id.bottomsheet2_recyclerview)
	RecyclerView mRecyclerView;

	@BindView(R.id.bottomsheet2_fab)
	FloatingActionButton mFab;

	private ImageTextAdapter mAdapter;

	private List<RecyclerNormalBean<Item>> mDataList = new ArrayList<>();

	public static void start(Context context) {
		Intent starter = new Intent(context, BottomSheet2Activity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activty_bottomsheet_recyclerview;
	}

	@Override
	public void initView() {
		setTitle(TAG);
		initRecyclerView();
		BottomSheetBehavior behavior = BottomSheetBehavior.from(mRecyclerView);
		showCurrentState(behavior.getState());
		behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
			@Override
			public void onStateChanged(@NonNull View bottomSheet, int newState) {
//				Log.e(TAG, "onStateChanged: " + newState);
				showCurrentState(newState);
			}

			@Override
			public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//				Log.e(TAG, "onSlide: " + slideOffset);
			}
		});
		mFab.setOnClickListener((View view) -> {
			behavior.setState(behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED ? BottomSheetBehavior.STATE_EXPANDED : BottomSheetBehavior.STATE_COLLAPSED);
		});
	}

	@Override
	public void initData() {
		generateData();
	}

	public void initRecyclerView() {
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setItemViewCacheSize(5);
		mAdapter = new ImageTextAdapter(BottomSheet2Activity.this);
		mAdapter.setItemListener(item -> {
			Log.e(TAG, "initRecyclerView: " + item);
		});
		mRecyclerView.setLayoutManager(new LinearLayoutManager(BottomSheet2Activity.this));
		mRecyclerView.setAdapter(mAdapter);
	}

	public void generateData() {
		RecyclerNormalBean<Item> info1 = new RecyclerNormalBean<>();
		Item item1 = new Item(R.mipmap.beauty, "Beauty");
		info1.setT(item1);
		mDataList.add(info1);

		RecyclerNormalBean<Item> info2 = new RecyclerNormalBean<>();
		Item item2 = new Item(R.mipmap.fox, "Fox");
		info2.setT(item2);
		mDataList.add(info2);

		RecyclerNormalBean<Item> info3 = new RecyclerNormalBean<>();
		Item item3 = new Item(R.mipmap.beauty2, "Beauty2");
		info3.setT(item3);
		mDataList.add(info3);
		Log.e(TAG, "generateData: " + mDataList);
		mAdapter.addItems(mDataList);
	}

	public void showCurrentState(int state) {
		switch (state) {
			case BottomSheetBehavior.STATE_COLLAPSED:
				Log.e(TAG, "showCurrentState: STATE_COLLAPSED");
				break;
			case BottomSheetBehavior.STATE_DRAGGING:
				Log.e(TAG, "showCurrentState: STATE_DRAGGING");
				break;
			case BottomSheetBehavior.STATE_EXPANDED:
				Log.e(TAG, "showCurrentState: STATE_EXPANDED");
				break;
			case BottomSheetBehavior.STATE_HIDDEN:
				Log.e(TAG, "showCurrentState: STATE_HIDDEN");
				break;
			case BottomSheetBehavior.STATE_SETTLING:
				Log.e(TAG, "showCurrentState: STATE_SETTLING");
				break;
		}
	}

}
