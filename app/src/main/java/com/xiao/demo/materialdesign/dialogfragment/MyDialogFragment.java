package com.xiao.demo.materialdesign.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
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

public class MyDialogFragment extends DialogFragment {

	public static final String TAG = "MyDialogFragment";

	@BindView(R.id.dialogfragment_et_name)
	EditText et_name;

	@BindView(R.id.dialogfragment_et_pwd)
	EditText et_pwd;

	@BindView(R.id.dialogfragment_textinputet_address)
	TextInputEditText et_address;

	@BindView(R.id.dialogfragment_btn_confirm)
	Button btn_confirm;


	public MyDialogFragment() {
	}

	public static MyDialogFragment newInstance() {

		Bundle args = new Bundle();

		MyDialogFragment fragment = new MyDialogFragment();
		fragment.setArguments(args);
		return fragment;
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
		getDialog().setTitle(TAG);
		et_name.requestFocus();
		btn_confirm.setOnClickListener(v -> {
			String name = et_name.getText().toString().trim();
			String pwd = et_pwd.getText().toString().trim();
			String address = et_address.getText().toString().trim();
			Toast.makeText(getActivity(), name + pwd + address, Toast.LENGTH_SHORT).show();
		});
		getDialog().setOnShowListener(dialogInterface -> Log.e(TAG, "onShow: " + dialogInterface));
		getDialog().setOnDismissListener(dialogInterface -> Log.e(TAG, "onDismiss: " + dialogInterface));
	}
}
