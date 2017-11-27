package com.xiao.demo.materialdesign.items;

/**
 * Created by xiao on 2017/9/13.
 */

public class RecyclerNormalBean<T> {

	private int mViewType;

	private T t;

	public RecyclerNormalBean() {
	}

	public RecyclerNormalBean(int mViewType, T t) {
		this.mViewType = mViewType;
		this.t = t;
	}

	public int getmViewType() {
		return mViewType;
	}

	public void setmViewType(int mViewType) {
		this.mViewType = mViewType;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "RecyclerNormalBean{" +
				"mViewType=" + mViewType +
				", t=" + t +
				'}';
	}
}

