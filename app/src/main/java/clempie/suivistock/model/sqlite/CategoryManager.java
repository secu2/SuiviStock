package clempie.suivistock.model.sqlite;

/**
 * Created by pierrick on 30/03/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

import clempie.suivistock.model.Category;

public class CategoryManager {

    public static final String TABLE_NAME = "category";
    public static final String KEY_CATEGORY_ID = "category_id";
    public static final String KEY_CATEGORY_NAME = "category_name";
    public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_CATEGORY_ID + " INTEGER primary key," +
            " " + KEY_CATEGORY_NAME + " VARCHAR2(256)" +
            ");";

    private MySQLite mySQLite;
    private SQLiteDatabase db;

    public CategoryManager(Context context) {
        mySQLite = MySQLite.getInstance(context);
    }

    public void open() {
        db = mySQLite.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long addCategory(Category category) {
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY_NAME, category.getName());

        return db.insert(TABLE_NAME, null, values);
    }

    public int modCategory(Category category) {
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY_NAME, category.getName());

        String where = KEY_CATEGORY_ID + " = ?";
        String[] whereArgs = {category.getId() + ""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supCategory(Category category) {
        String where = KEY_CATEGORY_ID + " = ?";
        String[] whereArgs = {category.getId() + ""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Category getCategory(int id) {
        Category category = new Category(0, "");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_CATEGORY_ID + "=" + id, null);
        if (c.moveToFirst()) {
            category.setId(c.getInt(c.getColumnIndex(KEY_CATEGORY_ID)));
            category.setName(c.getString(c.getColumnIndex(KEY_CATEGORY_NAME)));
            c.close();
        }

        return category;
    }

    public Cursor getCategory() {
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }


}
