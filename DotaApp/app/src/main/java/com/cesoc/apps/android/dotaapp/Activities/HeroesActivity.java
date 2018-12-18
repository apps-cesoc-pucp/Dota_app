package com.cesoc.apps.android.dotaapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.cesoc.apps.android.dotaapp.Adapters.ViewPagerAdapter;
import com.cesoc.apps.android.dotaapp.DotaApi.ApiConsumer;
import com.cesoc.apps.android.dotaapp.Adapters.GridHeroeAdapter;
import com.cesoc.apps.android.dotaapp.DotaApi.HeroesList;
import com.cesoc.apps.android.dotaapp.DotaApi.IAsyncResponse;
import com.cesoc.apps.android.dotaapp.DotaApi.QueryTask;
import com.cesoc.apps.android.dotaapp.Fragments.HeroesListFragment;
import com.cesoc.apps.android.dotaapp.Models.Heroe;
import com.cesoc.apps.android.dotaapp.R;

import org.json.JSONException;

import java.net.URL;
import java.util.List;

public class HeroesActivity extends AppCompatActivity implements IAsyncResponse,HeroesListFragment.OnItemClickListener {

    private QueryTask heroesQueryTask = new QueryTask();
    private HeroesList heroesList;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewPager);

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
            CreateAdapter();
            tabLayout.setupWithViewPager(viewPager);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void OnItemClick(Heroe heroe) {
        Intent intent =new Intent(HeroesActivity.this,HeroeActivity.class);
        intent.putExtra("heroe",heroe);
        startActivity(intent);
    }

    private void CreateAdapter(){
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragment(new HeroesListFragment(),heroesList.heroesAgilidad,"Agilidad");
        viewPagerAdapter.AddFragment(new HeroesListFragment(),heroesList.heroesFuerza,"Fuerza");
        viewPagerAdapter.AddFragment(new HeroesListFragment(),heroesList.heroesInteligencia,"Inteligencia");
        viewPager.setAdapter(viewPagerAdapter);
    }

}
