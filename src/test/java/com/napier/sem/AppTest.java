package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for methods that display country, city, capital, continent and region information.
 */
class AppTest {
    static ReportHandler reportHandler;
    static DatabaseHandler mockDatabaseHandler;

    /**
     * Before all tests initialise a ReportHandler instance with a mock DatabaseHandler.
     */

    @BeforeAll
    static void init() {
        // Create a mock instance of DatabaseHandler
        mockDatabaseHandler = mock(DatabaseHandler.class);

        // Initialise the ReportHandler instance
        reportHandler = new ReportHandler();
        reportHandler.setDatabaseHandler(mockDatabaseHandler);
    }


    /**
     * Test for handling null input when displaying countries.
     */
    @Test
    void displayCountriesTestNull() {
        reportHandler.displayCountries(null);
    }


    /**
     * Test for handling an empty list of countries when displaying countries.
     */
    @Test
    void displayCountriesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        reportHandler.displayCountries(countries);
    }


    /**
     * Test for handling a list of countries that contains a null element.
     */
    @Test
    void displayCountriesTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        reportHandler.displayCountries(countries);
    }


    /**
     * Test for displaying a list of countries with valid data.
     */
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


    /**
     * Test for handling null input when displaying cities.
     */
    @Test
    void displayCitiesTestNull() {
        // Test handling of null input
        reportHandler.displayCities(null);
    }


    /**
     * Test for handling an empty list of cities when displaying cities.
     */
    @Test
    void displayCitiesTestEmpty() {
        ArrayList<City> city = new ArrayList<>();
        reportHandler.displayCities(city);
    }


    /**
     * Test for handling a list of cities that contains a null element.
     */
    @Test
    void displayCitiesTestContainsNull() {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        reportHandler.displayCities(city);
    }


    /**
     * Test for displaying a list of cities with valid data.
     */
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


    /**
     * Test for handling null input when displaying capital cities.
     */
    @Test
    void displayCapitalsTestNull() {
        reportHandler.displayCapitals(null);
    }


    /**
     * Test for handling an empty list of capital cities when displaying capitals.
     */
    @Test
    void displayCapitalsTestEmpty() {
        ArrayList<Capital> capitals = new ArrayList<>();
        reportHandler.displayCapitals(capitals);
    }


    /**
     * Test for handling a list of capital cities that contains a null element.
     */
    @Test
    void displayCapitalsTestContainsNull() {
        ArrayList<Capital> capitals = new ArrayList<>();
        capitals.add(null);
        reportHandler.displayCapitals(capitals);
    }


    /**
     * Test for displaying a list of capital cities with valid data.
     */
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


    /**
     * Test for handling null input when displaying countries city and non-city population data.
     */
    @Test
    void testDisplayCountryCityNonCityPopulationTestNull() {
        // Mock the DatabaseHandler to return null
        when(mockDatabaseHandler.getCountryCitiesAndNonCitiesPopulationTotals()).thenReturn(null);

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayCountryPopulationCityNonCity(),
                //  Test fail output
                "Method should handle null input.");
    }


    /**
     * Test for handling null input when displaying continents city and non-city population data.
     */
    @Test
    void testDisplayContinentCityNonCityPopulationTestNull() {
        // Mock the DatabaseHandler to return null
        when(mockDatabaseHandler.getContinentCitiesAndNonCitiesPopulationTotals()).thenReturn(null);

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayContinentPopulationCityNonCity(),
                //  Test fail output
                "Method should handle null input.");
    }

    /**
     * Test for handling null input when displaying region city and non-city population data.
     */
    @Test
    void testDisplayRegionCityNonCityPopulationTestNull() {
        // Mock the DatabaseHandler to return null
        when(mockDatabaseHandler.getRegionCitiesAndNonCitiesPopulationTotals()).thenReturn(null);

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayRegionPopulationCityNonCity(),
                //  Test fail output
                "Method should handle null input.");
    }


    /**
     * Test for handling an empty list of countries city and non-city population data.
     */
    @Test
    void testDisplayCountryCityNonCityPopulationTestEmpty() {
        // Mock the DatabaseHandler to return an empty list
        when(mockDatabaseHandler.getCountryCitiesAndNonCitiesPopulationTotals()).thenReturn(new ArrayList<>());

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayCountryPopulationCityNonCity(),
                //  Test fail output
                "Method should handle empty list input.");
    }


    /**
     * Test for handling an empty list of continent city and non-city population data.
     */
    @Test
    void testDisplayContinentCityNonCityPopulationTestEmpty() {
        // Mock the DatabaseHandler to return an empty list
        when(mockDatabaseHandler.getCountryCitiesAndNonCitiesPopulationTotals()).thenReturn(new ArrayList<>());

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayContinentPopulationCityNonCity(),
                //  Test fail output
                "Method should handle empty list input.");
    }


    /**
     * Test for handling an empty list of region city and non-city population data.
     */
    @Test
    void testDisplayRegionCityNonCityPopulationTestEmpty() {
        // Mock the DatabaseHandler to return an empty list
        when(mockDatabaseHandler.getRegionCitiesAndNonCitiesPopulationTotals()).thenReturn(new ArrayList<>());

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayRegionPopulationCityNonCity(),
                //  Test fail output
                "Method should handle empty list input.");
    }


    /**
     * Test for displaying a list of countries city and non-city population percentages with valid data.
     */
    @Test
    void testDisplayCountryCityNonCityPopulationTestNormal() {
        // Create data for countries
        ArrayList<Country> countries = new ArrayList<>();

        // Country 1
        Country country1 = new Country();
        country1.name = "A_Country";
        country1.population = 1000000;
        country1.cityPopulation = 400000;
        country1.nonCityPopulation = 600000;
        country1.cityPopulationPercentage = 40;
        country1.nonCityPopulationPercentage = 60;

        // Country 2
        Country country2 = new Country();
        country2.name = "B_Country";
        country2.population = 500000;
        country2.cityPopulation = 500000;
        country2.nonCityPopulation = 0;
        country2.cityPopulationPercentage = 100;
        country2.nonCityPopulationPercentage = 0;

        // Add countries to list
        countries.add(country1);
        countries.add(country2);

        // Mock the database handler to return the list of countries
        when(mockDatabaseHandler.getCountryCitiesAndNonCitiesPopulationTotals()).thenReturn(countries);

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayCountryPopulationCityNonCity(),
                "The method should display valid city and non city population data");

    }

    /**
     * Test for displaying a list of continent city and non-city population percentages with valid data.
     */
    @Test
    void testDisplayContinentCityNonCityPopulationTestNormal() {
        // Create data for countries
        ArrayList<Continent> continents = new ArrayList<>();

        // Continent 1
        Continent continent1 = new Continent("A_Country");
        continent1.totalPopulation = 1000000;
        continent1.cityPopulation = 400000;
        continent1.nonCityPopulation = 600000;
        continent1.cityPercentage = 40;
        continent1.nonCityPercentage = 60;

        // Continent 2
        Continent continent2 = new Continent("B_Country");
        continent2.totalPopulation = 500000;
        continent2.cityPopulation = 500000;
        continent2.nonCityPopulation = 0;
        continent2.cityPercentage = 100;
        continent2.nonCityPercentage = 0;

        // Add continents to list
        continents.add(continent1);
        continents.add(continent2);

        // Mock the database handler to return the list of countries
        when(mockDatabaseHandler.getContinentCitiesAndNonCitiesPopulationTotals()).thenReturn(continents);

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayContinentPopulationCityNonCity(),
                "The method should display valid city and non city population data");
    }


    /**
     * Test for displaying a list of region city and non-city population percentages with valid data.
     */
    @Test
    void testDisplayRegionCityNonCityPopulationTestNormal() {
        // Create data for countries
        ArrayList<Region> regions = new ArrayList<>();

        // Region 1
        Region region1 = new Region("A_Country");
        region1.totalPopulation = 1000000;
        region1.cityPopulation = 400000;
        region1.nonCityPopulation = 600000;
        region1.cityPercentage = 40;
        region1.nonCityPercentage = 60;

        // Region 2
        Region region2 = new Region("B_Country");
        region2.totalPopulation = 500000;
        region2.cityPopulation = 500000;
        region2.nonCityPopulation = 0;
        region2.cityPercentage = 100;
        region2.nonCityPercentage = 0;

        // Add regions to list
        regions.add(region1);
        regions.add(region2);

        // Mock the database handler to return the list of countries
        when(mockDatabaseHandler.getRegionCitiesAndNonCitiesPopulationTotals()).thenReturn(regions);

        // Call the method and ensure it does not throw any exceptions
        assertDoesNotThrow(() -> reportHandler.displayRegionPopulationCityNonCity(),
                "The method should display valid city and non city population data");
    }


    /**
     * Test for verifying that the getWorldPopulation method returns the correct value.
     */
    @Test
    void getWorldPopulationTestNormal() {

        // Mock the database handler to return value for getWorldPopulation
        when(mockDatabaseHandler.getWorldPopulation()).thenReturn(8000000000L);

        // Set worldPopulation to mock value
        Long worldPopulation = mockDatabaseHandler.getWorldPopulation();

        // Assert that worldPopulation equals 8000000000
        assertEquals(8000000000L, worldPopulation, "World population should be 8 billion in test");
    }


    /**
     * Test for verifying that the getWorldPopulation handles null.
     */
    @Test
    void getWorldPopulationTestNull() {

        // Mock the database handler to return value for getWorldPopulation
        when(mockDatabaseHandler.getWorldPopulation()).thenReturn(null);

        // Set worldPopulation to mock value
        Long worldPopulation = mockDatabaseHandler.getWorldPopulation();

        // Assert that worldPopulation is null
        assertNull(worldPopulation, "World population should be null");
    }

    /**
     * Test for verifying that the getContinentPopulation method returns the correct value.
     */
    @Test
    void getContinentPopulationTestNormal() {

        String continentChosen = "Europe";

        // Mock the database handler to return value for getContinentPopulation
        when(mockDatabaseHandler.getContinentPopulation(continentChosen)).thenReturn(4000000000L);

        // Set continentPopulation to mock value
        Long continentPopulation = mockDatabaseHandler.getContinentPopulation(continentChosen);

        // Assert that continentPopulation equals 4000000000
        assertEquals(4000000000L, continentPopulation, "Continent population should be 4 billion in test");
    }


    /**
     * Test for verifying that the getContinentPopulation handles null.
     */
    @Test
    void getContinentPopulationTestNull() {

        String continentChosen = "Europe";

        // Mock the database handler to return value for getContinentPopulation
        when(mockDatabaseHandler.getContinentPopulation(continentChosen)).thenReturn(null);

        // Set continentPopulation to mock value
        Long continentPopulation = mockDatabaseHandler.getContinentPopulation(continentChosen);

        // Assert that continentPopulation is null
        assertNull(continentPopulation, "Continent population should be null");
    }

    /**
     * Test for verifying that the getCityPopulation method returns the correct value.
     */
    @Test
    void getCityPopulationTestNormal() {

        String cityChosen = "New York";

        // Mock the database handler to return value for getCityPopulation
        when(mockDatabaseHandler.getCityPopulation(cityChosen)).thenReturn(8000000L);

        // Set cityPopulation to mock value
        Long cityPopulation = mockDatabaseHandler.getCityPopulation(cityChosen);

        // Assert that cityPopulation equals 8000000
        assertEquals(8000000L, cityPopulation, "City population should be 8000000 in test");
    }

    /**
     * Test for verifying that the getCityPopulation handles null.
     */
    @Test
    void getCityPopulationTestNull() {

        String cityChosen = "New York";

        // Mock the database handler to return value for getCityPopulation
        when(mockDatabaseHandler.getCityPopulation(cityChosen)).thenReturn(null);

        // Set city Population to mock value
        Long cityPopulation = mockDatabaseHandler.getCityPopulation(cityChosen);

        // Assert that cityPopulation is null
        assertNull(cityPopulation, "City population should be null");
    }

    /**
     * Test for verifying that the getDistrictPopulation method returns the correct value.
     */
    @Test
    void getDistrictPopulationTestNormal() {

        String districtChosen = "California";

        // Mock the database handler to return value for getDistrictPopulation
        when(mockDatabaseHandler.getDistrictPopulation(districtChosen)).thenReturn(3000000L);

        // Set districtPopulation to mock value
        Long districtPopulation = mockDatabaseHandler.getDistrictPopulation(districtChosen);

        // Assert that districtPopulation equals 3000000
        assertEquals(3000000L, districtPopulation, "District population should be 3000000 in test");
    }

    /**
     * Test for verifying that the getDistrictPopulation handles null.
     */
    @Test
    void getDistrictPopulationTestNull() {

        String districtChosen = "California";

        // Mock the database handler to return value for getDistrictPopulation
        when(mockDatabaseHandler.getDistrictPopulation(districtChosen)).thenReturn(null);

        // Set city Population to mock value
        Long districtPopulation = mockDatabaseHandler.getDistrictPopulation(districtChosen);

        // Assert that cityPopulation is null
        assertNull(districtPopulation, "District population should be null");
    }

    /**
     * Test for verifying that the getDistrictPopulation method returns the correct value.
     */
    @Test
    void getCountryPopulationTestNormal() {
        String countryChosen = "Germany";

        // Mock the database handler to return value for getCountryPopulation
        when(mockDatabaseHandler.getCountryPopulation(countryChosen)).thenReturn(4000000L);

        // Set country Population to mock value
        Long countryPopulation = mockDatabaseHandler.getCountryPopulation(countryChosen);

        // Assert that districtPopulation equals 4000000
        assertEquals(4000000L, countryPopulation, "Country population should be 4 million in test");
    }

    /**
     * Test for verifying that the getCountryPopulation handles null.
     */
    @Test
    void getCountryPopulationTestNull() {
        String countryChosen = "Germany";

        // Mock the database handler to return value for getCountryPopulation
        when(mockDatabaseHandler.getCountryPopulation(countryChosen)).thenReturn(null);

        // Set country Population to mock value
        Long countryPopulation = mockDatabaseHandler.getCountryPopulation(countryChosen);

        // Assert that countryPopulation is null
        assertNull(countryPopulation, "Country population should be null");
    }

    /**
     * Test for verifying that the getRegionPopulation method returns the correct value.
     */
    @Test
    void getRegionPopulationTestNormal() {
        String regionChosen = "Caribbean";

        // Mock the database handler to return value for getRegionPopulation
        when(mockDatabaseHandler.getRegionPopulation(regionChosen)).thenReturn(8000000L);

        // Set Region Population to mock value
        Long regionPopulation = mockDatabaseHandler.getRegionPopulation(regionChosen);

        // Assert that districtPopulation equals 8000000
        assertEquals(8000000L, regionPopulation, "Region population should be 8000000 in test");
    }

    /**
     * Test for verifying that the getRegionPopulation handles null.
     */
    @Test
    void getRegionPopulationTestNull() {
        String regionChosen = "Caribbean";

        // Mock the database handler to return value for getRegionPopulation
        when(mockDatabaseHandler.getRegionPopulation(regionChosen)).thenReturn(null);

        // Set Region Population to mock value
        Long regionPopulation = mockDatabaseHandler.getRegionPopulation(regionChosen);

        // Assert that regionPopulation is null
        assertNull(regionPopulation, "Region population should be null");
    }

}




