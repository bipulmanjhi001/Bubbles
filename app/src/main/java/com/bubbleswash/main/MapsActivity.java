package com.bubbleswash.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bubbleswash.R;
import com.bubbleswash.database.Address;
import com.bubbleswash.database.DatabaseHandler;
import com.bubbleswash.model.ConnectivityReceiver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity

        implements OnMapReadyCallback,
        LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private static String TAG;
    private static String addressss;
    private static String cityss;
    private static String states;
    private static String countrys;
    Location mLastLocation;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    GoogleMap map;
    Marker marker;
    EditText address1, city, Landmark, Other;
    String addresss, citys, Landmarks, Others;
    Button submit_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        try {
            mapFragment.getMapAsync(this);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        address1 = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);
        Landmark = (EditText) findViewById(R.id.Landmark);
        Other = (EditText) findViewById(R.id.Other);

        submit_order = (Button) findViewById(R.id.submit_order);
        submit_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkConnection();
            }
        });

    }

    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            attemptMap();
        } else {
            message = "connect your internet.";
            color = Color.RED;
            Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    }

    private void attemptMap() {
        addresss = address1.getText().toString();
        citys = city.getText().toString();
        Landmarks = Landmark.getText().toString();
        Others = Other.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(addresss)) {
            address1.setError(getString(R.string.error_field_required));
            focusView = address1;
            cancel = true;
        }
        if (TextUtils.isEmpty(citys)) {
            city.setError(getString(R.string.error_field_required));
            focusView = city;
            cancel = true;
        }
        if (TextUtils.isEmpty(Landmarks)) {
            Landmark.setError(getString(R.string.error_field_required));
            focusView = Landmark;
            cancel = true;
        }
        if (TextUtils.isEmpty(Others)) {
            Other.setError(getString(R.string.error_field_required));
            focusView = Other;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();

        } else {

            DatabaseHandler db = new DatabaseHandler(MapsActivity.this);
            Address address = new Address();
            address.setAddresses(addresss);
            address.setCity(citys);
            address.setLandmark(Landmarks);
            address.setOther(Others);
            db.addAddress(address);

            List<Address> addresses = db.getAllAddress();

            for (Address cn : addresses) {
                String log = "Id: " + cn.getId() + " ,Address: " + cn.getAddresses() + " ,City: " + cn.getCity() + " ,Landmarks: " + cn.getLandmark() + " ,Landmarks: " + cn.getOther();
              //  Log.d("addresses: ", log);
                address1.setText("");
                city.setText("");
                Landmark.setText("");
                Other.setText("");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mGoogleApiClient == null || !mGoogleApiClient.isConnected()) {
            buildGoogleApiClient();
            mGoogleApiClient.connect();
        }
        if (map == null) {
            MapFragment mapFragment = (MapFragment) getFragmentManager()
                    .findFragmentById(R.id.map);
            try {
                mapFragment.getMapAsync(this);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap retMap) {
        map = retMap;
        setUpMap();
    }

    public void setUpMap() {
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        Toast.makeText(this, "Getting Address", Toast.LENGTH_SHORT).show();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        mLocationRequest.setSmallestDisplacement(0.1F);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        //remove previous current location Marker
        if (marker != null){
            marker.remove();
        }
        double dLatitude = mLastLocation.getLatitude();
        double dLongitude = mLastLocation.getLongitude();
        getAddress(getApplicationContext(),dLatitude,dLongitude);
        marker = map.addMarker(new MarkerOptions().position(new LatLng(dLatitude, dLongitude))
                .title(addressss).icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(dLatitude, dLongitude), 15));
        address1.setText(addressss);
        city.setText(cityss);
        Other.setText(states);
    }
    @Override
    public void onBackPressed() {
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        Intent openMain = new Intent(MapsActivity.this, AddressList.class);
        startActivity(openMain);
        finish();
    }
    public static void getAddress(Context context, double LATITUDE, double LONGITUDE) {
        try {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            List<android.location.Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null && addresses.size() > 0) {

                addressss = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                cityss = addresses.get(0).getLocality();
                states = addresses.get(0).getAdminArea();
                countrys = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

               // Log.d(TAG, "getAddress:  postalCode" + postalCode);
              //  Log.d(TAG, "getAddress:  knownName" + knownName);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
    }
