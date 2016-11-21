package com.ningjiahao.phhcomic.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by My on 2016/11/17.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final int VERSION=1;
    public static final String NAME="luka.db";


    public DBHelper(Context context) {


        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE search ( id INTEGER PRIMARY KEY AUTOINCREMENT,content TEXT NOT NULL)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
