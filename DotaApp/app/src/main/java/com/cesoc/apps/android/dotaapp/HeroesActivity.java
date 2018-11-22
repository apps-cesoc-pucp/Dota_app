package com.cesoc.apps.android.dotaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;


import com.cesoc.apps.android.dotaapp.DotaApi.ApiConsumer;
import com.cesoc.apps.android.dotaapp.DotaApi.GridHeroeAdapter;
import com.cesoc.apps.android.dotaapp.DotaApi.Heroe;
import com.cesoc.apps.android.dotaapp.DotaApi.IAsyncResponse;
import com.cesoc.apps.android.dotaapp.DotaApi.QueryTask;

import org.json.JSONException;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class HeroesActivity extends AppCompatActivity implements IAsyncResponse {

    private GridView gridView;
    private QueryTask heroesQueryTask = new QueryTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        gridView=findViewById(R.id.grillaHeroes);


        // PETICION DE DATA DE HEROES Y LLENADO DE GRILLA
        URL heroesURL = ApiConsumer.buildUrl(ApiConsumer.getUriHeroes());
        heroesQueryTask.delegate = this;
        heroesQueryTask.execute(heroesURL);

    }

    @Override
    public void processFinish(String jsonString) {
        // lista de heroes obtenida
        ArrayList<Heroe> heroesList;
        try {
            heroesList = ApiConsumer.getHeroesList(jsonString);
            // llenado en la grilla
            GridHeroeAdapter adapter= new GridHeroeAdapter(HeroesActivity.this, R.layout.grid_heroe_item, heroesList);
            gridView.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // metodo para imagen de Heroe
    void onClickHeroe(View view){
        // cómo obtener la imagen y el objeto Heroe al que pertenece?
        // INTENT para pasar al siguiente activity
        Intent intent = new Intent(this, HeroeActivity.class);
        // heroe a pasar para presentar datos (nombre y estadisticas, reemplazar la sgt linea)
        Heroe heroe = null;
        // pase de heroe
        intent.putExtra("heroe", (Serializable) heroe);
        startActivity(intent);
    }
}
