package com.mcs270.lootbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LootBox extends AppCompatActivity {

    private Button mNewGameButton;
    private Button mContinueGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loot_box);
    }

    @Override
    public boolean
    Intent intent = CrimePagerActivity.newIntent(getActivity(),crime.getId());
    startActivity(intent);

}
