package com.pidly.supportapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.urbanairship.util.DataManager;

/**
 * Created by devinsmythe on 1/31/16.
 */
public class PushItemDbHelper extends DataManager {
    public static final int DATABSE_VERSION = 1;
    public static final String DATABSE_NAME = "PushInformation.db";

    public PushItemDbHelper(Context context) {
        super(context, DATABSE_NAME, DATABSE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    protected void bindValuesToSqliteStatement(SQLiteStatement sqLiteStatement, ContentValues contentValues) {

    }

    @Override
    protected SQLiteStatement getInsertStatement(String s, SQLiteDatabase sqLiteDatabase) {
        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
