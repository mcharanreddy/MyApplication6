package com.example.mchar.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mchar on 24-08-2017.
 */

public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student3.sqLiteDatabase";
    public static final String TABLE_NAME = "student_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "ROLLNO";
    public static final String COL4 = "ROLLNO2";


    public databasehelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,ROLLNO INTEGER,ROLLNO2 INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData( String name, String rollno, String rollno2) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL2, name);
        contentvalues.put(COL3, rollno);
        contentvalues.put(COL4, rollno2);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentvalues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor gatalldata() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        return res;

    }
    public boolean update(String id,String name,String rollno,String rollno2){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL1, id);
        contentvalues.put(COL2, name);
        contentvalues.put(COL3, rollno);
        contentvalues.put(COL4, rollno2);
        sqLiteDatabase.update(TABLE_NAME,contentvalues,"ID = ?",new String[] {id} );
        return true;

    }
    public Integer delete(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,"ID=?",new String[] {id});

    }
}




