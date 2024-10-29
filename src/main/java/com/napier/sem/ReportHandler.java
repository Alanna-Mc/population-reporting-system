package com.napier.sem;

import java.util.ArrayList;

/**
 * Class to handle the display of various reports.
 */
public class ReportHandler {

    /**
     * Displays the top N populated countries.
     * @param countries A list of Country objects representing the top N populated countries.
     * @param n The number of top countries to display.
     */
    public void displayTopCountries(ArrayList<Country> countries, int n) {
        if (countries == null || countries.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        System.out.println("Code | Name | Continent | Region | Population | Capital");

        for (Country country : countries) {
            if (country == null) continue;
            System.out.println(
                    country.code + " | " +
                    country.name + " | " +
                    country.continent + " | " +
                    country.region + " | " +
                    country.population + " | " +
                    (country.capital != null ? country.capital : "N/A")
            );
        }
    }
}
