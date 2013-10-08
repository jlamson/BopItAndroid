package com.darkmoose117.bopit.utils;

import android.content.res.Resources;
import android.view.Gravity;

import com.darkmoose117.bopit.R;

import java.util.Random;

/**
 * Created by Joshua Lamson on 10/7/13.
 */
public class GameAction {

    public static final int TAP                 = 0;
    public static final int SWIPE_UP            = 1;
    public static final int SWIPE_DOWN          = 2;
    public static final int SWIPE_LEFT          = 3;
    public static final int SWIPE_RIGHT         = 4;
    public static final int NUMBER_OF_ACTIONS   = 5;

    public static final int[] ACTION_NAMES = {
            R.string.action_tap,
            R.string.action_swipe_up,
            R.string.action_swipe_down,
            R.string.action_swipe_left,
            R.string.action_swipe_right
    };

    public static final int[] ACTION_COLORS = {
            R.color.blue,
            R.color.green,
            R.color.red,
            R.color.yellow,
            R.color.purple
    };

    public static final int[] ACTION_SCREEN_LOCATION = {
            Gravity.CENTER,
            Gravity.TOP | Gravity.CENTER_HORIZONTAL,
            Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,
            Gravity.LEFT | Gravity.CENTER_VERTICAL,
            Gravity.RIGHT | Gravity.CENTER_VERTICAL
    };

    public static String getName(int action, Resources res) {
        checkAction(action);
        return res.getString(ACTION_NAMES[action]);
    }

    public static int getColor(int action, Resources res) {
        checkAction(action);
        return res.getColor(ACTION_COLORS[action]);
    }

    public static int getGravity(int action) {
        checkAction(action);
        return ACTION_SCREEN_LOCATION[action];
    }

    public static int getRandomAction() {
        Random random = new Random();
        return random.nextInt(NUMBER_OF_ACTIONS);
    }

    private static void checkAction(int action) {
        if (action < 0 || action >= NUMBER_OF_ACTIONS) {
            throw new IllegalArgumentException(String.format("Invalid GameAction: %d", action));
        }
    }
}
