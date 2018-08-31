package com.example.worldskills.turisapp.actividades;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.entidades.AllFragments;
import com.example.worldskills.turisapp.entidades.LugaresVo;
import com.example.worldskills.turisapp.fragments.CentrosFragment;
import com.example.worldskills.turisapp.utilidades.Conexion;
import com.example.worldskills.turisapp.utilidades.Utilidades;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AllFragments {


    Fragment fragment;
    Conexion conn;
    SQLiteDatabase bd;
    LugaresVo miLugaresVo;
    ArrayList<LugaresVo> list = new ArrayList<>();

    ///Victor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        conn = new Conexion(getApplicationContext(), "LUGARES", null, 1);
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

        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Cerro de Monserrate");
        miLugaresVo.setTipolugar("1");
        miLugaresVo.setDescripcioncorta("El Cerro de Monserrate los espera durante los 365 días del año.");
        miLugaresVo.setUbicacion("Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia");
        miLugaresVo.setDescripcion("El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad. Monserrate tiene una altitud de 3152 m y se ubica sobre la cordillera oriental.1\u200B Los cerros de Bogotá, de origen sedimentario, tienen por lo menos 16 millones de años de antigüedad, con rocas de edad cretácica pertenecientes al Grupo guadalupe, en lo que se refiere al aspecto geológico. Hasta mediados del siglo XVII fue conocido como cerro de Las Nieves. La basílica del Señor de Monserrate ha sido lugar de peregrinación religiosa desde la época colonial y se constituye en un atractivo natural, religioso, gastronómico de la ciudad. Se puede ascender al cerro por el sendero peatonal, por teleférico o por funicular.");
        miLugaresVo.setLatitud("4.6056941");
        miLugaresVo.setLongitud("-74.0642803");

        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setTipolugar("1");
        miLugaresVo.setNombre("Parque Metropolitano Simon Bolivar");
        miLugaresVo.setDescripcioncorta("Área verde urbana con recorridos para caminantes y ciclistas, lago para andar en bote y un área de juego.");
        miLugaresVo.setUbicacion("Av. Calle 53 y Av. Esmeralda s/n, Bogotá, Cundinamarca");
        miLugaresVo.setDescripcion("Este es el más grande e importante de la ciudad por varias razones: su estratégica ubicación en el corazón de Bogotá; sus amplios espacios verdes acompañados de un innumerable número de árboles o por la cantidad y variedad de los escenarios que lo conforman.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Este 'pulmón de la ciudad', que se ha convertido en parte esencial de la vida de los capitalinos, está conformado por:\n" +
                "\n" +
                "- El parque Central Simón Bolívar(Calle 63 y 53 entre carreras 48 y 68)\n" +
                "- El parque Los Novios (o parque El Lago)\n" +
                "- El Complejo Acuático\n" +
                "- El Centro de Alto Rendimiento\n" +
                "- La Cancha Popular de Golf\n" +
                "- La Plaza de los Artesanos\n" +
                "- El Salitre PRD (Recreodeportivo)\n" +
                "- El Museo de los Niños\n" +
                "- La biblioteca Virgilio Barco\n" +
                "- La Unidad Deportiva El Salitre\n" +
                "- El Salitre Mágico\n" +
                "- El Jardín Botánico");
        miLugaresVo.setLatitud("4.6482361");
        miLugaresVo.setLongitud("-74.3009552");
        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setTipolugar("1");
        miLugaresVo.setNombre("Centro Comercial Andino");
        miLugaresVo.setDescripcioncorta("El Centro Comercial Andino es el corazón de una de las zonas preferidas por los bogotanos y extranjeros");
        miLugaresVo.setUbicacion("Cra. 11 #82-71, Bogotá, Cundinamarca");
        miLugaresVo.setDescripcion("El Centro Comercial Andino es el corazón de una de las zonas preferidas por los bogotanos y extranjeros, y es reconocido como el Centro Comercial más exclusivo de la ciudad. \n" +
                "\n" +
                "La privilegiada ubicación, ambiente, comodidad, seguridad, excelente servicio y amplia gama de tiendas reconocidas a nivel nacional e internacional, lo convierten en la mejor opción para sus compras y entretenimiento.\n" +
                "\n" +
                "Cuenta con 230 locales comerciales distribuidos en 4 niveles, 700 parqueaderos ubicados en dos sótanos con valet parking y servicios exclusivos para niños y adultos.");
        miLugaresVo.setLatitud("4.6667313");
        miLugaresVo.setLongitud("-74.0553429");

        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setTipolugar("1");
        miLugaresVo.setNombre("Plaza de Bolivar");
        miLugaresVo.setDescripcioncorta("Centro urbano espacioso rodeado por una catedral y edificios importantes con una arquitectura destacada.");
        miLugaresVo.setUbicacion("Cra. 7 #11-10, Bogotá");
        miLugaresVo.setDescripcion("La Plaza Mayor, como se conocía esta plaza en los inicios de la ciudad, es uno de los lugares más importantes de la ciudad y del país pues es un importante escenario social, cultural y político, alrededor del cual se toman las decisiones más trascendentales para los colombianos y para la historia de Colombia.\n" +
                "\n" +
                "La Plaza Mayor, actualmente conocida como la Plaza de Bolívar en honor a El Libertador, fue fundada casi un año después de la creación de Bogotá,  exactamente el 27 de abril de 1539, por Sebastián de Belalcázar, uno de los más reconocidos personajes españoles de la conquista de América.");
        miLugaresVo.setLatitud("4.5981259");
        miLugaresVo.setLongitud("-74.0782322");

        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setTipolugar("1");
        miLugaresVo.setNombre("Centro Comercial Centro Mayor");
        miLugaresVo.setDescripcioncorta("Centro comercial Centro Mayor\n" +
                "Grandes emociones para todos.\n" +
                "Centro comercial Centro Mayor en Bogotá Cund - Colombia.jpg\n" +
                "Entrada principal del centro comercial.\n" +
                "Ubicación Bandera de Colombia Bogotá, Colombia\n" +
                "Localidad de Antonio Nariño\n" +
                "Coordenadas 4°35′30″N 74°07′26″OCoordenadas: 4°35′30″N 74°07′26″O (mapa)\n" +
                "Dirección Avenida NQS con 38A sur\n" +
                "Apertura 26 de marzo de 2010 (8 años)\n" +
                "Desarrollador Arquitectura & Concreto\n" +
                "Gerencia Ospinas\n" +
                "Propietario Luis Carlos Sarmiento Angulo\n" +
                "Arquitectos Contexto Urbano\n" +
                "Tiendas y servicios 354 tiendas\n" +
                "Superficie total 300.000 m²\n" +
                "Estacionamiento 3.141 espacios\n" +
                "N.º de plantas 3 niveles\n" +
                "Centro Comercial Centro Mayor\n" +
                "[editar datos en Wikidata]\n" +
                "El centro comercial Centro Mayor es un centro comercial ubicado en la localidad de Antonio Nariño, situada al sur de Bogotá");
        miLugaresVo.setUbicacion("Calle 38 A #Sur No. 34D-51, Bogotá");
        miLugaresVo.setDescripcion("El centro comercial cuenta con una disposición especial en su interior. Tiene una temática circense adoptada en su estructura y en su decoración. En cuanto a responsabilidad ambiental, su arquitectura bioclimática aprovecha los recursos climáticos (sol, lluvia, vientos) para disminuir los impactos ambientales y reducir el consumo de energía.4\u200B Cada una de las plazoletas en las que se divide el establecimiento tienen por nombre el de algún personaje circense y tienen en ellas esculturas de más de cuatro metros alusivas a dichos personajes:\n" +
                "\n" +
                "Plaza del Acordeonista\n" +
                "Plaza del Mago\n" +
                "Plaza del Contorsionista\n" +
                "Plaza del Malabarista\n" +
                "Plaza del Equilibrista\n" +
                "Plaza del Payaso\n" +
                "Plaza del Trapecista (Plaza principal)");
        miLugaresVo.setLatitud("4.5926585");
        miLugaresVo.setLongitud("-74.1263605");

        list.add(miLugaresVo);

        registrar();
    }

    private void registrar() {
        bd = conn.getReadableDatabase();
        bd.execSQL(" DELETE  FROM " + Utilidades.NOMBRE_TABLA);
        bd = conn.getReadableDatabase();

        ContentValues values;
        for (int i = 0; i < list.size(); i++) {
            values = new ContentValues();
            values.put(Utilidades.NOMBRE_LUGAR, list.get(i).getNombre());
            values.put(Utilidades.TIPO, list.get(i).getTipolugar());
            values.put(Utilidades.DESCRIPCION_CORTA, list.get(i).getDescripcioncorta());
            values.put(Utilidades.DESCRIPCION_LARGA, list.get(i).getDescripcion());
            values.put(Utilidades.UBICACION, list.get(i).getUbicacion());
            values.put(Utilidades.LATITUD, list.get(i).getLatitud());
            values.put(Utilidades.LONGITUD, list.get(i).getLongitud());

            bd.insert(Utilidades.NOMBRE_TABLA, null, values);
        }
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
            fragment = new CentrosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
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
