package com.cesoc.apps.android.dotaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cesoc.apps.android.dotaapp.DotaApi.Heroe;

public class HeroeActivity extends AppCompatActivity {

    Heroe heroe;
    TextView tv_heroeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe);

        tv_heroeName = findViewById(R.id.heroeName);

        heroe = (Heroe) getIntent().getSerializableExtra("heroe");
        tv_heroeName.setText(heroe.getName());
    }


}
