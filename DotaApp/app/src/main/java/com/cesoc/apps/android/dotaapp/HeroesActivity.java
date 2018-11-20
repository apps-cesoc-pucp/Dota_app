package com.cesoc.apps.android.dotaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cesoc.apps.android.dotaapp.DotaApi.GridHeroeAdapter;
import com.cesoc.apps.android.dotaapp.DotaApi.Heroe;

import java.util.ArrayList;
import java.util.List;

public class HeroesActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Heroe> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        gridView=findViewById(R.id.grillaHeroes);

        heroes=new ArrayList<Heroe>();
        heroes.add(new Heroe("Heroe 1"));
        heroes.add(new Heroe("Heroe 2"));
        heroes.add(new Heroe("Heroe 3"));
        heroes.add(new Heroe("Heroe 4"));
        heroes.add(new Heroe("Heroe 5"));
        heroes.add(new Heroe("Heroe 6"));
        heroes.add(new Heroe("Heroe 7"));
        heroes.add(new Heroe("Heroe 8"));
        heroes.add(new Heroe("Heroe 1"));
        heroes.add(new Heroe("Heroe 2"));
        heroes.add(new Heroe("Heroe 3"));
        heroes.add(new Heroe("Heroe 4"));
        heroes.add(new Heroe("Heroe 5"));
        heroes.add(new Heroe("Heroe 6"));
        heroes.add(new Heroe("Heroe 7"));
        heroes.add(new Heroe("Heroe 8"));

        GridHeroeAdapter adapter= new GridHeroeAdapter(HeroesActivity.this,R.layout.grid_heroe_item,heroes);
        gridView.setAdapter(adapter);

    }
}
