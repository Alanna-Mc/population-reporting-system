package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class for managing database connections and SQL statement.
 */
public class DatabaseHandler {

    //region <DATABASE CONNECTION REGION>
    // Connection to MySQL database
    private Connection con = null;

    /**
     * Connects to the database.
     * This method attempts to load the MySQL driver and connect to the database.
     * If the connection fails it will retry the connection attempt 30 times.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        boolean shouldWait = false;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                if (shouldWait) {
                    // Wait a bit for db to start
                    Thread.sleep(delay);
                }

                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "my-secret-pw");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());

                // Let's wait before attempting to reconnect
                shouldWait = true;
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnects from the database.
     *
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println("Connection closed");
            } catch (Exception e) {
                // Display Error
                System.out.println("Error closing connection to database");
            }
        }
    }
    //endregion

    //region <COUNTRY REPORTS REGION>
    /**
     * Get all the countries in the world, ordered by population
     * @return An ArrayList of Country objects ordered by largest to smallest population
     */
    public ArrayList<Country> getAllCountries() {
        return getCountries(
                "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "INNER JOIN city ON country.Capital = city.ID " +
                        "ORDER BY Population DESC"
        );
    }

    /**
     * Get all the countries in given continent
     * @param continent to filter the countries by
     * @return An ArrayList of Country objects ordered by largest to smallest population
     */
    public ArrayList<Country> getAllCountriesInContinent(String continent) {
        return getCountries(
                "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "INNER JOIN city ON country.Capital = city.ID " +
                        "WHERE Continent = '" + continent + "' " +
                        "ORDER BY Population DESC"
        );
    }

    /**
     * Get all countries in given region
     * @param region to filter countries by
     * @return An ArrayList of Country objects ordered by largest to smallest population
     */
    public ArrayList<Country> getAllCountriesInRegion(String region) {
        return getCountries(
                "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "INNER JOIN city ON country.Capital = city.ID " +
                        "WHERE Region = '" + region + "' " +
                        "ORDER BY Population DESC"
        );
    }

    /**
     * Get the top N populated countries globally.
     * @param n The number of top populated countries to retrieve.
     * @return An ArrayList of Country objects representing the top N populated countries globally.
     */
    public ArrayList<Country> getTopNPopulatedCountries(int n) {
        return getCountries(
                "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                "FROM country " +
                        "INNER JOIN city ON country.Capital = city.ID " +
                "ORDER BY Population DESC " +
                "LIMIT " + n
        );
    }

    /**
     * Get the top N populated countries in a chosen continent.
     * @param n The number of top populated countries to retrieve.
     * @param continent The continent to filter countries by.
     * @return An ArrayList of Country objects representing the top N populated countries in the specified continent.
     */
    public ArrayList<Country> getTopNPopulatedCountriesInContinent(int n, String continent) {
        return getCountries(
                "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                "FROM country " +
                        "INNER JOIN city ON country.Capital = city.ID " +
                "WHERE Continent = '" + continent + "' " +
                "ORDER BY Population DESC " +
                "LIMIT " + n
        );
    }

    /**
     * Get the top N populated countries in a chosen region.
     * @param n The number of top populated countries to retrieve.
     * @param region The region to filter countries by.
     * @return An ArrayList of Country objects representing the top N populated countries in the specified region.
     */
    public ArrayList<Country> getTopNPopulatedCountriesInRegion(int n, String region) {
        return getCountries(
                "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                "FROM country " +
                        "INNER JOIN city ON country.Capital = city.ID " +
                "WHERE Region = '" + region + "' " +
                "ORDER BY Population DESC " +
                "LIMIT " + n
        );
    }

