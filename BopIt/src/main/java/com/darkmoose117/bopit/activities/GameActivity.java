package com.darkmoose117.bopit.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.darkmoose117.bopit.R;
import com.darkmoose117.bopit.interfaces.GameActionListener;
import com.darkmoose117.bopit.utils.GameAction;
import com.darkmoose117.bopit.widgets.GameView;

/**
 * Created by Joshua Lamson on 10/7/13.
 */
public class GameActivity extends Activity implements GameActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        GameView gameView = (GameView) findViewById(R.id.game_view);
        gameView.setGestureListener(this);
    }

    @Override
    public void onGameAction(int action) {
        Toast.makeText(this, GameAction.getName(action, getResources()), Toast.LENGTH_SHORT).show();
    }
}
