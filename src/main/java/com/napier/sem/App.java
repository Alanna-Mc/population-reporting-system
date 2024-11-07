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
        String country = "USA";
        String district = "Scotland";

        //region <GENERATE COUNTRY REPORTS>
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
        //endregion

        //region <GENERATE CITY REPORTS>
        // Get all the Cities in the world, given continent, region, country or district
        ArrayList<City> allGlobalCities = a.dbHandler.getAllCities();
        ArrayList<City> allContinentCities = a.dbHandler.getAllCityInContinent(continent);
        ArrayList<City> allRegionCities = a.dbHandler.getAllCityInRegion(region);
        ArrayList<City> allDistrictCities = a.dbHandler.getAllCityInDistrict(district);
        ArrayList<City> allCountryCities = a.dbHandler.getAllCityInCountry(country);

        ArrayList<City> globalCities = a.dbHandler.getTopNPopulatedCities(n);
        ArrayList<City> continentCities = a.dbHandler.getTopNPopulatedCitiesInContinent(n, continent);
        ArrayList<City> regionCities = a.dbHandler.getTopNPopulatedCitiesInRegion(n, region);
        ArrayList<City> districtCities = a.dbHandler.getTopNPopulatedCitiesInDistrict(n, district);
        ArrayList<City> countryCities = a.dbHandler.getTopNPopulatedCitiesInCountry(n, country);

        // display all the Cities in the world
        System.out.println("\nAll Cities in the world:");
        a.reportsHandler.displayCities(allGlobalCities);

        // display all Cities  in a given continent report
        System.out.println("\nAll Cities in " + continent + ":");
        a.reportsHandler.displayCities(allContinentCities);

        // display all Cities in a given region report
        System.out.println("\nAll Cities in " + region + ":");
        a.reportsHandler.displayCities(allRegionCities);

        // display all Cities  in a given district report
        System.out.println("\nAll Cities in " + district + ":");
        a.reportsHandler.displayCities(allDistrictCities);

        // display all Cities in a given country report
        System.out.println("\nAll Cities in " + country + ":");
        a.reportsHandler.displayCities(allCountryCities);

        // display Top N Cities in the world
        System.out.println("\nTop " + n + " Cities in the world:");
        a.reportsHandler.displayCities(globalCities);

        // display Top N Cities  in a given continent report
        System.out.println("\nTop " + n + " Cities in " + continent + ":");
        a.reportsHandler.displayCities(continentCities);

        // display Top N Cities in a given region report
        System.out.println("\nTop " + n + " Cities in " + region + ":");
        a.reportsHandler.displayCities(regionCities);

        // display Top N Cities in a given district report
        System.out.println("\nTop " + n + " Cities in " + district + ":");
        a.reportsHandler.displayCities(districtCities);

        // display Top N Cities in a given country report
        System.out.println("\nTop " + n + " Cities in " + country + ":");
        a.reportsHandler.displayCities(countryCities);
        //endregion


        // Disconnect from database
        a.dbHandler.disconnect();

    }
}