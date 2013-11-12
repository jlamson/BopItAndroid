package com.darkmoose117.bopit.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.darkmoose117.bopit.R;
import com.darkmoose117.bopit.interfaces.GameActionListener;
import com.darkmoose117.bopit.utils.GameAction;
import com.darkmoose117.bopit.widgets.GameActionView;
import com.darkmoose117.bopit.widgets.GameView;

/**
 * Created by Joshua Lamson on 10/7/13.
 */
public class GameActivity extends Activity implements GameActionListener {

    private GameActionView mActionView;
    private TextView mScoreTextView;

    private int mAction;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        GameView gameView = (GameView) findViewById(R.id.game_view);
        gameView.setGameActionListener(this);

        mActionView = (GameActionView) findViewById(R.id.game_action_view);
        mScoreTextView = (TextView) findViewById(R.id.game_score_view);

        startNewAction();
    }

    @Override
    public void onGameAction(int action) {
        if (action == mAction) {
            mScore++;
            startNewAction();
        } else {
            mScore = 0;
            Toast.makeText(this, "OH SHIT", Toast.LENGTH_SHORT).show();
        }

        mScoreTextView.setText(String.valueOf(mScore));
    }

    private void startNewAction() {
        mAction = GameAction.getRandomAction();
        mActionView.setAction(mAction);
    }
}
