package com.cesoc.apps.android.dotaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cesoc.apps.android.dotaapp.DotaApi.ApiConsumer;
import com.cesoc.apps.android.dotaapp.DotaApi.Heroe;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Heroe> heroesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heroesList = ApiConsumer.chargeHeroesList();
    }
}
