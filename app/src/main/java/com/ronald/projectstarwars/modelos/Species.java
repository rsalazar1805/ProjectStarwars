package com.ronald.projectstarwars.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Species implements Serializable {
    private String name;
    private String classification;
    private String designation;    
    private String averageHeight;    
    private String averageLifespan;    
    private String eyeColors;    
    private String hairColors;    
    private String skinColors;    
    private String homeWorld;
    private String language;
    private String created;
    private String edited;
    private String url;    
    private ArrayList<String> peopleUrls;    
    private ArrayList<String> filmsUrls;

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public String getLanguage() {
        return language;
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

    public ArrayList<String> getPeopleUrls() {
        return peopleUrls;
    }

    public ArrayList<String> getFilmsUrls() {
        return filmsUrls;
    }
}
