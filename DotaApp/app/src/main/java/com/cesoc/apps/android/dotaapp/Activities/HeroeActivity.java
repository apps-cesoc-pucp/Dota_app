package com.cesoc.apps.android.dotaapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.cesoc.apps.android.dotaapp.Adapters.ListAbilityAdapter;
import com.cesoc.apps.android.dotaapp.Models.Heroe;
import com.cesoc.apps.android.dotaapp.R;

import java.util.ArrayList;
import java.util.List;

public class HeroeActivity extends AppCompatActivity {

    Heroe heroe;
    TextView tv_heroeName;
    ListView listViewAbilities;

    List<ListAbilityAdapter.Ability> listAbilities;

    ListAbilityAdapter abilityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe);

        listViewAbilities=findViewById(R.id.listaAbilities);

        heroe = getIntent().getParcelableExtra("heroe");

    }
}
