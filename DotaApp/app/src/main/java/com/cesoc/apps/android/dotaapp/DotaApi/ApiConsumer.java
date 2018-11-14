package com.cesoc.apps.android.dotaapp.DotaApi;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiConsumer implements IHeroes{

    // Metodo de contruccion de URL usando URLs de Api de Dota
    public static URL buildUrl() {
        Uri builtUri = Uri.parse(DOTA_URL_BASE+HEROES_URI_STAT).buildUpon().build();
        URL url = null;
        // puede formarse incorrectamente la URL, TRY necesario
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    // Metodo que retorna el pedido HTTP realizado como String(JSON)
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        // iniciamos la conexion a Internet para lanzar la peticion con la URL
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        // TRY para error de conexion. Sin importar el caso, FINALLY: cierra la conexion
        try {
            // obtenemos el pedido como InputStream
            InputStream in = urlConnection.getInputStream();
            // trick para parsear cadena de caracteres
            // UFT-16 a UFT-8
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            // confirmamos que no esta vacio, sino, retorna NULL
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
