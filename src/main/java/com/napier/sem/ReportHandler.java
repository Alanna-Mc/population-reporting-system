package com.napier.sem;

import java.util.ArrayList;

/**
 * Class to handle the display of various reports.
 */
public class ReportHandler {

    /**
     * Displays the top N populated countries.
     * @param countries A list of Country objects representing the top N populated countries.
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

    public void displayCities(ArrayList<City> cities) {
        if (cities == null || cities.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        System.out.printf("%-5s %-45s %-15s %-30sn", "Name", "Country", "District", "Population");

        for (City city : cities) {
            if (city == null) continue;
            String city_string =
                    String.format("%-5s %-45s %-15s %-30s",
                            City.name, City.country, City.district, City.population);
            System.out.println(city_string);

        }
    }
}
