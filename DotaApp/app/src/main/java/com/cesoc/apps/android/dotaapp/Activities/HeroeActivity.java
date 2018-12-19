package com.cesoc.apps.android.dotaapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cesoc.apps.android.dotaapp.Adapters.ListAbilityAdapter;
import com.cesoc.apps.android.dotaapp.Models.Heroe;
import com.cesoc.apps.android.dotaapp.R;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class HeroeActivity extends AppCompatActivity {
    Heroe heroe;

    ListView listViewAbilities;
    List<ListAbilityAdapter.Ability> listAbilities;
    ListAbilityAdapter abilityAdapter;

    // DATA DE HEROE
    TextView tv_heroe_name;
    ImageView iv_heroe_img;
    TextView tv_heroe_attack;
    TextView tv_heroe_attr;
    TextView tv_heroe_roles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe);

        // DATA DE HEROE
        tv_heroe_name = findViewById(R.id.heroe_name);
        iv_heroe_img = findViewById(R.id.heroe_image);
        tv_heroe_attack = findViewById(R.id.heroe_attack_type);
        tv_heroe_attr = findViewById(R.id.heroe_attribute);
        tv_heroe_roles = findViewById(R.id.heroe_roles);

        listViewAbilities = findViewById(R.id.listaAbilities);

        heroe = getIntent().getParcelableExtra("heroe");

        try {
            JSONObject heroesJson = new JSONObject(loadJSONFromAsset());
            JSONObject heroeJson  = heroesJson.getJSONObject(heroe.getName());
            heroe.fill_Abilities(heroeJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // LISTA DE ABILITIES DE HEROE
        // heroe.abilitiesList;

        // LLENADO DE DATA DE HEROE
        tv_heroe_name.setText(heroe.getName());
        tv_heroe_attack.setText(heroe.getAttack_type());
        tv_heroe_attr.setText(heroe.getPrimary_attr());
        Glide.with(this).load(heroe.getImg_URL()).into(iv_heroe_img);
//        String roles = String.join("  ", heroe.getRoles());
        StringBuilder roles = new StringBuilder();
        for (String role : heroe.getRoles()) {
            roles.append(role).append("  ");
        }
        tv_heroe_roles.setText(roles);

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

