package com.cesoc.apps.android.dotaapp.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cesoc.apps.android.dotaapp.Adapters.GridHeroeAdapter;
import com.cesoc.apps.android.dotaapp.DotaApi.HeroesList;
import com.cesoc.apps.android.dotaapp.Models.Heroe;
import com.cesoc.apps.android.dotaapp.R;

import java.util.List;


public class HeroesListFragment extends Fragment {

    private GridView grillaHeroes;
    private GridHeroeAdapter heroeAdapter;
    private OnItemClickListener callback;
    private List<Heroe> heroes;

    public HeroesListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            callback=(OnItemClickListener)context;
        }catch(Exception e){
            throw new ClassCastException(context.toString() +"should implement OnItemCLickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_heroes_list, container, false);
        grillaHeroes=view.findViewById(R.id.grillaHeroes);

        heroeAdapter=new GridHeroeAdapter(getContext(),R.layout.grid_heroe_item,heroes);
        grillaHeroes.setAdapter(heroeAdapter);
        grillaHeroes.setOnItemClickListener((parent, view1, position, id) -> {
            Heroe currentHeroe= heroes.get(position);
            callback.OnItemClick(currentHeroe);
        });
        // Inflate the layout for this fragment
        return view;
    }

    public void SetListHeroes(List<Heroe> heroes){
        this.heroes=heroes;
    }

    public interface OnItemClickListener{
        void OnItemClick(Heroe heroe);
    }


}
