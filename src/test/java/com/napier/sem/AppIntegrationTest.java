package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static DatabaseHandler dbHandler;
    static ReportHandler reportHandler;

    @BeforeAll
    static void init()
    {
        app = new App();
        dbHandler = new DatabaseHandler();
        dbHandler.connect("localhost:33060", 30000);
    }

    //region <GET COUNTRIES TESTS>

        @Test
        void getAllCountriesTest()
        {
            ArrayList<Country> countries = dbHandler.getAllCountries();

            assertFalse(countries.isEmpty());
            assertNotNull(countries.get(0).code);
            assertNotNull(countries.get(0).name);
            assertNotNull(countries.get(0).continent);
            assertNotNull(countries.get(0).region);
            assertNotNull(countries.get(0).capital);
            assertTrue(countries.get(0).population >= 0);
        }

        @Test
        void getAllCountriesInContinentTest()
        {
            ArrayList<Country> countries = dbHandler.getAllCountriesInContinent("Europe");

            assertFalse(countries.isEmpty());
            assertNotNull(countries.get(0).code);
            assertNotNull(countries.get(0).name);
            assertNotNull(countries.get(0).continent);
            assertNotNull(countries.get(0).region);
            assertNotNull(countries.get(0).capital);
            assertTrue(countries.get(0).population >= 0);
        }

        @Test
        void getAllCountriesInRegionTest()
        {
            ArrayList<Country> countries = dbHandler.getAllCountriesInRegion("Eastern Europe");

            assertFalse(countries.isEmpty());
            assertNotNull(countries.get(0).code);
            assertNotNull(countries.get(0).name);
            assertNotNull(countries.get(0).continent);
            assertNotNull(countries.get(0).region);
            assertNotNull(countries.get(0).capital);
            assertTrue(countries.get(0).population >= 0);
        }

        @Test
        void getNCountriesTest() {
            ArrayList<Country> countries = dbHandler.getTopNPopulatedCountries(5);

            assertEquals(countries.size(), 5);
            assertNotNull(countries.get(0).code);
            assertNotNull(countries.get(0).name);
            assertNotNull(countries.get(0).continent);
            assertNotNull(countries.get(0).region);
            assertNotNull(countries.get(0).capital);
            assertTrue(countries.get(0).population >= 0);
        }

        @Test
        void getNCountriesInContinentTest() {
            ArrayList<Country> countries = dbHandler.getTopNPopulatedCountriesInContinent(5, "Europe");

            assertEquals(countries.size(), 5);
            assertNotNull(countries.get(0).code);
            assertNotNull(countries.get(0).name);
            assertNotNull(countries.get(0).continent);
            assertNotNull(countries.get(0).region);
            assertNotNull(countries.get(0).capital);
            assertTrue(countries.get(0).population >= 0);
        }

        @Test
        void getNCountriesInRegionTest() {
            ArrayList<Country> countries = dbHandler.getTopNPopulatedCountriesInRegion(5, "Eastern Europe");

            assertEquals(countries.size(), 5);
            assertNotNull(countries.get(0).code);
            assertNotNull(countries.get(0).name);
            assertNotNull(countries.get(0).continent);
            assertNotNull(countries.get(0).region);
            assertNotNull(countries.get(0).capital);
            assertTrue(countries.get(0).population >= 0);
        }

    //endregion

    //region <GET CITIES TESTS>

        @Test
        void getAllCitiesTest()
        {
            ArrayList<City> cities = dbHandler.getAllCities();

            assertFalse(cities.isEmpty());
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getAllCitiesInContinentTest()
        {
            ArrayList<City> cities = dbHandler.getAllCityInContinent("Europe");

            assertFalse(cities.isEmpty());
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getAllCitiesInRegionTest()
        {
            ArrayList<City> cities = dbHandler.getAllCityInRegion("Eastern Europe");

            assertFalse(cities.isEmpty());
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getAllCitiesInDistrictTest()
        {
            ArrayList<City> cities = dbHandler.getAllCityInDistrict("Scotland");

            assertFalse(cities.isEmpty());
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getAllCitiesInCountryTest()
        {
            ArrayList<City> cities = dbHandler.getAllCityInCountry("USA");

            assertFalse(cities.isEmpty());
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getTopNCitiesTest()
        {
            ArrayList<City> cities = dbHandler.getTopNPopulatedCities(3);

            assertFalse(cities.isEmpty());
            assertEquals(cities.size(), 3);
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getTopNCitiesInContinentTest()
        {
            ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInContinent(3,"Europe");

            assertFalse(cities.isEmpty());
            assertEquals(cities.size(), 3);
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getTopNCitiesInRegionTest()
        {
            ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInRegion(3, "Eastern Europe");

            assertFalse(cities.isEmpty());
            assertEquals(cities.size(), 3);
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getTopNCitiesInDistrictTest()
        {
            ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInDistrict(3, "Scotland");

            assertFalse(cities.isEmpty());
            assertEquals(cities.size(), 3);
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

        @Test
        void getTopNCitiesInCountryTest()
        {
            ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInCountry(3,"USA");

            assertFalse(cities.isEmpty());
            assertEquals(cities.size(), 3);
            assertNotNull(cities.get(0).name);
            assertNotNull(cities.get(0).country);
            assertNotNull(cities.get(0).district);
            assertTrue(cities.get(0).population >= 0);
        }

    //endregion

    //region <GET CAPITAL CITIES TESTS>

        @Test
        void getAllCapitalsTest()
        {
            ArrayList<Capital> capitals = dbHandler.getAllCapitalCities();

            assertFalse(capitals.isEmpty());
            assertNotNull(capitals.get(0).name);
            assertNotNull(capitals.get(0).country);
            assertTrue(capitals.get(0).population >= 0);
        }

        @Test
        void getAllCapitalsInContinentTest()
        {
            ArrayList<Capital> capitals = dbHandler.getAllCapitalCitiesInContinent("Europe");

            assertFalse(capitals.isEmpty());
            assertNotNull(capitals.get(0).name);
            assertNotNull(capitals.get(0).country);
            assertTrue(capitals.get(0).population >= 0);
        }

        @Test
        void getAllCapitalsInRegionTest()
        {
            ArrayList<Capital> capitals = dbHandler.getAllCapitalCitiesInContinent("Europe");

            assertFalse(capitals.isEmpty());
            assertNotNull(capitals.get(0).name);
            assertNotNull(capitals.get(0).country);
            assertTrue(capitals.get(0).population >= 0);
        }

    //endregion

}
