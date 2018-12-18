package com.cesoc.apps.android.dotaapp.DotaApi;

import android.net.Uri;

import com.cesoc.apps.android.dotaapp.Models.Heroe;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ApiConsumer implements IHeroes{
    // URL
    public static URL buildUrl(String uriString) {
        Uri builtUri = Uri.parse(uriString).buildUpon().build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    // JSON string
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            return hasInput? scanner.next() : null;

        } finally {
            urlConnection.disconnect();
        }
    }

    /*******************************************************/
    /* AGREGAR aqui uris String necesarias para peticiones */

    // URI para heroes
    public static String getUriHeroes(){
        return DOTA_URL_BASE + HEROES_URI_STAT;
    }

    public static ArrayList<Heroe> getHeroesList(String jsonString) throws JSONException {
        ArrayList<Heroe> heroesList = new ArrayList<>();
        // transformamos el STRING recibido a un objeto JSON iterable
        // OBS: SEGUN DOCUMENTACION DE API, DEVUELVE UN ARREGLO, POR ELLO SE RECIBE COMO JSONARRAY
        JSONArray jsonArray = new JSONArray(jsonString);
        for(int i=0; i<jsonArray.length(); i++){
            heroesList.add(new Heroe(jsonArray.getJSONObject(i)));
        }
        return heroesList;
    }

    // URI para items
    public static String getUriItems(){
        return "HTTPS://";
    }
}
