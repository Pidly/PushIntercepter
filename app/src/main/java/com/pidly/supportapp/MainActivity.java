package com.pidly.supportapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.urbanairship.UAirship;


public class MainActivity extends ActionBarActivity {
    Button preferencesButton;
    Button listView;
    Button messageCenterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesButton = (Button)findViewById(R.id.preferencesButton);
        preferencesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, PreferencesActivity.class);
                //startActivity(intent);

                /*
                Lib version 7.0 is changing how they handle preferences so going to hold off on doing this part until the next lib version is out.
                 */
            }
        });

        listView = (Button)findViewById(R.id.listActivityButton);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PushListActivity.class);
                startActivity(intent);
            }
        });

        messageCenterButton = (Button)findViewById(R.id.messageCenterButton);
        messageCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UAirship.shared().getInbox().startInboxActivity();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
