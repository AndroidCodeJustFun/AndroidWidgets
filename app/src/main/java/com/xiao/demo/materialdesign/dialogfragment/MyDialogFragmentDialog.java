package com.xiao.demo.materialdesign.dialogfragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xiao.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiao on 2017/9/14.
 */

public class MyDialogFragmentDialog extends DialogFragment {

	public static final String TAG = "MyDialogFragmentDialog";

	@BindView(R.id.dialogfragment_et_name)
	EditText et_name;

	@BindView(R.id.dialogfragment_et_pwd)
	EditText et_pwd;

	@BindView(R.id.dialogfragment_textinputet_address)
	TextInputEditText et_address;

	@BindView(R.id.dialogfragment_btn_confirm)
	Button btn_confirm;
	private LayoutInflater inflater;

	public MyDialogFragmentDialog() {
	}

	public static MyDialogFragmentDialog newInstance() {

		Bundle args = new Bundle();

		MyDialogFragmentDialog fragment = new MyDialogFragmentDialog();
		fragment.setArguments(args);
		return fragment;
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Dialog dialog = new Dialog(getActivity());
		inflater = inflater == null ? LayoutInflater.from(getActivity()) : inflater;
		View view = inflater.inflate(R.layout.fragment_dialogfragment, null);
		ButterKnife.bind(this, view);
		dialog.setContentView(view);
		dialog.setOnCancelListener(dialogInterface -> Log.e(TAG, "onCancel: " + dialogInterface));
		dialog.setOnShowListener(dialogInterface -> Log.e(TAG, "onShow: " + dialogInterface));
		dialog.setTitle(TAG);
		return dialog;
	}
}
