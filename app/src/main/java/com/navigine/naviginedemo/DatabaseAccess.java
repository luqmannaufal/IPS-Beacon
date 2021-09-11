package com.navigine.naviginedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //return single instance
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //untuk open
    public void open() {
        this.db = openHelper.getReadableDatabase();
    }

    //untuk close
    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

//    public List getKoorXY(String suara) {
//        c = db.rawQuery("select KoorX, KoorY from Lantai1 where namaVenue = '" + suara + "'", new String[]{});
//        List KoorXYs = new ArrayList<>();
//        Float KoorXY = c.getFloat(c.getColumnIndexOrThrow("idVenue"));
//        KoorXYs.add(0, KoorXY);
//        KoorXYs.add(1, KoorXY);
//        KoorXYs.add(c.getFloat(0));
//        KoorXYs.add(c.getFloat(1));
//        Float KoorXY = c.getFloat(0);
//        while (c.moveToNext()) {
//            Float KoorXY = c.getFloat(0);
//            KoorXYs.add(KoorXY);
//        }

//        return null;
//        c.close();
//    }
//}

//        StringBuffer buffer = new StringBuffer();
//        while (c.moveToNext()){
//            Float KoorX = c.getFloat(0);
//            Float KoorY = c.getFloat(1);
//            buffer.append(""+KoorX);
//            buffer.append(""+KoorY);
//        }
//        return null;


    public double getKoorY(String suara){
//        String query= "SELECT idVenue, namaVenue, KoorX, KoorY FROM Lantai1 WHERE namaVenue = ?";
//        String[] selectionArgs = {"suara"};
//        c=db.rawQuery(String.valueOf(query), selectionArgs );
//        List KoorYs = new ArrayList<>();
        c=db.rawQuery("select idVenue from Lantai1 where namaVenue = '"+suara+"'",new String[]{} );
        List KoorYs = new ArrayList<>();
        while (c.moveToFirst()){
            double KoorY = c.getDouble(c.getColumnIndex("KoorY"));
            KoorYs.add(KoorY);
        }
        return 1;
    }

    public double getKoorX(String suara){
//        String query= "SELECT idVenue, namaVenue, KoorX, KoorY FROM Lantai1 WHERE namaVenue = ?";
//        String[] selectionArgs = {"suara"};
//        c=db.rawQuery(Double.valueOf(query), selectionArgs );
//        List KoorXs = new ArrayList<>();
        c=db.rawQuery("select idVenue from Lantai1 where namaVenue = '"+suara+"'", new String[]{});
        List KoorXs = new ArrayList<>();
        while (c.moveToFirst()){
            double KoorX = c.getDouble(c.getColumnIndex("KoorX"));
            KoorXs.add(KoorX);
        }
        return 1;
    }
}
