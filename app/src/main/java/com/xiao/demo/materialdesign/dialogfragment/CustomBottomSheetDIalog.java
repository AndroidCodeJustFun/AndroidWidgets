package com.xiao.demo.materialdesign.dialogfragment;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xiao.demo.R;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xiao on 2017/9/14.
 */

public class CustomBottomSheetDIalog {

	public static final String TAG = "CustomBottomSheetDIalog";
	private View view;

	private BottomSheetDialog dialog;

	WeakReference<Context> contextRef;

	@BindView(R.id.dialogfragment_et_name)
	EditText et_name;

	@BindView(R.id.dialogfragment_et_pwd)
	EditText et_pwd;

	@BindView(R.id.dialogfragment_textinputet_address)
	TextInputEditText et_address;

	@BindView(R.id.dialogfragment_btn_confirm)
	Button btn_confirm;
	private Unbinder unbinder;


	public CustomBottomSheetDIalog(Context context) {
		contextRef = new WeakReference<Context>(context);
		dialog = new BottomSheetDialog(contextRef.get());
	}

	public void show() {
		if (view == null) {
			view = LayoutInflater.from(contextRef.get()).inflate(R.layout.fragment_dialogfragment, null);
			unbinder = ButterKnife.bind(this, view);
			btn_confirm.setOnClickListener(v -> {
				String name = et_name.getText().toString().trim();
				String pwd = et_pwd.getText().toString().trim();
				String address = et_address.getText().toString().trim();
				Toast.makeText(contextRef.get(), name + pwd + address, Toast.LENGTH_SHORT).show();
			});
		}
		Log.e(TAG, "show: " + view.hashCode() + " " + dialog.hashCode());
		dialog.setContentView(view);
		dialog.setOnShowListener(dialogInterface -> Log.e(TAG, "onShow: "));
		dialog.setOnDismissListener(dialogInterface -> Log.e(TAG, "onDismiss: "));
		dialog.setOnCancelListener(dialogInterface -> Log.e(TAG, "onCanceled: "));
		dialog.setTitle(TAG);
		dialog.show();
	}

	public void dismiss() {
		if (unbinder != null) {
			unbinder.unbind();
		}
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
		}
	}

}
