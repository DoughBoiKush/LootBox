package com.mcs270.lootbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LootBox extends AppCompatActivity {

    //private Button mNewGameButton;
    private Button mContinueGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loot_box);

        mContinueGameButton = (Button) findViewById(R.id.continue_game_button);
        mContinueGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LootBoxActivity.class);
                startActivity(intent);
            }
        });
    }

}
