package clempie.suivistock.model.sqlite;

/**
 * Created by pierrick on 30/03/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

import clempie.suivistock.model.Box;
import clempie.suivistock.model.Content;
import clempie.suivistock.model.Reference;
import clempie.suivistock.util.Convert;

public class ContentManager {

    public static final String TABLE_NAME = "content";
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_CONTENT_QUANTITY = "content_quantity";
    public static final String KEY_CONTENT_DATE = "content_date";
    public static final String KEY_CONTENT_BOX = "content_box";
    public static final String KEY_CONTENT_REFERENCE = "content_reference";
    public static final String CREATE_TABLE_CONTENT = "CREATE TABLE " + TABLE_NAME +
            " (" +
            " " + KEY_CONTENT_ID + " INTEGER primary key," +
            " " + KEY_CONTENT_QUANTITY + " INTEGER," +
            " " + KEY_CONTENT_DATE + " DATE," +
            " " + KEY_CONTENT_BOX + " INTEGER," +
            " " + KEY_CONTENT_REFERENCE + " INTEGER," +
            " FOREIGN KEY(" + KEY_CONTENT_BOX + ") REFERENCES " + BoxManager.TABLE_NAME + "(" + BoxManager.KEY_BOX_ID + ")," +
            " FOREIGN KEY(" + KEY_CONTENT_REFERENCE + ") REFERENCES " + ReferenceManager.TABLE_NAME + "(" + ReferenceManager.KEY_REFERENCE_ID + ")," +
            ");";

    private MySQLite mySQLite;
    private SQLiteDatabase db;
    private Context context;

    public ContentManager(Context context) {
        mySQLite = MySQLite.getInstance(context);
        context = context;
    }

    public void open() {
        db = mySQLite.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long addContent(Content content) {
        ContentValues values = new ContentValues();
        values.put(KEY_CONTENT_QUANTITY, content.getQuantity());

        return db.insert(TABLE_NAME, null, values);
    }

    public int modContent(Content content) {
        ContentValues values = new ContentValues();
        values.put(KEY_CONTENT_QUANTITY, content.getQuantity());

        String where = KEY_CONTENT_ID + " = ?";
        String[] whereArgs = {content.getId() + ""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supContent(Content content) {
        String where = KEY_CONTENT_ID + " = ?";
        String[] whereArgs = {content.getId() + ""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Content getContent(int id) {
        Content content = new Content(0, 1, new Date(), new Box(0, ""), new Reference(0, ""));
        BoxManager boxM = new BoxManager(context);
        ReferenceManager referenceM = new ReferenceManager(context);


        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_CONTENT_ID + "=" + id, null);
        if (c.moveToFirst()) {
            content.setId(c.getInt(c.getColumnIndex(KEY_CONTENT_ID)));
            content.setQuantity(c.getInt(c.getColumnIndex(KEY_CONTENT_QUANTITY)));
            content.setBox(boxM.getBox(c.getInt(c.getColumnIndex(KEY_CONTENT_BOX))));
            content.setReference(referenceM.getReference(c.getInt(c.getColumnIndex(KEY_CONTENT_REFERENCE))));
            c.close();
        }

        return content;
    }

    public Cursor getContent() {
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }


}
