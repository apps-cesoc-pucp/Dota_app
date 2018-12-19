package com.cesoc.apps.android.dotaapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.cesoc.apps.android.dotaapp.DotaApi.IHeroes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Heroe implements IHeroes, Parcelable {

    private int id;
    private String name; // nombre de juego(localized_name en JSON)
    private String large_name; // nombre extenso de Dota(name en JSON)
    private String primary_attr; // atributo principal
    private String attack_type;
    private ArrayList<String> rolesList; // roles de heroe en el juego
    private String img_URL;
    private String icon_URL;
    public ArrayList<Ability> abilitiesList;

    // CONSTRUCTOR
    public Heroe(JSONObject jsonObject) throws JSONException {
        this.setId(jsonObject.getInt("id"));
        this.setName(jsonObject.getString("localized_name")+" ");
        this.setLarge_name(jsonObject.getString("name"));
        this.setPrimary_attr(jsonObject.getString("primary_attr"));
        this.setAttack_type(jsonObject.getString("attack_type"));
        this.img_URL = DOTA_URL_BASE + jsonObject.getString("img");
        this.icon_URL = DOTA_URL_BASE + jsonObject.getString("icon");
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

    public String getImg_URL() {
        return img_URL;
    }
    public void setImg_URL(String img_URL) {
        this.img_URL = img_URL;
    }

    public String getIcon_URL() {
        return icon_URL;
    }
    public void setIcon_URL(String icon_URL) {
        this.icon_URL = icon_URL;
    }


    /* PARCELABLE PARA PASAR OBJETO HEROE POR MEDIO DE INTENTS */
    public Heroe(Parcel parcel){
        this.id = parcel.readInt();

        this.name = parcel.readString();
        this.large_name = parcel.readString();
        this.primary_attr = parcel.readString();
        this.attack_type = parcel.readString();

        this.rolesList = parcel.createStringArrayList();

        this.img_URL = parcel.readString();
        this.icon_URL = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.id);

        parcel.writeString(this.name);
        parcel.writeString(this.large_name);
        parcel.writeString(this.primary_attr);
        parcel.writeString(this.attack_type);

        parcel.writeStringList(this.rolesList);

        parcel.writeString(this.img_URL);
        parcel.writeString(this.icon_URL);
    }

    public static final Parcelable.Creator<Heroe>CREATOR = new Parcelable.Creator<Heroe>(){
        public Heroe createFromParcel(Parcel in) {
            return new Heroe(in);
        }

        public Heroe[] newArray(int size) {
            return new Heroe[size];
        }
    };


    public void fill_Abilities(JSONObject heroeJson) throws JSONException {
        // obtener todos los JSONobjects para guardarlos
        this.abilitiesList = new ArrayList<>();
        for (Iterator<String> it = heroeJson.keys(); it.hasNext(); ) {
            String key = it.next();
            JSONObject abilityJson = heroeJson.getJSONObject(key);
            String name_ability = abilityJson.getString("dname");
            String description_ability = abilityJson.getString("desc");
            String url_img_ability = "http://cdn.dota2.com/apps/dota2/images/abilities/"+ key +"_lg.png";
            this.abilitiesList.add(new Ability(name_ability, description_ability, url_img_ability));
        }
    }
}
