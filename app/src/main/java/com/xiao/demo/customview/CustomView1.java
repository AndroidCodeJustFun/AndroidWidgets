package com.xiao.demo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.xiao.demo.R;

/**
 * Created by xiao on 2017/9/25.
 */

public class CustomView1 extends View {

	public static final String TAG = "CustomView1";

	private Paint mBackgroundPaint;

	private Paint mForeGroundPaint;

	private Paint mContentPaint;

	private int mMinWidth;

	private int mMinHeight;
	private boolean showForeGround;
	private int contentColor;
	private int backgroundColor;
	private boolean showBackground;
	private String content;

	public CustomView1(Context context) {
		super(context);
		Log.e(TAG, "CustomView1: ");
		initPaint();
	}

	public CustomView1(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		Log.e(TAG, "CustomView1 Context context, @Nullable AttributeSet attrs: ");
		init(attrs);
	}

	public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		Log.e(TAG, "CustomView1 Context context, @Nullable AttributeSet attrs, int defStyleAttr: ");
		init(attrs);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		Log.e(TAG, "CustomView1: Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes");
		init(attrs);
	}

	public void init(AttributeSet attrs) {
		TypedArray array = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView1, 0, 0);
		try {
			content = array.getString(R.styleable.CustomView1_content);
			showBackground = array.getBoolean(R.styleable.CustomView1_showBackground, true);
			backgroundColor = array.getColor(R.styleable.CustomView1_backColor, Color.argb(20, 255, 0, 0));
			contentColor = array.getColor(R.styleable.CustomView1_contentColor, Color.parseColor("#22f0f0f0"));
			mMinHeight = array.getDimensionPixelSize(R.styleable.CustomView1_minHeight, 50);
			mMinWidth = array.getDimensionPixelSize(R.styleable.CustomView1_minWidth, 200);
			Log.e(TAG, "init: " + mMinHeight + " " + array.getDimension(R.styleable.CustomView1_minHeight, 50) + "  " + array.getDimensionPixelOffset(R.styleable.CustomView1_minHeight, 50));
			showForeGround = array.getBoolean(R.styleable.CustomView1_showForeGround, true);
			float fraction = array.getFraction(0, 1, 1, 0.5f);
			Log.e(TAG, "init: " + fraction);
			initPaint();
		} catch (Exception e) {
//			e.printStackTrace();
			Log.e(TAG, "init: " + e.getMessage());
		} finally {
			array.recycle();
		}
	}

	public void initPaint() {
		mContentPaint = new Paint();
		mContentPaint.setAntiAlias(true);
		mContentPaint.setColor(Color.parseColor("#ff0000"));
		mContentPaint.setStyle(Paint.Style.FILL);
		mContentPaint.setStrokeWidth(1);
		mContentPaint.setDither(true);
		mContentPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mContentPaint.setTextSize(18);
		mContentPaint.setTextAlign(Paint.Align.CENTER);

		if (showBackground) {
			mBackgroundPaint = new Paint();
			mBackgroundPaint.setStyle(Paint.Style.FILL_AND_STROKE);
			mBackgroundPaint.setColor(Color.parseColor("#00ff00"));
			mBackgroundPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
			mBackgroundPaint.setAntiAlias(true);
		}
		if (showForeGround) {
			mForeGroundPaint = new Paint();
			mForeGroundPaint.setColor(Color.parseColor("#0000ff"));
			mForeGroundPaint.setAntiAlias(true);
			mForeGroundPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (showBackground)
			canvas.drawPaint(mBackgroundPaint);
		int width = getWidth();
		int height = getHeight();
		Log.e(TAG, "onDraw: width = " + width + "  height = " + height);
//		canvas.drawCircle(width / 2, height / 2, 200, mContentPaint);
		float textWidth = mContentPaint.measureText(content);
		float textHeight = mContentPaint.descent() - mContentPaint.ascent();
		Rect rect = new Rect();
		mContentPaint.getTextBounds(content, 0, content.length() - 1, rect);
		int width1 = rect.width();
		int height1 = rect.height();
		Log.e(TAG, "onDraw: " + textWidth + "  " + textHeight + "  " + width1 + "  " + height1);
		canvas.drawText(content, (width - textWidth) / 2, (height - textHeight) / 2, mContentPaint);
	}

	@Override
	public void onDrawForeground(Canvas canvas) {
		super.onDrawForeground(canvas);
		if (!showForeGround) return;
		int width = getWidth();
		int height = getHeight();
		canvas.drawCircle(width * 4 / 5, height * 4 / 5, 50, mForeGroundPaint);
	}


	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		Log.e(TAG, "onAttachedToWindow: ");
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		Log.e(TAG, "onDetachedFromWindow: ");
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		Log.e(TAG, "onMeasure: ");
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		Log.e(TAG, "onMeasure: widthMeasureSpec = " + MeasureSpec.toString(widthMeasureSpec) + " heightMeasureSpec = " + MeasureSpec.toString(heightMeasureSpec));
//		resolveSizeAndState()
//		getDefaultSize()
		setMeasuredDimension(mMinWidth, mMinHeight);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		Log.e(TAG, "onLayout: ");
	}

	@Override
	public boolean performClick() {
		Log.e(TAG, "performClick: ");
		return super.performClick();
	}

	@Override
	public boolean callOnClick() {
		Log.e(TAG, "callOnClick: ");
		return super.callOnClick();
	}

	@Override
	public boolean performLongClick() {
		Log.e(TAG, "performLongClick: ");
		return super.performLongClick();
	}


	public int getmMinWidth() {
		return mMinWidth;
	}

	public void setmMinWidth(int mMinWidth) {
		this.mMinWidth = mMinWidth;
	}

	public int getmMinHeight() {
		return mMinHeight;
	}

	public void setmMinHeight(int mMinHeight) {
		this.mMinHeight = mMinHeight;
	}

	public boolean isShowForeGround() {
		return showForeGround;
	}

	public void setShowForeGround(boolean showForeGround) {
		this.showForeGround = showForeGround;
	}

	public int getContentColor() {
		return contentColor;
	}

	public void setContentColor(int contentColor) {
		this.contentColor = contentColor;
	}

	public int getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	public void setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public boolean isShowBackground() {
		return showBackground;
	}

	public void setShowBackground(boolean showBackground) {
		this.showBackground = showBackground;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
