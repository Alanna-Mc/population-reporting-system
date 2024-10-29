package com.napier.sem;

import java.util.ArrayList;

/**
 * Main application class.
 */
public class App
{
    // Declare instance variables for App class
    private DatabaseHandler dbHandler;
    private ReportHandler reportsHandler;


    /**
     * Constructor method to create instance of App
     */
    public App() {
        // Initialise variables
        dbHandler = new DatabaseHandler();
        reportsHandler = new ReportHandler();

    }
    /**
     * Main method to run the application.
     */
    public static void main(String[] args)
    {
        App a = new App();

        // Connect to database
        a.dbHandler.connect();

        // Hard coded values
        int n = 10;
        String continent = "Europe";
        String region = "Eastern Europe";

        // Get all the countries in the world, given continent or given region
        ArrayList<Country> allGlobalCountries = a.dbHandler.getAllCountries();
        ArrayList<Country> allContinentCountries = a.dbHandler.getAllCountriesInContinent(continent);
        ArrayList<Country> allRegionCountries = a.dbHandler.getAllCountriesInRegion(region);

        // Get the top N populated countries: globally and by selected continent and region
        ArrayList<Country> globalCountries = a.dbHandler.getTopNPopulatedCountries(n);
        ArrayList<Country> continentCountries = a.dbHandler.getTopNPopulatedCountriesInContinent(n, continent);
        ArrayList<Country> regionCountries = a.dbHandler.getTopNPopulatedCountriesInRegion(n, region);

        // Display each report
        // display all countries in the world report
        System.out.println("\nAll Countries in the world:");
        a.reportsHandler.displayCountries(allGlobalCountries);

        // display all countries  in a given continent report
        System.out.println("\nAll Countries in " + continent + ":");
        a.reportsHandler.displayCountries(allContinentCountries);

        // display all countries in a given region report
        System.out.println("\nAll Countries in " + region + ":");
        a.reportsHandler.displayCountries(allRegionCountries);

        // Get the top N populated countries
        System.out.println("\nTop " + n + " Countries Globally:");
        a.reportsHandler.displayCountries(globalCountries);

        // Get the top N populated countries by continent
        System.out.println("\nTop " + n + " Countries in " + continent + ":");
        a.reportsHandler.displayCountries(continentCountries);

        // Get the top N populated countries by region
        System.out.println("\nTop " + n + " Countries in " + region + ":");
        a.reportsHandler.displayCountries(regionCountries);

        // Disconnect from database
        a.dbHandler.disconnect();

    }
}