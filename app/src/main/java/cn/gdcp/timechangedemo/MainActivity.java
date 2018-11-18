package cn.gdcp.timechangedemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements IOnUpdateTime{

    private ListenTime service;
    private TextView tv_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service=new ListenTime(MainActivity.this);
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(service,filter);
        tv_time=(TextView)findViewById(R.id.id_time);
        updateTime();
    }

    public void updateTime(){
        StringBuffer sb=new StringBuffer();
        Calendar c=Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        if(hour<10){
           hour=Integer.parseInt("0"+hour);
        }
        if(minute<10){
            minute=Integer.parseInt("0"+minute);
        }
        sb.append(hour+":"+minute);
        tv_time.setText(sb);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(service);
    }
}
