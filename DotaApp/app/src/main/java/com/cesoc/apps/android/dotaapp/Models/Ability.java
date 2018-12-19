package com.cesoc.apps.android.dotaapp.Models;

import org.json.JSONObject;

public class Ability {
    private String url_img;
    private String nombre;
    private String descripcion;

    // CONSTRUCTOR
    public Ability(JSONObject jsonObject) {

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
