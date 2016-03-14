package com.pidly.supportapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.urbanairship.util.DataManager;

import java.sql.SQLException;


public class PushItemDbHelper extends DataManager {
    private SQLiteDatabase mDatabase;

    public static final int DATABSE_VERSION = 1;
    private static final String DATABSE_NAME = "PushInformation.db";

    private static final String TABLE_PUSHDATA = "PUSHDATA";

    private static final String COLUMN_ID = "_ID";
    private static final String COLUMN_RECEIVED_TIME = "RECEIVED_TIME";
    private static final String COLUMN_CREATED_TIME = "CREATED_TIME";
    private static final String COLUMN_PUSH_KIND = "PUSH_KIND";

    private static final String COLUMN_GROUP_ID = "GROUP_ID";
    private static final String COLUMN_ALERT = "ALERT";
    private static final String COLUMN_AUDIENCE = "AUDIENCE";
    private static final String COLUMN_ENDPOINT = "ENDPOINT";

    private static final String DB_CREATE =
            "CREATE TABLE " + TABLE_PUSHDATA + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_RECEIVED_TIME + " INTEGER, " +
                    COLUMN_CREATED_TIME + " INTEGER, " +
                    COLUMN_PUSH_KIND + " TEXT, " +
                    COLUMN_ENDPOINT + " TEXT, " +
                    COLUMN_AUDIENCE + " TEXT, " +
                    COLUMN_ALERT + " TEXT, " +
                    COLUMN_GROUP_ID + " INTEGER" + ")";

    public PushItemDbHelper(Context context) {
        super(context, DATABSE_NAME, DATABSE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
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

    //Database Operations.

    public void open() throws SQLException{
        mDatabase = this.getWritableDatabase();
    }

    public void close(){
        mDatabase.close();
    }

    public void insertPushItem(PushItem item){
        ContentValues values = new ContentValues();
        values.put("kind", item.getKind());
        values.put("endPoint", item.getEndPoint());
        values.put("audience", item.getAudience());
        values.put("alert", item.getAlert());
        values.put("groupingId", item.getGroupingId());
        values.put("pushSent", item.getPushSent());
        values.put("pushReceived", item.getPushReceived());
    }

    public void savePushItem(PushItem pushItem){

    }
}
