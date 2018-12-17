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
import com.xiao.demo.animation.AnimationManagerActivity;
import com.xiao.demo.kotlin.KotlinMainActivity;
import com.xiao.demo.materialdesign.MaterialDesignActivity;
import com.xiao.demo.materialdesign.WidgetActivity;

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

    @BindView(R.id.main_btn_kotlin)
    Button btn_kotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (btn_Animation != null) {
            btn_Animation.setOnClickListener(view -> {
                AnimationManagerActivity.start(MainActivity.this);
            });
        } else {
            Log.e(TAG, "com.xiao.demo.MainActivity.onCreate.[savedInstanceState]: btn_aniomation is null ");
        }
        if (btn_widget != null) {
            btn_widget.setOnClickListener(view -> {
                WidgetActivity.start(MainActivity.this);
            });
        }
        if (btn_kotlin != null) {
            btn_kotlin.setOnClickListener(v -> {
                KotlinMainActivity.start(MainActivity.this);
            });
        }
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
                MaterialDesignActivity.start(MainActivity.this);
                break;
            case R.id.main_btn_retrofit:
                Toast.makeText(this, "Go Retrofit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn_arouter:
                break;
            default:
                break;
        }
    }
}
