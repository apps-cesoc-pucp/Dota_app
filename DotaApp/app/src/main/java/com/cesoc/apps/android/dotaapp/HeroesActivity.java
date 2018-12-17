package com.cesoc.apps.android.dotaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;


import com.cesoc.apps.android.dotaapp.DotaApi.ApiConsumer;
import com.cesoc.apps.android.dotaapp.DotaApi.GridHeroeAdapter;
import com.cesoc.apps.android.dotaapp.DotaApi.Heroe;
import com.cesoc.apps.android.dotaapp.DotaApi.HeroesList;
import com.cesoc.apps.android.dotaapp.DotaApi.IAsyncResponse;
import com.cesoc.apps.android.dotaapp.DotaApi.QueryTask;

import org.json.JSONException;

import java.net.URL;

public class HeroesActivity extends AppCompatActivity implements IAsyncResponse {

    public String a;
    private GridView gridView;
    private QueryTask heroesQueryTask = new QueryTask();
    private HeroesList heroesList;

    GridHeroeAdapter adapterAgilidad;
    GridHeroeAdapter adapterFuerza;
    GridHeroeAdapter adapterInteligencia;
    int btn_pressed;

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
            heroesList = new HeroesList(ApiConsumer.getHeroesList(jsonString));
            //Metodo para ir al Activity de Heroe
            gridView.setOnItemClickListener((adapterView, view, i, l) -> {
                final Heroe HEROE=heroesList.get(i);
                Intent intent=new Intent(HeroesActivity.this, HeroeActivity.class);
                intent.putExtra("heroe",HEROE);
                startActivity(intent);
            });
            // llenado en la grilla
            adapterAgilidad = new GridHeroeAdapter(HeroesActivity.this,
                    R.layout.grid_heroe_item, heroesList.heroesAgilidad);
            gridView.setAdapter(adapterAgilidad);
            btn_pressed = 1;

            // adapters restantes generados
            adapterFuerza = new GridHeroeAdapter(HeroesActivity.this,
                    R.layout.grid_heroe_item, heroesList.heroesFuerza);
            adapterInteligencia = new GridHeroeAdapter(HeroesActivity.this,
                    R.layout.grid_heroe_item, heroesList.heroesInteligencia);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onClickAgilidad(View view){
        if(btn_pressed == 1) return;
        gridView.setAdapter(adapterAgilidad);
        btn_pressed = 1;
    }

    public void onClickFuerza(View view){
        if(btn_pressed == 2) return;
        gridView.setAdapter(adapterFuerza);
        btn_pressed = 2;
    }

    public void onClickInteligencia(View view){
        if(btn_pressed == 3) return;
        gridView.setAdapter(adapterInteligencia);
        btn_pressed = 3;
    }
}
