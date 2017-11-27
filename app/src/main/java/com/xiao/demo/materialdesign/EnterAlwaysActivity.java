package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;
import com.xiao.demo.materialdesign.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * RecyclerView  && ToolBar in APPBarLayout
 * toolbar 设置layout_ScrollFalgs  scroll||enterAlways
 * Created by xiao on 2017/9/11.
 */

public class EnterAlwaysActivity extends BaseActivity {

	@BindView(R.id.recyclerview)
	RecyclerView recyclerView;

	SimpleAdapter mAdapter;

	List<String> mDataList = new ArrayList<>();

	public static void start(Context context) {
		Intent starter = new Intent(context, EnterAlwaysActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_excotoolbars;
	}

	@Override
	public void initView() {
		setTitle("EnterAlwaysActivity");
		mAdapter = new SimpleAdapter(EnterAlwaysActivity.this);
		recyclerView.setAdapter(mAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(EnterAlwaysActivity.this));
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemViewCacheSize(5);
		recyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
			@Override
			public boolean onFling(int velocityX, int velocityY) {
				Log.e(TAG, "onFling:  velocityY = " + velocityY);
				return false;
			}
		});
//		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//			recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//				@Override
//				public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//
//				}
//			});
//			recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
//				@Override
//				public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//					super.onScrollStateChanged(recyclerView, newState);
//				}
//
//				@Override
//				public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//					super.onScrolled(recyclerView, dx, dy);
//				}
//			});
//		}else{
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
//		}
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
