package com.cesoc.apps.android.dotaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    }

    public void changeHello(View view){
        if(heroesList.isEmpty()){
            tv_hello.setText("empty");
        }else{
            tv_hello.setText("no empty");
        }

    }
}
