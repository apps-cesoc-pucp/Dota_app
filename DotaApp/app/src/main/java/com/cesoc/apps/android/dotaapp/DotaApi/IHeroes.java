package com.cesoc.apps.android.dotaapp.DotaApi;

public interface IHeroes {
    // URL principal
    static final String DOTA_URL_BASE = "https://api.opendota.com";
    static final String HEROES_URI_STAT = "/api/heroStats";
    // obtener imagenes de heroes: heroe["img"]
    // "/apps/dota2/images/heroes/antimage_full.png?"
    // obtener iconos de heroes: heroe["icon"]
    // "/apps/dota2/images/heroes/antimage_icon.png"
}
