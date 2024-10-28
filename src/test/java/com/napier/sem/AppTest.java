package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class AppTest
{
        static ReportHandler reportHandler;

        @BeforeAll
        static void init() {
        // Initialise the ReportHandler instance
        reportHandler = new ReportHandler();
    }

        // Country is null
        @Test
        void displayTopCountriesTestNull() {
        // Test handling of null input
        reportHandler.displayTopCountries(null, 10);
    }

        // Country list is Empty
        @Test
        void displayTopCountriesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        reportHandler.displayTopCountries(countries, 10);

    }

        // Country Contains null
        @Test
        void displayTopCountriesTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        reportHandler.displayTopCountries(countries, 10);
    }

        // Country Contains All Non-null
        @Test
        void displayTopCountriesTestNormal() {
        ArrayList<Country> countries = new ArrayList<>();
        // Create data
        Country country1 = new Country();
        country1.name = "A_Country";
        country1.population = 1000000;
        Country country2 = new Country();
        country2.name = "Another_Country";
        country2.population = 800000;

        // Add to list
        countries.add(country1);
        countries.add(country2);

        reportHandler.displayTopCountries(countries, 2);
    }
}
