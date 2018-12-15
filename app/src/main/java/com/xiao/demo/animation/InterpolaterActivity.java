package com.xiao.demo.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiao.demo.R;
import com.xiao.demo.animation.interpolater.MyLinearpolater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 动画插值器
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class InterpolaterActivity extends AppCompatActivity {

    private static final String TAG = "InterpolaterActivity";

    @BindView(R.id.interpolater_btn_start)
    Button interpolater_btn_start;

    @BindView(R.id.interpolater_btn_end)
    Button interpolater_btn_end;

    @BindView(R.id.interpolater_btn_pause)
    Button interpolater_btn_pause;

    @BindView(R.id.interpolater_btn_resume)
    Button interpolater_btn_resume;

    @BindView(R.id.interpolater_btn_cancel)
    Button interpolater_btn_cancel;

    @BindView(R.id.control)
    LinearLayout control;

    @BindView(R.id.interpolater_tv_accedece)
    TextView tv_accedece;

    @BindView(R.id.interpolater_tv_acce)
    TextView tv_acce;

    @BindView(R.id.interpolater_tv_anticipate)
    TextView tv_anticipate;

    @BindView(R.id.interpolater_tv_anticipateovershoot)
    TextView tv_anticipateovershoot;

    @BindView(R.id.interpolater_tv_bounce)
    TextView tv_bounce;

    @BindView(R.id.interpolater_tv_cycle)
    TextView tv_cycle;

    @BindView(R.id.interpolater_tv_decelerate)
    TextView tv_decelerate;

    @BindView(R.id.interpolater_tv_linear)
    TextView tv_linear;

    @BindView(R.id.interpolater_tv_overshoot)
    TextView tv_overshoot;

    @BindView(R.id.interpolater_tv_path)
    TextView tv_path;

    @BindView(R.id.interpolater_tv_fastoutlinear)
    TextView tv_fastoutlinear;

    @BindView(R.id.interpolater_tv_fastoutslow)
    TextView tv_fastoutslow;

    @BindView(R.id.interpolater_tv_linearoutslow)
    TextView tv_linearoutslow;

    @BindView(R.id.activity_interpolater)
    RelativeLayout activity_interpolater;

    @BindView(R.id.cb_openpath)
    CheckBox cb_openpath;

    public static void start(Context context) {
        Intent starter = new Intent(context, InterpolaterActivity.class);
        context.startActivity(starter);
    }

    long duration = 10 * 1000;

    String method = "translationX";

    int repeatCount = 3;

    int screenWidth;

    ObjectAnimator ani_acce, ani_anticipate, ani_anticipateovershoot, ani_bounce;

    ObjectAnimator ani_cycle, ani_decelerate, ani_accedece, ani_linear;

    ObjectAnimator ani_overshoot, ani_path, ani_fastoutlinear, ani_fastoutslow, ani_linearoutslow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolater);
        ButterKnife.bind(this);
        screenWidth = this.getResources().getDisplayMetrics().widthPixels - 50;
        setTitle("动画插值器");
        initAnimation();
    }

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initAnimation() {
        ani_accedece = ObjectAnimator.ofFloat(tv_accedece, method, 0f, screenWidth);
        ani_accedece.setDuration(duration);
        ani_accedece.setRepeatCount(repeatCount);
        ani_accedece.setRepeatMode(ObjectAnimator.RESTART);
        ani_accedece.setInterpolator(new AccelerateDecelerateInterpolator());
        ani_acce = ani_accedece.clone();
        ani_acce.setTarget(tv_acce);
        ani_acce.setInterpolator(new AccelerateInterpolator());
        ani_anticipate = ani_accedece.clone();
        ani_anticipate.setTarget(tv_anticipate);
        ani_anticipate.setInterpolator(new AnticipateInterpolator());
        ani_anticipateovershoot = ani_accedece.clone();
        ani_anticipateovershoot.setTarget(tv_anticipateovershoot);
        ani_anticipateovershoot.setInterpolator(new AnticipateOvershootInterpolator());
        ani_bounce = ani_accedece.clone();
        ani_bounce.setTarget(tv_bounce);
        ani_bounce.setInterpolator(new BounceInterpolator());
        ani_cycle = ani_accedece.clone();
        ani_cycle.setTarget(tv_cycle);
        ani_cycle.setInterpolator(new CycleInterpolator(3.0f));
        ani_decelerate = ani_accedece.clone();
        ani_decelerate.setTarget(tv_decelerate);
        ani_decelerate.setInterpolator(new DecelerateInterpolator());
        ani_fastoutslow = ani_accedece.clone();
        ani_fastoutslow.setTarget(tv_fastoutslow);
        ani_fastoutslow.setInterpolator(new FastOutSlowInInterpolator());
        ani_fastoutlinear = ani_accedece.clone();
        ani_fastoutlinear.setTarget(tv_fastoutlinear);
        ani_fastoutlinear.setInterpolator(new FastOutLinearInInterpolator());
        ani_linear = ani_accedece.clone();
        ani_linear.setTarget(tv_linear);
        ani_linear.setInterpolator(new MyLinearpolater());
        ani_linearoutslow = ani_accedece.clone();
        ani_linearoutslow.setTarget(tv_linearoutslow);
        ani_linearoutslow.setInterpolator(new LinearOutSlowInInterpolator());
        ani_overshoot = ani_accedece.clone();
        ani_overshoot.setTarget(tv_overshoot);
        ani_overshoot.setInterpolator(new OvershootInterpolator(0.3f));
        cb_openpath.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ani_path = ani_accedece.clone();
                    ani_path.setTarget(tv_path);
                    Path path = new Path();
                    path.cubicTo(0.2f, 0f, 0.1f, 1f, 0.5f, 1f);
                    path.lineTo(1f, 1f);
                    ani_path.setInterpolator(new PathInterpolator(path));
                    ani_path.addListener(animatorListener);
                    ani_path.addPauseListener(animatorPauseListener);
                }
            }
        });
        ani_accedece.addListener(animatorListener);
        ani_accedece.addPauseListener(animatorPauseListener);
        ani_acce.addListener(animatorListener);
        ani_acce.addPauseListener(animatorPauseListener);
        ani_anticipate.addListener(animatorListener);
        ani_anticipate.addPauseListener(animatorPauseListener);
        ani_anticipateovershoot.addListener(animatorListener);
        ani_anticipateovershoot.addPauseListener(animatorPauseListener);
        ani_decelerate.addListener(animatorListener);
        ani_decelerate.addPauseListener(animatorPauseListener);
        ani_cycle.addListener(animatorListener);
        ani_cycle.addPauseListener(animatorPauseListener);
        ani_bounce.addListener(animatorListener);
        ani_bounce.addPauseListener(animatorPauseListener);
        ani_linear.addListener(animatorListener);
        ani_linear.addPauseListener(animatorPauseListener);
        ani_linearoutslow.addListener(animatorListener);
        ani_linearoutslow.addPauseListener(animatorPauseListener);
        ani_overshoot.addListener(animatorListener);
        ani_overshoot.addPauseListener(animatorPauseListener);
        ani_fastoutlinear.addListener(animatorListener);
        ani_fastoutlinear.addPauseListener(animatorPauseListener);
        ani_fastoutslow.addListener(animatorListener);
        ani_fastoutslow.addPauseListener(animatorPauseListener);
        Log.e(TAG, "initAnimation: ani_accedece = " + ani_accedece
                + " ani_acce = " + ani_acce
                + " ani_anticipate = " + ani_anticipate
                + " ani_anticipateovershoot = " + ani_anticipateovershoot
                + " ani_bounce = " + ani_bounce
                + " ani_cycle = " + ani_cycle
                + " ani_decelerate = " + ani_decelerate
                + " ani_fastoutlinear = " + ani_fastoutlinear
                + " ani_fastoutslow = " + ani_fastoutslow
                + " ani_linear = " + ani_linear
                + " ani_linearoutslow = " + ani_linearoutslow
                + " ani_overshoot = " + ani_overshoot
                + " ani_path = " + ani_path
        );
