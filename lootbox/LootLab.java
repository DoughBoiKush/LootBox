package com.mcs270.lootbox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import com.mcs270.lootbox.database.LootBaseHelper;
import com.mcs270.lootbox.database.LootCursorWrapper;
import com.mcs270.lootbox.database.LootDbSchema.LootTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LootLab {
    private static LootLab sLootLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static LootLab get(Context context){
        if (sLootLab == null){
            sLootLab = new LootLab(context);
        }
        return sLootLab;
    }

    private LootLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new LootBaseHelper(mContext)
                .getWritableDatabase();
    }

    public void addBox(Box box){
        ContentValues values = getContentValues(box);

        mDatabase.insert(LootTable.NAME, null, values);
    }

    public List<Box> getBox(){
        List<Box> box = new ArrayList<>();

        LootCursorWrapper cursor = queryBoxes(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                box.add(cursor.getBox());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return box;
    }

    public Box getBox(UUID id){
        LootCursorWrapper cursor = queryBoxes(
                LootTable.Cols.UUID + " = ?",
                new String[] { id.toString() }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return  cursor.getBox();
        } finally {
            cursor.close();
        }
    }

    public void updateBox(Box box) {
        String uuidString = box.getId().toString();
        ContentValues values = getContentValues(box);

        mDatabase.update(LootTable.NAME, values,
                LootTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    private LootCursorWrapper queryBoxes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                LootTable.NAME,
                null, // columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );

        return  new LootCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Box box) {
        ContentValues values = new ContentValues();
        values.put(LootTable.Cols.UUID, box.getId().toString());
        values.put(LootTable.Cols.TIER, box.getTier());
        values.put(LootTable.Cols.RARITY, box.getRarity());
        values.put(LootTable.Cols.KEPT, box.isKept() ? 1 : 0);
        values.put(LootTable.Cols.PRICE, box.getPrice());

        return values;
    }

}
