package com.example.java_service;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notification extends Application {
    public static final String CHANNEL_ID =  "notification";
    @Override
    public void onCreate() {
            super.onCreate();
        create_notification_channel();
    }
    private void create_notification_channel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new  NotificationChannel(CHANNEL_ID, "HEARTBEAT", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("CHANNEL DESCRIPTION");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
