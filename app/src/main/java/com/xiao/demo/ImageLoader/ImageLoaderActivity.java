package com.xiao.demo.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiao.demo.R;

public class ImageLoaderActivity extends AppCompatActivity {

	public static void start(Context context) {
		Intent starter = new Intent(context, ImageLoaderActivity.class);
		context.startActivity(starter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_loader);
	}
}
