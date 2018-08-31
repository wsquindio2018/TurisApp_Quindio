package com.example.worldskills.turisapp.actividades;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.worldskills.turisapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RutaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    String lactitudI;
    String lactitudF;

    String longitudI;
    String longitudF;


    //https://maps.googleapis.com/maps/api/directions/json?origin=parametroLatitud,parametroLongitud&destination=parametroLatitud,parametroLongitud
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        cargarWebServices(lactitudI,longitudI,lactitudF,longitudF);
    }

    private void cargarWebServices(String lactitudI, String longitudI, String lactitudF, String longitudF) {

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
