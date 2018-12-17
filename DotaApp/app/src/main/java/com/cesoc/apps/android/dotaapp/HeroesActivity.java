package com.cesoc.apps.android.dotaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.cesoc.apps.android.dotaapp.DotaApi.ApiConsumer;
import com.cesoc.apps.android.dotaapp.DotaApi.GridHeroeAdapter;
import com.cesoc.apps.android.dotaapp.DotaApi.Heroe;
import com.cesoc.apps.android.dotaapp.DotaApi.IAsyncResponse;
import com.cesoc.apps.android.dotaapp.DotaApi.QueryTask;

import org.json.JSONException;

import java.net.URL;
import java.util.ArrayList;

public class HeroesActivity extends AppCompatActivity implements IAsyncResponse {

    public String a;
    private GridView gridView;
    private QueryTask heroesQueryTask = new QueryTask();
    private ArrayList<Heroe> heroesList;

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
        try {
            heroesList = ApiConsumer.getHeroesList(jsonString);
            //Metodo para ir al Activity de Heroe
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    final Heroe HEROE=heroesList.get(i);
                    Intent intent=new Intent(HeroesActivity.this, HeroeActivity.class);
                    intent.putExtra("heroe",HEROE);
                    startActivity(intent);
                }
            });
            // llenado en la grilla
            GridHeroeAdapter adapter= new GridHeroeAdapter(HeroesActivity.this,
                                        R.layout.grid_heroe_item, heroesList);
            gridView.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
