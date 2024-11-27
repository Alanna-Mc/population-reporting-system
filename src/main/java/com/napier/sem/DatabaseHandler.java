package com.napier.sem;

import java.sql.*;
import java.util.*;

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
     *
     * @return An ArrayList of Country objects ordered by largest to smallest population
     */
    public ArrayList<Country> getAllCountries() {
        return getCountries(
                "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "ORDER BY Population DESC"
        );
    }

    /**
     * Get all the countries in given continent
     *
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
     *
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
     *
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
     *
     * @param n         The number of top populated countries to retrieve.
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
     *
     * @param n      The number of top populated countries to retrieve.
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
     *
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

                if (country.capital == null) {
                    country.capital = "No capital";
                }
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     * @param n         The number of top populated cities to retrieve
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
     *
     * @param n      The number of top populated cities to retrieve
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
     *
     * @param n        The number of top populated cities to retrieve
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
     *
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
     *
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
     *
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
     *
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
     *
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


    /**
     * Get the top N capital cities in the world
     * @param n The number of Top populated capitals to retrieve
     * @return An ArrayList of Capital objects ordered by largest to smallest population
     */
    public ArrayList<Capital> getNCapitalCities(int n) {
        return getCapitalCities(
                "SELECT city.Name AS Name, country.Name AS Country, city.Population AS Population " +
                        "FROM country " +
                        "JOIN city on country.Capital = city.ID " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
    }

    /**
     * Get Top N capital cities in the given continent
     * @param n The number of Top populated capitals to retrieve
     * @param continent the name of the continent to filter by
     * @return An ArrayList of Capital objects ordered by largest to smallest population
     */
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

    /**
     * Get Top N capital cities in the given region
     * @param n The number of Top populated capitals to retrieve
     * @param region the name of the region to filter by
     * @return An ArrayList of Capital objects ordered by largest to smallest population
     */
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
     *
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

    /**
     * Get the total population of the world.
     *
     * @return The total population of the world as a long.
     */
    public Long getWorldPopulation() {
        long worldPopulation = 0;

        try {
            // SQL query to get and calculate the total population of the world
            String query = "SELECT SUM(Population) AS WorldPopulation FROM country";
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(query);

            // Retrieve result set
            if (rset.next()) {
                // Set worldPopulation as the result from the WorldPopulation SQL SUM
                worldPopulation = rset.getLong("WorldPopulation");
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve world population: " + e.getMessage());
        }

        return worldPopulation;
    }

    /**
     * Get the total population of a chosen continent.
     *
     * @param continentChosen The name of the continent.
     * @return The total population of the continent.
     */
    public Long getContinentPopulation(String continentChosen) {
        long continentPopulation = 0;

        try {
            // SQL query to get and calculate the total population of a continent
            String query = "SELECT SUM(Population) AS ContinentPopulation FROM country WHERE Continent = '" + continentChosen + "'";
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(query);

            // Retrieve result set
            if (rset.next()) {
                // Set continentPopulation as the result from the ContinentPopulation SQL SUM
                continentPopulation = rset.getLong("ContinentPopulation");
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve continent population: " + e.getMessage());
        }

        return continentPopulation;
    }

    /**
     * Get the total population of a chosen city
     * @param chosenCity The name of the city that's population is required
     * @return The total population of the city passed in as a param
     */
    public Long getCityPopulation(String chosenCity) {
        long cityPopulation = 0;

        try {
            // SQL query to get and calculate the total population of a continent
            String query = "SELECT SUM(Population) AS CityPopulation FROM city WHERE Name = '" + chosenCity + "'";
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(query);

            // Retrieve result set
            if (rset.next()) {
                // Set continentPopulation as the result from the ContinentPopulation SQL SUM
                cityPopulation = rset.getLong("CityPopulation");
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve city population: " + e.getMessage());
        }

        return cityPopulation;
    }

    /**
     * Get the total population of a chosen district
     * @param chosenDistrict The name of the district that's population is required
     * @return The total population of the district passed in as a param
     */
    public Long getDistrictPopulation(String chosenDistrict) {
        long districtPopulation = 0;

        try {
            // SQL query to get and calculate the total population of a continent
            String query = "SELECT SUM(Population) AS DistrictPopulation FROM city WHERE District = '" + chosenDistrict + "'";
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(query);

            // Retrieve result set
            if (rset.next()) {
                // Set continentPopulation as the result from the ContinentPopulation SQL SUM
                districtPopulation = rset.getLong("DistrictPopulation");
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve district population: " + e.getMessage());
        }

        return districtPopulation;
    }


    /**
     * Get the population total of people living in cities and those not living in cities for each Country.
     *
     * @return An ArrayList of Country objects, each containing city and non-city population totals.
     */
    public ArrayList<Country> getCountryCitiesAndNonCitiesPopulationTotals() {

        // Array to get all countries from getAllCountries method
        ArrayList<Country> countries = getAllCountries();

        // Loop through each Country in the countries list
        for (Country country : countries) {
            ArrayList<City> citiesInCountry = getAllCityInCountry(country.code);
            long totalCityPopulation = 0;

            // Calculate total city population for each country
            for (City city : citiesInCountry) {
                totalCityPopulation += city.population;
            }

            // Calculate non-city population, accounting for population inconsistencies in database
            long nonCityPopulation = Math.max(country.population - totalCityPopulation, 0);

            // Calculate percentages and store them in the country object
            if (country.population > 0) {
                country.cityPopulationPercentage = Math.round(((double) totalCityPopulation / country.population) * 100);
                country.nonCityPopulationPercentage = Math.round(((double) nonCityPopulation / country.population) * 100);

                // If non-city population is zero, ensure city percentage does not exceed 100
                if (country.cityPopulationPercentage > 100) {
                    country.cityPopulationPercentage = 100;
                }
            }

            // Store the results in the country object
            country.cityPopulation = totalCityPopulation;
            country.nonCityPopulation = nonCityPopulation;
        }

        return countries;
    }


    /**
     * Get the population total of people living in cities and those not living in cities for each continent.
     * @return An ArrayList of Continent objects, each containing city and non-city population totals.
     */
    public ArrayList<Continent> getContinentCitiesAndNonCitiesPopulationTotals() {

        // HashMap: Key - continent names, Values - Continent objects
        Map<String, Continent> continentMap = new HashMap<>();

        try {
            Statement stmt = con.createStatement();
            // SQL query to retrieve country and city population data, grouped by country
            // Sums up the populations of cities in each country
            String query = "SELECT country.Code, country.Name, country.Continent, country.Population AS CountryPopulation, " +
                    "IFNULL(SUM(city.Population), 0) AS TotalCityPopulation " +
                    "FROM country LEFT JOIN city ON country.Code = city.CountryCode " +
                    "GROUP BY country.Code, country.Name, country.Continent, country.Population";

            // Execute query and get the data
            ResultSet rset = stmt.executeQuery(query);

            // Iterate over each row in the result set to process data.
            while (rset.next()) {
                String countryCode = rset.getString("Code");
                String countryName = rset.getString("Name");
                String continentName = rset.getString("Continent");
                long countryPopulation = rset.getLong("CountryPopulation");
                long totalCityPopulation = rset.getLong("TotalCityPopulation");
                // Calculate the non-city population by subtracting city population from country population
                long nonCityPopulation = countryPopulation - totalCityPopulation;

                // Get or create Continent object for this continent
                Continent continent = continentMap.getOrDefault(continentName, new Continent(continentName));

                // Update the total population of the continent by adding the country's population
                continent.totalPopulation += countryPopulation;
                // Update the total city population of the continent by adding the country's city population
                continent.cityPopulation += totalCityPopulation;
                // Update the total non-city population of the continent by adding the country's non-city population
                continent.nonCityPopulation += nonCityPopulation;

                // Calculate percentages and store them
                if (continent.totalPopulation > 0) {
                    continent.cityPercentage = Math.round(((double) continent.cityPopulation / continent.totalPopulation) * 100);
                    continent.nonCityPercentage = Math.round(((double) continent.nonCityPopulation / continent.totalPopulation) * 100);
                }
                // Update the map with continent data
                continentMap.put(continentName, continent);
            }

            // Convert the values of the continentMap to a list and return it
            return new ArrayList<>(continentMap.values());

        } catch (SQLException e) {
            System.out.println("Failed to retrieve continent populations: " + e.getMessage());
            return null;
        }
    }


    /**
     * Get the population total of people living in cities and those not living in cities for each region.
     * @return An ArrayList of Region objects, each containing city and non-city population totals.
     */
    public ArrayList<Region> getRegionCitiesAndNonCitiesPopulationTotals() {

        // HashMap: Key - region names, Values - Region objects
        Map<String, Region> regionMap = new HashMap<>();

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT country.Code, country.Name, country.Region, country.Population AS CountryPopulation, " +
                    "IFNULL(SUM(city.Population), 0) AS TotalCityPopulation " +
                    "FROM country LEFT JOIN city ON country.Code = city.CountryCode " +
                    "GROUP BY country.Code, country.Name, country.Region, country.Population";

            ResultSet rset = stmt.executeQuery(query);

            while (rset.next()) {
                String countryCode = rset.getString("Code");
                String countryName = rset.getString("Name");
                String regionName = rset.getString("Region");
                long countryPopulation = rset.getLong("CountryPopulation");
                long totalCityPopulation = rset.getLong("TotalCityPopulation");
                long nonCityPopulation = countryPopulation - totalCityPopulation;

                Region region = regionMap.getOrDefault(regionName, new Region(regionName));

                region.totalPopulation += countryPopulation;
                region.cityPopulation += totalCityPopulation;
                region.nonCityPopulation += nonCityPopulation;

                regionMap.put(regionName, region);

                // Calculate percentages and store them
                if (region.totalPopulation > 0) {
                    region.cityPercentage = Math.round(((double) region.cityPopulation / region.totalPopulation) * 100);
                    region.nonCityPercentage = Math.round(((double) region.nonCityPopulation / region.totalPopulation) * 100);
                }
            }

            return new ArrayList<>(regionMap.values());

        } catch (SQLException e) {
            System.out.println("Failed to retrieve region populations: " + e.getMessage());
            return null;
        }
    }

}