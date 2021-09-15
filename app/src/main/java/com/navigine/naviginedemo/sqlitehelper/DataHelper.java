package com.navigine.naviginedemo.sqlitehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.net.ContentHandler;

public class DataHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "datalokasi.db";
    public static final String TABLE_NAME = "lokasi";
    private static final Integer DATABASE_VERSION = 15;

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
                "posisiy REAL NULL," +
                "venuex REAL NULL," +
                "venuey REAL NULL)" ;

        Log.d("Data", "onCreate: "+sql);
        //db.execSQL(sql);
        String sql2 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy, venuex, venuey ) VALUES (" +
                " '1', 'pintu', " +
                " '94.70', '70.78', " +
                " '2.12', '10.33' )";

        String sql3 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy,  venuex, venuey ) VALUES (" +
                " '2', 'kasir', " +
                " '58.82', '150.53'," +
                " '1.21', '9.19' )";

        String sql4 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy,  venuex, venuey ) VALUES (" +
                " '3', 'beras', " +
                " '26.92', '229.28'," +
                " '7.10', '4.99' )";

        String sql5 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy,  venuex, venuey ) VALUES (" +
                " '4', 'pepsodent', " +
                " '98.69', '201.37'," +
                " '10.54', '6.84' )";

        String sql6 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy,  venuex, venuey ) VALUES (" +
                " '5', 'atm', " +
                " '224.30', '128.60'," +
                " '15.70', '9.12' )";

//        String sql7 = "INSERT INTO " + TABLE_NAME +"  (id, nama, posisix, posisiy,  venuex, venuey ) VALUES (" +
//                " '6', 'kamar mandi 3', " +
//                " '1009', '1458'," +
//                " '15.31', '0.85' )";

        String[] statements = new String[]{sql, sql2, sql3, sql4, sql5, sql6};
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


