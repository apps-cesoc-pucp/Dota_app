package com.cesoc.apps.android.dotaapp.DotaApi;

import java.util.ArrayList;

public class Heroe {
    private int id;
    private String name; // nombre de juego(localized_name en JSON)
    private String large_name; // nombre extenso de Dota(name en JSON)
    private String primary_attr; // atributo principal
    private String attack_type;
    private ArrayList<String> roles; // roles de heroe en el juego
    public String img_URI;
    public String icon_URI;

    public Heroe(String name){
        this.name=name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLarge_name() {
        return large_name;
    }
    public void setLarge_name(String large_name) {
        this.large_name = large_name;
    }

    public String getPrimary_attr() {
        return primary_attr;
    }
    public void setPrimary_attr(String primary_attr) {
        this.primary_attr = primary_attr;
    }

    public String getAttack_type() {
        return attack_type;
    }
    public void setAttack_type(String attack_type) {
        this.attack_type = attack_type;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }
    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }
}
