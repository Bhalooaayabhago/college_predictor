package com.example.cp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class dtrains extends AppCompatActivity implements LocationListener {
    LocationManager l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtrains);
        if(ContextCompat.checkSelfPermission(dtrains.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(dtrains.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }
        get();
    }
    @SuppressLint("MissingPermission")
    public void get()
    {
        try {
            l1 = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            l1.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, (float) 5.0, dtrains.this);
        }
        catch (Exception e)
        {
            Log.d("err", "ytbhodika");
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        try {
            Geocoder gc=new Geocoder(dtrains.this, Locale.getDefault());
            List<Address> lat=gc.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String pt=lat.get(0).getAddressLine(0);
            TextView tv=findViewById(R.id.test1);
            tv.setText(pt);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {

    }

    @Override
    public void onFlushComplete(int requestCode) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}