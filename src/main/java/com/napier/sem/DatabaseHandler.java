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
 * Method to get the top N populated countries from the database.
 * @param n The number of top populated countries to retrieve.
 * @return A list of top N populated countries.
 */
        public ArrayList<Country> getTopNPopulatedCountries(int n)
        {
            try {
                // Create an SQL statement
                Statement stmt = con.createStatement();

                // Create the SQL query to get the top N populated countries
                String strSelect =
                        "SELECT Name, Population " +
                                "FROM country " +
                                "ORDER BY Population DESC " +
                                "LIMIT " + n; // Maximum number of records to return

                // Execute the SQL query
                ResultSet rset = stmt.executeQuery(strSelect);

                // Create a list to store the result
                ArrayList<Country> countries = new ArrayList<>();

                // Loop through the result set
                while (rset.next()) {
                    // Create a new Country object for each record
                    Country country = new Country();
                    country.name = rset.getString("Name");
                    country.population = rset.getInt("Population");

                    // Add the country to the list
                    countries.add(country);
                }

                // Return the list of countries
                return countries;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get top N populated countries.");
                return null;
            }
        }
    }