package com.napier.sem;

/**
 * Represents a Continent
 */
public class Continent {
    /**
     * Continent name
     */
    public String name;

    /**
     * Total population of the continent
     */
    public long totalPopulation;

    /**
     * Total city population in the continent
     */
    public long cityPopulation;

    /**
     * Total non-city population in the continent
     */
    public long nonCityPopulation;

    /**
     * Total city population percentage in the region
     */
    public long cityPercentage;

    /**
     * Total non-city population percentage in the region
     */
    public long nonCityPercentage;

    // Constructor
    public Continent(String name) {
        this.name = name;
        this.totalPopulation = 0L;
        this.cityPopulation = 0L;
        this.nonCityPopulation = 0L;
        this.cityPercentage = 0L;
        this.nonCityPercentage = 0L;
    }
}