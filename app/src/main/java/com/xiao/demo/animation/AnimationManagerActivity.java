package com.xiao.demo.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xiao.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationManagerActivity extends AppCompatActivity {

    @BindView(R.id.am_btn_objectanimator)
    Button am_btn_objectanimator;

    @BindView(R.id.am_btn_interpolater)
    Button am_btn_interpolater;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbar_layout;

    @BindView(R.id.app_bar)
    AppBarLayout app_bar;

    @BindView(R.id.am_btn_valueanimator)
    Button am_btn_valueanimator;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    public static void start(Context context) {
        Intent starter = new Intent(context, AnimationManagerActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_manager);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(v -> Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AnimationManagerActivity.this, "Click on Snackbar", Toast.LENGTH_SHORT).show();
                    }
                }).show());
    }

    @OnClick(R.id.am_btn_valueanimator)
    public void am_btn_valueanimator() {
        ValueAnimatorActivity.start(this);
    }

    @OnClick(R.id.am_btn_objectanimator)
    public void am_btn_objectanimator() {
        ObjectAnimationActivity.start(AnimationManagerActivity.this);
    }

    @OnClick(R.id.am_btn_interpolater)
    public void am_btn_interpolater() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            InterpolaterActivity.start(AnimationManagerActivity.this);
        }
    }
}
