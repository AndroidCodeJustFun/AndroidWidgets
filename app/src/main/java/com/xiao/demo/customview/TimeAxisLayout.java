package com.xiao.demo.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.xiao.demo.R;

/**
 * Created by xiao on 2017/10/12.
 */

public class TimeAxisLayout extends LinearLayout {

	public static final String TAG = "TimeAxisLayout";

	Paint mAxisPaint, mPointPaint;

	int mAxisColor, mStartColor, mMiddleColor, mEndColor;

	int mStartRadius, mMiddleRadius, mEndRadius;

	int mMarginLeft = 280;

	BitmapDrawable mIconDrawable;

	int mAxisLen = 8;

	public TimeAxisLayout(Context context) {
		super(context);
//		context.obtainStyledAttributes()
	}

	public TimeAxisLayout(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimeAxisLayout);
		mAxisColor = typedArray.getColor(R.styleable.TimeAxisLayout_axisColor, 0xffe1e2e3);
		mStartColor = typedArray.getColor(R.styleable.TimeAxisLayout_startColor, 0xffff0000);
		mMiddleColor = typedArray.getColor(R.styleable.TimeAxisLayout_middleColor, 0xfff1e2d3);
		mEndColor = typedArray.getColor(R.styleable.TimeAxisLayout_endColor, 0xffa1b2c3);
		mStartRadius = typedArray.getDimensionPixelSize(R.styleable.TimeAxisLayout_startRadius, 10);
		mMiddleRadius = typedArray.getDimensionPixelSize(R.styleable.TimeAxisLayout_middleRadius, 6);
		mEndRadius = typedArray.getDimensionPixelSize(R.styleable.TimeAxisLayout_endRadius, 8);
		int iconRes = typedArray.getResourceId(R.styleable.TimeAxisLayout_iconRes, R.mipmap.img_progress_start);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
			mIconDrawable = (BitmapDrawable) getResources().getDrawable(iconRes, null);
		} else {
			mIconDrawable = (BitmapDrawable) getResources().getDrawable(iconRes);
		}
		typedArray.recycle();
		setWillNotDraw(false);
		initPaint();
	}

	public TimeAxisLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public TimeAxisLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	public void initPaint() {
		mAxisPaint = new Paint();
		mAxisPaint.setAntiAlias(true);
		mAxisPaint.setDither(true);
		mAxisPaint.setStyle(Paint.Style.FILL);
		mAxisPaint.setColor(mAxisColor);
		mAxisPaint.setStrokeWidth(1);

		mPointPaint = new Paint();
		mPointPaint.setAntiAlias(true);
		mPointPaint.setStyle(Paint.Style.FILL);
		mPointPaint.setDither(true);
		mPointPaint.setColor(mStartColor);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		drawContent(canvas);
	}

	public void drawContent(Canvas canvas) {
		int count = getChildCount();
		Log.e(TAG, "drawContent: " + count);
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				View view = getChildAt(i);
				if (view.getVisibility() != View.VISIBLE) continue;
				int top = view.getTop();
				int bottom = view.getBottom();
//				Log.e(TAG, "drawContent: y = " + view.getY() + "  x = " + view.getX() + "  width = " + view.getWidth() + " height = " + view.getHeight() + "  top = " + view.getTop() + "  bottom = " + view.getBottom() + "  left = " + view.getLeft() + "  right = " + view.getRight() + "  paddingTop = " + view.getPaddingTop() + "  paddingBottom = " + view.getPaddingBottom() + "  paddingLeft = " + view.getPaddingLeft() + "  paddingRight = " + view.getPaddingRight() + "  MeasureWidth = " + view.getMeasuredWidth() + " measureHeight = " + view.getMeasuredHeight());
				if (i == 0) {
					drawPoint(canvas, i, (bottom + top) / 2);
				} else if (i == count - 1) {
					View starter = findStartView(i - 1);
					drawPoint(canvas, -1, (bottom + top) / 2);
					drawAxis(canvas, (starter.getBottom() + starter.getTop()) / 2 + (((int) starter.getTag()) == 0 ? mStartRadius : mMiddleRadius), ((bottom + top) / 2 - mEndRadius));
				} else {
					View starter = findStartView(i - 1);
//					if (i == 1) {
//					} else {
//						drawAxis(canvas, (starter.getBottom() + starter.getTop() + mMiddleRadius) / 2, (bottom + top - mMiddleRadius) / 2);
//					}
					drawPoint(canvas, 1, (bottom + top) / 2);
					if (starter != null) {
						Log.e(TAG, "drawContent: i = " + i + "  ");
						int index = (int) starter.getTag();
						drawAxis(canvas, ((starter.getBottom() + starter.getTop()) / 2 + (index == 0 ? mStartRadius : mMiddleRadius)), ((bottom + top) / 2 - mMiddleRadius));
					}
				}
			}
//			canvas.save();
//			canvas.restore();
		}
	}

	public void drawPoint(Canvas canvas, int falg, int top) {
		int central = mMarginLeft + mStartRadius;
		Log.e(TAG, "drawPoint: top = " + top + " mStartRadius " + mStartRadius + "  mMiddleRadius = " + mMiddleRadius + "  mEndRadius = " + mEndRadius);
		if (falg == 0) {
			canvas.drawCircle(central, top, mStartRadius, mPointPaint);
			Bitmap bitmap = mIconDrawable.getBitmap();
			mPointPaint.setColor(mStartColor);
			canvas.drawBitmap(bitmap, central - bitmap.getWidth() / 2, top - bitmap.getHeight() / 2, mPointPaint);
		} else if (falg == -1) {
			mPointPaint.setColor(mEndColor);
			canvas.drawCircle(central, top, mEndRadius, mPointPaint);
		} else {
			mPointPaint.setColor(mMiddleColor);
			canvas.drawCircle(central, top, mMiddleRadius, mPointPaint);
		}
	}

	public void drawAxis(Canvas canvas, int start, int end) {
		float[] array = new float[]{mAxisLen, mAxisLen};
		int central = mMarginLeft + mStartRadius;
		Log.e(TAG, "drawAxis: " + start + " " + end + "  " + central);
		DashPathEffect effect = new DashPathEffect(array, 0);
		mAxisPaint.setPathEffect(effect);
		mAxisPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();
		path.moveTo(central, start);
		path.lineTo(central, end);
		mAxisPaint.setStrokeWidth(3);
		canvas.drawPath(path, mAxisPaint);
	}

	public View findStartView(int index) {
		View view = null;
		for (int i = index; i >= 0; i--) {
			view = getChildAt(i);
			if (view.getVisibility() == View.VISIBLE) {
				Log.e(TAG, "findStartView: index = " + index + " finalPosition = " + i);
				view.setTag(i);
				break;
			}
		}
		return view;
	}

}
