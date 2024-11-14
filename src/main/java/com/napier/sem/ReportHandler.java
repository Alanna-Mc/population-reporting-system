package com.napier.sem;

import java.util.ArrayList;

/**
 * Class to handle the display of various reports.
 */
public class ReportHandler {

    private DatabaseHandler databaseHandler = new DatabaseHandler();

    // Constructors
    // Initialise without a DatabaseHandler
    public ReportHandler() {
        this.databaseHandler = null;
    }
    // Accepts a DatabaseHandler instance
    public ReportHandler(DatabaseHandler dbHandler) {
        this.databaseHandler = dbHandler;
    }

    /**
     * Displays countries.
     * @param countries A list of Country objects representing countries.
     */
    public void displayCountries(ArrayList<Country> countries) {
        if (countries == null || countries.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        System.out.printf("%-5s %-45s %-15s %-30s %-12s %-30s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");

        for (Country country : countries) {
            if (country == null) continue;
            String country_string =
                    String.format("%-5s %-45s %-15s %-30s %-12s %-30s",
                            country.code, country.name, country.continent, country.region, country.population, country.capital);
            System.out.println(country_string);

        }
    }

    /**
     * Displays cities
     * @param cities A list of City objects representing cities
     */
    public void displayCities(ArrayList<City> cities) {
        if (cities == null || cities.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        System.out.printf("%-45s %-30s %-30s %-10s%n", "Name", "Country", "District", "Population");

        for (City city : cities) {
            if (city == null) continue;
            String city_string =
                    String.format("%-45s %-30s %-30s %-10s",
                            city.name, city.country, city.district, city.population);
            System.out.println(city_string);

        }
    }

    /**
     * Display capital cities
     * @param capitals A list of Capital objects representing capital cities
     */
    public void displayCapitals(ArrayList<Capital> capitals) {
        if (capitals == null || capitals.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        System.out.printf("%-45s %-45s %-30s%n", "Name", "Country", "Population");

        for (Capital capital : capitals) {
            if (capital == null) continue;
            String capital_string =
                    String.format("%-45s %-45s %-30s",
                            capital.name, capital.country, capital.population);
            System.out.println(capital_string);

        }
    }

    /**
     * Display the calculated populations for each country.
     */
    public void displayCountryPopulationCityNonCity() {

        ArrayList<Country> countries = databaseHandler.getCountryCitiesAndNonCitiesPopulationTotals();

        System.out.printf("%-45s %-15s %-15s%n", "Country", "City Population", "Non-City Population");

        for (Country country : countries) {
            System.out.printf("%-45s %-15d %-15d%n",
                    country.name, country.cityPopulation, country.nonCityPopulation);
        }
    }
}
