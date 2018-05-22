package com.mcs270.lootbox;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.DialogInterface;
import android.app.AlertDialog;

//import lootbox.mcs270.com.lootbox.R;

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
                Intent intent = com.mcs270.lootbox.LootBoxActivity.newIntent(getApplicationContext(), 1);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        newGame();
                        Intent intent = com.mcs270.lootbox.LootBoxActivity.newIntent(getApplicationContext(), 1);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
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
        mEditor.putInt("totalMoney", 200);
        mEditor.commit();
        mEditor.putInt("boxes", 0);
        mEditor.commit();
        mEditor.putInt("boxes1", 0);
        mEditor.commit();
        mEditor.putInt("boxes2", 0);
        mEditor.commit();
        mEditor.putInt("boxes3", 0);
        mEditor.commit();
        mEditor.putInt("boxes4", 0);
        mEditor.commit();
    }

}
