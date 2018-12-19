package com.cesoc.apps.android.dotaapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cesoc.apps.android.dotaapp.Models.Heroe;
import com.cesoc.apps.android.dotaapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class HeroeActivity extends AppCompatActivity {
    Heroe heroe;
    TextView tv_heroeName;
    TextView tv_heroeAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe);

        tv_heroeName = findViewById(R.id.heroeName);
        tv_heroeAux  = findViewById(R.id.textView);

        heroe = getIntent().getParcelableExtra("heroe");

        // textView de ejemplo, eliminar para nuevo disenio de activity
        tv_heroeName.setText(heroe.getName());

        try {
            JSONObject heroesJson = new JSONObject(loadJSONFromAsset());
            JSONObject heroeJson  = heroesJson.getJSONObject(heroe.getName());
            heroe.fill_Abilities(heroeJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // textView de ejemplo, eliminar para nuevo disenio de activity
        tv_heroeAux.setText(heroe.abilitiesList.get(0).getDescripcion());
    }


    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("abilities.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

