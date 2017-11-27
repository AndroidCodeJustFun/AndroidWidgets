package com.xiao.demo.materialdesign.items;

import android.support.annotation.DrawableRes;

/**
 * Created by xiao on 2017/9/13.
 */

public class Item {

	private int mDrawableRes;

	private String mTitle;

	public Item() {
	}

	public Item(@DrawableRes int mDrawableRes, String mTitle) {
		this.mDrawableRes = mDrawableRes;
		this.mTitle = mTitle;
	}

	public int getmDrawableRes() {
		return mDrawableRes;
	}

	public void setmDrawableRes(int mDrawableRes) {
		this.mDrawableRes = mDrawableRes;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	@Override
	public String toString() {
		return "Item{" +
				"mTitle='" + mTitle + '\'' +
				'}';
	}
}
