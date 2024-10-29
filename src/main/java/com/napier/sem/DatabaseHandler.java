package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class for managing database connections and SQL statement.
 */
public class DatabaseHandler {
    // Connection to MySQL database
    private Connection con = null;

    /**
     * Connects to the database.
     * This method attempts to load the MySQL driver and connect to the database.
     * If the connection fails it will retry the connection attempt 30 times.
     */
    public void connect() {
        try {
            // Load MySQL driver to connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            // If the driver class is not found, print error and exit the program
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 30; // Number of retries to connect to the database
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait for 30 seconds to give the database time to start up
                Thread.sleep(30000);
                // Attempt to connect to the database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "my-secret-pw");
                System.out.println("Successfully connected");
                // Exit the loop once connection is successful
                break;
            } catch (SQLException sqle) {
                // If connection fails, print the attempt number and error message
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
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

    /**
     * Get all the countries in the world, ordered by population
     * @return An ArrayList of Country objects ordered by largest to smallest population
     */
    public ArrayList<Country> getAllCountries() {
        return getCountries(
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
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
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
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
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
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
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                "FROM country " +
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
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                "FROM country " +
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
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                "FROM country " +
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
                country.capital = rset.getInt("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve countries.");
            return null;
        }
    }

}