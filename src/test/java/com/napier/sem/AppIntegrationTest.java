package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static DatabaseHandler dbHandler;
    static ReportHandler reportHandler;

    /**
     *
     */
    @BeforeAll
    static void init()
    {
        app = new App();
        dbHandler = new DatabaseHandler();
        dbHandler.connect("localhost:33060", 30000);
        reportHandler = new ReportHandler();
    }

    //region <GET COUNTRIES TESTS>

    /**
     * Test that checks that getAllCountries method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCountriesTest()
    {
        ArrayList<Country> countries = dbHandler.getAllCountries();
        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertNotNull(countries.get(0), "Object at index position of countries should not be null");
    }

    /**
     * Test that checks that getAllCountriesInContinent method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCountriesInContinentTest()
    {
        ArrayList<Country> countries = dbHandler.getAllCountriesInContinent("Europe");
        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertNotNull(countries.get(0), "Object at index position of countries should not be null");
    }

    /**
     * Test that checks that getAllCountriesInRegion method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCountriesInRegionTest()
    {
        ArrayList<Country> countries = dbHandler.getAllCountriesInRegion("Eastern Europe");
        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertNotNull(countries.get(0), "Object at index position of countries should not be null");
    }

    /**
     * Test that checks that getTopNPopulatedCountries method is returning an arraylist that's size is equal to N
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNCountriesTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountries(5);
        assertEquals(countries.size(), 5, "countries size should be 5");
        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertNotNull(countries.get(0), "Object at index position of countries should not be null");
    }

    /**
     * Test that checks that getTopNPopulatedCountriesInContinent method is returning an arraylist that's size is equal to N
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNCountriesInContinentTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountriesInContinent(5, "Europe");
        assertEquals(countries.size(), 5);
        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertNotNull(countries.get(0), "Object at index position of countries should not be null");
    }

    /**
     * Test that checks that getTopNPopulatedCountriesInRegion method is returning an arraylist that's size is equal to N
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNCountriesInRegionTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountriesInRegion(5, "Eastern Europe");
        assertEquals(countries.size(), 5);
        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertNotNull(countries.get(0), "Object at index position of countries should not be null");
    }

    /**
     * Test that checks the displayCountries method is working correctly when valid parameter is entered
     */
    @Test
    void displayCountriesTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountries(5);
        reportHandler.displayCountries(countries);
    }

    //endregion

    //region <GET CITIES TESTS>

    /**
     * Test that checks that getAllCities method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCitiesTest()
    {
        ArrayList<City> cities = dbHandler.getAllCities();
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getAllCitiesInContinent method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCitiesInContinentTest()
    {
        ArrayList<City> cities = dbHandler.getAllCityInContinent("Europe");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getAllCitiesInRegion method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCitiesInRegionTest()
    {
        ArrayList<City> cities = dbHandler.getAllCityInRegion("Eastern Europe");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getAllCitiesInDistrict method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCitiesInDistrictTest()
    {
        ArrayList<City> cities = dbHandler.getAllCityInDistrict("Scotland");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getAllCitiesInCountry method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCitiesInCountryTest()
    {
        ArrayList<City> cities = dbHandler.getAllCityInCountry("USA");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getTopNPopulatedCities method is returning an arraylist that's size is equal to N.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNPopulatedCitiesTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCities(3);
        assertEquals(cities.size(), 3, "cities size should be 3");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getTopNPopulatedCitiesInContinent method is returning an arraylist that's size is equal to N.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNPopulatedCitiesInContinentTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInContinent(3,"Europe");
        assertEquals(cities.size(), 3, "cities size should be 3");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getTopNPopulatedCitiesInRegion method is returning an arraylist that's size is equal to N.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNPopulatedCitiesInRegionTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInRegion(3, "Eastern Europe");
        assertEquals(cities.size(), 3, "cities size should be 3");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getTopNPopulatedCitiesInDistrict method is returning an arraylist that's equal to N.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNPopulatedCitiesInDistrictTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInDistrict(3, "Scotland");
        assertEquals(cities.size(), 3, "cities size should be 3");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks that getTopNPopulatedCitiesInCountry method is returning an arraylist that's size is equal to N.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNPopulatedCitiesInCountryTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInCountry(3,"USA");
        assertEquals(cities.size(), 3, "cities size should be 3");
        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertNotNull(cities.get(0), "Object at index position of cities should not be null");
    }

    /**
     * Test that checks the displayCities method is working correctly when valid parameter is entered
     */
    @Test
    void displayCitiesTest() {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCities(5);
        reportHandler.displayCities(cities);
    }

    //endregion

    //region <GET CAPITAL CITIES TESTS>

    /**
     * Test that checks that getAllCapitals method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCapitalsTest()
    {
        ArrayList<Capital> capitals = dbHandler.getAllCapitalCities();
        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertNotNull(capitals.get(0), "Object at index position of capitals should not be null");
    }

    /**
     * Test that checks that getAllCapitalsInContinent method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCapitalsInContinentTest()
    {
        ArrayList<Capital> capitals = dbHandler.getAllCapitalCitiesInContinent("Europe");
        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertNotNull(capitals.get(0), "Object at index position of capitals should not be null");
    }

    /**
     * Test that checks that getAllCapitalsInRegion method is returning an arraylist that is not empty.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getAllCapitalsInRegionTest()
    {
        ArrayList<Capital> capitals = dbHandler.getAllCapitalCitiesInRegion("Eastern Europe");
        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertNotNull(capitals.get(0), "Object at index position of capitals should not be null");
    }

    /**
     * Test that checks that getTopNCapitalCities method is returning an arraylist that's size is equal to N.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNPopulatedCapitalsTest()
    {
        ArrayList<Capital> capitals = dbHandler.getNCapitalCities(3);
        assertEquals(capitals.size(), 3,  "capitals size should be 3");
        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertNotNull(capitals.get(0), "Object at index position of capitals should not be null");
    }

    /**
     * Test that checks that getTopNCapitalCitiesInContinent method is returning an arraylist that's size is equal to N.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNPopulatedCapitalsInContinentTest()
    {
        ArrayList<Capital> capitals = dbHandler.getTopNCapitalCitiesInContinent(3,"Europe");
        assertEquals(capitals.size(), 3,  "capitals size should be 3");
        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertNotNull(capitals.get(0), "Object at index position of capitals should not be null");
    }

    /**
     * Test that checks that getAllCapitalsInRegion method is returning an arraylist that's size is equal to N.
     * Test that checks the object at index position 0 is not null
     */
    @Test
    void getTopNPopulatedCapitalsInRegionTest()
    {
        ArrayList<Capital> capitals = dbHandler.getTopNCapitalCitiesInRegion(3,"Eastern Europe");
        assertEquals(capitals.size(), 3,  "capitals size should be 3");
        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertNotNull(capitals.get(0), "Object at index position of capitals should not be null");
    }

    /**
     * Test that checks the displayCapitalCities method is working correctly when valid parameter is entered
     */
    @Test
    void displayCapitalsTest() {
        ArrayList<Capital> capitals = dbHandler.getNCapitalCities(3);
        reportHandler.displayCapitals(capitals);
    }

    //endregion

}
