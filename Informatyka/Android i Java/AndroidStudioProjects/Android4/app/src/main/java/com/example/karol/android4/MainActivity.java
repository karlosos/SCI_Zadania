package com.example.karol.android4;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    private LocationManager service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = (LocationManager) getSystemService(LOCATION_SERVICE);

        if(service.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            LocationListener locationListener = new locationListener();
            service.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);

            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            Toast toast = Toast.makeText(getApplicationContext(), "GPS WLACZONY", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "GPS WYLACZONY", Toast.LENGTH_SHORT);
            toast.show();
        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class locationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {

            Toast.makeText(
                    getBaseContext(),
                    "Location changed: Lat: " + loc.getLatitude() + " Lng: "
                            + loc.getLongitude(), Toast.LENGTH_SHORT).show();
            String longitude = "Longitude: " + loc.getLongitude();

            String location = "http://maps.google.com/maps?saddr="+loc.getLatitude()+","+loc.getLongitude()+"&daddr=53.4307789,14.5550528";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
            startActivity(Intent.createChooser(intent, "Choose browser"));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast toast = Toast.makeText(getApplicationContext(), "GPS WLACZONY", Toast.LENGTH_SHORT);
            toast.show();
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast toast = Toast.makeText(getApplicationContext(), "GPS WYLACZONY", Toast.LENGTH_SHORT);
            toast.show();
        }
    };
}
