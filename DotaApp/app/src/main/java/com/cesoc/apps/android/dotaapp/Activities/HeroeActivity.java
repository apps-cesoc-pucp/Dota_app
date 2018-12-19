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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe);

        // textView de ejemplo, eliminar para nuevo disenio de activity
        tv_heroeName = findViewById(R.id.heroeName);

        heroe = getIntent().getParcelableExtra("heroe");
        tv_heroeName.setText(heroe.getName());

        try {
            JSONObject heroesJson = new JSONObject(loadJSONFromAsset());
            JSONObject heroeJson  = heroesJson.getJSONObject(heroe.getName());
            heroe.fill_Abilities(heroeJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
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

