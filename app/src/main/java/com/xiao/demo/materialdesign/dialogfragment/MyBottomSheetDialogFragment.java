package com.xiao.demo.materialdesign.dialogfragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xiao.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiao on 2017/9/14.
 */

public class MyBottomSheetDialogFragment extends BottomSheetDialogFragment {

	public static final String TAG = "BottomSheetDialogFrag";

	@BindView(R.id.dialogfragment_et_name)
	EditText et_name;

	@BindView(R.id.dialogfragment_et_pwd)
	EditText et_pwd;

	@BindView(R.id.dialogfragment_textinputet_address)
	TextInputEditText et_address;

	@BindView(R.id.dialogfragment_btn_confirm)
	Button btn_confirm;

	private String title;

	public MyBottomSheetDialogFragment() {
	}

	public static MyBottomSheetDialogFragment newInstance(String title) {
		Bundle args = new Bundle();
		args.putString("title", title);
		MyBottomSheetDialogFragment fragment = new MyBottomSheetDialogFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		Log.e(TAG, "onAttach: ");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.e(TAG, "onDetach: ");
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(TAG, "onCreate: ");
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		super.onDismiss(dialog);
		Log.e(TAG, "onDismiss: ");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.e(TAG, "onActivityCreated: ");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_dialogfragment, container);
		ButterKnife.bind(this, view);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		Log.e(TAG, "onViewCreated: ");
		title = getArguments().getString("title", TAG);
		getDialog().setTitle(title);
		et_name.requestFocus();
//		getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

		btn_confirm.setOnClickListener(v -> {
			String name = et_name.getText().toString().trim();
			String pwd = et_pwd.getText().toString().trim();
			String address = et_address.getText().toString().trim();
			Toast.makeText(getActivity(), name + pwd + address, Toast.LENGTH_SHORT).show();
		});

	}
}
