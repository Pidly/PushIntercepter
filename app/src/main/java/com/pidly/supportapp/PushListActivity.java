package com.pidly.supportapp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PushListActivity extends ListActivity {

    private static final String TAG = "PushListActivity";
    //ExpandableListAdapter mListAdapter;
    //ExpandableListView mExpandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    ArrayAdapter listAdapter;
    ListView mListView;

    private TextView text;

    String[] arrayItems;
    private List<String> listValues;

    List<PushItem> mPushItems;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_push_list);

        text = (TextView)findViewById(R.id.mainText);

        prepareListData();

        //ArrayAdapter requires the resource ID to be a TextView
        PushItem[] pushItems = new PushItem[mPushItems.size()];
        pushItems = mPushItems.toArray(pushItems);

        PushItemAdapter pushItemAdapter = new PushItemAdapter(this, pushItems);

        setListAdapter(pushItemAdapter);
        //setListAdapter(new ArrayAdapter<String>(this, R.layout.row_layout, R.id.listText, listValues));
    }

    private void prepareListData() {
        Log.i(TAG, "Preparing list data");

        listValues = new ArrayList<String>();

        PushItemDbHelper dbHelper = new PushItemDbHelper(getApplicationContext());

        try{
            dbHelper.open();
            mPushItems = dbHelper.getAllItems();


            for(PushItem item : mPushItems){
                if(item.getAlert() != null){
                    listValues.add(item.getAudience());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbHelper.close();
        }
        Log.i(TAG, "Closed the DB");

    }
}
