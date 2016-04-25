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
import clempie.suivistock.model.Category;
import clempie.suivistock.model.Content;
import clempie.suivistock.model.Reference;

public class ReferenceManager {

    public static final String TABLE_NAME = "reference_product";
    public static final String KEY_REFERENCE_ID = "reference_id";
    public static final String KEY_REFERENCE_NAME = "reference_name";
    public static final String KEY_REFERENCE_IMAGE = "reference_image";
    public static final String KEY_REFERENCE_BRAND = "reference_brand";
    public static final String KEY_REFERENCE_CONDITIONING = "reference_conditioning";
    public static final String KEY_REFERENCE_QUANTITY = "reference_quantity";
    public static final String KEY_REFERENCE_WEIGHT = "reference_weight";
    public static final String KEY_REFERENCE_BARCODE = "reference_barcode";
    public static final String KEY_REFERENCE_PRICE = "reference_price";
    public static final String KEY_REFERENCE_CATEGORY = "reference_category";
    public static final String CREATE_TABLE_REFERENCE = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_REFERENCE_ID + " INTEGER primary key," +
            " " + KEY_REFERENCE_NAME + " VARCHAR2(256)," +
            " " + KEY_REFERENCE_IMAGE + " VARCHAR2(256)," +
            " " + KEY_REFERENCE_BRAND + " VARCHAR2(256)," +
            " " + KEY_REFERENCE_CONDITIONING + " VARCHAR2(256)," +
            " " + KEY_REFERENCE_QUANTITY + " INTEGER," +
            " " + KEY_REFERENCE_WEIGHT + " INTEGER," +
            " " + KEY_REFERENCE_BARCODE + " VARCHAR2(256)," +
            " " + KEY_REFERENCE_PRICE + " INTEGER," +
            " " + KEY_REFERENCE_CATEGORY + " INTEGER," +
            " FOREIGN KEY(" + KEY_REFERENCE_CATEGORY + ") REFERENCES " + CategoryManager.TABLE_NAME + "(" + CategoryManager.KEY_CATEGORY_ID + ")" +
            ");";

    private MySQLite mySQLite;
    private SQLiteDatabase db;
    private Context context;

    public ReferenceManager(Context context) {
        mySQLite = MySQLite.getInstance(context);
        this.context = context;
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
        Reference reference = new Reference(0);

        CategoryManager categoryM = new CategoryManager(context);

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_REFERENCE_ID + "=" + id, null);
        if (c.moveToFirst()) {
            reference.setId(c.getInt(c.getColumnIndex(KEY_REFERENCE_ID)));
            reference.setName(c.getString(c.getColumnIndex(KEY_REFERENCE_NAME)));
            reference.setImage(c.getString(c.getColumnIndex(KEY_REFERENCE_IMAGE)));
            reference.setBrand(c.getString(c.getColumnIndex(KEY_REFERENCE_BRAND)));
            reference.setConditioning(c.getString(c.getColumnIndex(KEY_REFERENCE_CONDITIONING)));
            reference.setQuantity(c.getInt(c.getColumnIndex(KEY_REFERENCE_QUANTITY)));
            reference.setWeight(c.getInt(c.getColumnIndex(KEY_REFERENCE_WEIGHT)));
            reference.setBarcode(c.getString(c.getColumnIndex(KEY_REFERENCE_BARCODE)));
            reference.setPrice(c.getInt(c.getColumnIndex(KEY_REFERENCE_PRICE)));
            reference.setCategory(categoryM.getCategory(c.getInt(c.getColumnIndex(KEY_REFERENCE_CATEGORY))));
            c.close();
        }

        return reference;
    }

    public Reference getReference(String name) {
        Category category = new Category(0, "none");
        Reference reference = new Reference(0, "", "", "", "", 1, 0, "", 0, category);



        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_REFERENCE_NAME + "='" + name+"'", null);
        if (c.moveToFirst()) {

            reference.setId(c.getInt(c.getColumnIndex(KEY_REFERENCE_ID)));
            reference.setName(c.getString(c.getColumnIndex(KEY_REFERENCE_NAME)));
            reference.setBarcode(c.getString(c.getColumnIndex(KEY_REFERENCE_BARCODE)));
            reference.setBrand(c.getString(c.getColumnIndex(KEY_REFERENCE_BRAND)));
            reference.setConditioning(c.getString(c.getColumnIndex(KEY_REFERENCE_CONDITIONING)));
            reference.setImage(c.getString(c.getColumnIndex(KEY_REFERENCE_IMAGE)));
            reference.setPrice(c.getInt(c.getColumnIndex(KEY_REFERENCE_PRICE)));
            reference.setWeight(c.getInt(c.getColumnIndex(KEY_REFERENCE_WEIGHT)));
            reference.setQuantity(c.getInt(c.getColumnIndex(KEY_REFERENCE_QUANTITY)));
            //TODO Category
            c.close();
        }

        return reference;
    }

    public ArrayList<Reference> getReferences() {
        ArrayList<Reference> references = new ArrayList<>();
        ReferenceManager referenceM = new ReferenceManager(context);


        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (c.moveToFirst()) {
            while (c.isAfterLast() == false) {
                references.add(getReference(c.getInt(c.getColumnIndex(KEY_REFERENCE_ID))));
                c.moveToNext();
            }
        }

        return references;
    }

    public boolean isReference(String name){
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_REFERENCE_NAME + "='" + name+"'", null);
        if (c.moveToFirst()) {
            return true;
        }
        return false;
    }

    public Cursor getReference() {
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }


}
