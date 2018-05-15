
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

        if(mSharedPreferences.getBoolean("save", false) == false) {
            newGame();
        }

        mContinueGameButton = (Button) findViewById(R.id.continue_game_button);
        mContinueGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LootBoxActivity.class);
                startActivity(intent);
            }
        });

        mNewGameButton = (Button) findViewById(R.id.new_game_button);
        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
                Intent intent = new Intent(getApplicationContext(), LootBoxActivity.class);
                startActivity(intent);
            }
        });
    }

    public void newGame() {
        mEditor.putBoolean("save", true);
        for (int i = 0; i < 100; i++) {
            mEditor.putBoolean(Integer.toString(i), false);
        }
        mEditor.putInt("money", 200);
    }

}
