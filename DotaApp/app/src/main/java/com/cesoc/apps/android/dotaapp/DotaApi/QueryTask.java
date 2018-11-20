package com.cesoc.apps.android.dotaapp.DotaApi;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;

public class QueryTask extends AsyncTask<URL, Void, String> {
    public IAsyncResponse delegate = null;
    // Mientras se obtienen los datos de todos los heroes
    /*
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    */

    // SOBRECARGA de metodo que procesa pedido de String JSON en un HILO diferente
    @Override
    protected String doInBackground(URL... params) {
        URL url = params[0];
        String searchResults = null;
        try {
            searchResults = ApiConsumer.getResponseFromHttpUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchResults;
    }

    // SOBRECARGA de metodo que procesa instrucciones despues de la peticion
    @Override
    protected void onPostExecute(String searchResults) {
        // hacer algo con la data recolectada en String JSON
        // lo delegamos al metodo processFinish() que sera implementado en una Activity
        delegate.processFinish(searchResults);
    }
}
