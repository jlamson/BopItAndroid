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
    private GameActionListener mGameActionListener;

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

    public void setGameActionListener(GameActionListener gameActionListener) {
        mGameActionListener = gameActionListener;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        if (mGameActionListener != null) {
            mGameActionListener.onGameAction(GameAction.TAP);
            return true;
        }

        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float vX, float vY) {
        if (mGameActionListener != null) {
            // TODO figure out how close to horizontal a vertical swipe can be before invalid & vice versa
            boolean isVertical = Math.abs(vX) < Math.abs(vY);
            if (isVertical) {
                if (vY < 0) mGameActionListener.onGameAction(GameAction.SWIPE_UP);
                else mGameActionListener.onGameAction(GameAction.SWIPE_DOWN);
            } else {
                if (vX < 0) mGameActionListener.onGameAction(GameAction.SWIPE_LEFT);
                else mGameActionListener.onGameAction(GameAction.SWIPE_RIGHT);
            }
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
