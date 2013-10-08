package com.darkmoose117.bopit.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.darkmoose117.bopit.utils.GameAction;
import com.darkmoose117.bopit.interfaces.GameActionListener;

/**
 * Created by Joshua Lamson on 10/7/13.
 */
public class GameView extends FrameLayout implements GestureDetector.OnGestureListener {

    private GestureDetector mGestureDetector;
    private GameActionListener mGestureListener;

    public GameView(Context context) {
        this(context, null);
    }

    public GameView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mGestureDetector = new GestureDetector(context, this);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mGestureDetector.onTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    public void setGestureListener(GameActionListener gestureListener) {
        mGestureListener = gestureListener;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        if (mGestureListener != null) {
            mGestureListener.onGameAction(GameAction.TAP);
            return true;
        }

        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (mGestureListener != null) {
            if (velocityY < 0) mGestureListener.onGameAction(GameAction.SWIPE_UP);
            else if (velocityY > 0) mGestureListener.onGameAction(GameAction.SWIPE_DOWN);
            else return false;
            return true;
        }

        return false;
    }

    // NOT NEEDED OVERRIDES

    @Override
    public boolean onScroll(MotionEvent e1,
                            MotionEvent e2,
                            float distanceX,
                            float distanceY)    { return true; }

    @Override
    public boolean onDown(MotionEvent e)        { return true; }

    @Override
    public void onLongPress(MotionEvent e)      { }

    @Override
    public void onShowPress(MotionEvent e)      { }

}
