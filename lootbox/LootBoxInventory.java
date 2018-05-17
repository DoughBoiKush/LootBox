package com.mcs270.lootbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LootBoxInventory extends AppCompatActivity{

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Button mHomeButton;
    private Button mPrevButton;
    private Button mNextButton;
    private ImageView mItem1;
    private ImageView mItem2;
    private ImageView mItem3;
    private ImageView mItem4;
    private ImageView mItem5;
    private ImageView mItem6;
    private ImageView mItem7;
    private ImageView mItem8;
    private ImageView mItem9;
    private int range;
    private int tier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_layout);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        range = 1;
        tier = 1;

        mHomeButton = (Button) findViewById(R.id.Home_button);
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LootBoxActivity.class);
                startActivity(intent);
            }
        });

        mPrevButton = (Button) findViewById(R.id.Previous_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (range == 1) {
                    range = 172;
                } else {
                    range = range - 9;
                }
                if (range < 46) {
                    tier = 1;
                } else if (range < 91) {
                    tier = 2;
                } else if (range < 136) {
                    tier = 3;
                } else {
                    tier = 4;
                }
                updateItems();
            }

        });

        mNextButton = (Button) findViewById(R.id.Next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (range == 172) {
                    range = 1;
                } else {
                    range = range + 9;
                }
                if (range < 46) {
                    tier = 1;
                } else if (range < 91) {
                    tier = 2;
                } else if (range < 136) {
                    tier = 3;
                } else {
                    tier = 4;
                }
                updateItems();
            }
        });

        mItem1 = (ImageView) findViewById(R.id.item_1);
        mItem2 = (ImageView) findViewById(R.id.item_2);
        mItem3 = (ImageView) findViewById(R.id.item_3);
        mItem4 = (ImageView) findViewById(R.id.item_4);
        mItem5 = (ImageView) findViewById(R.id.item_5);
        mItem6 = (ImageView) findViewById(R.id.item_6);
        mItem7 = (ImageView) findViewById(R.id.item_7);
        mItem8 = (ImageView) findViewById(R.id.item_8);
        mItem9 = (ImageView) findViewById(R.id.item_9);
        updateItems();
    }

    public void updateItems() {
        if (mSharedPreferences.getBoolean(Integer.toString(range), false)) {
            mItem1.setImageResource(getResources().getIdentifier("item" + range, "drawable",
                    getPackageName()));
        } else {
            mItem1.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }
        if (mSharedPreferences.getBoolean(Integer.toString(range + 1), false)) {
            mItem2.setImageResource(getResources().getIdentifier("item" + (range + 1), "drawable",
                    getPackageName()));
        } else {
            mItem2.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }
        if (mSharedPreferences.getBoolean(Integer.toString(range + 2), false)) {
            mItem3.setImageResource(getResources().getIdentifier("item" + (range + 2), "drawable",
                    getPackageName()));
        } else {
            mItem3.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }
        if (mSharedPreferences.getBoolean(Integer.toString(range + 3), false)) {
            mItem4.setImageResource(getResources().getIdentifier("item" + (range + 3), "drawable",
                    getPackageName()));
        } else {
            mItem4.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }
        if (mSharedPreferences.getBoolean(Integer.toString(range + 4), false)) {
            mItem5.setImageResource(getResources().getIdentifier("item" + (range + 4), "drawable",
                    getPackageName()));
        } else {
            mItem5.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }
        if (mSharedPreferences.getBoolean(Integer.toString(range + 5), false)) {
            mItem6.setImageResource(getResources().getIdentifier("item" + (range + 5), "drawable",
                    getPackageName()));
        } else {
            mItem6.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }
        if (mSharedPreferences.getBoolean(Integer.toString(range + 6), false)) {
            mItem7.setImageResource(getResources().getIdentifier("item" + (range + 6), "drawable",
                    getPackageName()));
        } else {
            mItem7.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }
        if (mSharedPreferences.getBoolean(Integer.toString(range + 7), false)) {
            mItem8.setImageResource(getResources().getIdentifier("item" + (range + 7), "drawable",
                    getPackageName()));
        } else {
            mItem8.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }
        if (mSharedPreferences.getBoolean(Integer.toString(range + 8), false)) {
            mItem9.setImageResource(getResources().getIdentifier("item" + (range + 8), "drawable",
                    getPackageName()));
        } else {
            mItem9.setImageResource(getResources().getIdentifier("itemt" + tier + "blank", "drawable",
                    getPackageName()));
        }

    }
}
