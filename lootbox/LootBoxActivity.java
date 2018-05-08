package com.mcs270.lootbox;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    private int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

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
                mCurrentChest.setImageResource(R.drawable.blank);
                updateChest("500", 1);
                price = 500;
            }
        });

        mRareButton = (Button) findViewById(R.id.rare_chest);
        mRareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentChest.setImageResource(R.drawable.blank);
                updateChest("1000", 2);
                price = 1000;
            }
        });

        mEpicButton = (Button) findViewById(R.id.epic_chest);
        mEpicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentChest.setImageResource(R.drawable.blank);
                updateChest("1500", 3);
                price = 1500;
            }
        });

        mLegendaryButton = (Button) findViewById(R.id.lengendary_chest);
        mLegendaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentChest.setImageResource(R.drawable.blank);
                updateChest("2000", 4);
                price = 2000;
            }
        });

        mCurrentChest = (ImageButton) findViewById(R.id.current_chest);
        mCurrentChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentChest.setImageResource(R.drawable.blank);
                if( mCounter ==0) {
                    if (price==500){
                        ImageView animation1 = findViewById(R.id.imageView);
                        animation1.setImageResource(R.drawable.animation1);
                        AnimationDrawable openBox = (AnimationDrawable) animation1.getDrawable();
                        openBox.start();
                       mCounter++;
                    }
                    else if (price==1000){
                        ImageView animation2 = findViewById(R.id.imageView);
                        animation2.setImageResource(R.drawable.animation2);
                        AnimationDrawable openBox = (AnimationDrawable) animation2.getDrawable();
                        openBox.start();
                       mCounter++;
                    }
                    else if(price==1500){
                        ImageView animation3 = findViewById(R.id.imageView);
                        animation3.setImageResource(R.drawable.animation3);
                        AnimationDrawable openBox = (AnimationDrawable) animation3.getDrawable();
                        openBox.start();
                       mCounter++;
                    }
                    else{
                        ImageView animation4 = findViewById(R.id.imageView);
                        animation4.setImageResource(R.drawable.animation4);
                        AnimationDrawable openBox = (AnimationDrawable) animation4.getDrawable();
                        openBox.start();
                      mCounter++;
                    }
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Loot.class);
                    startActivity(intent);
                    mCounter--;}
            }
        });
        updateChest("500", 1);
    }




    private void updateChest(String price, int box) {
        mPriceView.setText(price);
        if (box == 1) {
            mCurrentChest.setImageResource(R.drawable.common01);
        } else if (box == 2) {
            mCurrentChest.setImageResource(R.drawable.rare01);
        } else if (box == 3) {
            mCurrentChest.setImageResource(R.drawable.epic01);
        } else if (box == 4) {
            mCurrentChest.setImageResource(R.drawable.legendary01);
        }
    }

}
