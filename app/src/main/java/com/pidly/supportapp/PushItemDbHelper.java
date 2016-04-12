package com.pidly.supportapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.urbanairship.util.DataManager;

import java.sql.SQLException;
import java.util.Locale;


public class PushItemDbHelper extends DataManager {
    private SQLiteDatabase mDatabase;

    private static final String TAG = "PushItemDbHelper";

    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PushInformation.db";

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
        super(context, DATABASE_NAME, DATABASE_VERSION);
        Log.i(TAG, "Creating DB");
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
        Log.i(TAG, "Opening DB");
        mDatabase = this.getWritableDatabase();
    }

    public void close(){
        mDatabase.close();
    }

    public void insertPushItem(PushItem item){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PUSH_KIND, item.getKind());
        values.put(COLUMN_ENDPOINT, item.getEndPoint());
        values.put(COLUMN_AUDIENCE, item.getAudience());
        values.put(COLUMN_ALERT, item.getAlert());
        values.put(COLUMN_GROUP_ID, item.getGroupingId());
        values.put(COLUMN_CREATED_TIME, item.getPushSentDateString());
        values.put(COLUMN_RECEIVED_TIME, item.getPushReceivedDateString());

        Log.i(TAG, "Inserting data into DB");

        Log.i(TAG, "kind: " + item.getKind() + " endpoint: " + item.getEndPoint() + " audience: " + item.getAudience() +
                " alert: " + item.getAlert() + " groupingId: " + item.getGroupingId() + " pushSent " + item.getPushSentDateString() +
                " pushReceived: " + item.getPushReceivedDateString());

        mDatabase.insert(PushItemDbHelper.TABLE_PUSHDATA, null, values);
    }

    public void savePushItem(PushItem pushItem){

    }
}
