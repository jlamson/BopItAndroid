package com.darkmoose117.bopit.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.darkmoose117.bopit.R;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.main_play_button);
        playButton.setOnClickListener(this);
        Button leaderBoardButton = (Button) findViewById(R.id.main_leader_board_button);
        leaderBoardButton.setOnClickListener(this);
        Button optionsButton = (Button) findViewById(R.id.main_options_button);
        optionsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_play_button:
                startGame();
                break;
            case R.id.main_leader_board_button:
            case R.id.main_options_button:
            default:
                Toast.makeText(this, "Not Implemented Yet", Toast.LENGTH_SHORT).show();
        }
    }

    private void startGame() {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivity(gameIntent);
    }
}
