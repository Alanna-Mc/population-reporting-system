package com.napier.sem;

import java.util.ArrayList;

/**
 * Main application class.
 */
public class App
{
    // Declare instance variables for App class
    private DatabaseHandler dbHandler;
    private ReportHandler reportsHandler;


    /**
     * Constructor method to create instance of App
     */
    public App() {
        // Initialise variables
        dbHandler = new DatabaseHandler();
        reportsHandler = new ReportHandler();

    }
    /**
     * Main method to run the application.
     */
    public static void main(String[] args)
    {
        App a = new App();

        // Hardcoded user input value for N
        int n = 10;
        System.out.println("You selected top " + n + " countries:");

        // Connect to database
        a.dbHandler.connect();

        // Get the top N populated countries
        ArrayList<Country> countries = a.dbHandler.getTopNPopulatedCountries(n);

        // Display the report using ReportsHandler
        a.reportsHandler.displayTopCountries(countries, n);

        // Line break
        System.out.println("/n");

        // Disconnect from database
        a.dbHandler.disconnect();

    }
}