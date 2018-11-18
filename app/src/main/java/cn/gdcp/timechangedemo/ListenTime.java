package cn.gdcp.timechangedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by acer on 2018/11/18.
 */

public class ListenTime extends BroadcastReceiver {
    private IOnUpdateTime updateTime;
    public ListenTime(IOnUpdateTime updateTime){
        this.updateTime=updateTime;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("京东家电节","Intent.ACTION_TIME_TICK");
        String action=intent.getAction();
        if(action.equals(Intent.ACTION_TIME_TICK)){
            updateTime.updateTime();
            Log.e("京东家电节","Intent.ACTION_TIME_TICK");
        }
    }
}
