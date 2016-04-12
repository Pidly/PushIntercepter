package com.pidly.supportapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.urbanairship.push.PushMessage;

import java.sql.SQLException;


public class PushIntentService extends IntentService {

    private static final String TAG = "PushIntentService";

    public PushIntentService(){
        super("PushIntentService");
    }
    public PushIntentService(String name) {
        super(name);
        Log.i(TAG, "Creating push intent service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            Log.i(TAG, "Intent is null");
            return;
        }

        Log.i(TAG, "Handling Intent");
        switch (intent.getAction()) {
            case "SAVE_PUSH":
                onSavePush(intent);
                break;
        }
    }


    private void onSavePush(Intent intent) {
        Log.i(TAG, "Saving push item");
        PushItem item = intent.getParcelableExtra("PUSH_ITEM");

        // save yourself
        PushItemDbHelper dbHelper = new PushItemDbHelper(getApplicationContext());
        try {
            dbHelper.open();
            //dbHelper.insertPushItem(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbHelper.close();
        }
    }
}
