package com.napier.sem;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        try
        {
            // Load MySQL driver to connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }
        catch (ClassNotFoundException e)
        {
            // If the driver class is not found, print error and exit the program
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        Connection con = null;
        int retries = 10; // Number of retries to connect to the database
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait for 30 seconds to give the database time to start up
                Thread.sleep(30000);
                // Attempt to connect to the database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "my-secret-pw");
                System.out.println("Successfully connected");
                // Wait for 10 seconds
                Thread.sleep(10000);
                // Exit the loop if connection is successful
                break;
            }
            catch (SQLException sqle)
            {
                // If connection fails, print the attempt number and error message
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }

        // If connection was successful
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
}