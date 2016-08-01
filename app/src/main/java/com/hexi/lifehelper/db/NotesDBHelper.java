package com.hexi.lifehelper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by he.xx on 2016/8/1.
 */
public class NotesDBHelper extends SQLiteOpenHelper {
    public NotesDBHelper(Context context) {
        super(context, "lifehelper.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table note(title text,content text,date text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
