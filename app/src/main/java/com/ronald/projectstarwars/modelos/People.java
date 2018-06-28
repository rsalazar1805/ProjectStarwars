package com.ronald.projectstarwars.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class People implements Serializable {
    private String name;
    private String birthYear;
    private String gender;
    private String hairColor;
    private String height;
    private String homeWorldUrl;
    private String mass;
    private String skinColor;
    private String created;
    private String edited;
    private String url;
    private ArrayList<String> filmsUrls;
    private ArrayList<String> speciesUrls;
    private ArrayList<String> starshipsUrls;
    private ArrayList<String> vehiclesUrls;

    public String getName() {
        return name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getHeight() {
        return height;
    }

    public String getHomeWorldUrl() {
        return homeWorldUrl;
    }

    public String getMass() {
        return mass;
    }

    public String getSkinColor() {
        return skinColor;
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

    public ArrayList<String> getFilmsUrls() {
        return filmsUrls;
    }

    public ArrayList<String> getSpeciesUrls() {
        return speciesUrls;
    }

    public ArrayList<String> getStarshipsUrls() {
        return starshipsUrls;
    }

    public ArrayList<String> getVehiclesUrls() {
        return vehiclesUrls;
    }
}
