package com.cesoc.apps.android.dotaapp.DotaApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Heroe {
    private int id;
    private String name; // nombre de juego(localized_name en JSON)
    private String large_name; // nombre extenso de Dota(name en JSON)
    private String primary_attr; // atributo principal
    private String attack_type;
    private ArrayList<String> rolesList; // roles de heroe en el juego
    public  String img_URI;
    public  String icon_URI;

    // CONSTRUCTOR
    public Heroe(JSONObject jsonObject) throws JSONException {
        this.setId(jsonObject.getInt("id"));
        this.setName(jsonObject.getString("localized_name"));
        this.setLarge_name(jsonObject.getString("name"));
        this.setPrimary_attr(jsonObject.getString("primary_attr"));
        this.setAttack_type(jsonObject.getString("attack_type"));
        this.img_URI = jsonObject.getString("img");
        this.icon_URI = jsonObject.getString("icon");
        // arreglo de roles de heroe
        JSONArray jsonArrayRoles = jsonObject.getJSONArray("roles");
        ArrayList<String> roles = new ArrayList<>();
        for(int i=0; i<jsonArrayRoles.length(); i++){
            roles.add(jsonArrayRoles.getString(i));
        }
        this.setRoles(roles);
    }

    // GETTERS Y SETTERS
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
        return rolesList;
    }
    public void setRoles(ArrayList<String> rolesList) {
        this.rolesList = rolesList;
    }
}
