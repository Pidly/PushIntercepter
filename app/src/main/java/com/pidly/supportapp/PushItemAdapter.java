package com.pidly.supportapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by devinsmythe on 5/10/16.
 */
public class PushItemAdapter extends BaseAdapter{
    private Context mContext;
    private PushItem[] mPushItems;

    public PushItemAdapter(Context context, PushItem[] pushItems){
        mContext = context;
        mPushItems = pushItems;
    }

    @Override
    public int getCount() {
        return mPushItems.length;
    }

    @Override
    public Object getItem(int position) {
        return mPushItems[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.iconPushReceived = (ImageView)convertView.findViewById(R.id.pushReceivedImage);
            holder.pushTypeLabel = (TextView)convertView.findViewById(R.id.pushType);
            holder.pushTimeReceived = (TextView)convertView.findViewById(R.id.timeReceived);
            holder.pushTimeDelta = (TextView)convertView.findViewById(R.id.pushTimeDelta);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        PushItem pushItem = mPushItems[position];


        return convertView;
    }

    private static class ViewHolder{
        ImageView iconPushReceived;
        TextView pushTypeLabel;
        TextView pushTimeReceived;
        TextView pushTimeDelta;
    }
}
