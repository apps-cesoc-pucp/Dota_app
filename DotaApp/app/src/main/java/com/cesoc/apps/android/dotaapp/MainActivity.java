package com.cesoc.apps.android.dotaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cesoc.apps.android.dotaapp.DotaApi.ApiConsumer;
import com.cesoc.apps.android.dotaapp.DotaApi.Heroe;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Heroe> heroesList;
    TextView tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_hello = findViewById(R.id.hello);
        heroesList = ApiConsumer.chargeHeroesList();
        tv_hello.setText(" ");
        for(Heroe heroe : heroesList){
            tv_hello.append(heroe.getName());
            tv_hello.append(heroe.getAttack_type());
        }

    }
}
