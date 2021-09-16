package com.example.adress_add_activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASEVERSION = 1;
    public DBHelper(Context context){ super(context, "contactdb", null, DATABASEVERSION);}

    @Override
    public void onCreate(SQLiteDatabase db){
        String tableSql = "create table tb_contact (" +
                "_id integer primary key autoincrement," +
                "name not null,"+
                "phone, "+
                "email)";
        db.execSQL(tableSql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(newVersion==DATABASEVERSION){
            db.execSQL("drop table tb_contact");
            onCreate(db);
        }
    }
}
