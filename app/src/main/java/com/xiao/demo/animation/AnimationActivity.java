package com.xiao.demo.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

import com.xiao.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationActivity extends AppCompatActivity {

    private static final String TAG = "AnimationActivity";

    @BindView(R.id.animation_btn_start)
    Button btn_start;

    @BindView(R.id.animation_btn_stop)
    Button btn_stop;

    @BindView(R.id.animation_img)
    ImageView img;

    @BindView(R.id.animation_img2)
    ImageView img2;

    private AnimationSet animationIn;

    private AnimationSet animationIn2;

    private AnimationSet animationOut;

    public static void start(Context context) {
        Intent starter = new Intent(context, AnimationActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initAnimation();
        btn_start.setOnClickListener(v -> startAnimation());
        btn_stop.setOnClickListener(v -> stopAnimation());
    }

    int i;

    private void initAnimation() {
        animationIn = AnimationUtil.getInstance().getAnimationIn(5f, 2000, 0);
        animationIn2 = AnimationUtil.getInstance().getAnimationIn(5f, 2000, 2000 / 3);
//        animationIn2.setStartOffset(animationIn.getDuration() / 4);
//        img.setAnimation(animationIn);
//        img2.setAnimation(animationIn2);
//        animationOut = AnimationUtil.getInstance().getAnimationOut();
//        img.setAnimation(animationIn);
//        img.setAnimation(animationOut);
        animationIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e(TAG, "animationIn -> onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e(TAG, "animationIn -> onAnimationEnd: auto start animationOut");
//                animationOut.start();
//                animationOut.startNow();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                i++;
                Log.e(TAG, "onAnimationRepeat: " + i);
            }
        });
//        animationOut.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                Log.e(TAG, "animationOut -> onAnimationStart: ");
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Log.e(TAG, "animationOut -> onAnimationEnd: auto start animationIn");
//                animationIn.start();
////                animationIn.startNow();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
    }

    private void startAnimation() {
        Log.e(TAG, "startAnimation: ");
//        img.setAnimation(animationIn);
//        img2.setAnimation(animationIn2);
        img.startAnimation(animationIn);
        img2.startAnimation(animationIn2);
//        animationIn.start();
////        animationOut.start();
//        img.invalidate();
//        animationIn.startNow();
//        animationOut.startNow();
    }

    private void stopAnimation() {
        Log.e(TAG, "stopAnimation: ");
        animationIn.cancel();
        animationIn2.cancel();
//        animationOut.cancel();
        img.clearAnimation();
        img2.clearAnimation();
    }
}
