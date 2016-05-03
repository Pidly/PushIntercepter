package com.pidly.supportapp;

import android.app.Application;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;

/**
 * Created by devinsmythe on 1/24/16.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate(){
        super.onCreate();

        AirshipConfigOptions options = new AirshipConfigOptions.Builder()
                .setDevelopmentAppKey("6Htn0T9rREm_dIAf1qCqkQ")
                .setDevelopmentAppSecret("LoMXqdx6TleVn9h3SUIuvQ")
                .setProductionAppKey("")
                .setProductionAppSecret("")
                .setInProduction(false)
                .setGcmSender("319839714290")
                .build();

        /*
        App key, secret, gcm sender inside the gradle.properties file
        add gradle.properties to gitignore.

        Platform
        version

        they should never post notifications in android

        look into action frameworks.  I could save DB info using actions.

        rich message actions.
         */
        UAirship.takeOff(this, options, new UAirship.OnReadyCallback() {
            @Override
            public void onAirshipReady(UAirship airship) {
                airship.getPushManager().setUserNotificationsEnabled(true);
            }
        });
    }
}
