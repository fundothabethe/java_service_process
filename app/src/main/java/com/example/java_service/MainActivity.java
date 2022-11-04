package com.example.java_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public Intent service_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service_intent = new Intent(getApplicationContext(), J_service.class);
        Log.d("Tag", "Main thread " + Thread.currentThread().getId());
    }

    public void btn_click(View v) {
        String name = String.valueOf(v.getId());
        EditText text = findViewById(R.id.top_text);
//        if (v.getId() == R.id.start_service) startService(service_intent);
        if (v.getId() == R.id.start_service) getLocation();

        if (v.getId() == R.id.stop_service) stopService(service_intent);
    }

    public String getLocation() {
        // Get the location manager
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        Double lat = 0.0 ,lon = 0.0;
        String bestProvider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        try {
            Location location = locationManager.getLastKnownLocation(bestProvider);
                lat = location.getLatitude ();
            lon = location.getLongitude ();
            Toast.makeText(this,""+lat.toString()+"-"+lon.toString(),Toast.LENGTH_SHORT).show();
        }
        catch (NullPointerException e){
            Toast.makeText(this,"HELL-NO",Toast.LENGTH_SHORT).show();
            Log.w("HELL-NO","n",e);
            e.printStackTrace();
        }
        }
        return "Longitude" + lat.toString() + "longitude " + lon.toString();
    }
}