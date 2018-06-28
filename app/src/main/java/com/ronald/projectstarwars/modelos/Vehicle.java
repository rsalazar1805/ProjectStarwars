package com.ronald.projectstarwars.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehicle implements Serializable {
    private String name;
    private String model;
    private String vehicleClass;
    private String manufacturer;    
    private String costInCredits;
    private String length;
    private String crew;
    private String passengers;    
    private String maxAtmospheringSpeed;    
    private String cargoCapacity;
    private String consumables;
    private String created;
    private String edited;
    private String url;    
    private ArrayList<String> pilotsUrls;    
    private ArrayList<String> filmsUrls;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public String getLength() {
        return length;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
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

    public ArrayList<String> getPilotsUrls() {
        return pilotsUrls;
    }

    public ArrayList<String> getFilmsUrls() {
        return filmsUrls;
    }
}
