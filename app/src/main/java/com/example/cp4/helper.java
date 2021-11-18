package com.example.cp4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class helper extends SQLiteOpenHelper
{
    public helper(@Nullable Context context) {
        super(context,"Colleges.db",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String statement;
        statement="CREATE TABLE PREDICT (ID INTEGER PRIMARY KEY AUTOINCREMENT, BRANCH TEXT, NAME TEXT , CLOSING INTEGER , CATEGORY INTEGER)";
        db.execSQL(statement);
        //read execl
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    public boolean add(tuple top)
    {
        SQLiteDatabase x=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("BRANCH",top.getBranch());
        cv.put("NAME",top.getName());
        cv.put("CLOSING",top.getClosing());
        cv.put("CATEGORY",top.getCategory());
        long insert=x.insert("PREDICT",null,cv);
        if(insert>0)
            return true;
        return false;
    }
    public List<tuple> query(int rank, int val)
    {
        //int val=calCategory(rank,quota,gender);
        int val2=val+1;
        //Map<String,String> dox=new LinkedHashMap<>();
        String query="SELECT * FROM PREDICT WHERE CLOSING>"+rank+" AND (CATEGORY="+val2+" OR CATEGORY="+val+")\nORDER BY CLOSING";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cat=db.rawQuery(query,null);
        List<tuple> go=new ArrayList<>();
        if(cat.moveToFirst())
        {
            do {
                String s1=cat.getString(1);
                String s2=cat.getString(2);
                int id=cat.getInt(0);
                int cut=cat.getInt(3);
                int cate=cat.getInt(4);
                go.add(new tuple(id,cate,cut,s2,s1));
            }while(cat.moveToNext());
        }
        db.close();
        return go;
    }

}