package com.xiao.demo.recyclerview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.xiao.demo.recyclerview.ui.adapter.ListAdapter;

/**
 * RecyclerView 分割线 或者传递 Drawable  或者 传递纯色色值  通过Paint绘制
 */
public class RecyclerViewDecoration extends RecyclerView.ItemDecoration {

    //布局方向  既有垂直 又有  水平 即 用于 GridLaytoutManager
    public static final int ORIENTATION_HYBIRD = 0x2;

    /**
     * RecyclerView布局方向 默认垂直
     */
    private int mOrientation = LinearLayoutManager.VERTICAL;

    /**
     * 画笔
     */
    private Paint mPaint;

    private int mDividerHeight = 2;

    private Drawable mDrawable;

    public RecyclerViewDecoration() {
        super();
    }

    /**
     * @param mOrientation
     * @param color        Color.BLACK 或者 getResource().getColor(R.color.xxx);
     */
    public RecyclerViewDecoration(Context context, int mOrientation, int color) {
        if (mOrientation != LinearLayoutManager.VERTICAL && mOrientation != LinearLayoutManager.HORIZONTAL && mOrientation != ORIENTATION_HYBIRD)
            throw new IllegalArgumentException("orientation is Illegal , Must be LinearLayoutManager.VERTICAL or LinearLayoutManager.HORIZONTAL or ORIENTATION_HYBIRD");
        this.mOrientation = mOrientation;
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(color);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mDividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics());
    }

    public RecyclerViewDecoration(Context context, int mOrientation, Drawable mDrawable) {
        if (mOrientation != LinearLayoutManager.VERTICAL && mOrientation != LinearLayoutManager.HORIZONTAL && mOrientation != ORIENTATION_HYBIRD)
            throw new IllegalArgumentException("orientation is Illegal , Must be LinearLayoutManager.VERTICAL or LinearLayoutManager.HORIZONTAL or ORIENTATION_HYBIRD");
        this.mOrientation = mOrientation;
        this.mDrawable = mDrawable;
    }

    // 子Item绘制之前
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    // 子item 绘制之后
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        switch (mOrientation) {
            case LinearLayoutManager.VERTICAL:
                drawVertical(c, parent);
                break;
            case LinearLayoutManager.HORIZONTAL:
                drawHorizontal(c, parent);
                break;
            case ORIENTATION_HYBIRD:
                drawVertical(c, parent);
                drawHorizontal(c, parent);
                break;
            default:
                drawVertical(c, parent);
                break;
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }

    public void setmOrientation(int mOrientation) {
        this.mOrientation = mOrientation;
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
//        int left = parent.getPaddingLeft();
//        int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(child);
            if (childViewHolder instanceof ListAdapter.HeaderViewHolder) continue;
            if (childViewHolder instanceof ListAdapter.GridViewHolder) continue;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + layoutParams.bottomMargin;
            int left = child.getLeft() - layoutParams.leftMargin;
            int right = child.getRight() + layoutParams.rightMargin;
            if (mDrawable != null) { // 优先绘制Drawable
                right += mDrawable.getIntrinsicWidth();
                final int bottom = top + mDrawable.getIntrinsicHeight();
                mDrawable.setBounds(left, top, right, bottom);
                mDrawable.draw(c);
            } else {//其次绘制纯色
                right += mDividerHeight;
                final int bottom = top + mDividerHeight;
                c.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getTop() - layoutParams.topMargin;
            int bottom = child.getBottom() + layoutParams.bottomMargin;
            int left = child.getRight() + layoutParams.rightMargin;
            if (mDrawable != null) { // 优先绘制Drawable
                final int right = left + mDrawable.getIntrinsicWidth();
                mDrawable.setBounds(left, top, right, bottom);
                mDrawable.draw(c);
            } else {//其次绘制纯色
                final int right = left + mDividerHeight;
                c.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    public void setmDrawable(Drawable mDrawable) {
        this.mDrawable = mDrawable;
    }
}
