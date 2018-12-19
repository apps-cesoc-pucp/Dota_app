package com.cesoc.apps.android.dotaapp.Models;

import org.json.JSONObject;

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
    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
