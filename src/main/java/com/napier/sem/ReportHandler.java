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
