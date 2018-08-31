package com.example.worldskills.turisapp.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.entidades.MapasGenerales;

public class DetalleActivity extends AppCompatActivity {

    ImageView img;
    TextView nombre,detalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(),CalcularRutaActivity.class);
                startActivity(intent);
            }
        });

        nombre=findViewById(R.id.nombreDetalle);
        detalle=findViewById(R.id.campoDescripcionLarga);
        img=findViewById(R.id.imgDetalle);

        nombre.setText(" "+ MapasGenerales.nombre);
        detalle.setText(" "+ MapasGenerales.Descripcion);
        img.setImageDrawable(MapasGenerales.lista.get(MapasGenerales.img));
    }

}
