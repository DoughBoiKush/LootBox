package com.mcs270.lootbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Loot extends AppCompatActivity{

    private static final String EXTRA_TIER = "com.mcs270.lootbox.tier";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private TextView mMoney;
    private int mTier;
    private int loot1;
    private int loot2;
    private int loot3;
    private int loot4;
    private int loot5;
    private int loot6;
    private ImageView mLoot1;
    private ImageView mLoot2;
    private ImageView mLoot3;
    private ImageView mLoot4;
    private ImageView mLoot5;
    private ImageView mLoot6;
    private Button mSell1;
    private Button mSell2;
    private Button mSell3;
    private Button mSell4;
    private Button mSell5;
    private Button mSell6;
    private Button mKeep1;
    private Button mKeep2;
    private Button mKeep3;
    private Button mKeep4;
    private Button mKeep5;
    private Button mKeep6;
    private int money;
    private int totalMoney;
    private int counter;

    public static Intent newIntent(Context packageContext, int tier) {
        Intent intent = new Intent(packageContext, Loot.class);
        intent.putExtra(EXTRA_TIER, tier);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loot);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mTier = getIntent().getIntExtra(EXTRA_TIER, 1);
        getLoot(mTier);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        money = mSharedPreferences.getInt("money", 0);
        mMoney = (TextView) findViewById(R.id.money);
        mMoney.setText("Money: " + Integer.toString(money));

        mLoot1 = (ImageView) findViewById(R.id.loot_1);
        mLoot1.setImageResource(getResources().getIdentifier("item" + loot1,"drawable",
                getPackageName()));
        mLoot2 = (ImageView) findViewById(R.id.loot_2);
        mLoot2.setImageResource(getResources().getIdentifier("item" + loot2,"drawable",
                getPackageName()));
        mLoot3 = (ImageView) findViewById(R.id.loot_3);
        mLoot3.setImageResource(getResources().getIdentifier("item" + loot3,"drawable",
                getPackageName()));
        mLoot4 = (ImageView) findViewById(R.id.loot_4);
        mLoot4.setImageResource(getResources().getIdentifier("item" + loot4,"drawable",
                getPackageName()));
        mLoot5 = (ImageView) findViewById(R.id.loot_5);
        mLoot5.setImageResource(getResources().getIdentifier("item" + loot5,"drawable",
                getPackageName()));
        mLoot6 = (ImageView) findViewById(R.id.loot_6);
        mLoot6.setImageResource(getResources().getIdentifier("item" + loot6,"drawable",
                getPackageName()));

        mSell1 = (Button) findViewById(R.id.sell_1);
        mSell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putInt("money", money + getPrice(loot1));
                mEditor.commit();
                totalMoney = mSharedPreferences.getInt("totalMoney", 0);
                mEditor.putInt("totalMoney", totalMoney + getPrice(loot1));
                mEditor.commit();
                money = mSharedPreferences.getInt("money", 0);
                mSell1.setVisibility(View.INVISIBLE);
                mKeep1.setVisibility(View.INVISIBLE);
                mLoot1.setImageResource(R.drawable.blank);
                mMoney.setText("Money: " + Integer.toString(money));
                addCounter();
            }
        });
        mSell2 = (Button) findViewById(R.id.sell_2);
        mSell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putInt("money", money + getPrice(loot2));
                mEditor.commit();
                totalMoney = mSharedPreferences.getInt("totalMoney", 0);
                mEditor.putInt("totalMoney", totalMoney + getPrice(loot2));
                mEditor.commit();
                money = mSharedPreferences.getInt("money", 0);
                mSell2.setVisibility(View.INVISIBLE);
                mKeep2.setVisibility(View.INVISIBLE);
                mLoot2.setImageResource(R.drawable.blank);
                mMoney.setText("Money: " + Integer.toString(money));
                addCounter();
            }
        });
        mSell3 = (Button) findViewById(R.id.sell_3);
        mSell3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putInt("money", money + getPrice(loot3));
                mEditor.commit();
                totalMoney = mSharedPreferences.getInt("totalMoney", 0);
                mEditor.putInt("totalMoney", totalMoney + getPrice(loot3));
                mEditor.commit();
                money = mSharedPreferences.getInt("money", 0);
                mSell3.setVisibility(View.INVISIBLE);
                mKeep3.setVisibility(View.INVISIBLE);
                mLoot3.setImageResource(R.drawable.blank);
                mMoney.setText("Money: " + Integer.toString(money));
                addCounter();
            }
        });
        mSell4 = (Button) findViewById(R.id.sell_4);
        mSell4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putInt("money", money + getPrice(loot4));
                mEditor.commit();
                totalMoney = mSharedPreferences.getInt("totalMoney", 0);
                mEditor.putInt("totalMoney", totalMoney + getPrice(loot4));
                mEditor.commit();
                money = mSharedPreferences.getInt("money", 0);
                mSell4.setVisibility(View.INVISIBLE);
                mKeep4.setVisibility(View.INVISIBLE);
                mLoot4.setImageResource(R.drawable.blank);
                mMoney.setText("Money: " + Integer.toString(money));
                addCounter();
            }
        });
        mSell5 = (Button) findViewById(R.id.sell_5);
        mSell5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putInt("money", money + getPrice(loot5));
                mEditor.commit();
                totalMoney = mSharedPreferences.getInt("totalMoney", 0);
                mEditor.putInt("totalMoney", totalMoney + getPrice(loot5));
                mEditor.commit();
                money = mSharedPreferences.getInt("money", 0);
                mSell5.setVisibility(View.INVISIBLE);
                mKeep5.setVisibility(View.INVISIBLE);
                mLoot5.setImageResource(R.drawable.blank);
                mMoney.setText("Money: " + Integer.toString(money));
                addCounter();
            }
        });
        mSell6 = (Button) findViewById(R.id.sell_6);
        mSell6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putInt("money", money + getPrice(loot6));
                mEditor.commit();
                totalMoney = mSharedPreferences.getInt("totalMoney", 0);
                mEditor.putInt("totalMoney", totalMoney + getPrice(loot6));
                mEditor.commit();
                money = mSharedPreferences.getInt("money", 0);
                mSell6.setVisibility(View.INVISIBLE);
                mKeep6.setVisibility(View.INVISIBLE);
                mLoot6.setImageResource(R.drawable.blank);
                mMoney.setText("Money: " + Integer.toString(money));
                addCounter();
            }
        });

        mKeep1 = (Button) findViewById(R.id.keep_1);
        mKeep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putBoolean(Integer.toString(loot1), true);
                mEditor.commit();
                mKeep1.setVisibility(View.INVISIBLE);
                mSell1.setVisibility(View.INVISIBLE);
                mLoot1.setImageResource(R.drawable.blank);
                addCounter();
                updateKeep();
            }
        });
        if (mSharedPreferences.getBoolean(Integer.toString(loot1), false)){
            mKeep1.setVisibility(View.INVISIBLE);
        }
        mKeep2 = (Button) findViewById(R.id.keep_2);
        mKeep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putBoolean(Integer.toString(loot2), true);
                mEditor.commit();
                mKeep2.setVisibility(View.INVISIBLE);
                mSell2.setVisibility(View.INVISIBLE);
                mLoot2.setImageResource(R.drawable.blank);
                addCounter();
                updateKeep();
            }
        });
        if (mSharedPreferences.getBoolean(Integer.toString(loot2), false)){
            mKeep2.setVisibility(View.INVISIBLE);
        }
        mKeep3 = (Button) findViewById(R.id.keep_3);
        mKeep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putBoolean(Integer.toString(loot3), true);
                mEditor.commit();
                mKeep3.setVisibility(View.INVISIBLE);
                mSell3.setVisibility(View.INVISIBLE);
                mLoot3.setImageResource(R.drawable.blank);
                addCounter();
                updateKeep();
            }
        });
        if (mSharedPreferences.getBoolean(Integer.toString(loot3), false)){
            mKeep3.setVisibility(View.INVISIBLE);
        }
        mKeep4 = (Button) findViewById(R.id.keep_4);
        mKeep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putBoolean(Integer.toString(loot4), true);
                mEditor.commit();
                mKeep4.setVisibility(View.INVISIBLE);
                mSell4.setVisibility(View.INVISIBLE);
                mLoot4.setImageResource(R.drawable.blank);
                addCounter();
                updateKeep();
            }
        });
        if (mSharedPreferences.getBoolean(Integer.toString(loot4), false)){
            mKeep4.setVisibility(View.INVISIBLE);
        }
        mKeep5 = (Button) findViewById(R.id.keep_5);
        mKeep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putBoolean(Integer.toString(loot5), true);
                mEditor.commit();
                mKeep5.setVisibility(View.INVISIBLE);
                mSell5.setVisibility(View.INVISIBLE);
                mLoot5.setImageResource(R.drawable.blank);
                addCounter();
                updateKeep();
            }
        });
        if (mSharedPreferences.getBoolean(Integer.toString(loot5), false)){
            mKeep5.setVisibility(View.INVISIBLE);
        }
        mKeep6 = (Button) findViewById(R.id.keep_6);
        mKeep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putBoolean(Integer.toString(loot6), true);
                mEditor.commit();
                mKeep6.setVisibility(View.INVISIBLE);
                mSell6.setVisibility(View.INVISIBLE);
                mLoot6.setImageResource(R.drawable.blank);
                addCounter();
                updateKeep();
            }
        });
        if (mSharedPreferences.getBoolean(Integer.toString(loot6), false)){
            mKeep6.setVisibility(View.INVISIBLE);
        }

    }

    public int getItem(int rarity, int tier) {
        Random r = new Random();
        if (rarity < 71) {
            return ((tier - 1) * 45) + r.nextInt(18) + 1;
        } else if (rarity < 91) {
            return ((tier - 1) * 45) + r.nextInt(12) + 19;
        } else if (rarity < 100) {
            return ((tier - 1) * 45) + r.nextInt(10) + 31;
        }
            return ((tier - 1) * 45) + r.nextInt(5) + 41;
    }


    public void getLoot(int tier) {
        Random r = new Random();
        loot1 = getItem(r.nextInt(100) + 1, tier);
        loot2 = getItem(r.nextInt(100) + 1, tier);
        loot3 = getItem(r.nextInt(100) + 1, tier);
        loot4 = getItem(r.nextInt(100) + 1, tier);
        loot5 = getItem(r.nextInt(100) + 1, tier);
        loot6 = getItem(r.nextInt(100) + 1, tier);
    }

    public int getPrice(int loot) {
        if (loot <  19) {
            return 10;
        } else if (loot < 31) {
            return 30;
        } else if (loot < 41) {
            return 100;
        } else if (loot < 46) {
            return 200;
        } else if (loot < 64) {
            return 100;
        } else if (loot < 76) {
            return 300;
        } else if (loot < 86) {
            return 1000;
        } else if (loot < 91) {
            return 2000;
        } else if (loot < 109) {
            return 1000;
        } else if (loot < 121) {
            return 3000;
        } else if (loot < 131) {
            return 10000;
        } else if (loot < 136) {
            return 20000;
        } else if (loot < 154) {
            return 10000;
        } else if (loot < 166) {
            return 30000;
        } else if (loot < 176) {
            return 100000;
        } else {
            return 200000;
        }
    }

    public void addCounter() {
        counter++;
        if (counter == 6) {
            Intent intent = LootBoxActivity.newIntent(getApplicationContext(), mTier);
            startActivity(intent);
        }
    }

    public void updateKeep() {
        if (mSharedPreferences.getBoolean(Integer.toString(loot1), false)){
            mKeep1.setVisibility(View.INVISIBLE);
        }
        if (mSharedPreferences.getBoolean(Integer.toString(loot2), false)){
            mKeep2.setVisibility(View.INVISIBLE);
        }
        if (mSharedPreferences.getBoolean(Integer.toString(loot3), false)){
            mKeep3.setVisibility(View.INVISIBLE);
        }
        if (mSharedPreferences.getBoolean(Integer.toString(loot4), false)){
            mKeep4.setVisibility(View.INVISIBLE);
        }
        if (mSharedPreferences.getBoolean(Integer.toString(loot5), false)){
            mKeep5.setVisibility(View.INVISIBLE);
        }
        if (mSharedPreferences.getBoolean(Integer.toString(loot6), false)){
            mKeep6.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public void onBackPressed() {
        return;
    }
}
