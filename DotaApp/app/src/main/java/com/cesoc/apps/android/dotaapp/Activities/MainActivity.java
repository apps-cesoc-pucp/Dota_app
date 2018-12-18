package com.cesoc.apps.android.dotaapp.Activities;

import com.cesoc.apps.android.dotaapp.Models.Heroe;
import com.cesoc.apps.android.dotaapp.DotaApi.ApiConsumer;
import com.cesoc.apps.android.dotaapp.DotaApi.IAsyncResponse;
import com.cesoc.apps.android.dotaapp.DotaApi.QueryTask;
import com.cesoc.apps.android.dotaapp.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import org.json.JSONException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements IAsyncResponse {

    TextView tv_hello;
    QueryTask heroesQueryTask = new QueryTask();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_hello = findViewById(R.id.hello);

        // PETICION DE DATA DE HEROES Y LLENADO DE GRILLA
        URL heroesURL = ApiConsumer.buildUrl(ApiConsumer.getUriHeroes());
        heroesQueryTask.delegate = this;
        heroesQueryTask.execute(heroesURL);
    }


    /* DELEGADO POR onPostExecute() de QueryTask */
    /* LLENADO DE GRILLA */
    @Override
    public void processFinish(String jsonString){
        // lista de heroes obtenida
        ArrayList<Heroe> heroesList;
        try {
            heroesList = ApiConsumer.getHeroesList(jsonString);
            // llenado en la grilla
            tv_hello.setText(heroesList.get(0).getName());

        } catch (JSONException e) {
            tv_hello.setText("ERROR");
            e.printStackTrace();
        }
    }
}
