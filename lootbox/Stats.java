package com.mcs270.lootbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Stats extends AppCompatActivity{

    private SharedPreferences mSharedPreferences;
    private int money;
    private int totalMoney;
    private int items;
    private int boxes;
    private int boxes1;
    private int boxes2;
    private int boxes3;
    private int boxes4;
    private TextView mMoney;
    private TextView mTotalMoney;
    private TextView mItems;
    private TextView mBoxes;
    private TextView mBoxes1;
    private TextView mBoxes2;
    private TextView mBoxes3;
    private TextView mBoxes4;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_layout);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        money = mSharedPreferences.getInt("money", 0);
        totalMoney = mSharedPreferences.getInt("totalMoney", 0);
        items = getItems();
        boxes = mSharedPreferences.getInt("boxes", 0);
        boxes1 = mSharedPreferences.getInt("boxes1", 0);
        boxes2 = mSharedPreferences.getInt("boxes2", 0);
        boxes3 = mSharedPreferences.getInt("boxes3", 0);
        boxes4 = mSharedPreferences.getInt("boxes4", 0);

        mMoney = (TextView) findViewById(R.id.moneyView);
        mMoney.setText("Money: " + Integer.toString(money));

        mTotalMoney = (TextView) findViewById(R.id.totalMoneyView);
        mTotalMoney.setText("Total Money: " + Integer.toString(totalMoney));

        mItems = (TextView) findViewById(R.id.itemsView);
        mItems.setText("Total Items: " + Integer.toString(items));

        mBoxes = (TextView) findViewById(R.id.boxesView);
        mBoxes.setText("Boxes Opened: " + Integer.toString(boxes));

        mBoxes1 = (TextView) findViewById(R.id.boxes1View);
        mBoxes1.setText("Common Boxes Opened: " + Integer.toString(boxes1));

        mBoxes2 = (TextView) findViewById(R.id.boxes2View);
        mBoxes2.setText("Rare Boxes Opened: " + Integer.toString(boxes2));

        mBoxes3 = (TextView) findViewById(R.id.boxes3View);
        mBoxes3.setText("Unique Boxes Opened: " + Integer.toString(boxes3));

        mBoxes4 = (TextView) findViewById(R.id.boxes4View);
        mBoxes4.setText("Legendary Boxes Opened: " + Integer.toString(boxes4));

        mBackButton = (Button) findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LootBoxActivity.class);
                startActivity(intent);
            }
        });
    }

    public int getItems() {
        int acc = 0;
        for (int i = 1; i < 181; i++) {
            if (mSharedPreferences.getBoolean(Integer.toString(i), false)) {
                acc++;
            }
        }
        return acc;
    }
}
