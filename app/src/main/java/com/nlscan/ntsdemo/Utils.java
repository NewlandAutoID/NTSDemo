package com.nlscan.ntsdemo;

import android.util.Log;

public class Utils {
    private static String TAG = "NTSDemo";

    public static void NLogD(String log){
        Log.d(TAG,log);
    }

    public static void NLogI(String log){
        Log.i(TAG,log);
    }

    public static void NLogE(String log){
        Log.e(TAG,log);
    }
}
