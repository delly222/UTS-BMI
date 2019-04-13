package com.del222.utsproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BMI.db";
    private static final int DATABASE_VERSION = 1;
    static final String TABEL_NAME = "TABLE_BMI";
    static final String COLUMN_TINGGI = "tinggi";
    static final String COLUMN_BERAT = "berat";
    static final String COLUMN_BMI = "BMI";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + TABEL_NAME + "(TINGGI TEXT, BERAT TEXT, BMI TEXT )";

        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABEL_NAME;
        db.execSQL(SQL_DELETE_TABLE);

    }

    public boolean insertData(String tinggi, String berat, String BMI){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TINGGI, tinggi);
        contentValues.put(COLUMN_BERAT, berat);
        contentValues.put(COLUMN_BMI, BMI);

        Long result =  db.insert(TABEL_NAME,null, contentValues);

        if (result == -1){
            return  false;
        } else {
            return true;
        }

    }

    public Cursor getData(){
        SQLiteDatabase db = getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM "+ TABEL_NAME, null);
        return data;

    }







}
