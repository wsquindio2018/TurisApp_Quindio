package com.example.worldskills.turisapp.actividades;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.entidades.AllFragments;
import com.example.worldskills.turisapp.entidades.LugaresVo;
import com.example.worldskills.turisapp.fragments.SitiosFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,AllFragments{


    Fragment  fragment;
    ///Victor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        registrarSitios();
        registrarHoteles();

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void registrarHoteles() {
    }

    private void registrarSitios() {
        LugaresVo miLugaresVo=new LugaresVo();
        ArrayList <LugaresVo> list=new ArrayList<>();

        miLugaresVo.setNombre("Cerro de Monserrate");
        miLugaresVo.setDescripcioncorta("El Cerro de Monserrate los espera durante los 365 días del año.");
        miLugaresVo.setUbicacion("Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia");
        miLugaresVo.setDescripcion("El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad. Monserrate tiene una altitud de 3152 m y se ubica sobre la cordillera oriental.1\u200B Los cerros de Bogotá, de origen sedimentario, tienen por lo menos 16 millones de años de antigüedad, con rocas de edad cretácica pertenecientes al Grupo guadalupe, en lo que se refiere al aspecto geológico. Hasta mediados del siglo XVII fue conocido como cerro de Las Nieves. La basílica del Señor de Monserrate ha sido lugar de peregrinación religiosa desde la época colonial y se constituye en un atractivo natural, religioso, gastronómico de la ciudad. Se puede ascender al cerro por el sendero peatonal, por teleférico o por funicular.");
        miLugaresVo.setLatitud("4.6056941");
        miLugaresVo.setLongitud("-74.0642803");

        list.add(miLugaresVo);

        miLugaresVo.setNombre("Cerro de Monserrate");
        miLugaresVo.setDescripcioncorta("El Cerro de Monserrate los espera durante los 365 días del año.");
        miLugaresVo.setUbicacion("Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia");
        miLugaresVo.setDescripcion("El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad. Monserrate tiene una altitud de 3152 m y se ubica sobre la cordillera oriental.1\u200B Los cerros de Bogotá, de origen sedimentario, tienen por lo menos 16 millones de años de antigüedad, con rocas de edad cretácica pertenecientes al Grupo guadalupe, en lo que se refiere al aspecto geológico. Hasta mediados del siglo XVII fue conocido como cerro de Las Nieves. La basílica del Señor de Monserrate ha sido lugar de peregrinación religiosa desde la época colonial y se constituye en un atractivo natural, religioso, gastronómico de la ciudad. Se puede ascender al cerro por el sendero peatonal, por teleférico o por funicular.");
        miLugaresVo.setLatitud("4.6056941");
        miLugaresVo.setLongitud("-74.0642803");

        list.add(miLugaresVo);
        miLugaresVo.setNombre("Cerro de Monserrate");
        miLugaresVo.setDescripcioncorta("El Cerro de Monserrate los espera durante los 365 días del año.");
        miLugaresVo.setUbicacion("Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia");
        miLugaresVo.setDescripcion("El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad. Monserrate tiene una altitud de 3152 m y se ubica sobre la cordillera oriental.1\u200B Los cerros de Bogotá, de origen sedimentario, tienen por lo menos 16 millones de años de antigüedad, con rocas de edad cretácica pertenecientes al Grupo guadalupe, en lo que se refiere al aspecto geológico. Hasta mediados del siglo XVII fue conocido como cerro de Las Nieves. La basílica del Señor de Monserrate ha sido lugar de peregrinación religiosa desde la época colonial y se constituye en un atractivo natural, religioso, gastronómico de la ciudad. Se puede ascender al cerro por el sendero peatonal, por teleférico o por funicular.");
        miLugaresVo.setLatitud("4.6056941");
        miLugaresVo.setLongitud("-74.0642803");

        list.add(miLugaresVo);
        miLugaresVo.setNombre("Cerro de Monserrate");
        miLugaresVo.setDescripcioncorta("El Cerro de Monserrate los espera durante los 365 días del año.");
        miLugaresVo.setUbicacion("Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia");
        miLugaresVo.setDescripcion("El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad. Monserrate tiene una altitud de 3152 m y se ubica sobre la cordillera oriental.1\u200B Los cerros de Bogotá, de origen sedimentario, tienen por lo menos 16 millones de años de antigüedad, con rocas de edad cretácica pertenecientes al Grupo guadalupe, en lo que se refiere al aspecto geológico. Hasta mediados del siglo XVII fue conocido como cerro de Las Nieves. La basílica del Señor de Monserrate ha sido lugar de peregrinación religiosa desde la época colonial y se constituye en un atractivo natural, religioso, gastronómico de la ciudad. Se puede ascender al cerro por el sendero peatonal, por teleférico o por funicular.");
        miLugaresVo.setLatitud("4.6056941");
        miLugaresVo.setLongitud("-74.0642803");

        list.add(miLugaresVo);

        miLugaresVo.setNombre("Cerro de Monserrate");
        miLugaresVo.setDescripcioncorta("El Cerro de Monserrate los espera durante los 365 días del año.");
        miLugaresVo.setUbicacion("Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia");
        miLugaresVo.setDescripcion("El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad. Monserrate tiene una altitud de 3152 m y se ubica sobre la cordillera oriental.1\u200B Los cerros de Bogotá, de origen sedimentario, tienen por lo menos 16 millones de años de antigüedad, con rocas de edad cretácica pertenecientes al Grupo guadalupe, en lo que se refiere al aspecto geológico. Hasta mediados del siglo XVII fue conocido como cerro de Las Nieves. La basílica del Señor de Monserrate ha sido lugar de peregrinación religiosa desde la época colonial y se constituye en un atractivo natural, religioso, gastronómico de la ciudad. Se puede ascender al cerro por el sendero peatonal, por teleférico o por funicular.");
        miLugaresVo.setLatitud("4.6056941");
        miLugaresVo.setLongitud("-74.0642803");

        list.add(miLugaresVo);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            fragment = new SitiosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
