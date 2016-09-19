package com.example.termproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class myDB extends SQLiteOpenHelper {
	final private static int DB_VERSION = 1;
    final private static String DB_NAME = "myDB.db";
    
    public static final String TABLE_NAME = "TASKS";
    
    public myDB(Context context, String name, CursorFactory factory, int version) {
            super(context, DB_NAME, factory, DB_VERSION);
            // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    	/* TASK: USER的活動
    	 * TYPE: 1表示參加*/
    	String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( " +
    								"_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            		"TITLE STRING NOT NULL, " +
                            		"DUE STRING NOT NULL, " +
                            		"DATE STRING NOT NULL, " +
                            		"LOCATION STRING NOT NULL, " +
                            		"NEED INTEGER NOT NULL, " +
                            		"TASK STRING NOT NULL, " +
                            		"TYPE INT NOT NULL " + 
                            		");";
    	db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}
