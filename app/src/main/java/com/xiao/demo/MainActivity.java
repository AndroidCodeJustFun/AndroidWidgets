package com.xiao.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xiao.demo.ImageLoader.ImageLoaderActivity;
import com.xiao.demo.materialdesign.WidgetActivity;
import com.xiao.demo.materialdesign.adapter.SimpleAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

	public static final String TAG = "MainActivity";

	@BindView(R.id.main_btn_imageloader)
	Button btn_Imageloader;
	@BindView(R.id.main_btn_design)
	Button btn_Design;
	@BindView(R.id.main_btn_retrofit)
	Button btn_Retrofit;
	@BindView(R.id.main_btn_animation)
	Button btn_Animation;
	@BindView(R.id.main_btn_arouter)
	Button mainBtnArouter;
	@BindView(R.id.main_btn_widget)
	Button btn_widget;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		// lambda expression
		btn_Animation.setOnClickListener(view -> {
			Toast.makeText(this, "Go Animation", Toast.LENGTH_SHORT).show();
		});
		btn_widget.setOnClickListener(view -> {
			WidgetActivity.start(MainActivity.this);
		});
		// ATTENTION: This was auto-generated to handle app links.
		Intent appLinkIntent = getIntent();
		String appLinkAction = appLinkIntent.getAction();
		Uri appLinkData = appLinkIntent.getData();
		Log.e(TAG, "onCreate: " + appLinkAction + "  " + appLinkData);


	}

	@OnClick({R.id.main_btn_imageloader, R.id.main_btn_design, R.id.main_btn_retrofit, R.id.main_btn_arouter})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.main_btn_imageloader:
				ImageLoaderActivity.start(MainActivity.this);
				break;
			case R.id.main_btn_design:
				Toast.makeText(this, "Go Material Design ", Toast.LENGTH_SHORT).show();
				break;
			case R.id.main_btn_retrofit:
				Toast.makeText(this, "Go Retrofit", Toast.LENGTH_SHORT).show();
				break;
			case R.id.main_btn_arouter:
				break;
		}
	}


}
