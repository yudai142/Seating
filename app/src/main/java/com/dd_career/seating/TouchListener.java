package com.dd_career.seating;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

// 間取り図タッチ機能を提供する.
public class TouchListener implements View.OnTouchListener {
    private float downX;
    private float downY;
    private int leftMargin;
    private int topMargin;

    public TouchListener() {
    }

    private void down(View view, MotionEvent args) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        downX = args.getRawX();
        downY = args.getRawY();

        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams layout = (ViewGroup.MarginLayoutParams)params;
            leftMargin = layout.leftMargin;
            topMargin = layout.topMargin;
        }
    }

    private void layout(View view, int left, int top) {
        int right = left + view.getWidth();
        int bottom = top + view.getHeight();
        view.layout(left, top, right, bottom);
    }

    private void move(View view, MotionEvent args) {
        ViewGroup.LayoutParams params = view.getLayoutParams();

        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams layout = (ViewGroup.MarginLayoutParams)params;
            layout.leftMargin = leftMargin + (int)(args.getRawX() - downX);
            layout.topMargin = topMargin + (int)(args.getRawY() - downY);
            layout(view, layout.leftMargin, layout.topMargin);
        }
    }

    @Override
    public boolean onTouch(View sender, MotionEvent eventArgs) {
        switch (eventArgs.getAction()) {
            case MotionEvent.ACTION_DOWN:
                down(sender, eventArgs);
                return true;
            case MotionEvent.ACTION_MOVE:
                move(sender, eventArgs);
                return true;
            case MotionEvent.ACTION_UP:
                up();
                return true;
        }

        return false;
    }

    private void up() {
        downX = 0;
        downY = 0;
        leftMargin = 0;
        topMargin = 0;
    }
}
