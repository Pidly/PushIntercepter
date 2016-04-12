package com.pidly.supportapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.urbanairship.push.PushMessage;

import java.util.Date;
import java.util.Map;


public class PushItem implements Parcelable {
    private String kind;
    private String endPoint;
    private String audience;
    private String alert;

    private String groupingId;

    private String pushSentDateString;
    private String pushReceivedDateString;

    private int pushReceived;
    private int pushSent;

    public PushItem(Map<String, String> pushInfo){
        kind = pushInfo.get("kind");
        endPoint = pushInfo.get("endPoint");
        audience = pushInfo.get("audience");
        alert = pushInfo.get("alert");
        groupingId = pushInfo.get("groupingId");

        pushSent = Integer.parseInt(pushInfo.get("pushSent"));
        pushReceived = Integer.parseInt(pushInfo.get("pushReceived"));

        pushSentDateString = pushInfo.get("pushSent");
        pushReceivedDateString = pushInfo.get("pushReceived");

        //Convert the strings into dates
    }

    public PushItem(PushMessage message){
        kind = (String)message.getPushBundle().get("kind");
        endPoint = (String)message.getPushBundle().get("endPoint");
        audience = (String)message.getPushBundle().get("audience");
        alert = message.getAlert();
        pushSentDateString = (String)message.getPushBundle().get("pushSent");
        pushReceivedDateString = "Received date time";
    }



    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getAlert() {
        return alert;
    }

    public void setGroupingId(String groupingId){
        this.groupingId = groupingId;
    }

    public String getGroupingId(){
        return groupingId;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public int getPushReceived() {
        return pushReceived;
    }

    public void setPushReceived(int pushReceived) {
        this.pushReceived = pushReceived;
    }

    public int getPushSent() {
        return pushSent;
    }

    public String getPushSentDateString(){
        return pushSentDateString;
    }

    public String getPushReceivedDateString(){
        return pushReceivedDateString;
    }

    public void setPushSent(int pushSent) {
        this.pushSent = pushSent;
    }


    public static final Creator<PushItem> CREATOR = new Creator<PushItem>() {
        @Override
        public PushItem createFromParcel(Parcel in) {
            return new PushItem(in);
        }

        @Override
        public PushItem[] newArray(int size) {
            return new PushItem[size];
        }
    };

    protected PushItem(Parcel in) {
        kind = in.readString();
        endPoint = in.readString();
        audience = in.readString();
        alert = in.readString();
        groupingId = in.readString();
        pushSent = in.readInt();
        pushReceived = in.readInt();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kind);
        dest.writeString(endPoint);
        dest.writeString(audience);
        dest.writeString(alert);
        dest.writeString(groupingId);
        dest.writeInt(pushSent);
        dest.writeInt(pushReceived);
    }
}
