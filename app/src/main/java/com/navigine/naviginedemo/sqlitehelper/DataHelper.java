package com.navigine.naviginedemo.sqlitehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.net.ContentHandler;

public class DataHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "datalokasi.db";
    public static final String TABLE_NAME = "lokasi";
    private static final Integer DATABASE_VERSION = 4;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private static final String SQL_DELETE_LOKASI =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE " + TABLE_NAME +" (" +
                "id INTEGER PRIMARY KEY, " +
                "nama TEXT NULL, " +
                "posisix REAL NULL," +
                "posisiy REAL NULL)" ;

        Log.d("Data", "onCreate: "+sql);
        //db.execSQL(sql);
        String sql2 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy ) VALUES (" +
                        " '1', 'Kamar Bagus', " +
                        " '243', '1056' )";

        String sql3 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy ) VALUES (" +
                " '2', 'pagar', " +
                " '102', '841' )";

        String sql4 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy ) VALUES (" +
                " '3', 'kamar aku', " +
                " '826', '1156' )";

        String sql5 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy ) VALUES (" +
                " '4', 'kamar mandi 1', " +
                " '977', '1018' )";

        String sql6 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy ) VALUES (" +
                " '5', 'kamar mandi 2', " +
                " '950', '1271' )";

        String sql7 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy ) VALUES (" +
                " '6', 'kamar mandi 3', " +
                " '1009', '1458' )";

        String[] statements = new String[]{sql, sql2, sql3, sql4, sql5, sql6, sql7};
        // use something like StringTokenizer to separate sql statements
        for(String sqlExec : statements){
            db.execSQL(sqlExec);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_LOKASI);
        onCreate(db);
    }

}


