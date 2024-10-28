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

        System.out.println("Top " + n + " Populated Countries:");
        System.out.println("Name |Population");

        for (Country country : countries) {
            System.out.println(
                    country.name + " | " +
                    country.population
            );
        }
    }
}
