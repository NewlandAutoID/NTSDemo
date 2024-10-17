package com.nlscan.ntsdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WifiHotspotActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mStart = null;
    private Button mStop = null;
    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifihotspot);

        mStart = findViewById(R.id.WifiHotspotStart);
        mStart.setOnClickListener(this);

        mStop = findViewById(R.id.WifiHotspotStop);
        mStop.setOnClickListener(this);

        mContext = this;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.WifiHotspotStart){
            WiFiHotspotStart();
        }else if(v.getId() == R.id.WifiHotspotStop) {
            WiFiHotspotStop();
        }
    }

    /*
    Start Wi-Fi Hotspot
    Broadcast : am broadcast -a com.nlscan.action.backuprecovery -n com.nlscan.nlsbackuprecovery/.receiver.DataReceiver --ez silence true --es set [Json]
    Json: "{"device_setting":[{"hotspot":[{"command":"start","ssid":"NewlandAIDC","password":"88888888","band":1,"channel":6}]}]}"
    [command] : start
    [ssid] : Wi-Fi Hotspot Name
    [password] : Wi-Fi Hotspot Password
    [band] : 2.4G [1] / 5G [2]
    [channel] : 2.4G [1-13] / 5G [Base On CountryCode]
     */
    private void WiFiHotspotStart(){
        String Json = "{\"device_setting\":[{\"hotspot\":[{\"command\":\"start\",\"ssid\":\"NewlandAIDC\",\"password\":\"88888888\",\"band\":1,\"channel\":6}]}]}";

        Intent mIntent = new Intent();
        mIntent.setAction("com.nlscan.action.backuprecovery");
        mIntent.setComponent(new ComponentName("com.nlscan.nlsbackuprecovery","com.nlscan.nlsbackuprecovery.receiver.DataReceiver"));
        mIntent.putExtra("set",Json);
        mIntent.putExtra("silence", true);
        sendBroadcast(mIntent);
    }

    /*
    Stop Wi-Fi Hotspot
    Broadcast : am broadcast -a com.nlscan.action.backuprecovery -n com.nlscan.nlsbackuprecovery/.receiver.DataReceiver --ez silence true --es set [Json]
    Json: "{"device_setting":[{"hotspot":[{"command":"stop"}]}]}"
    [command] : stop
     */
    private void WiFiHotspotStop(){
        String Json = "{\"device_setting\":[{\"hotspot\":[{\"command\":\"stop\"}]}]}";

        Intent mIntent = new Intent("com.nlscan.action.backuprecovery");
        mIntent.setComponent(new ComponentName("com.nlscan.nlsbackuprecovery","com.nlscan.nlsbackuprecovery.receiver.DataReceiver"));
        mIntent.putExtra("set",Json);
        mIntent.putExtra("silence", true);
        sendBroadcast(mIntent);
    }
}
