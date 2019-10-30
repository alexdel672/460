package com.example.sqlitekino;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseM extends SQLiteOpenHelper {
    public static final String DATA_BASENAME = "MOVIE.DB";
    public static final int DATABASE_VERSION = 5;



    public DatabaseM(Context context){
        super(context, DATA_BASENAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, GENRE TEXT, PRICE TEXT);", NewMovie.info.TABLE_NAME));
        Log.e("DATABASE OPERATIONS", "Table created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ NewMovie.info.TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(String name, String genre, String price){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentData = new ContentValues();
        contentData.put(NewMovie.info.COLUMN02, name);
        contentData.put(NewMovie.info.COLUMN03, genre);
        contentData.put(NewMovie.info.COLUMN04, price);

        long error = db.insert(NewMovie.info.TABLE_NAME, null, contentData);
        if(error == -1){
            Log.e("DATABASE OPERATIONS", "Table INSERT ERROR ...");
            return false; // insert did not succeed
        }
        else {
            Log.e("DATABASE OPERATIONS", "Table INSERT SUCCESS ...");
            return true; // insert succeed
        }

    }
    public Cursor showMovies(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor show = db.rawQuery("select * from " + NewMovie.info.TABLE_NAME, null);
        return show;
    }
}
