package com.napier.sem;

public class Region {
    /**
     * Region name
     */
    public String name;

    /**
     * Total population of the region
     */
    public long totalPopulation;

    /**
     * Total city population in the region
     */
    public long cityPopulation;

    /**
     * Total non-city population in the region
     */
    public long nonCityPopulation;

    // Constructor
    public Region(String name) {
        this.name = name;
        this.totalPopulation = 0L;
        this.cityPopulation = 0L;
        this.nonCityPopulation = 0L;
    }
}
