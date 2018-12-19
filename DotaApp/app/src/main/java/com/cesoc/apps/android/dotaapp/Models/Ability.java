package com.cesoc.apps.android.dotaapp.Models;

public class Ability {
    private String nombre;
    private String descripcion;
    private String url_img;

    // CONSTRUCTOR
    Ability(String nombre, String descripcion, String url_img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url_img = url_img;
    }

    public String getUrl_img() {
        return url_img;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
}
