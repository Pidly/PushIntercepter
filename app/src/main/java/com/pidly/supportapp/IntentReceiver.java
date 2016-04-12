package com.pidly.supportapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.urbanairship.push.BaseIntentReceiver;
import com.urbanairship.push.PushMessage;

import java.util.HashMap;
import java.util.Map;

public class IntentReceiver extends BaseIntentReceiver {
    private static final String TAG = "IntentReceiver";

    private static final String PUSH_INFO_ID = "pushinfo";

    @Override
    protected void onChannelRegistrationSucceeded(Context context, String channelId) {
        Log.i(TAG, "Channel registration updated. Channel Id:" + channelId + ".");
    }

    @Override
    protected void onChannelRegistrationFailed(Context context) {
        Log.i(TAG, "Channel registration failed.");
    }

    @Override
    protected void onPushReceived(Context context, PushMessage message, int notificationId) {
        Log.i(TAG, "Received push notification. Alert: " + message.getAlert() + ". Notification ID: " + notificationId);

        if(message.getPushBundle().containsKey(PUSH_INFO_ID)){

            Intent intent = new Intent(context, PushIntentService.class)
                    .setAction("SAVE_PUSH")
                    .putExtra("PUSH_ITEM", new PushItem(message));


            Log.i(TAG, "Starting service");
            context.startService(intent);



//            PushItem pushItem = new PushItem(message);
        }
    }

    @Override
    protected void onBackgroundPushReceived(Context context, PushMessage message) {
        Log.i(TAG, "Received background push message: " + message);
    }

    @Override
    protected boolean onNotificationOpened(Context context, PushMessage message, int i) {
        Log.i(TAG, "User clicked notification. Alert: " + message.getAlert());

        return false;
    }

    @Override
    protected boolean onNotificationActionOpened(Context context, PushMessage message, int notificationId, String buttonId, boolean isForeground) {
        Log.i(TAG, "User clicked notification button. Button ID: " + buttonId + " Alert: " + message.getAlert());

        return false;
    }
}
