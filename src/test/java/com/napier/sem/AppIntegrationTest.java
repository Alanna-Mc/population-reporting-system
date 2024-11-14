package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static DatabaseHandler dbHandler;

    /**
     *
     */
    @BeforeAll
    static void init()
    {
        app = new App();
        dbHandler = new DatabaseHandler();
        dbHandler.connect("localhost:33060", 30000);
    }

    //region <GET COUNTRIES TESTS>

    /**
     * Test that checks that getAllCountries method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCountriesTest()
    {
        ArrayList<Country> countries = dbHandler.getAllCountries();

        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertEquals(countries.get(0).code, "CHN", "Code should be CHN");
        assertEquals(countries.get(0).name, "China", "Name should be China");
        assertEquals(countries.get(0).continent, "Asia", "Continent should be Asia");
        assertEquals(countries.get(0).region, "Eastern Asia", "Region should be Eastern Asia");
        assertEquals(countries.get(0).capital, "Peking", "Capital should be Peking");
        assertEquals(countries.get(0).population, 1277558000, "Population should be 1277558000");
    }

    /**
     * Test that checks that getAllCountriesInContinent method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCountriesInContinentTest()
    {
        ArrayList<Country> countries = dbHandler.getAllCountriesInContinent("Europe");

        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertEquals(countries.get(0).code, "RUS", "Code should be RUS");
        assertEquals(countries.get(0).name, "Russian Federation", "Name should be Russian Federation");
        assertEquals(countries.get(0).continent, "Europe", "Continent should be Europe");
        assertEquals(countries.get(0).region, "Eastern Europe", "Region should be Eastern Europe");
        assertEquals(countries.get(0).capital, "Moscow", "Capital should be Moscow");
        assertEquals(countries.get(0).population,146934000, "Population should be 146934000");
    }

    /**
     * Tests getAllCountriesInContinent method when invalid continent is entered as param
     */
    @Test
    void getCountriesByInvalidContinentTest() {
        ArrayList<Country> countries = dbHandler.getAllCountriesInContinent("Invalid");
        assertTrue(countries.isEmpty(), "countries arraylist should be empty when invalid continent entered");
    }

    /**
     * Test that checks that getAllCountriesInRegion method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCountriesInRegionTest()
    {
        ArrayList<Country> countries = dbHandler.getAllCountriesInRegion("Eastern Europe");

        assertFalse(countries.isEmpty(), "countries ArrayList should not be empty");
        assertEquals(countries.get(0).code, "RUS", "Code should be RUS");
        assertEquals(countries.get(0).name, "Russian Federation", "Name should be Russian Federation");
        assertEquals(countries.get(0).continent, "Europe", "Continent should be Europe");
        assertEquals(countries.get(0).region, "Eastern Europe", "Region should be Eastern Europe");
        assertEquals(countries.get(0).capital, "Moscow", "Capital should be Moscow");
        assertEquals(countries.get(0).population,146934000, "Population should be 146934000");
    }

    /**
     * Tests getAllCountriesInRegion method when invalid region is entered as param
     */
    @Test
    void getCountriesByInvalidRegionTest() {
        ArrayList<Country> countries = dbHandler.getAllCountriesInRegion("Invalid");
        assertTrue(countries.isEmpty(), "countries arraylist should be empty when invalid region entered");
    }

    /**
     * Test that checks that getTopNPopulatedCountries method is returning an arraylist that's size is equal to N
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNCountriesTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountries(5);

        assertEquals(countries.size(), 5, "countries size should be 5");
        assertEquals(countries.get(0).code, "CHN", "Code should be CHN");
        assertEquals(countries.get(0).name, "China", "Name should be China");
        assertEquals(countries.get(0).continent, "Asia", "Continent should be Asia");
        assertEquals(countries.get(0).region, "Eastern Asia", "Region should be Eastern Asia");
        assertEquals(countries.get(0).capital, "Peking", "Capital should be Peking");
        assertEquals(countries.get(0).population, 1277558000, "Population should be 1277558000");
    }

    /**
     * Tests getTopNPopulatedCountries method with invalid param entered to ensure arraylist is null
     */
    @Test
    void getTopNCountriesInvalidNTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountries(-1);
        assertNull(countries, "countries arraylist should be null");
    }

    /**
     * Test that checks that getTopNPopulatedCountriesInContinent method is returning an arraylist that's size is equal to N
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNCountriesInContinentTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountriesInContinent(5, "Europe");

        assertEquals(countries.size(), 5);
        assertEquals(countries.get(0).code, "RUS");
        assertEquals(countries.get(0).name, "Russian Federation");
        assertEquals(countries.get(0).continent, "Europe");
        assertEquals(countries.get(0).region, "Eastern Europe");
        assertEquals(countries.get(0).capital, "Moscow");
        assertEquals(countries.get(0).population,146934000);
    }

    /**
     * Tests getTopNPopulatedCountriesInContinent method with invalid param to ensure arraylist is null
     */
    @Test
    void getTopNCountriesInContinentInvalidNTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountriesInContinent(-1, "Europe");
        assertNull(countries, "countries arraylist should be null");
    }

    /**
     * Test that checks that getTopNPopulatedCountriesInRegion method is returning an arraylist that's size is equal to N
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNCountriesInRegionTest() {
        ArrayList<Country> countries = dbHandler.getTopNPopulatedCountriesInRegion(5, "Eastern Europe");

        assertEquals(countries.size(), 5);
        assertEquals(countries.get(0).code, "RUS");
        assertEquals(countries.get(0).name, "Russian Federation");
        assertEquals(countries.get(0).continent, "Europe");
        assertEquals(countries.get(0).region, "Eastern Europe");
        assertEquals(countries.get(0).capital, "Moscow");
        assertEquals(countries.get(0).population,146934000);
    }

    //endregion

    //region <GET CITIES TESTS>

    /**
     * Test that checks that getAllCities method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCitiesTest()
    {
        ArrayList<City> cities = dbHandler.getAllCities();

        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertEquals(cities.get(0).name, "Mumbai (Bombay)", "Name should be Mumbai (Bombay)");
        assertEquals(cities.get(0).country, "India", "Country should be India");
        assertEquals(cities.get(0).district, "Maharashtra", "District should be Maharashtra");
        assertEquals(cities.get(0).population, 10500000, "Population should be 10500000");
    }

    /**
     * Test that checks that getAllCitiesInContinent method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCitiesInContinentTest()
    {
        ArrayList<City> cities = dbHandler.getAllCityInContinent("Europe");

        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertEquals(cities.get(0).name, "Moscow", "Name should be Moscow");
        assertEquals(cities.get(0).country, "Russian Federation", "Country should be Russian Federation");
        assertEquals(cities.get(0).district, "Moscow (City)", " District should be Moscow (City)");
        assertEquals(cities.get(0).population, 8389200, "Population should be 8389200");
    }

    /**
     * Test that checks that getAllCitiesInRegion method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCitiesInRegionTest()
    {
        ArrayList<City> cities = dbHandler.getAllCityInRegion("Eastern Europe");

        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertEquals(cities.get(0).name, "Moscow", "Name should be Moscow");
        assertEquals(cities.get(0).country, "Russian Federation", "Country should be Russian Federation");
        assertEquals(cities.get(0).district, "Moscow (City)", " District should be Moscow (City)");
        assertEquals(cities.get(0).population, 8389200, "Population should be 8389200");
    }

    /**
     * Test that checks that getAllCitiesInDistrict method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCitiesInDistrictTest()
    {
        ArrayList<City> cities = dbHandler.getAllCityInDistrict("Scotland");

        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertEquals(cities.get(0).name, "Glasgow", "Name should be Glasgow");
        assertEquals(cities.get(0).country, "United Kingdom", "Country should be United Kingdom");
        assertEquals(cities.get(0).district, "Scotland", "District should be Scotland");
        assertEquals(cities.get(0).population, 619680, "Population should be 619680");
    }

    /**
     * Test that checks that getAllCitiesInCountry method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCitiesInCountryTest()
    {
        ArrayList<City> cities = dbHandler.getAllCityInCountry("USA");

        assertFalse(cities.isEmpty(), "cities array should not be empty");
        assertEquals(cities.get(0).name, "New York", "Name should be New York");
        assertEquals(cities.get(0).country, "United States", "Country should be United States");
        assertEquals(cities.get(0).district, "New York", "District should be New York");
        assertEquals(cities.get(0).population, 8008278, "Population should be 8008278");
    }

    /**
     * Test that checks that getTopNPopulatedCities method is returning an arraylist that's size is equal to N.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNPopulatedCitiesTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCities(3);

        assertEquals(cities.size(), 3, "cities size should be 3");
        assertEquals(cities.get(0).name, "Mumbai (Bombay)", "Name should be Mumbai (Bombay)");
        assertEquals(cities.get(0).country, "India", "Country should be India");
        assertEquals(cities.get(0).district, "Maharashtra", "District should be Maharashtra");
        assertEquals(cities.get(0).population, 10500000, "Population should be 10500000");
    }

    /**
     * Test that checks that getTopNPopulatedCitiesInContinent method is returning an arraylist that's size is equal to N.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNPopulatedCitiesInContinentTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInContinent(3,"Europe");

        assertEquals(cities.size(), 3, "cities size should be 3");
        assertEquals(cities.get(0).name, "Moscow", "Name should be Moscow");
        assertEquals(cities.get(0).country, "Russian Federation", "Country should be Russian Federation");
        assertEquals(cities.get(0).district, "Moscow (City)", " District should be Moscow (City)");
        assertEquals(cities.get(0).population, 8389200,  "Population should be 8389200");
    }

    /**
     * Test that checks that getTopNPopulatedCitiesInRegion method is returning an arraylist that's size is equal to N.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNPopulatedCitiesInRegionTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInRegion(3, "Eastern Europe");

        assertEquals(cities.size(), 3, "cities size should be 3");
        assertEquals(cities.get(0).name, "Moscow", "Name should be Moscow");
        assertEquals(cities.get(0).country, "Russian Federation", "Country should be Russian Federation");
        assertEquals(cities.get(0).district, "Moscow (City)", " District should be Moscow (City)");
        assertEquals(cities.get(0).population, 8389200, "Population should be 8389200");
    }

    /**
     * Test that checks that getTopNPopulatedCitiesInDistrict method is returning an arraylist that's equal to N.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNPopulatedCitiesInDistrictTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInDistrict(3, "Scotland");

        assertEquals(cities.size(), 3, "cities size should be 3");
        assertEquals(cities.get(0).name, "Glasgow", "Name should be Glasgow");
        assertEquals(cities.get(0).country, "United Kingdom", "Country should be United Kingdom");
        assertEquals(cities.get(0).district, "Scotland", "District should be Scotland");
        assertEquals(cities.get(0).population, 619680, "Population should be 619680");
    }

    /**
     * Test that checks that getTopNPopulatedCitiesInCountry method is returning an arraylist that's size is equal to N.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNPopulatedCitiesInCountryTest()
    {
        ArrayList<City> cities = dbHandler.getTopNPopulatedCitiesInCountry(3,"USA");

        assertEquals(cities.size(), 3, "cities size should be 3");
        assertEquals(cities.get(0).name, "New York", "Name should be New York");
        assertEquals(cities.get(0).country, "United States", "Country should be United States");
        assertEquals(cities.get(0).district, "New York", "District should be New York");
        assertEquals(cities.get(0).population, 8008278,  "Population should be 8008278");
    }

    //endregion

    //region <GET CAPITAL CITIES TESTS>

    /**
     * Test that checks that getAllCapitals method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCapitalsTest()
    {
        ArrayList<Capital> capitals = dbHandler.getAllCapitalCities();

        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertEquals(capitals.get(0).name, "Seoul", "Name should be Seoul");
        assertEquals(capitals.get(0).country, "South Korea", "Country should be South Korea");
        assertEquals(capitals.get(0).population, 9981619,  "Population should be 9981619");
    }

    /**
     * Test that checks that getAllCapitalsInContinent method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCapitalsInContinentTest()
    {
        ArrayList<Capital> capitals = dbHandler.getAllCapitalCitiesInContinent("Europe");

        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertEquals(capitals.get(0).name, "Moscow", "Name should be Moscow");
        assertEquals(capitals.get(0).country, "Russian Federation", "Country should be Russian Federation");
        assertEquals(capitals.get(0).population, 8389200,  "Population should be 8389200");
    }

    /**
     * Test that checks that getAllCapitalsInRegion method is returning an arraylist that is not empty.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getAllCapitalsInRegionTest()
    {
        ArrayList<Capital> capitals = dbHandler.getAllCapitalCitiesInRegion("Eastern Europe");

        assertFalse(capitals.isEmpty(), "capitals should not be empty");
        assertEquals(capitals.get(0).name, "Moscow", "Name should be Moscow");
        assertEquals(capitals.get(0).country, "Russian Federation", "Country should be Russian Federation");
        assertEquals(capitals.get(0).population, 8389200,  "Population should be 8389200");
    }

    /**
     * Test that checks that getTopNCapitalCities method is returning an arraylist that's size is equal to N.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNPopulatedCapitalsTest()
    {
        ArrayList<Capital> capitals = dbHandler.getNCapitalCities(3);

        assertEquals(capitals.size(), 3,  "capitals size should be 3");
        assertEquals(capitals.get(0).name, "Seoul", "Name should be Seoul");
        assertEquals(capitals.get(0).country, "South Korea", "Country should be South Korea");
        assertEquals(capitals.get(0).population, 9981619,  "Population should be 9981619");
    }

    /**
     * Test that checks that getTopNCapitalCitiesInContinent method is returning an arraylist that's size is equal to N.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNPopulatedCapitalsInContinentTest()
    {
        ArrayList<Capital> capitals = dbHandler.getTopNCapitalCitiesInContinent(3,"Europe");

        assertEquals(capitals.size(), 3,  "capitals size should be 3");
        assertEquals(capitals.get(0).name, "Moscow", "Name should be Moscow");
        assertEquals(capitals.get(0).country, "Russian Federation", "Country should be Russian Federation");
        assertEquals(capitals.get(0).population, 8389200,  "Population should be 8389200");
    }

    /**
     * Test that checks that getAllCapitalsInRegion method is returning an arraylist that's size is equal to N.
     * Compares each of the object in index position 0's attributes to confirm they contain expected values
     */
    @Test
    void getTopNPopulatedCapitalsInRegionTest()
    {
        ArrayList<Capital> capitals = dbHandler.getTopNCapitalCitiesInRegion(3,"Eastern Europe");

        assertEquals(capitals.size(), 3,  "capitals size should be 3");
        assertEquals(capitals.get(0).name, "Moscow", "Name should be Moscow");
        assertEquals(capitals.get(0).country, "Russian Federation", "Country should be Russian Federation");
        assertEquals(capitals.get(0).population, 8389200,  "Population should be 8389200");
    }

    //endregion

}
