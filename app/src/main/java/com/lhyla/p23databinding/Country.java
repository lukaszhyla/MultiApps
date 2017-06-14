package com.lhyla.p23databinding;

public class Country {
    private String name;
    private String capitalCity;
    private String flagURL;

    public Country(String name, String capitalCity) {
        this.name = name;
        this.capitalCity = capitalCity;
        //this.flagURL = flagURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getFlagURL() {
        return flagURL;
    }

    public void setFlagURL(String flagURL) {
        this.flagURL = flagURL;
    }
}
