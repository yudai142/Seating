package com.dd_career.seating;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class TouchListener implements View.OnTouchListener {
    private float downX;
    private float downY;
    private int downLeftMargin;
    private int downTopMargin;

    public TouchListener() {
    }

    @Override
    public boolean onTouch(View sender, MotionEvent eventArgs) {
        ViewGroup.LayoutParams layout = sender.getLayoutParams();

        if (layout instanceof  ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)layout;

            switch (eventArgs.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downX = eventArgs.getRawX();
                    downY = eventArgs.getRawY();
                    downLeftMargin = margin.leftMargin;
                    downTopMargin = margin.topMargin;
                    return true;
                case MotionEvent.ACTION_MOVE:
                    margin.leftMargin = downLeftMargin + (int)(eventArgs.getRawX() - downX);
                    margin.topMargin = downTopMargin + (int)(eventArgs.getRawY() - downY);
                    sender.layout(margin.leftMargin, margin.topMargin, margin.leftMargin + sender.getWidth(), margin.topMargin + sender.getHeight());
                    return true;
            }
        }

        return false;
    }
}
