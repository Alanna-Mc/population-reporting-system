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


        // Get the top N populated countries: globally, by continent and by region
        ArrayList<Country> globalCountries = a.dbHandler.getTopNPopulatedCountries(n);

        ArrayList<Country> continentCountries = a.dbHandler.getTopNPopulatedCountriesInContinent(n, continent);

        ArrayList<Country> regionCountries = a.dbHandler.getTopNPopulatedCountriesInRegion(n, region);

        // Display each report
        // Get the top N populated countries
        System.out.println("\nTop " + n + " Countries Globally:");
        a.reportsHandler.displayTopCountries(globalCountries, n);

        // Get the top N populated countries by continent
        System.out.println("\nTop " + n + " Countries in " + continent + ":");
        a.reportsHandler.displayTopCountries(continentCountries, n);

        // Get the top N populated countries by region
        System.out.println("\nTop " + n + " Countries in " + region + ":");
        a.reportsHandler.displayTopCountries(regionCountries, n);

        // Disconnect from database
        a.dbHandler.disconnect();

    }
}