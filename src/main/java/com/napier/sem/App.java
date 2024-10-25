package com.napier.sem;

import java.sql.*;

/**
 * The main class for connecting to and interacting with the MySQL database.
 */
public class App
{
    // Connection to MySQL database
    private Connection con = null;

    /**
     * Connects to the MySQL database.
     * This method attempts to load the MySQL driver and connect to the database.
     * It will retry the connection if the initial attempts fail.
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
     * Disconnects from the MySQL database.
     * This method closes the current database connection if it exists.
     */
        public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
                System.out.println("Connection closed");
            }
            catch (Exception e)
            {
                // Display Error
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     *
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Disconnect from database
        a.disconnect();
    }
}