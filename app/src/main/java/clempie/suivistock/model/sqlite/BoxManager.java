package clempie.suivistock.model.sqlite;

/**
 * Created by pierrick on 23/03/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import clempie.suivistock.model.Box;

public class BoxManager {

    public static final String TABLE_NAME = "box";
    public static final String KEY_BOX_ID = "box_id";
    public static final String KEY_BOX_NAME = "box_name";
    public static final String CREATE_TABLE_BOX = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_BOX_ID + " INTEGER primary key," +
            " " + KEY_BOX_NAME + " VARCHAR2(256)" +
            ");";

    private MySQLite mySQLite;
    private SQLiteDatabase db;

    public BoxManager(Context context) {
        mySQLite = MySQLite.getInstance(context);
    }



    public void open() {
        db = mySQLite.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long addBox(Box box) {
        ContentValues values = new ContentValues();
        values.put(KEY_BOX_NAME, box.getName());

        return db.insert(TABLE_NAME, null, values);
    }

    public int modBox(Box box) {
        ContentValues values = new ContentValues();
        values.put(KEY_BOX_NAME, box.getName());

        String where = KEY_BOX_ID + " = ?";
        String[] whereArgs = {box.getId() + ""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supBox(Box box) {
        String where = KEY_BOX_ID + " = ?";
        String[] whereArgs = {box.getId() + ""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Box getBox(int id) {
        Box box = new Box(0, "");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_BOX_ID + "=" + id, null);
        if (c.moveToFirst()) {
            box.setId(c.getInt(c.getColumnIndex(KEY_BOX_ID)));
            box.setName(c.getString(c.getColumnIndex(KEY_BOX_NAME)));
            c.close();
        }

        return box;
    }

    public Box getBox(String name) {
        Box box = new Box(0, "");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_BOX_NAME + "='" + name+"'", null);
        if (c.moveToFirst()) {
            box.setId(c.getInt(c.getColumnIndex(KEY_BOX_ID)));
            box.setName(c.getString(c.getColumnIndex(KEY_BOX_NAME)));
            c.close();
        }

        return box;
    }

    public ArrayList<Box> getBox() {
        ArrayList<Box> res = new ArrayList<Box>();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);

        if (cursor .moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                res.add(getBox(cursor.getInt(cursor.getColumnIndex(KEY_BOX_ID))));
                cursor.moveToNext();
            }
        }

        res.add(new Box(999999999, "Nouvelle box"));
        return res;
    }

    public int count(){
        Cursor mCount= db.rawQuery("SELECT COUNT() FROM " + TABLE_NAME, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;
    }




}
