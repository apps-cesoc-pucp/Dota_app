package com.cesoc.apps.android.dotaapp.DotaApi;

import com.cesoc.apps.android.dotaapp.Models.Heroe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HeroesList {
    private final String ATTR1 = "agi";
    private final String ATTR2 = "str";
    private final String ATTR3 = "int";

    public ArrayList<Heroe> heroesFuerza = new ArrayList<>();
    public ArrayList<Heroe> heroesAgilidad= new ArrayList<>();
    public ArrayList<Heroe> heroesInteligencia = new ArrayList<>();

    public HeroesList(ArrayList<Heroe> heroesList){
        for (Heroe heroe : heroesList) {
            switch (heroe.getPrimary_attr()){
                case ATTR1:
                    heroesAgilidad.add(heroe);
                    break;
                case ATTR2:
                    heroesFuerza.add(heroe);
                    break;
                case ATTR3:
                    heroesInteligencia.add(heroe);
                    break;
            }
        }

        Collections.sort(heroesAgilidad, ComparatorHeroes.sort());
        Collections.sort(heroesFuerza, ComparatorHeroes.sort());
        Collections.sort(heroesInteligencia, ComparatorHeroes.sort());
    }

    private static class ComparatorHeroes{
//        private static Comparator<Heroe> sortAgilidad(){
//            return (heroe, t1) -> heroe.getName().compareTo(t1.getName());
//        }
//        private static Comparator<Heroe> sortFuerza(){
//            return (heroe, t1) -> heroe.getName().compareTo(t1.getName());
//        }
//        private static Comparator<Heroe> sortInteligencia(){
//            return (heroe, t1) -> heroe.getName().compareTo(t1.getName());
//        }
        private static Comparator<Heroe> sort(){
            return (heroe, t1) -> heroe.getName().compareTo(t1.getName());
        }
    }

    /* de manera general, HeroesList debe ser tratado como un ArrayList<Heroe>,
    * pero sin usar extends por ello la implementacion de los sgts metodos
    */
    public Heroe get(int i){
        return this.heroesAgilidad.get(i);
    }

}
