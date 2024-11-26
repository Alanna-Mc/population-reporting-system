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
        reportsHandler = new ReportHandler(dbHandler);
    }
    /**
     * Main method to run the application.
     */
    public static void main(String[] args)
    {
        App a = new App();

        // Connect to database
        if (args.length < 1) {
            a.dbHandler.connect("localhost:33060", 10000);
        } else {
            a.dbHandler.connect(args[0], Integer.parseInt(args[1]));
        }

        // Hard coded values
        int n = 10;
        String continent = "Europe";
        String region = "Eastern Europe";
        String country = "USA";
        String district = "Scotland";
        String continentTotalPop = "Asia";


        // <GENERATE COUNTRY REPORTS>


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

        // display all countries in a given continent report
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

        //  <GENERATE CITY REPORTS>

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


        //  <CAPITAL CITY REPORTS>

        // Get all the capital cities in the world, given continent or given region
        ArrayList<Capital> allGlobalCapitals = a.dbHandler.getAllCapitalCities();
        ArrayList<Capital> allContinentCapitals = a.dbHandler.getAllCapitalCitiesInContinent(continent);
        ArrayList<Capital> allRegionCapitals = a.dbHandler.getAllCapitalCitiesInRegion(region);

        // Get top N capital cities in the world, given continent or region
        ArrayList<Capital> NGlobalCapitals = a.dbHandler.getNCapitalCities(n);
        ArrayList<Capital> NContinentCapitals = a.dbHandler.getTopNCapitalCitiesInContinent(n, continent);
        ArrayList<Capital> NRegionCapitals = a.dbHandler.getTopNCapitalCitiesInRegion(n, region);

        // Display all capital cities in the world
        System.out.println("\nAll Capitals in the world:");
        a.reportsHandler.displayCapitals(allGlobalCapitals);

        // Display all capital cities in a given continent
        System.out.println("\nAll Capitals in " + continent + ":");
        a.reportsHandler.displayCapitals(allContinentCapitals);

        // Display all capital cities in a given region
        System.out.println("\nAll Capitals in " + region + ":");
        a.reportsHandler.displayCapitals(allRegionCapitals);

        // Display top N capital cities in the world
        System.out.println("\nTop " + n + " Capitals in the world:");
        a.reportsHandler.displayCapitals(NGlobalCapitals);

        // Display top N capital cities in given continent
        System.out.println("\nTop " + n + " Capitals in " + continent + ":");
        a.reportsHandler.displayCapitals(NContinentCapitals);

        // Display top N capital cities in given region
        System.out.println("\nTop " + n + " Capitals in " + region + ":");
        a.reportsHandler.displayCapitals(NRegionCapitals);


        // <POPULATION REPORTS>

        // Display the total population of people living in cities and not living in cities
        // for each Country, Region, & Continent
        System.out.println("\n\nCountry city and non-city population total:\n");
        a.reportsHandler.displayCountryPopulationCityNonCity();

        System.out.println("\n\nContinent city and non-city population total:\n");
        a.reportsHandler.displayContinentPopulationCityNonCity();

        System.out.println("\n\nRegion city and non-city population total:\n");
        a.reportsHandler.displayRegionPopulationCityNonCity();

        // Total World Population Report
        long worldPopulation = a.dbHandler.getWorldPopulation();
        System.out.println("\nThe total population of the world is: " + worldPopulation);

        // Total Chosen Continent Population Report
        long chosenContinentPopulation = a.dbHandler.getContinentPopulation(continentTotalPop);
        System.out.println("\nThe total population of " + continentTotalPop + " is: " + chosenContinentPopulation);


        // Disconnect from database
        a.dbHandler.disconnect();

    }
}