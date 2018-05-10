package com.mcs270.lootbox.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mcs270.lootbox.database.LootDbSchema.LootTable;

    public class LootBaseHelper extends SQLiteOpenHelper {
        private static final int VERSION = 1;
        private static final String DATABASE_NAME = "crime.db";

        public LootBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + LootTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    LootTable.Cols.UUID + ", " +
                    LootTable.Cols.NUM + "," +
                    LootTable.Cols.TIER + ", " +
                    LootTable.Cols.RARITY + ", " +
                    LootTable.Cols.PRICE + ", " +
                    LootTable.Cols.KEPT +
                    ")"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        }
    }
