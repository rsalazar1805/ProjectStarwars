package com.ronald.projectstarwars.modelos;

import java.io.Serializable;

public class Root implements Serializable {

    private String filmsUrl;
    private String peopleUrl;
    private String planetsUrl;
    private String speciesUrl;
    private String starshipsUrl;
    private String vehiclesUrl;

    public String getFilmsUrl() {
        return filmsUrl;
    }

    public String getPeopleUrl() {
        return peopleUrl;
    }

    public String getPlanetsUrl() {
        return planetsUrl;
    }

    public String getSpeciesUrl() {
        return speciesUrl;
    }

    public String getStarshipsUrl() {
        return starshipsUrl;
    }

    public String getVehiclesUrl() {
        return vehiclesUrl;
    }
}
