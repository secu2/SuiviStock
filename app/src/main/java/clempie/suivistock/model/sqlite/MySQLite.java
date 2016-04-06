package clempie.suivistock.model.sqlite;

/**
 * Created by pierrick on 23/03/16.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import clempie.suivistock.model.Content;

public class MySQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db.suivistock";
    private static final int DATABASE_VERSION = 4;
    private static MySQLite sInstance;

    public static synchronized MySQLite getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MySQLite(context);
        }
        return sInstance;
    }

    private MySQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BoxManager.CREATE_TABLE_BOX);
        sqLiteDatabase.execSQL(CategoryManager.CREATE_TABLE_CATEGORY);
        sqLiteDatabase.execSQL(ReferenceManager.CREATE_TABLE_REFERENCE);
        sqLiteDatabase.execSQL(ContentManager.CREATE_TABLE_CONTENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        onCreate(sqLiteDatabase);
    }

}
