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

    @Test
    void getAllCountriesTest()
    {
        ArrayList<Country> countries = dbHandler.getAllCountries();
        assertEquals(countries.size(), 232);
    }

}
