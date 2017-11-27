package com.xiao.demo.materialdesign.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.xiao.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiao on 2017/9/14.
 */

public class MyBottonSheetsDialog extends BottomSheetDialogFragment {


	public static final String TAG = "MyBottonSheetsDialog";

	@BindView(R.id.dialogfragment_et_name)
	EditText et_name;

	@BindView(R.id.dialogfragment_et_pwd)
	EditText et_pwd;

	@BindView(R.id.dialogfragment_textinputet_address)
	TextInputEditText et_address;

	@BindView(R.id.dialogfragment_btn_confirm)
	Button btn_confirm;

	public MyBottonSheetsDialog() {
	}

	public static MyBottonSheetsDialog newInstance() {

		Bundle args = new Bundle();

		MyBottonSheetsDialog fragment = new MyBottonSheetsDialog();
		fragment.setArguments(args);
		return fragment;
	}

	LayoutInflater inflater;
	ViewGroup container;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//		View view = inflater.inflate(R.layout.fragment_dialogfragment, container);
//		ButterKnife.bind(this, view);
		this.inflater = inflater;
		this.container = container;
		Log.e(TAG, "onCreateView: " + inflater + "  " + container);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
//
//	@Override
//	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//		super.onViewCreated(view, savedInstanceState);
//
//	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
		dialog.setTitle(TAG);
		inflater = inflater == null ? LayoutInflater.from(getActivity()) : inflater;
		View view = inflater.inflate(R.layout.fragment_dialogfragment, container);
		ButterKnife.bind(this, view);
		dialog.setContentView(view);
		dialog.setOnCancelListener(dialogInterface -> Log.e(TAG, "onCancel: " + dialogInterface));
		dialog.setOnShowListener(dialogInterface -> Log.e(TAG, "onShow: " + dialogInterface));
		dialog.setTitle(TAG);
		return dialog;
	}


//	@Override
//	public Dialog onCreateDialog(Bundle savedInstanceState) {
//		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
//		alertDialogBuilder.setTitle(TAG);
//		alertDialogBuilder.setMessage("Are you sure?");
//		alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// on success
//			}
//		});
//		alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				if (dialog != null) {
//					dialog.dismiss();
//				}
//			}
//		});
//		return alertDialogBuilder.create();
//	}
}
