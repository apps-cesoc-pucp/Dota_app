package com.cesoc.apps.android.dotaapp.DotaApi;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class HeroesQueryTask extends AsyncTask<URL, Void, String> {
    public ArrayList<Heroe> heroesList;
    // Mientras se obtienen los datos de todos los heroes
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        mProgresssBar.setVisibility(View.VISIBLE);
//    }

    // SOBRECARGA de metodo que procesa pedido de String JSON en un HILO diferente
    @Override
    protected String doInBackground(URL... params) {
        URL searchUrl = params[0];
        String heroesSearchResults = null;
        try {
            heroesSearchResults = ApiConsumer.getResponseFromHttpUrl(searchUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return heroesSearchResults;
    }

    // SOBRECARGA de metodo que procesa instrucciones despues de la peticion
    @Override
    protected void onPostExecute(String heroesSearchResults) {
        // hacer algo con la data recolectada en String JSON
        try {
            heroesList = ApiConsumer.getHeroesList(heroesSearchResults);
        } catch (JSONException e) {
            heroesList = null;
            e.printStackTrace();
        }
    }
}
