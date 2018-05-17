package com.mcs270.lootbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;


public class LootBoxActivity extends AppCompatActivity{

    private static final String EXTRA_TIER = "com.mcs270.lootbox.tier";
    private int mTier;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Button mInventoryButton;
    private TextView mPriceView;
    private Button mCommonButton;
    private Button mRareButton;
    private Button mEpicButton;
    private Button mLegendaryButton;
    private ImageButton mCurrentChest;
    private TextView mMoneyView;
    private int price;
    private long mLastClickTime = 0;
    private int money;

    public static Intent newIntent(Context packageContext, int tier) {
        Intent intent = new Intent(packageContext, LootBoxActivity.class);
        intent.putExtra(EXTRA_TIER, tier);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        mTier = getIntent().getIntExtra(EXTRA_TIER, 1);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        money = mSharedPreferences.getInt("money", 0);

        mMoneyView = (TextView) findViewById(R.id.MoneyView);
        mMoneyView.setText(Integer.toString(money));

        mInventoryButton = (Button) findViewById(R.id.inventory_button);
        mInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mis-clicking prevention, using threshold of 1300 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1300){
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), LootBoxInventory.class);
                startActivity(intent);
            }
        });

        mPriceView = (TextView) findViewById(R.id.price_text);

        mCommonButton = (Button) findViewById(R.id.common_chest);
        mCommonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mis-clicking prevention, using threshold of 1300 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1300){
                    return;
                }
                mCurrentChest.setImageResource(R.drawable.blank);
                updateChest(1);
            }
        });

        mRareButton = (Button) findViewById(R.id.rare_chest);
        mRareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mis-clicking prevention, using threshold of 1300 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1300){
                    return;
                }
                mCurrentChest.setImageResource(R.drawable.blank);
                updateChest(2);
            }
        });

        mEpicButton = (Button) findViewById(R.id.epic_chest);
        mEpicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mis-clicking prevention, using threshold of 12300 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1300){
                    return;
                }
                mCurrentChest.setImageResource(R.drawable.blank);
                updateChest(3);
            }
        });

        mLegendaryButton = (Button) findViewById(R.id.lengendary_chest);
        mLegendaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mis-clicking prevention, using threshold of 1300 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1300){
                    return;
                }
                mCurrentChest.setImageResource(R.drawable.blank);
                updateChest(4);
            }
        });

        mCurrentChest = (ImageButton) findViewById(R.id.current_chest);
        mCurrentChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (money < 100) {
                    Toast.makeText(getApplicationContext(), R.string.game_over, Toast.LENGTH_SHORT).show();
                    return;
                } else if (money < price) {
                    Toast.makeText(getApplicationContext(), R.string.no_money, Toast.LENGTH_SHORT).show();
                    return;
                }
                // mis-clicking prevention, using threshold of 1300 ms
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1300){
                    return;
                }
                mCurrentChest.setImageResource(R.drawable.blank);
                if (price == 100){
                    money = money - price;
                    mEditor.putInt("money", money);
                    mEditor.commit();
                    mMoneyView.setText(Integer.toString(money));
                    mLastClickTime = SystemClock.elapsedRealtime();
                    ImageView animation1 = findViewById(R.id.imageView);
                    animation1.setImageResource(R.drawable.animation1);
                    AnimationDrawable openBox = (AnimationDrawable) animation1.getDrawable();
                    openBox.start();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1.2s = 1200ms
                            Intent intent = Loot.newIntent(getApplicationContext(), 1);
                            startActivity(intent);
                        }
                    }, 1200);
                }
                else if (price == 1000) {
                    money = money - price;
                    mEditor.putInt("money", money);
                    mEditor.commit();
                    mMoneyView.setText(Integer.toString(money));
                    ImageView animation2 = findViewById(R.id.imageView);
                    animation2.setImageResource(R.drawable.animation2);
                    AnimationDrawable openBox = (AnimationDrawable) animation2.getDrawable();
                    openBox.start();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1.2s = 1200ms
                            Intent intent = Loot.newIntent(getApplicationContext(), 2);
                            startActivity(intent);
                        }
                    }, 1200);
                }
                else if (price == 10000) {
                    money = money - price;
                    mEditor.putInt("money", money);
                    mEditor.commit();
                    mMoneyView.setText(Integer.toString(money));
                    ImageView animation3 = findViewById(R.id.imageView);
                    animation3.setImageResource(R.drawable.animation3);
                    AnimationDrawable openBox = (AnimationDrawable) animation3.getDrawable();
                    openBox.start();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1.2s = 1200ms
                            Intent intent = Loot.newIntent(getApplicationContext(), 3);
                            startActivity(intent);
                        }
                    }, 1200);
                }
                else {
                    money = money - price;
                    mEditor.putInt("money", money);
                    mEditor.commit();
                    mMoneyView.setText(Integer.toString(money));
                    ImageView animation4 = findViewById(R.id.imageView);
                    animation4.setImageResource(R.drawable.animation4);
                    AnimationDrawable openBox = (AnimationDrawable) animation4.getDrawable();
                    openBox.start();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1.2s = 1200ms
                            Intent intent = Loot.newIntent(getApplicationContext(), 4);
                            startActivity(intent);
                        }
                    }, 1200);
                }
            }

        });
        updateChest(mTier);
    }




    private void updateChest(int box) {
        if (box == 1) {
            mCurrentChest.setImageResource(R.drawable.common01);
            price = 100;
            mPriceView.setText(Integer.toString(price));
        } else if (box == 2) {
            mCurrentChest.setImageResource(R.drawable.rare01);
            price = 1000;
            mPriceView.setText(Integer.toString(price));
        } else if (box == 3) {
            mCurrentChest.setImageResource(R.drawable.epic01);
            price = 10000;
            mPriceView.setText(Integer.toString(price));
        } else if (box == 4) {
            mCurrentChest.setImageResource(R.drawable.legendary01);
            price = 100000;
            mPriceView.setText(Integer.toString(price));

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), LootBox.class);
        startActivity(intent);
    }

}
