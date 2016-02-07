package com.pidly.supportapp;

import android.app.IntentService;
import android.content.Intent;

import com.urbanairship.push.PushMessage;

/**
 * Created by devinsmythe on 2/1/16.
 */
public class PushIntentService extends IntentService {

    public PushIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }

        switch (intent.getAction()) {
            case "SAVE_PUSH":
                onSavePush(intent);
                break;


        }
    }


    private void onSavePush(Intent intent) {
        PushItem item = intent.getParcelableExtra("PUSH_ITEM");

        // save yourself
        

    }
}