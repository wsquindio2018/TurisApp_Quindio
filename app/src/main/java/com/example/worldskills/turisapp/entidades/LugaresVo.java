package com.example.worldskills.turisapp.entidades;

public class LugaresVo {

    private int id;
    private String nombre;
    private String descripcioncorta;
    private String ubicacion;
    private String descripcion;
    private String latitud;
    private String longitud;
    private String tipolugar;
    private String urlimagen;



    public LugaresVo(int id, String nombre, String descripcioncorta, String ubicacion, String descripcion, String latitud, String longitud, String tipolugar, String urlimagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcioncorta = descripcioncorta;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipolugar = tipolugar;
        this.urlimagen = urlimagen;
    }

    public LugaresVo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getTipolugar() {
        return tipolugar;
    }

    public void setTipolugar(String tipolugar) {
        this.tipolugar = tipolugar;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
