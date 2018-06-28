package com.ronald.projectstarwars.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {
    private String title;   
    private int episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private String release_date;
    private String url;
    private String created;
    private String edited;    
    private ArrayList<String> speciesUrls;  
    private ArrayList<String> starshipsUrls;   
    private ArrayList<String> vehiclesUrls;   
    private ArrayList<String> planetsUrls;   
    private ArrayList<String> charactersUrls;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public ArrayList<String> getSpeciesUrls() {
        return speciesUrls;
    }

    public void setSpeciesUrls(ArrayList<String> speciesUrls) {
        this.speciesUrls = speciesUrls;
    }

    public ArrayList<String> getStarshipsUrls() {
        return starshipsUrls;
    }

    public void setStarshipsUrls(ArrayList<String> starshipsUrls) {
        this.starshipsUrls = starshipsUrls;
    }

    public ArrayList<String> getVehiclesUrls() {
        return vehiclesUrls;
    }

    public void setVehiclesUrls(ArrayList<String> vehiclesUrls) {
        this.vehiclesUrls = vehiclesUrls;
    }

    public ArrayList<String> getPlanetsUrls() {
        return planetsUrls;
    }

    public void setPlanetsUrls(ArrayList<String> planetsUrls) {
        this.planetsUrls = planetsUrls;
    }

    public ArrayList<String> getCharactersUrls() {
        return charactersUrls;
    }

    public void setCharactersUrls(ArrayList<String> charactersUrls) {
        this.charactersUrls = charactersUrls;
    }
}
