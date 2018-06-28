package com.ronald.projectstarwars.modelos;

import java.io.Serializable;

public class Starship implements Serializable{
    private String starshipClass;    
    private String hyperdriveRating;    
    private String mglt;

    public String getStarshipClass() {
        return starshipClass;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public String getMglt() {
        return mglt;
    }
}
