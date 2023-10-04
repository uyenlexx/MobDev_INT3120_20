package com.example.slide11_2;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyBackgroundService extends Service {
    //IBinder is an interface that describes the communication channel between the service and the client
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId) {
        Toast.makeText(this,"Service Started", Toast.LENGTH_LONG).show();
        CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.e("CountDown", "CountDown: " + millisUntilFinished / 1000);
            }
            @Override
            public void onFinish() {
                Log.e("CountDown", "CountDown: Finished");
            }
        }.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service Stopped", Toast.LENGTH_LONG).show();
    }
}
