package com.astuetz.viewpager.extensions.sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Javier on 23/03/15.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LinearLayoutFeedback extends LinearLayout {
    private final Drawable mForegroundDrawable;

    public LinearLayoutFeedback(Context context) {
        this(context, null);
    }

    public LinearLayoutFeedback(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearLayoutFeedback(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = getContext().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
        mForegroundDrawable = a.getDrawable(0);
        if (mForegroundDrawable != null) {
            mForegroundDrawable.setCallback(this);
        }
        a.recycle();
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        mForegroundDrawable.setState(getDrawableState());
        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mForegroundDrawable.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldwidth, int oldheight) {
        super.onSizeChanged(width, height, oldwidth, oldheight);
        mForegroundDrawable.setBounds(0, 0, width, height);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        if (mForegroundDrawable != null) {
            mForegroundDrawable.setHotspot(x, y);
        }
    }

    @Override
    protected boolean verifyDrawable(@NonNull Drawable who) {
        return super.verifyDrawable(who) || (who == mForegroundDrawable);
    }

    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mForegroundDrawable.jumpToCurrentState();
    }
}