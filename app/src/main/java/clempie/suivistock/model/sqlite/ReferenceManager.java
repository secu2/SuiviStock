package clempie.suivistock.model.sqlite;

/**
 * Created by pierrick on 23/03/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import clempie.suivistock.model.Reference;

public class ReferenceManager {

    private static final String TABLE_NAME = "reference";
    public static final String KEY_REFERENCE_ID = "reference_id";
    public static final String KEY_REFERENCE_NAME = "reference_name";
    public static final String KEY_REFERENCE_IMAGE = "reference_image";
    public static final String KEY_REFERENCE_BRAND = "reference_brand";
    public static final String KEY_REFERENCE_CONDITIONING = "reference_conditioning";
    public static final String KEY_REFERENCE_QUANTITY = "reference_name";
    public static final String KEY_REFERENCE_WEIGHT = "reference_name";
    public static final String KEY_REFERENCE_BARCODE = "reference_name";
    public static final String KEY_REFERENCE_PRICE = "reference_name";
    public static final String KEY_REFERENCE_CATEGORY = "reference_category";
    public static final String CREATE_TABLE_REFERENCE = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_REFERENCE_ID + " INTEGER primary key," +
            " " + KEY_REFERENCE_NAME + " VARCHAR2(256)" +
            ");";

    private MySQLite mySQLite;
    private SQLiteDatabase db;

    public ReferenceManager(Context context) {
        mySQLite = MySQLite.getInstance(context);
    }

    public void open() {
        db = mySQLite.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long addReference(Reference reference) {
        ContentValues values = new ContentValues();
        values.put(KEY_REFERENCE_NAME, reference.getName());

        return db.insert(TABLE_NAME, null, values);
    }

    public int modReference(Reference reference) {
        ContentValues values = new ContentValues();
        values.put(KEY_REFERENCE_NAME, reference.getName());

        String where = KEY_REFERENCE_ID + " = ?";
        String[] whereArgs = {reference.getId() + ""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supReference(Reference reference) {
        String where = KEY_REFERENCE_ID + " = ?";
        String[] whereArgs = {reference.getId() + ""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Reference getReference(int id) {
        Reference reference = new Reference(0, "");

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_REFERENCE_ID + "=" + id, null);
        if (c.moveToFirst()) {
            reference.setId(c.getInt(c.getColumnIndex(KEY_REFERENCE_ID)));
            reference.setName(c.getString(c.getColumnIndex(KEY_REFERENCE_NAME)));
            c.close();
        }

        return reference;
    }

    public Cursor getReference() {
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }


}
