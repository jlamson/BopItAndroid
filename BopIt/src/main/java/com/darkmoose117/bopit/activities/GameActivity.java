package com.darkmoose117.bopit.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.darkmoose117.bopit.R;
import com.darkmoose117.bopit.enums.GameGesture;
import com.darkmoose117.bopit.interfaces.GameGestureListener;
import com.darkmoose117.bopit.widgets.GameView;

/**
 * Created by Joshua Lamson on 10/7/13.
 */
public class GameActivity extends Activity implements GameGestureListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        GameView gameView = (GameView) findViewById(R.id.game_view);
        gameView.setGestureListener(this);
    }

    @Override
    public void onGameGesture(GameGesture gesture) {
        String toast;
        switch (gesture) {
            case TAP:
                toast = "TAP";
                break;
            case SWIPE_UP:
                toast = "SWIPE UP";
                break;
            case SWIPE_DOWN:
                toast = "SWIPE DOWN";
                break;
            default:
                throw new IllegalArgumentException("Invalid GameGesture passed to onGameGesture");
        }
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}
