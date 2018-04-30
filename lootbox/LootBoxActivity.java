package com.mcs270.lootbox;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class LootBoxActivity extends AppCompatActivity{

    private Button mInventoryButton;
    private TextView mPriceView;
    private Button mCommonButton;
    private Button mRareButton;
    private Button mEpicButton;
    private Button mLegendaryButton;
    private ImageButton mCurrentChest;
    private int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        price = 500;
        mCurrentChest.setImageResource(R.drawable.box1);

        mInventoryButton = (Button) findViewById(R.id.inventory_button);
        mInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LootBoxInventory.class);
                startActivity(intent);
            }
        });

        mPriceView = (TextView) findViewById(R.id.price_text);

        mCommonButton = (Button) findViewById(R.id.common_chest);
        mCommonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateChest("500", 1);
                price = 500;
            }
        });

        mRareButton = (Button) findViewById(R.id.rare_chest);
        mRareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateChest("1000", 2);
                price = 1000;
            }
        });

        mEpicButton = (Button) findViewById(R.id.epic_chest);
        mEpicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateChest("1500", 3);
                price = 1500;
            }
        });

        mLegendaryButton = (Button) findViewById(R.id.lengendary_chest);
        mLegendaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateChest("2000", 4);
                price = 2000;
            }
        });

        mCurrentChest = (ImageButton) findViewById(R.id.current_chest);
    }

    private void updateChest(String price, int box) {
        mPriceView.setText(price);
        if (box == 1) {
            mCurrentChest.setImageResource(R.drawable.box1);
        } else if (box == 2) {
            mCurrentChest.setImageResource(R.drawable.box2);
        } else if (box == 3) {
            mCurrentChest.setImageResource(R.drawable.box3);
        } else if (box == 4) {
            mCurrentChest.setImageResource(R.drawable.box4);
        }
    }

}
