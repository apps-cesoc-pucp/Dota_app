package com.cesoc.apps.android.dotaapp.DotaApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HeroesList {
    public ArrayList<Heroe> heroesFuerza = new ArrayList<>();
    public ArrayList<Heroe> heroesAgilidad= new ArrayList<>();
    public ArrayList<Heroe> heroesInteligencia = new ArrayList<>();

    public HeroesList(ArrayList<Heroe> heroesList){
        for (Heroe heroe : heroesList) {
            heroesAgilidad.add(heroe);
            heroesFuerza.add(heroe);
            heroesInteligencia.add(heroe);
        }

        Collections.sort(heroesAgilidad, ComparatorHeroes.sortAgilidad());
        Collections.sort(heroesFuerza, ComparatorHeroes.sortFuerza());
        Collections.sort(heroesInteligencia, ComparatorHeroes.sortInteligencia());
    }

    private static class ComparatorHeroes{
        private static Comparator<Heroe> sortAgilidad(){
            return (heroe, t1) -> Integer.compare(heroe.getId(), t1.getId());
        }
        private static Comparator<Heroe> sortFuerza(){
            return (heroe, t1) -> heroe.getName().compareTo(t1.getName());
        }
        private static Comparator<Heroe> sortInteligencia(){
            return (heroe, t1) -> heroe.getPrimary_attr().compareTo(t1.getPrimary_attr());
        }
    }

    /* de manera general, HeroesList debe ser tratado como un ArrayList<Heroe>,
    * pero sin usar extends por ello la implementacion de los sgts metodos
    */
    public Heroe get(int i){
        return this.heroesAgilidad.get(i);
    }

}
