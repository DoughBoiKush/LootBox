
package com.mcs270.lootbox;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;

public class LootBox extends AppCompatActivity {

    private Button mNewGameButton;
    private Button mContinueGameButton;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loot_box);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mContinueGameButton = (Button) findViewById(R.id.continue_game_button);
        mContinueGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LootBoxActivity.newIntent(getApplicationContext(), 1);
                startActivity(intent);
            }
        });
        if(mSharedPreferences.getBoolean("save", false) == false) {
            mContinueGameButton.setVisibility(View.GONE);
        }

        mNewGameButton = (Button) findViewById(R.id.new_game_button);
        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
                Intent intent = LootBoxActivity.newIntent(getApplicationContext(), 1);
                startActivity(intent);
            }
        });
    }

    public void newGame() {
        mEditor.putBoolean("save", true);
        mEditor.commit();
        for (int i = 1; i < 180; i++) {
            mEditor.putBoolean(Integer.toString(i), false);
            mEditor.commit();
        }
        mEditor.putInt("money", 200);
        mEditor.commit();
    }

}
