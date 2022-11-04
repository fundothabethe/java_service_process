package com.example.java_service;

import static com.example.java_service.Notification.CHANNEL_ID;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class J_service extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Tag" , "Starting Notification...");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new  Notification.Builder(getApplicationContext(), CHANNEL_ID)
                    .setContentTitle("Title")
                    .setContentText("Text...")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .build();
            startForeground(1, notification);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("Tag" , "Service is dead");

    }
    @Override
    public  int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Tag", "Service running creating new thread for the service");
        new Thread(() -> {
            int i = 0;
            while(true){

                try {
                    Thread.sleep(5000);
                    Log.d("Tag" , "service " + i);
                    Log.d("Tag", "Service thread " + Thread.currentThread().getId());
                } catch (InterruptedException e){
                    Log.i("Error", "Fucked Error occured" );
                }
                i++;
            }
        }).start();
        return START_STICKY;
    }
}
