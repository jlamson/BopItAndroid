package com.darkmoose117.bopit.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.darkmoose117.bopit.R;
import com.darkmoose117.bopit.utils.GameAction;

/**
 * Created by Joshua Lamson on 10/7/13.
 */
public class GameActionView extends FontTextView {
    public GameActionView(Context context) {
        this(context, null);
    }

    public GameActionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GameActionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setFontFile(R.string.roboto_black);
    }

    public void setAction(int action) {
        Resources res = getResources();
        setTextColor(GameAction.getColor(action, res));
        setText(GameAction.getName(action, res));
        ((FrameLayout.LayoutParams) getLayoutParams()).gravity = GameAction.getGravity(action);
        requestLayout();
    }
}
