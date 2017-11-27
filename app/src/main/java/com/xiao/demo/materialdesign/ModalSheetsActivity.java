package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;
import com.xiao.demo.materialdesign.dialogfragment.CustomBottomSheetDIalog;
import com.xiao.demo.materialdesign.dialogfragment.MyBottomSheetDialogFragment;
import com.xiao.demo.materialdesign.dialogfragment.MyBottonSheetsDialog;
import com.xiao.demo.materialdesign.dialogfragment.MyDialogFragment;
import com.xiao.demo.materialdesign.dialogfragment.MyDialogFragmentDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xiao on 2017/9/14.
 */

public class ModalSheetsActivity extends BaseActivity {

	public static final String TAG = "ModalSheetsActivity";

	@BindView(R.id.modalsheets_content)
	FrameLayout modalsheetsContent;

	@BindView(R.id.modalsheets_btn_bottomsheetdialog)
	Button btn_bottomsheetdialog;

	public static void start(Context context) {
		Intent starter = new Intent(context, ModalSheetsActivity.class);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_modalsheets;
	}

	@Override
	public void initView() {
		btn_bottomsheetdialog.setOnClickListener(view -> new CustomBottomSheetDIalog(ModalSheetsActivity.this).show());
	}

	@Override
	public void initData() {
		setTitle(TAG);
	}

	@OnClick({R.id.modalsheets_btn_bottomfragment, R.id.modalsheets_btn_bottomdialog, R.id.modalsheets_btn_dialogfragment, R.id.modalsheets_btn_dialog})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.modalsheets_btn_bottomfragment:
				showBottomSheetDialogFragment();
				break;
			case R.id.modalsheets_btn_bottomdialog:
				showBottomSheetDialog();
				break;
			case R.id.modalsheets_btn_dialogfragment:
				showDialogFragment();
				break;
			case R.id.modalsheets_btn_dialog:
				showMyDialogFragmetDialog();
				break;
		}
	}

	public void showBottomSheetDialogFragment() {
		FragmentManager fm = getSupportFragmentManager();
		MyBottomSheetDialogFragment fragment = MyBottomSheetDialogFragment.newInstance(null);
		fragment.show(fm, MyBottomSheetDialogFragment.TAG);
	}

	public void showBottomSheetDialog() {
		FragmentManager fm = getSupportFragmentManager();
		MyBottonSheetsDialog.newInstance().show(fm, MyBottonSheetsDialog.TAG);
	}

	public void showDialogFragment() {
		FragmentManager fm = getSupportFragmentManager();
		MyDialogFragment.newInstance().show(fm, MyDialogFragment.TAG);
	}

	public void showMyDialogFragmetDialog() {
		FragmentManager fm = getSupportFragmentManager();
		MyDialogFragmentDialog.newInstance().show(fm, MyDialogFragmentDialog.TAG);
	}


}
