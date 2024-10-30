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
            reportHandler.displayCountries(null);
        }

        // Country list is Empty
        @Test
        void displayTopCountriesTestEmpty() {
            ArrayList<Country> countries = new ArrayList<>();
            reportHandler.displayCountries(countries);
        }

        // Country Contains null
        @Test
        void displayTopCountriesTestContainsNull() {
            ArrayList<Country> countries = new ArrayList<>();
            countries.add(null);
            reportHandler.displayCountries(countries);
        }

        // Country Contains All Non-null
        @Test
        void displayTopCountriesTestNormal() {
            ArrayList<Country> countries = new ArrayList<>();
            // Create data
            Country country1 = new Country();
            country1.code = "ABC";
            country1.name = "A_Country";
            country1.population = 1000000;
            country1.continent = "A_Continent";
            country1.capital = "Capital 1";
            country1.region = "A_Region";

            Country country2 = new Country();
            country2.code = "DEF";
            country2.name = "Another_Country";
            country2.population = 800000;
            country2.continent = "Another_Continent";
            country2.capital = "Capital 2";
            country2.region = "Another_Region";

            // Add to list
            countries.add(country1);
            countries.add(country2);

            reportHandler.displayCountries(countries);
        }
}
