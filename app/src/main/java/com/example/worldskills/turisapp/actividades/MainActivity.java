package com.example.worldskills.turisapp.actividades;

import android.content.ContentValues;
import android.content.Intent;
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
import com.example.worldskills.turisapp.entidades.Puente;
import com.example.worldskills.turisapp.fragments.CentrosFragment;
import com.example.worldskills.turisapp.fragments.HotelesFragment;
import com.example.worldskills.turisapp.fragments.PirncipalFragment;
import com.example.worldskills.turisapp.fragments.RestaurantesFragment;
import com.example.worldskills.turisapp.utilidades.Conexion;
import com.example.worldskills.turisapp.utilidades.Utilidades;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AllFragments,Puente {


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
        registrasRestaurantes();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment = new PirncipalFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenido, fragment).commit();
    }

    private void registrasRestaurantes() {
        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Juana La Loca");
        miLugaresVo.setTipolugar("3");
        miLugaresVo.setDescripcioncorta("Buenos cocteles, agradable grupos");
        miLugaresVo.setUbicacion("Calle 90 # 11-13, Bogotá");
        miLugaresVo.setDescripcion(" Del primer menú de Juana La Loca quedan pocos platillos. Los chicharrones de cochinillo con lima y jalapeño son de los pocos que sobreviven a ese difícil comienzo, hace dos años. De ese momento quedarán otros cinco platos, como clásicos de siempre –dice Rafael Londoño, al frente de la marca–. Pero, pasados unos ocho meses de funcionamiento empezamos el proceso de reformar la carta”.\n" +
                "Londoño recuerda que se estrenó en el mundo de los restaurantes con Juana la Loca, cuando se asoció con el grupo Tragaluz de Barcelona. Pero no fue tan sencillo traer las cosas que eran exitosas en la ciudad catalana a Bogotá.");
        miLugaresVo.setLatitud("4.672065");
        miLugaresVo.setLongitud("-74.05126");
        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("La fragata Giratoria");
        miLugaresVo.setTipolugar("3");
        miLugaresVo.setDescripcioncorta("El Restaurante La Fragata Giratorio es un sitio en donde se puede degustar comida de excelencia a base de productos marinos.");
        miLugaresVo.setUbicacion("Calle 100 # 8A-55 Piso 12. W.T.C");
        miLugaresVo.setDescripcion("El Restaurante La Fragata Giratorio es un sitio en donde se puede degustar comida de excelencia a base de productos marinos. Su calidad está garantizada con una tradición de más de cuarenta años en otras ciudades de Colombia. Desde el espacioso y sofisticado local, se alcanza una vista única del norte capitalino y sus cerros, lugar ideal para compartir con la familia, amigos o pasar el rato en solitario. En su carta se destaca el famoso plato Langostino Fragata, acompañado de arroz con coco, plátano gratinado y una salsa exclusiva de la casa. Otras de sus creaciones son el seviche costeño, el seviche peruano, los rollos de anguila y el más completo de todos. langosta 3 sabores. La opción de entrante más solicitada es la sopa caldereta de cangrejos y, para el postre, se ofrecen opciones ligeras, como el postre de natas y la torta de café. La oferta del menú infantil da la oportunidad de reunirse para festejos de todo tipo. Además del comedor, cuenta con un café y una barra de sushi. En el restaurante se celebran festivales de comida nacional e internacional a los que asisten cocineros y chefs extranjeros, y en los que se presentan recetas que enriquecen el menú de La Fragata Giratorio todos los años.");
        miLugaresVo.setLatitud("4.6810056");
        miLugaresVo.setLongitud("-74.04333");
        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Criterion");
        miLugaresVo.setTipolugar("3");
        miLugaresVo.setDescripcioncorta("Criterion es el primer restaurante de alta cocina de los hermanos Rausch y su taller creativo");
        miLugaresVo.setUbicacion("Calle 69A # 5-75");
        miLugaresVo.setDescripcion("Criterion es el primer restaurante de alta cocina de los hermanos Rausch y su taller creativo. \n" +
                " Ofrecen una cocina de autor moderna y sofisticada, utilizando en la mayoría de sus preparaciones productos locales y reinventando recetas tradicionales de la gastronomía colombiana que podemos encontrar en el menú, como la posta negra cartagenera, el merengón de guanábana o chimichurri chontaduro en magret de pato. \n" +
                " Además de los platos de la carta, Criterión ofrece la oportunidad de disfrutar el menú degustación, un concepto que precisamente llevaron los hermanos Rausch a Colombia y trata de la experiencia completa del restaurante a través de diferentes y variados platos, inspirados en satisfacer su apetito. \n" +
                " Su lema “El producto final nunca puede ser mejor que su materia prima”, deja claro el trabajo y la dedicación que los hermanos Raush ponen en cada una de sus creaciones. ");
        miLugaresVo.setLatitud("4.6517161");
        miLugaresVo.setLongitud("-74.058187");
        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Tramonti");
        miLugaresVo.setTipolugar("3");
        miLugaresVo.setDescripcioncorta("Entre montañas y bosques naturales desde donde se observa una de las mejores vista de Bogotá, se encuentra este chalet que tiene 25 años de tradición");
        miLugaresVo.setUbicacion("Carrera 1ra N° 93-50");
        miLugaresVo.setDescripcion("Entre montañas y bosques naturales desde donde se observa una de las mejores vista de Bogotá, se encuentra este chalet que tiene 25 años de tradición y que ofrece cocina mediterránea con carnes y pastas.\n" +
                " Tramonti es un lugar para no olvidar, único, romántico, ideal no sólo para almorzar o cenar, sino con el ambiente para realizar todo tipo de celebraciones, que sin duda serán memorables. Algunas de las entradas frías, son tonno sardegna, selezione di antipasti, carpaccio di manzo, carpaccio di salmone e tonno, selezione di tapas di spagna, trio di ceviche. como entradas calientes hay calamari fritti e tapenade, funghi all´aglio, crostino di gamberetti e feta, cuore di palma con gamberetti e curry, entre otras. Las oferta de ensaladas contiene insalata vito d´asio, insalata greca, insalata dell´ angello, insalata montana, entre otras.\n" +
                " Si la chimenea que tiene el restaurante no basta para contrarrestar el frío de los cerros orientales, la propuesta de sopas incluye zuppa di cipolle alla francese, zuppa di cipolle e sfoglia di funghi, zuppa di pomodoro alla griglia, minestrone classico.\n" +
                " La elegancia del lugar no es obstáculo para encontrar opciones más informales y típicas de otras regiones como la tortilla española, el chori pan, el queso manchego y las empanadas argentinas, entre otros, como opciones para picar.\n" +
                " Para los amantes de la carne, podrán disfrutar de excelentes cortes como punta de anca (400 gms), filet mignon, baby beef (400 gms), lombata tramonti con roquefort, costola di maiale al barbecue, coniglio al timo, ossobuco di abba, pollo ai funghi.\n" +
                " Si la preferencia son pastas, estas son las opciones: pappardelle ai funghi, spaghetti neri, spaghetti al pomodoro, canelloni tramonti, gnocchi della famiglia, risotto del bosco, risotto mediterraneo, risotto nero di mare, los cocteles tramonti milenio (cognanc, vodka, amaretto y jugo de naranja) y tramonto (vodka, jugo de naranja y granadina) son sólo algunas de la variedad que se encuentra en el restaurante, además de otros más tradicionales como margarita, piña colada, daiquiri de fresa, mojito, dry martini, canelazo de aguardiente, sangría, entre otros.");
        miLugaresVo.setLatitud("4.6677515");
        miLugaresVo.setLongitud("-74.0530483");
        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Tratoria La Divina Comedia");
        miLugaresVo.setTipolugar("3");
        miLugaresVo.setDescripcioncorta("Es una buena invitación para sentirse como en casa, ");
        miLugaresVo.setUbicacion("Calle 71 # 5-73");
        miLugaresVo.setDescripcion("Ubicado en el norte de la ciudad, La Divina Comedia es una buena invitación para sentirse como en casa, pues su chef Sergio Martin proviene de familia italiana y busca evocar y difundir de manera moderna, las enseñanzas que le dejo su nonna a su padre.\n" +
                " Además de tener la referencia del libro de recetas de familia, el chef tiene gran experiencia en el arte de cocinar, el cual también difunde a través de cursos de pasta fresca, de programas de televisión y de su blog.\n" +
                " Con una presentación de los platos sobria y elaborada de los platos, el restaurante divide su carta entre pastas cortas, pastas frescas y pastas rellenas. Además de remontarse al nombre del sitio, ofreciendo un aparte para los platos Del Paraíso (ristottos), Del Purgatorio (tortellis y tortellonis) y Del Inferno (varias opciones). Su especialidad es la pasta rellena, como el Canelloni Dante. De otros platos, también se recomienda el risotto funghi, el spaghetti Tripomodoro y el Penne Primavera. Quienes desean otras opciones más ligeras, hay variedad de ensaladas y sopas. \n" +
                " En un ambiente cálido y sencillo con mesas de madera, sillas rojas y manteles blancos, se puede disfrutar también de diferentes risottos, pescados y carnes.\n" +
                " Un buen cierre por el sitio se puede hacer con un tiramisú y uno de los vinos seleccionados que tienen.");
        miLugaresVo.setLatitud("4.653567");
        miLugaresVo.setLongitud("-74.0571337");
        list.add(miLugaresVo);

        registrar();
    }

    private void registrarHoteles() {
        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Hotel Continental Bluedoors");
        miLugaresVo.setTipolugar("2");
        miLugaresVo.setDescripcioncorta("Hotel sofisticado con un bar restaurante moderno y una cafetería, además de un gimnasio y un spa.");
        miLugaresVo.setUbicacion("Avenida Jiménez No. 4 - 16\n" +
                "Candelaria - Centro Historico");
        miLugaresVo.setDescripcion("Este elegante hotel con todo suites, situado a 4 minutos a pie de los objetos de oro del Museo del Oro, también se encuentra a 8 minutos a pie de las obras de arte del Museo Botero y a 11 minutos a pie de la Plaza de Bolívar, la plaza principal de la ciudad.\n" +
                "Las luminosas y modernas suites disponen de Wi-Fi gratis, televisiones de pantalla plana y minibares, además de cocinas y salas de estar.\n" +
                "El aparcamiento es gratuito. El desayuno se ofrece por un suplemento. Entre el resto de instalaciones que se incluyen en el hotel se encuentran una panadería cafetería, un bar restaurante moderno con terraza, un gimnasio y un spa.");
        miLugaresVo.setLatitud("4.6010598");
        miLugaresVo.setLongitud("-74.0705079");
        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Hotel Tequendama y centro de convenciones");
        miLugaresVo.setTipolugar("2");
        miLugaresVo.setDescripcioncorta("El Hotel Tequendama Bogotá, ubicado en pleno centro de Bogotá y a tan sólo 15 minutos del Aeropuerto Internacional El Dorado");
        miLugaresVo.setUbicacion("Cra. 10 #26-21, Bogotá, Cundinamarca");
        miLugaresVo.setDescripcion("El Hotel Tequendama Bogotá, ubicado en pleno centro de Bogotá y a tan sólo 15 minutos del Aeropuerto Internacional El Dorado, ofrece todos los servicios de un hotel 5 estrellas.\n" +
                "\n" +
                "Dispone de 573 habitaciones de estilo clásico totalmente reformadas y dotadas con la última tecnología, todo lo necesario para garantizar el máximo confort de nuestros clientes.\n" +
                "Además, el hotel ofrece wifi gratuito, restaurante, spa y 39 salones que lo convierten en la mejor opción para celebrar cualquier tipo de reunión de negocios o evento empresarial en Bogotá.");
        miLugaresVo.setLatitud("4.6128583");
        miLugaresVo.setLongitud("-74.0728357");
        list.add(miLugaresVo);


        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Bogota Marriot Hotel");
        miLugaresVo.setTipolugar("2");
        miLugaresVo.setDescripcioncorta("Hotel moderno de habitaciones luminosas con spa, comida italiana y japonesa, y traslados al aeropuerto gratis.");
        miLugaresVo.setUbicacion("Av. El Dorado #69 B-53, Bogotá, Cundinamarca");
        miLugaresVo.setDescripcion("Este hotel de lujo, que se alberga en un edificio con fachada acristalada del distrito comercial de Salitre, está a 2 km del Parque Simón Bolívar y a 6 km del aeropuerto internacional de El Dorado.\n" +
                "Las coloridas y modernas habitaciones tienen Wi-Fi gratis, televisores de pantalla plana y bases para iPod, así como minineveras, teteras y cafeteras. Las habitaciones superiores brindan acceso a un salón con refrescos de cortesía, mientras que las suites cuentan con salas de estar y, algunas, incluso con bañeras de hidromasaje. Hay servicio de habitaciones disponible las 24 horas.\n" +
                "El establecimiento ofrece servicio de traslado al aeropuerto y aparcamiento de forma gratuita. El desayuno es de pago. Entre las instalaciones, se encuentran un restaurante italiano y uno japonés, además de un spa, una piscina cubierta y un gimnasio.\n");
        miLugaresVo.setLatitud("4.6591583");
        miLugaresVo.setLongitud("-74.1039294");
        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre(" Hilton Bogota");
        miLugaresVo.setTipolugar("2");
        miLugaresVo.setDescripcioncorta("Habitaciones y suites chics (algunas con vistas a la montaña), restaurante colombiano y piscina descubierta.");
        miLugaresVo.setUbicacion("Cra. 7 #72-41, Bogotá");
        miLugaresVo.setDescripcion("Este elegante hotel, ubicado en el distrito financiero y a 12 minutos a pie de la estación de metro de la calle 72, está a 1,6 km del exclusivo centro comercial Andino y a 5,8 km del centro de Bogotá.\n" +
                "Las elegantes habitaciones y suites cuentan con camas de diseño personalizado, televisión de pantalla plana, conexión Wi-Fi (de pago) y cafetera. Las suites incluyen sala de estar independiente y algunas tienen vistas a la montaña. Las habitaciones Club y algunas suites ofrecen acceso a un salón con desayuno gratuito, aperitivos y bebidas vespertinas.\n" +
                "El hotel dispone de un restaurante colombiano, de una cafetería moderna y de un bar de cócteles con DJ residente. También cuenta con una piscina descubierta y un gimnasio, además de instalaciones para reuniones y eventos y aparcamiento gratuito");
        miLugaresVo.setLatitud("4.6554579");
        miLugaresVo.setLongitud("-74.055213");
        list.add(miLugaresVo);

        miLugaresVo = new LugaresVo();
        miLugaresVo.setNombre("Hotel NH Collection Bogota");
        miLugaresVo.setTipolugar("2");
        miLugaresVo.setDescripcioncorta("Habitaciones y suites modernas en un hotel actual con un restaurante internacional, un piano bar y un spa.");
        miLugaresVo.setUbicacion("Cl. 114 #6-2, Bogotá, Cundinamarca");
        miLugaresVo.setDescripcion("Este moderno hotel de lujo se encuentra a 3 minutos a pie de una parada de autobús, a 2 km de las tiendas y los clubes del parque de la 93 y a 8 km del parque de atracciones Salitre Mágico.\n" +
                "Las habitaciones están insonorizadas y son elegantes. Están equipadas con Wi-Fi gratis, televisión de pantalla plana, base para iPod, minibar y sala de estar. Las habitaciones de categoría superior disponen de sofá cama, cafetera y tetera; algunas tienen terraza. Las suites cuentan con cocina y balcón amueblado.\n" +
                "El hotel dispone de una sala de desayunos informal con una claraboya, un restaurante sofisticado con ventanas de suelo a techo, un bar de deportes con una mesa de billar y sushi, un gimnasio y un spa.");
        miLugaresVo.setLatitud("4.6918426");
        miLugaresVo.setLongitud("-74.0340631");
        list.add(miLugaresVo);

        registrar();
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
            fragment = new PirncipalFragment();
        } else if (id == R.id.nav_gallery) {
            fragment = new CentrosFragment();
        } else if (id == R.id.nav_slideshow) {
            fragment = new HotelesFragment();
        } else if (id == R.id.nav_manage) {
            fragment = new RestaurantesFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.contenido, fragment).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void cambio() {
        Intent miIntent=new Intent(MainActivity.this,GeneralActivity.class);
        startActivity(miIntent);
    }
}
