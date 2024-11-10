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
        void displayCountriesTestNull() {
            // Test handling of null input
            reportHandler.displayCountries(null);
        }

        // Country list is Empty
        @Test
        void displayCountriesTestEmpty() {
            ArrayList<Country> countries = new ArrayList<>();
            reportHandler.displayCountries(countries);
        }

        // Country Contains null
        @Test
        void displayCountriesTestContainsNull() {
            ArrayList<Country> countries = new ArrayList<>();
            countries.add(null);
            reportHandler.displayCountries(countries);
        }

        // Country Contains All Non-null
        @Test
        void displayCountriesTestNormal() {
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

        //City is null
        @Test
        void displayCitiesTestNull() {
            // Test handling of null input
            reportHandler.displayCities(null);
        }

        //City list in empty
        @Test
        void displayCitiesTestEmpty() {
            ArrayList<City> city = new ArrayList<>();
            reportHandler.displayCities(city);
        }

        // City Contains null
        @Test
        void displayCitiesTestContainsNull() {
            ArrayList<City> city = new ArrayList<>();
            city.add(null);
            reportHandler.displayCities(city);
        }

        // City Contains All Non-null
        @Test
        void displayCitiesTestNormal() {
            ArrayList<City> cities = new ArrayList<>();
            // Create data
            City City1 = new City();
            City1.name = "A_Country";
            City1.country = "ABC";
            City1.district = "A_District";
            City1.population = 1000000;

            City City2 = new City();
            City2.name = "B_Country";
            City2.country = "DEF";
            City2.district = "B_District";
            City2.population = 600000;

            // Add to list
            cities.add(City1);
            cities.add(City2);

            reportHandler.displayCities(cities);
        }

    @Test
    void displayCapitalsTestNull() {
        // Test handling of null input
        reportHandler.displayCapitals(null);
    }

    // Capital list is Empty
    @Test
    void displayCapitalsTestEmpty() {
        ArrayList<Capital> capitals = new ArrayList<>();
        reportHandler.displayCapitals(capitals);
    }

    // Capital Contains null
    @Test
    void displayCapitalsTestContainsNull() {
        ArrayList<Capital> capitals = new ArrayList<>();
        capitals.add(null);
        reportHandler.displayCapitals(capitals);
    }

    // Capital Contains All Non-null
    @Test
    void displayCapitalsTestNormal() {
        ArrayList<Capital> capitals = new ArrayList<>();
        // Create data
        Capital capital1 = new Capital();
        capital1.name = "Capital";
        capital1.country = "Country";
        capital1.population = 800000;

        Capital capital2 = new Capital();
        capital2.name = "Another_Capital";
        capital2.country = "Another_Country";
        capital2.population = 20000;

        // Add to list
        capitals.add(capital1);
        capitals.add(capital2);

        reportHandler.displayCapitals(capitals);
    }


    }


