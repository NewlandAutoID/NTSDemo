**[简体中文](./README_zh-cn.md) | English**<br>

# NTSDemo说明

[TOC]

------

| 日期       | 说明        |
| ---------- | ----------- |
| 2024-10-17 | Init Commit |
|            |             |
|            |             |

> This Demo can guide you to use Newland APl mentioned in the Newland Android PDA APl Handbook

## 1、Wi-Fi Hotspot

### 1.1、Open Wi-Fi Hotspot

```java
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
```

### 1.2、Close Wi-Fi Hotspot

```java
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
```



