package com.example.worldskills.turisapp.actividades;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.entidades.LugaresVo;
import com.example.worldskills.turisapp.entidades.MapasGenerales;
import com.example.worldskills.turisapp.utilidades.Conexion;
import com.example.worldskills.turisapp.utilidades.Utilidades;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class GeneralActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    LugaresVo lugaresVo;
    ArrayList<LugaresVo> listaLugares;
    Conexion conn;
    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        conn = new Conexion(getApplicationContext(), "LUGARES", null, 1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        listaLugares = new ArrayList<>();
        bd = conn.getReadableDatabase();

        Cursor cursor = bd.rawQuery("SELECT * FROM " + Utilidades.NOMBRE_TABLA + " WHERE " + Utilidades.TIPO + " = "+ MapasGenerales.id, null);

        while (cursor.moveToNext()) {
            lugaresVo = new LugaresVo();
            lugaresVo.setNombre(cursor.getString(0));
            lugaresVo.setLatitud(cursor.getString(4));
            lugaresVo.setLongitud(cursor.getString(5));
            listaLugares.add(lugaresVo);
        }
        LatLng sydney=null;

        for (int i = 0; i < listaLugares.size(); i++) {

            sydney = new LatLng(Double.parseDouble(listaLugares.get(i).getLatitud()), Double.parseDouble(listaLugares.get(i).getLongitud()));
            mMap.addMarker(new MarkerOptions().position(sydney).title(listaLugares.get(i).getNombre()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }


        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,MapasGenerales.zoom));
    }
}
