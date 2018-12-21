package com.cesoc.apps.android.dotaapp.Activities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cesoc.apps.android.dotaapp.Adapters.ListAbilityAdapter;
import com.cesoc.apps.android.dotaapp.Models.Ability;
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
    ListAbilityAdapter abilityAdapter;

    // DATA DE HEROE
    TextView tv_heroe_name;
    ImageView iv_heroe_img;
    TextView tv_heroe_attack;
    TextView tv_heroe_attr;
    TextView tv_heroe_roles;
    Dialog dialAbility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe);

        // DATA DE HEROE
        iv_heroe_img = findViewById(R.id.iv_heroe_img);
        tv_heroe_name=findViewById(R.id.tv_heroe_name);
        tv_heroe_attack=findViewById(R.id.tv_heroe_attack);
        tv_heroe_attr=findViewById(R.id.tv_heroe_attr);
        tv_heroe_roles=findViewById(R.id.tv_heroe_roles);

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
        String attr=heroe.getPrimary_attr();

        if(attr.equals("agi")){
            tv_heroe_attr.setText("Principal attribute: Agility");
        }else if(attr.equals("str")){
            tv_heroe_attr.setText("Principal attribute: Strength");
        }else if(attr.equals("int")){
            tv_heroe_attr.setText("Principal attribute: Intelligence");
        }

        RequestOptions options=new RequestOptions();
        options.fitCenter();
        options.centerCrop();
        Glide.with(this).load(heroe.getImg_URL()).apply(options).into(iv_heroe_img);
//        String roles = String.join("  ", heroe.getRoles());
        StringBuilder roles = new StringBuilder();
        for (String role : heroe.getRoles()) {
            roles.append(role).append("  ");
        }
        tv_heroe_roles.setText(roles);
        abilityAdapter=new ListAbilityAdapter(HeroeActivity.this,R.layout.list_ability_item,heroe.getAbilitiesList());
        listViewAbilities.setAdapter(abilityAdapter);

        listViewAbilities.setOnItemClickListener((parent, view, position, id) -> {
            dialAbility=new Dialog(HeroeActivity.this);
            ShowPopUp(heroe.getAbilitiesList().get(position));
        });
    }

    private void ShowPopUp(Ability ability){
        ImageButton imageButton;
        ImageView imageView;
        TextView name;
        TextView description;

        dialAbility.setContentView(R.layout.popup_ability);

        imageButton=dialAbility.findViewById(R.id.closeAbility);
        imageView=dialAbility.findViewById(R.id.imageAbility);
        name=dialAbility.findViewById(R.id.nameAbility);
        description=dialAbility.findViewById(R.id.completeDescriptionAbility);

        imageButton.setOnClickListener(v -> dialAbility.dismiss());

        RequestOptions options=new RequestOptions();
        options.fitCenter();
        options.circleCrop();
        Glide.with(HeroeActivity.this).load(ability.getUrl_img()).apply(options).into(imageView);
        name.setText(ability.getNombre());
        description.setText(ability.getDescripcion());
        dialAbility.show();
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

