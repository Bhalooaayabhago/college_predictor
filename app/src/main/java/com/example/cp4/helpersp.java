package com.example.cp4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class helpersp extends SQLiteOpenHelper
{
    public helpersp(@Nullable Context context) {
        super(context,"Profiler.db",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String statement;
        statement="CREATE TABLE PROFILE (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PACKAGE INTEGER , LINK TEXT , STATE TEXT)";
        db.execSQL(statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    public void add(ctop rat,String st)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("NAME",rat.getCollege());
        cv.put("PACKAGE",Integer.parseInt(rat.getPay()));
        cv.put("LINK",rat.getLink());
        cv.put("STATE",st);
    }

}
