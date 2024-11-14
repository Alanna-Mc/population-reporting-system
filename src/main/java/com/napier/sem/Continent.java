package com.napier.sem;

public class Continent {
    /**
     * Continent name
     */
    public String name;

    /**
     * Total population of the continent
     */
    public int totalPopulation;

    /**
     * Total city population in the continent
     */
    public int cityPopulation;

    /**
     * Total non-city population in the continent
     */
    public int nonCityPopulation;

    // Constructor
    public Continent(String name) {
        this.name = name;
        this.totalPopulation = 0;
        this.cityPopulation = 0;
        this.nonCityPopulation = 0;
    }
}