    /**
     * Helper function to execute country queries and return results.
     * @param query The SQL query to execute for retrieving countries.
     * @return An ArrayList of Country objects based on the executed query.
     */
    private ArrayList<Country> getCountries(String query) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            ArrayList<Country> countries = new ArrayList<>();

            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve countries.");
            return null;
        }
    }

    //endregion

    //region <CITY REPORT REGION>
    /**
     * Get all the cities in the world, ordered by population
     * @return An ArrayList of Country objects ordered by largest to smallest population
     */
    public ArrayList<City> getAllCities() {
        return getCities(
                "Select city.Name, country.Name as Country, city.District, city.Population From city "
                        + "Inner Join country on city.CountryCode = country.Code "
                        + "ORDER BY city.Population DESC"
        );
    }

    /**
     * get all cities a continent, ordered by population
     * @param continent to filter city by
     * @return An ArrayList of City objects ordered by largest to smallest population
     */
    public ArrayList<City> getAllCityInContinent(String continent) {
        return getCities(
                "Select city.Name, country.Name as Country, city.District, city.Population From city " +
                        "Inner Join country On city.CountryCode = country.Code " +
                        "Where country.Continent = '" + continent + "' " +
                        "ORDER BY city.Population DESC"
        );
    }

    /**
     * get all cities a continent, ordered by population
     * @param region to filter city by
     * @return An ArrayList of City objects ordered by largest to smallest population
     */
    public ArrayList<City> getAllCityInRegion(String region) {
        return getCities(
                "Select city.Name, country.Name as Country, city.District, city.Population From city " +
                        "Inner Join country ON city.countryCode = country.Code " +
                        "Where country.Region = '" + region + "' " +
                        "ORDER BY city.Population DESC"
        );
    }

    /**
     * get all cities a continent, ordered by population
     * @param district to filter city by
     * @return An ArrayList of City objects ordered by largest to smallest population
     */
    public ArrayList<City> getAllCityInDistrict(String district) {
        return getCities(
                "Select city.Name, country.Name as Country, city.district, city.Population From city " +
                        "Inner Join country ON city.CountryCode = country.Code " +
                        "Where city.district = '" + district + "' " +
                        "ORDER BY city.Population DESC"
        );
    }

    /**
     * get all cities a continent, ordered by population
     * @param country to filter city by
     * @return An ArrayList of City objects ordered by largest to smallest population
     */
    public ArrayList<City> getAllCityInCountry(String country) {
        return getCities(
                "Select city.Name, country.Name as Country, city.District, city.Population From city " +
                        "Inner Join country ON city.CountryCode = country.Code " +
                        "Where city.CountryCode = '" + country + "' " +
                        "ORDER BY city.Population DESC"
        );
    }

    /**
     * Get the top N populated cities in the world
     * @param n The number of top populated cities to retrieve
     * @return An ArrayList of City objects representing the top N populated countries in the world
     */
    public ArrayList<City> getTopNPopulatedCities(int n) {
        return getCities(
                "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    /**
     * Get the top N populated cities in a chosen continent
     * @param n The number of top populated cities to retrieve
     * @param continent The continent to filter countries by
     * @return An ArrayList of City objects representing the top N populated cities in the specified continent
     */
    public ArrayList<City> getTopNPopulatedCitiesInContinent(int n, String continent) {
        return getCities(
                "SELECT city.Name, country.Name as Country, city.District, city.Population " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Continent = '" + continent + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    /**
     * Get the top N populated cities in a chosen region
     * @param n The number of top populated cities to retrieve
     * @param region The region to filter countries by
     * @return An ArrayList of City objects representing the top N populated cities in the specified region
     */
    public ArrayList<City> getTopNPopulatedCitiesInRegion(int n, String region) {
        return getCities(
                "SELECT city.Name, country.Name as Country, city.District, city.Population " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Region = '" + region + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    /**
     * Get the top N populated cities in a chosen district
     * @param n The number of top populated cities to retrieve
     * @param district The district to filter countries by
     * @return An ArrayList of City objects representing the top N populated cities in the specified district
     */
    public ArrayList<City> getTopNPopulatedCitiesInDistrict(int n, String district) {
        return getCities(
                "SELECT city.Name, country.Name as Country, city.District, city.Population " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE city.District = '" + district + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    /**
     * Get the top N populated cities in a chosen country
     * @param n The number of top populated cities to retrieve
     * @param country The country to filter countries by
     * @return An ArrayList of City objects representing the top N populated cities in the specified country
     */
    public ArrayList<City> getTopNPopulatedCitiesInCountry(int n, String country) {
        return getCities(
                "SELECT city.Name, country.Name as Country, city.District, city.Population " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE city.CountryCode = '" + country + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    /**
     * function to execute city queries and return results.
     * @param query The SQL query to execute for retrieving Cities.
     * @return An ArrayList of City objects based on the executed query.
     */
    private ArrayList<City> getCities(String query) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            ArrayList<City> cities = new ArrayList<>();

            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.country = rset.getString("Country");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve cities.");
            return null;
        }
    }
    //endregion

    //region <CAPITAL CITY REGION>

    /**
     * Get all the capital cities in the world
     * @return An ArrayList of Capital objects ordered by largest to smallest population
     */
    public ArrayList<Capital> getAllCapitalCities() {
        return getCapitalCities(
                "SELECT city.Name AS Name, country.Name AS Country, city.Population AS Population " +
                        "FROM country " +
                        "JOIN city on country.Capital = city.ID " +
                        "ORDER BY city.Population DESC"
        );
    }

    /**
     * Get all the capital cities in a given continent
     * @param continent to filter the capital cities by
     * @return An ArrayList of Capital objects ordered by largest to smallest population
     */
    public ArrayList<Capital> getAllCapitalCitiesInContinent(String continent) {
        return getCapitalCities(
                "SELECT city.Name AS Name, country.Name AS Country, city.Population AS Population " +
                        "FROM country " +
                        "JOIN city on country.Capital = city.ID " +
                        "WHERE Continent = '" + continent + "' " +
                        "ORDER BY city.Population DESC"
        );
    }

    /**
     * Get all the capital cities in a given continent
     * @param region to filter the capital cities by
     * @return An ArrayList of Capital objects ordered by largest to smallest population
     */
    public ArrayList<Capital> getAllCapitalCitiesInRegion(String region) {
        return getCapitalCities(
                "SELECT city.Name AS Name, country.Name AS Country, city.Population AS Population " +
                        "FROM country " +
                        "JOIN city on country.Capital = city.ID " +
                        "WHERE Region = '" + region + "' " +
                        "ORDER BY city.Population DESC"
        );
    }
    public ArrayList<Capital> getNCapitalCities(int n) {
        return getCapitalCities(
                "SELECT city.Name AS Name, country.Name AS Country, city.Population AS Population " +
                        "FROM country " +
                        "JOIN city on country.Capital = city.ID " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    public ArrayList<Capital> getTopNCapitalCitiesInContinent(int n, String continent) {
        return getCapitalCities(
                "SELECT city.Name AS Name, country.Name AS Country, city.Population AS Population " +
                        "FROM country " +
                        "JOIN city on country.Capital = city.ID " +
                        "WHERE Continent = '" + continent + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    public ArrayList<Capital> getTopNCapitalCitiesInRegion(int n, String region) {
        return getCapitalCities(
                "SELECT city.Name AS Name, country.Name AS Country, city.Population AS Population " +
                        "FROM country " +
                        "JOIN city on country.Capital = city.ID " +
                        "WHERE Region = '" + region + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    /**
     * Helper function to execute capital city queries and return results.
     * @param query The SQL query to execute for retrieving capital cities.
     * @return An ArrayList of Capital objects based on the executed query.
     */
    private ArrayList<Capital> getCapitalCities(String query) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            ArrayList<Capital> capitals = new ArrayList<>();

            while (rset.next()) {
                Capital capital = new Capital();
                capital.name = rset.getString("Name");
                capital.country = rset.getString("Country");
                capital.population = rset.getInt("Population");

                capitals.add(capital);
            }
            return capitals;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve capital cities.");
            return null;
        }
    }

    //endregion
}