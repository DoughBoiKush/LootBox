package com.mcs270.lootbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class game extends AppCompatActivity {
    private int aCounter=0;
    private int bCounter=0;
    private int cCounter=0;
    private int Dcounter=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button box_one= (Button) findViewById(R.id.box_one_button);
        box_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView price_boxes= (TextView) findViewById(R.id.box_one_button);
                price_boxes.setText("500");
                price_boxes.setText(R.string.price);

            }
        });
        Button box_two= (Button) findViewById(R.id.box_two_button);
        box_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            TextView price_boxes= (TextView) findViewById(R.id.box_two_button);
            price_boxes.setText("1000");
            price_boxes.setText(R.string.price);


            }
        });
        Button box_three= (Button) findViewById(R.id.box_three_button);
        box_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView price_boxes= (TextView) findViewById(R.id.box_three_button);
                price_boxes.setText("1500");
                price_boxes.setText(R.string.price);
            }
        });
        Button box_four= (Button) findViewById(R.id.box_four_button);
        box_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView price_boxes= (TextView) findViewById(R.id.box_four_button);
                price_boxes.setText("2000");
                price_boxes.setText(R.string.price);
            }
        });



    }

}
