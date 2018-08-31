package com.example.worldskills.turisapp.actividades;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.worldskills.turisapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RutaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    String lactitudI = "4.611758";
    String lactitudF = "-74.01124";
    String longitudI = "4.672065";
    String longitudF = "-74.05126";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        request = Volley.newRequestQueue(getApplicationContext());
        setContentView(R.layout.activity_ruta);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        cargarWebServices(lactitudI, longitudI, lactitudF, longitudF);
    }

    private void cargarWebServices(String lactitudI, String longitudI, String lactitudF, String longitudF) {

        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + lactitudI + "," + longitudI + "&destination=" + lactitudF + "," + longitudF;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                cargarPuntos(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.add(jsonObjectRequest);
    }

    private List cargarPuntos(JSONObject json) {
        String polyline = "";
        List lista = new ArrayList();
        JSONArray jRoutes, jLegs, jSteps;

        try {
            jRoutes = json.getJSONArray("routes");
            for (int i = 0; i < jRoutes.length(); i++) {
                jLegs = ((JSONObject) (jRoutes.get(i))).getJSONArray("legs");
                for (int j = 0; j < jLegs.length(); j++) {
                    jSteps = ((JSONObject) (jLegs.get(j))).getJSONArray("steps");
                    for (int k = 0; k < jSteps.length(); k++) {
                        polyline = "" + ((JSONObject) ((JSONObject) jSteps.get(k)).get("polyline")).get("points");
                        List<LatLng> list = PolyUtil.decode(polyline);
                        mMap.addPolyline(new PolylineOptions().addAll(list).color(Color.GREEN));
                    }
                }
            }
            ///2B:DD:A5:08:A8:A1:98:81:04:B9:59:51:46:0B:87:F2:A9:E9:C4:11;com.example.worldskills.turisapp
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
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
    }
}
