package com.xiao.demo.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * FileName:com.xiao.demo.recyclerview.animation.AnimationUtil.java
 * Created on 2016/9/5
 * Version V1.0
 */
public class AnimationUtil {

    private volatile static AnimationUtil animationUtil;

    private AnimationUtil() {
    }

    public static AnimationUtil getInstance() {
        if (animationUtil == null) {
            synchronized (AnimationUtil.class) {
                if (animationUtil == null) {
                    animationUtil = new AnimationUtil();
                }
            }
        }
        return animationUtil;
    }

    public AnimationSet getAnimationIn(float scale, long duration, long startOffset) {
        AnimationSet animationset = new AnimationSet(true);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setStartOffset(startOffset);
        Animation alphaAnimationIn = generateAlphaAnimationIn();
        alphaAnimationIn.setRepeatCount(Animation.INFINITE);
        alphaAnimationIn.setDuration(duration);
        animationset.addAnimation(alphaAnimationIn);
        Animation scaleAnimationIn = generateScaleAnimationIn(scale);
        scaleAnimationIn.setRepeatCount(Animation.INFINITE);
        scaleAnimationIn.setDuration(duration);
        animationset.addAnimation(scaleAnimationIn);
//        Animation alphaAnimationOut = generateAlphaAnimationOut();
//        alphaAnimationOut.setRepeatCount(Animation.INFINITE);
//        alphaAnimationOut.setStartOffset(2000);
//        alphaAnimationOut.setDuration(2000);
//        animationset.addAnimation(alphaAnimationOut);
//
//
//        Animation scaleAnimationOut = generateScaleAnimationOut();
//        scaleAnimationOut.setRepeatCount(Animation.INFINITE);
//        scaleAnimationOut.setStartOffset(2000);
//        scaleAnimationOut.setDuration(2000);
//        animationset.addAnimation(scaleAnimationOut);
        animationset.setRepeatMode(Animation.RESTART);
        return animationset;
    }

    public AnimationSet getAnimationOut() {
        AnimationSet animationset = new AnimationSet(true);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setDuration(2000);
        animationset.addAnimation(generateAlphaAnimationOut());
        animationset.addAnimation(generateScaleAnimationOut());
        return animationset;
    }

    public Animation generateAlphaAnimationIn() {
        Animation animation = new AlphaAnimation(1f, 0.1f);
        animation.setInterpolator(new DecelerateInterpolator());
//        animation.setDuration(2000);
        return animation;
    }

    public Animation generateAlphaAnimationOut() {
        Animation animation = new AlphaAnimation(1.0f, 0);
        animation.setInterpolator(new DecelerateInterpolator());
//        animation.setDuration(2000);
        return animation;
    }

    public Animation generateScaleAnimationIn(float scale) {
        Animation animation = new ScaleAnimation(1.0f, scale, 1.0f, scale, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setInterpolator(new DecelerateInterpolator());
//        animation.setDuration(2000);
        return animation;
    }

    public Animation generateScaleAnimationOut() {
        Animation animation = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.00f);
        animation.setInterpolator(new DecelerateInterpolator());
//        animation.setDuration(2000);
        return animation;
    }
}
