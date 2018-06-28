package com.ronald.projectstarwars.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Planet implements Serializable{
    private String name;
    private String diameter;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String created;
    private String edited;
    private String url;    
    private String rotationPeriod;   
    private String orbitalPeriod;   
    private String surfaceWater;   
    private ArrayList<String> residentsUrls;   
    private ArrayList<String> filmsUrls;

    public String getName() {
        return name;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public String getPopulation() {
        return population;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public ArrayList<String> getResidentsUrls() {
        return residentsUrls;
    }

    public ArrayList<String> getFilmsUrls() {
        return filmsUrls;
    }
}
