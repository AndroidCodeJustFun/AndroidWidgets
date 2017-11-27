package com.xiao.demo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.xiao.demo.materialdesign.adapter.ItemListener;
import com.xiao.demo.util.CheckUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiao on 2017/9/12.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter {

	protected List<T> mDataList;

	protected Context mContext;

	protected LayoutInflater mLayoutInflater;

	protected ItemListener itemListener;

	public void setItemListener(ItemListener itemListener) {
		this.itemListener = itemListener;
	}

	public BaseRecyclerViewAdapter(Context mContext) {
		this.mContext = mContext;
		mLayoutInflater = LayoutInflater.from(mContext);
		mDataList = new ArrayList<>();
	}

	public BaseRecyclerViewAdapter(List<T> mDataList, Context mContext) {
		this.mDataList = mDataList;
		this.mContext = mContext;
		mLayoutInflater = LayoutInflater.from(mContext);
	}

	public void addItems(List<T> dataList) {
		if (!CheckUtil.isEmpty(dataList)) {
			if (mDataList == null) {
				mDataList = new ArrayList<>();
			}
			mDataList.addAll(dataList);
			notifyDataSetChanged();
		}
	}

	public void resetData(List<T> dataList) {
		if (mDataList != null) {
			mDataList.clear();
		}
		if (dataList != null) {
			mDataList.addAll(dataList);
		}
		notifyDataSetChanged();
	}

	public T getItem(int position) {
		return mDataList.get(position);
	}


	@Override
	public int getItemCount() {
		return mDataList == null ? 0 : mDataList.size();
	}

	public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

		protected View rootView;

		public BaseViewHolder(View itemView) {
			super(itemView);
			rootView = itemView;
		}

		public abstract void showItem(T t);

	}

}
