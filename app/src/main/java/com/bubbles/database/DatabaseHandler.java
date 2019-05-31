package com.bubbles.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "addressManager";
    private static final String TABLE_ADDRESS = "address";
    private static final String KEY_ID = "id";
    private static final String KEY_ADDRESSES = "addresss";
    private static final String KEY_CITY = "city";
    private static final String KEY_LANDMARK = "landmark";
    private static final String KEY_OTHER = "other";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ADDRESS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ADDRESSES + " TEXT," + KEY_CITY + " TEXT," + KEY_LANDMARK + " TEXT,"
                + KEY_OTHER + " TEXT" + ")";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESS);
        onCreate(db);
    }

    public void addAddress(Address address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ADDRESSES, address.getAddresses());
        values.put(KEY_CITY, address.getCity());
        values.put(KEY_LANDMARK, address.getLandmark());
        values.put(KEY_OTHER, address.getOther());
        db.insert(TABLE_ADDRESS, null, values);
        db.close();
    }

    public List<Address> getAllAddress() {
        List<Address> contactList = new ArrayList<Address>();
        String selectQuery = "SELECT  * FROM " + TABLE_ADDRESS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Address address = new Address();
                address.setId(Integer.parseInt(cursor.getString(0)));
                address.setAddresses(cursor.getString(1));
                address.setCity(cursor.getString(2));
                address.setLandmark(cursor.getString(3));
                address.setOther(cursor.getString(4));
                contactList.add(address);
            } while (cursor.moveToNext());
        }

        return contactList;
    }

    // Deleting single contact
    public void deleteContact(Address address) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ADDRESS, KEY_ID + " = ?",
                new String[]{String.valueOf(address.getId())});
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ADDRESS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}