//        if (cb_openpath.isChecked())
//            Log.e(TAG, "initAnimation: ani_path = " + ani_path);
    }

    Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {
            ObjectAnimator obj = (ObjectAnimator) animation;
            if (obj == ani_accedece) {
                Log.e(TAG, "onAnimationStart: ani_accedece.start");
            } else if (obj == ani_acce) {
                Log.e(TAG, "onAnimationEnd: ani_acce.start");
            } else if (obj == ani_anticipate) {
                Log.e(TAG, "onAnimationEnd: ani_anticipate.start");
            } else if (obj == ani_anticipateovershoot) {
                Log.e(TAG, "onAnimationEnd: ani_anticipateovershoot.start");
            } else if (obj == ani_bounce) {
                Log.e(TAG, "onAnimationEnd: ani_bounce.start");
            } else if (obj == ani_cycle) {
                Log.e(TAG, "onAnimationEnd: ani_cycle.start");
            } else if (obj == ani_decelerate) {
                Log.e(TAG, "onAnimationEnd: ani_decelerate.start");
            } else if (obj == ani_fastoutlinear) {
                Log.e(TAG, "onAnimationEnd: ani_fastoutlinear.start");
            } else if (obj == ani_fastoutslow) {
                Log.e(TAG, "onAnimationEnd: ani_fastoutslow.start");
            } else if (obj == ani_linear) {
                Log.e(TAG, "onAnimationEnd: ani_linear.start");
            } else if (obj == ani_linearoutslow) {
                Log.e(TAG, "onAnimationEnd: ani_linearoutslow.start");
            } else if (obj == ani_overshoot) {
                Log.e(TAG, "onAnimationEnd: ani_overshoot.start");
            } else if (obj == ani_path) {
                Log.e(TAG, "onAnimationEnd: ani_path.start");
            }
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            ObjectAnimator obj = (ObjectAnimator) animation;
            if (obj == ani_accedece) {
                Log.e(TAG, "onAnimationStart: ani_accedece.end  " + tv_accedece.getTranslationX());
            } else if (obj == ani_acce) {
                Log.e(TAG, "onAnimationEnd: ani_acce.end  " + tv_acce.getTranslationX());
            } else if (obj == ani_anticipate) {
                Log.e(TAG, "onAnimationEnd: ani_anticipate.end " + tv_anticipate.getTranslationX());
            } else if (obj == ani_anticipateovershoot) {
                Log.e(TAG, "onAnimationEnd: ani_anticipateovershoot.end " + tv_anticipateovershoot.getTranslationX());
            } else if (obj == ani_bounce) {
                Log.e(TAG, "onAnimationEnd: ani_bounce.end " + tv_bounce.getTranslationX());
            } else if (obj == ani_cycle) {
                Log.e(TAG, "onAnimationEnd: ani_cycle.end " + tv_cycle.getTranslationX());
            } else if (obj == ani_decelerate) {
                Log.e(TAG, "onAnimationEnd: ani_decelerate.end " + tv_decelerate.getTranslationX());
            } else if (obj == ani_fastoutlinear) {
                Log.e(TAG, "onAnimationEnd: ani_fastoutlinear.end " + tv_fastoutlinear.getTranslationX());
            } else if (obj == ani_fastoutslow) {
                Log.e(TAG, "onAnimationEnd: ani_fastoutslow.end " + tv_fastoutslow.getTranslationX());
            } else if (obj == ani_linear) {
                Log.e(TAG, "onAnimationEnd: ani_linear.end " + tv_linear.getTranslationX());
            } else if (obj == ani_linearoutslow) {
                Log.e(TAG, "onAnimationEnd: ani_linearoutslow.end " + tv_linearoutslow.getTranslationX());
            } else if (obj == ani_overshoot) {
                Log.e(TAG, "onAnimationEnd: ani_overshoot.end " + tv_overshoot.getTranslationX());
            } else if (obj == ani_path) {
                Log.e(TAG, "onAnimationEnd: ani_path.end " + tv_path.getTranslationX());
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            ObjectAnimator obj = (ObjectAnimator) animation;
            if (obj == ani_accedece) {
                Log.e(TAG, "onAnimationStart: ani_accedece.Cancel");
            } else {
            }
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            ObjectAnimator obj = (ObjectAnimator) animation;
            if (obj == ani_accedece) {
                Log.e(TAG, "onAnimationStart: ani_accedece.Repeat");
            } else if (obj == ani_acce) {
                Log.e(TAG, "onAnimationEnd: ani_acce.Repeat");
            } else if (obj == ani_anticipate) {
                Log.e(TAG, "onAnimationEnd: ani_anticipate.Repeat");
            } else if (obj == ani_anticipateovershoot) {
                Log.e(TAG, "onAnimationEnd: ani_anticipateovershoot.Repeat");
            } else if (obj == ani_bounce) {
                Log.e(TAG, "onAnimationEnd: ani_bounce.Repeat");
            } else if (obj == ani_cycle) {
                Log.e(TAG, "onAnimationEnd: ani_cycle.Repeat");
            } else if (obj == ani_decelerate) {
                Log.e(TAG, "onAnimationEnd: ani_decelerate.Repeat");
            } else if (obj == ani_fastoutlinear) {
                Log.e(TAG, "onAnimationEnd: ani_fastoutlinear.Repeat");
            } else if (obj == ani_fastoutslow) {
                Log.e(TAG, "onAnimationEnd: ani_fastoutslow.Repeat");
            } else if (obj == ani_linear) {
                Log.e(TAG, "onAnimationEnd: ani_linear.Repeat");
            } else if (obj == ani_linearoutslow) {
                Log.e(TAG, "onAnimationEnd: ani_linearoutslow.Repeat");
            } else if (obj == ani_overshoot) {
                Log.e(TAG, "onAnimationEnd: ani_overshoot.Repeat");
            } else if (obj == ani_path) {
                Log.e(TAG, "onAnimationEnd: ani_path.Repeat");
            }
        }
    };

    Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() {
        @Override
        public void onAnimationPause(Animator animation) {
            ObjectAnimator obj = (ObjectAnimator) animation;
            if (obj == ani_accedece) {
                Log.e(TAG, "onAnimationStart: ani_accedece.Pause  " + tv_accedece.getTranslationX());
            } else if (obj == ani_acce) {
                Log.e(TAG, "onAnimationEnd: ani_acce.Pause  " + tv_acce.getTranslationX());
            } else if (obj == ani_anticipate) {
                Log.e(TAG, "onAnimationEnd: ani_anticipate.Pause  " + tv_anticipate.getTranslationX());
            } else if (obj == ani_anticipateovershoot) {
                Log.e(TAG, "onAnimationEnd: ani_anticipateovershoot.Pause  " + tv_anticipateovershoot.getTranslationX());
            } else if (obj == ani_bounce) {
                Log.e(TAG, "onAnimationEnd: ani_bounce.Pause  " + tv_bounce.getTranslationX());
            } else if (obj == ani_cycle) {
                Log.e(TAG, "onAnimationEnd: ani_cycle.Pause  " + tv_cycle.getTranslationX());
            } else if (obj == ani_decelerate) {
                Log.e(TAG, "onAnimationEnd: ani_decelerate.Pause  " + tv_decelerate.getTranslationX());
            } else if (obj == ani_fastoutlinear) {
                Log.e(TAG, "onAnimationEnd: ani_fastoutlinear.Pause  " + tv_fastoutlinear.getTranslationX());
            } else if (obj == ani_fastoutslow) {
                Log.e(TAG, "onAnimationEnd: ani_fastoutslow.Pause  " + tv_fastoutslow.getTranslationX());
            } else if (obj == ani_linear) {
                Log.e(TAG, "onAnimationEnd: ani_linear.Pause  " + tv_linear.getTranslationX());
            } else if (obj == ani_linearoutslow) {
                Log.e(TAG, "onAnimationEnd: ani_linearoutslow.Pause  " + tv_linearoutslow.getTranslationX());
            } else if (obj == ani_overshoot) {
                Log.e(TAG, "onAnimationEnd: ani_overshoot.Pause  " + tv_overshoot.getTranslationX());
            } else if (obj == ani_path) {
                Log.e(TAG, "onAnimationEnd: ani_path.Pause  " + tv_path.getTranslationX());
            }
        }

        @Override
        public void onAnimationResume(Animator animation) {
        }
    };

    @OnClick(R.id.interpolater_btn_start)
    public void interpolater_btn_start() {
        ani_accedece.start();
        ani_acce.start();
        ani_linearoutslow.start();
        ani_linear.start();
        ani_anticipate.start();
        ani_anticipateovershoot.start();
        ani_bounce.start();
        ani_cycle.start();
        ani_decelerate.start();
        ani_fastoutlinear.start();
        ani_fastoutslow.start();
        ani_overshoot.start();
        if (cb_openpath.isChecked() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && ani_path != null) {
            ani_path.start();
        }
    }

    @OnClick(R.id.interpolater_btn_end)
    public void interpolater_btn_end() {
        ani_acce.end();
        ani_accedece.end();
        ani_linearoutslow.end();
        ani_linear.end();
        ani_anticipate.end();
        ani_anticipateovershoot.end();
        ani_bounce.end();
        ani_cycle.end();
        ani_decelerate.end();
        ani_fastoutlinear.end();
        ani_fastoutslow.end();
        ani_overshoot.end();
        if (cb_openpath.isChecked() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && ani_path != null) {
            ani_path.end();
        }
    }

    @OnClick(R.id.interpolater_btn_pause)
    public void interpolater_btn_pause() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ani_acce.pause();
            ani_accedece.pause();
            ani_linearoutslow.pause();
            ani_linear.pause();
            ani_anticipate.pause();
            ani_anticipateovershoot.pause();
            ani_bounce.pause();
            ani_cycle.pause();
            ani_decelerate.pause();
            ani_fastoutlinear.pause();
            ani_fastoutslow.pause();
            ani_overshoot.pause();
            if (cb_openpath.isChecked() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && ani_path != null) {
                ani_path.pause();
            }
        }
    }

    @OnClick(R.id.interpolater_btn_resume)
    public void interpolater_btn_resume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ani_acce.resume();
            ani_accedece.resume();
            ani_linearoutslow.resume();
            ani_linear.resume();
            ani_anticipate.resume();
            ani_anticipateovershoot.resume();
            ani_bounce.resume();
            ani_cycle.resume();
            ani_decelerate.resume();
            ani_fastoutlinear.resume();
            ani_fastoutslow.resume();
            ani_overshoot.resume();
            if (cb_openpath.isChecked() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && ani_path != null) {
                ani_path.resume();
            }
        }
    }

    @OnClick(R.id.interpolater_btn_cancel)
    public void interpolater_btn_cancel() {
        ani_acce.cancel();
        ani_accedece.cancel();
        ani_linearoutslow.cancel();
        ani_linear.cancel();
        ani_anticipate.cancel();
        ani_anticipateovershoot.cancel();
        ani_bounce.cancel();
        ani_cycle.cancel();
        ani_decelerate.cancel();
        ani_fastoutlinear.cancel();
        ani_fastoutslow.cancel();
        ani_overshoot.cancel();
        if (cb_openpath.isChecked() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && ani_path != null) {
            ani_path.cancel();
        }
    }
}
