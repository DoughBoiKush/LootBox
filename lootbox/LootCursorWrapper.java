package com.mcs270.lootbox;

import android.database.Cursor;
import android.database.CursorWrapper;

public class LootCursorWrapper extends CursorWrapper{

    public LootCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Box getBox() {

    }
}
