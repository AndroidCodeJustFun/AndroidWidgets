package com.xiao.demo.arouter;

import android.support.v7.widget.CardView;
import android.widget.Toast;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xiao on 2017/9/4.
 */

public class ArouterActivity extends BaseActivity {


	@BindView(R.id.arouter_card_basicinfo)
	CardView arouterCardBasicinfo;

	@Override
	public int layoutRes() {
		return R.layout.activity_arouter;
	}

	@Override
	public void initView() {

	}

	@Override
	public void initData() {

	}

	@OnClick(R.id.arouter_card_basicinfo)
	public void onViewClicked() {
		Toast.makeText(this, "Go Basic Introduce Page", Toast.LENGTH_SHORT).show();
	}
}
