package com.navigine.naviginedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess (Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //return single instance
    public static DatabaseAccess getInstance(Context context){
        if (instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //untuk open
    public void open(){
        this.db=openHelper.getReadableDatabase();
    }

    //untuk close
    public void close(){
        if (db!=null){
            this.db.close();
        }
    }

    public String getKoorX(String name){
        c=db.rawQuery("select KoorX from Lantai1 where namaVenue = '"+name+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String KoorX = c.getString(0);
            buffer.append(""+KoorX);
        }
        return buffer.toString();
    }

    public String getKoorY(String name){
        c=db.rawQuery("select KoorY from Lantai1 where namaVenue = '"+name+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String KoorY = c.getString(0);
            buffer.append(""+KoorY);
        }
        return buffer.toString();
    }
}
