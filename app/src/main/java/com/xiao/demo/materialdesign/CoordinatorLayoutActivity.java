package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xiao.demo.BuildConfig;
import com.xiao.demo.R;
import com.xiao.demo.WebViewActivity;
import com.xiao.demo.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * SnackBar  & FloatingActionButton
 * Created by xiao on 2017/9/9.
 */

public class CoordinatorLayoutActivity extends BaseActivity {

	@BindView(R.id.coordinator_tv_des)
	TextView tv_des;

	@BindView(R.id.coordinatelayout_cardview_snackbarfab)
	CardView card_snackbarfab;

	@BindView(R.id.widget_btn_customview)
	Button btn_scrollingactivity;
	@BindView(R.id.widget_btn_expandingcollapsing_toolbars)
	Button btn_scrollfalgs_enteralways;
	@BindView(R.id.coordinator_scrollfalgs_tv_enteralways)
	TextView tvEnteralways;

	@BindView(R.id.widget_btn_enteralwaysCollapsed)
	Button btn_enteralwayscollapsed;

	@BindView(R.id.widget_btn_exitUntilCollapsed)
	Button btn_exituntilcollapsed;

	@BindView(R.id.widget_btn_snap)
	Button btn_snap;

	@BindView(R.id.widget_btn_collapsing_effects)
	Button btn_collapsing_effects;

	@BindView(R.id.widget_btn_parallax)
	Button btn_parallax;

	@BindView(R.id.widget_btn_bottomsheet)
	Button btn_bottomsheet_recyclerview;

	@BindView(R.id.widget_btn_bottomsheet2)
	Button btn_bottomsheet_nestedscrollview;

	@BindView(R.id.widget_btn_modalsheets)
	Button btn_modalsheets;


	public static void start(Context context) {
		Intent starter = new Intent(context, CoordinatorLayoutActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_coordinatorlayout;
	}

	@Override
	public void initView() {
		setTitle("CoordinatorLayoutActivity");
		tv_des.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
		tv_des.setOnClickListener(view -> WebViewActivity.start(CoordinatorLayoutActivity.this, BuildConfig.coordinatelayout));
		btn_scrollingactivity.setOnClickListener(view -> ScrollingActivity.start(CoordinatorLayoutActivity.this));
		card_snackbarfab.setOnClickListener(view -> SnackbarFABActivity.start(CoordinatorLayoutActivity.this));
		btn_scrollfalgs_enteralways.setOnClickListener(view -> EnterAlwaysActivity.start(CoordinatorLayoutActivity.this));
		btn_enteralwayscollapsed.setOnClickListener(view -> EnteralwaysCollapsedActivity.start(CoordinatorLayoutActivity.this));
		btn_exituntilcollapsed.setOnClickListener(view -> ExitUtilCollapsedActivity.start(CoordinatorLayoutActivity.this));
		btn_snap.setOnClickListener(view -> SnapActivity.start(CoordinatorLayoutActivity.this));
		btn_collapsing_effects.setOnClickListener(view -> CollapsedEffectsActivity.start(CoordinatorLayoutActivity.this));
		btn_parallax.setOnClickListener(view -> ParallaxAnimationActivity.start(CoordinatorLayoutActivity.this));
		btn_bottomsheet_recyclerview.setOnClickListener(view -> BottomSheet2Activity.start(CoordinatorLayoutActivity.this));
		btn_bottomsheet_nestedscrollview.setOnClickListener(view -> BottomSheetNestedScrollViewActivity.start(CoordinatorLayoutActivity.this));
		btn_modalsheets.setOnClickListener(view -> ModalSheetsActivity.start(CoordinatorLayoutActivity.this));
	}

	@Override
	public void initData() {

	}


	@OnClick({R.id.widget_btn_expandingcollapsing_toolbars, R.id.widget_btn_bahavior})
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.widget_btn_expandingcollapsing_toolbars:
				EnterAlwaysActivity.start(CoordinatorLayoutActivity.this);
				break;
			case R.id.widget_btn_bahavior:
				BehaviorActivity.start(CoordinatorLayoutActivity.this);
				break;
		}
	}

}
