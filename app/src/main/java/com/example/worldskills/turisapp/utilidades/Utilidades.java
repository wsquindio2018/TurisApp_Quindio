package com.example.worldskills.turisapp.utilidades;

import android.widget.Toast;

public class Utilidades {


    public static final String NOMBRE_TABLA = "LUGARES";
    public static final String ID = "ID";
    public static final String NOMBRE_LUGAR = "NOMBRE";
    public static final String TIPO = "TIPO";
    public static final String DESCRIPCION_CORTA = "CORTA";
    public static final String DESCRIPCION_LARGA = "LARGA";
    public static final String UBICACION = "UBICACION";
    public static final String LATITUD = "LATITUD";
    public static final String LONGITUD = "LONGITUD";

    public static final String CREAR_TABLA = "CREATE TABLE " + NOMBRE_TABLA + " ( " + NOMBRE_LUGAR + " VARCHAR , " + DESCRIPCION_CORTA + " VARCHAR, " +
            DESCRIPCION_LARGA + " VARCHAR, " + UBICACION + " VARCHAR, " + LATITUD + " VARCHAR, " + LONGITUD + " VARCHAR, " + TIPO + " INT, " + ID + " INT);";
}
