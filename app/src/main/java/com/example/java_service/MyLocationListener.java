package com.example.java_service;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyLocationListener implements LocationListener {


    @Override
    public void onLocationChanged(Location location) {
        Log.d("Tag" , String.valueOf(location.getLongitude()));
        Log.d("Tag" , String.valueOf(location.getLongitude()));
    }
    public void get_current_location(){


    }
}