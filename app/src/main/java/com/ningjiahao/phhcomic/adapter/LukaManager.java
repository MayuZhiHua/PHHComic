package com.ningjiahao.phhcomic.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ningjiahao.phhcomic.helper.DBHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by My on 2016/11/17.
 */

public class LukaManager {

    private SQLiteDatabase sqLiteDatabase;

    private DBHelper dbHelper;


    public LukaManager(Context context){
        dbHelper=new DBHelper(context);

    }

    public Set<String>getHistorySearch(){
        sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from search order by id desc limit 5 offset 0",null);
        int index=cursor.getColumnIndex("content");
        Set<String> list=new HashSet<>();
        while (cursor.moveToNext()){
            list.add(cursor.getString(index));

        }
        cursor.close();
        return list;


    }

    public void insert(String search){

        sqLiteDatabase=dbHelper.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("content",search);
        sqLiteDatabase.insert("search",null,contentValues);
    }



}
