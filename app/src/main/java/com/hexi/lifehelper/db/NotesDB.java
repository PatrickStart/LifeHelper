package com.hexi.lifehelper.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hexi.lifehelper.note.NotesEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by he.xx on 2016/8/1.
 */
public class NotesDB {
    Context mC;
    SQLiteDatabase db;

    public NotesDB(Context mC) {
        this.mC = mC;
        NotesDBHelper helper = new NotesDBHelper(mC);
        db = helper.getReadableDatabase();
    }

    /**
     * 添加标签
     * @param entity
     */
    public void addNote(NotesEntity entity){
        ContentValues values = new ContentValues();
        values.put("title",entity.getTitle());
        values.put("content",entity.getContent());
        values.put("date",entity.getDate());
        db.insert("note",null,values);
    }

    /**
     * 查询所有已保存标签
     */
    public List<NotesEntity> getAllTag(){
        List<NotesEntity> list = new ArrayList<NotesEntity>();
        NotesEntity entity = null;
        Cursor cursor = db.rawQuery("select * from note",null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                entity = new NotesEntity(title, date, content);
                list.add(entity);
            }
        }
        return list;
    }



    /**
     * 通过标签名字删除
     */
    public void delete(String date) {
        db.delete("note", "date = ?", new String[]{date});
    }
}
