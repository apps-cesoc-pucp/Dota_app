package com.cesoc.apps.android.dotaapp.DotaApi;

public interface IHeroes {
    // URL principal
    String DOTA_URL_BASE = "https://api.opendota.com";
    String HEROES_URI_STAT = "/api/heroStats";
    // obtener imagenes de heroes: heroe["img"]
    // "https://api.opendota.com/ ~~ apps/dota2/images/heroes/antimage_full.png?"
    // obtener iconos de heroes: heroe["icon"]
    // "/apps/dota2/images/heroes/antimage_icon.png"
}
