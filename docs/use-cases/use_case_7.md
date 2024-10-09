# USE CASE: 7 - Produce a report that details people living in cities and those outside of cities in a chosen area (Continent, Region or Country)

## CHARACTERISTIC INFORMATION

### Goal in Context

As an analyst I want to produce a report detailing the population of people living in cities, and those not living in cities within a chosen area (Continent, Region or Country), so that urbanisation in the selected area can be examined.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

User knows area to be examined.\
Database contains the relevant data.

### Success End Condition


### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

A report on population in and outside cities is requested.

## MAIN SUCCESS SCENARIO

1. Request for report on population in and outside of cities in specific area is received.
2. Analyst selects Population from menu
3. Analyst selects required area from menu
   1. If Continent is selected user is prompted to enter name of required continent
   2. If Region is selected user is prompted to enter name of required region
   3. If Country is selected user is prompted to enter name of required country
4. Requested data on population in and outside of cities in selected area is retrieved from the database
5. Report containing the following information on each capital city, sorted by largest to smallest population, is generated,
   * The name of the continent/region/country.
   * The total population of the continent/region/country.
   * The total population of the continent/region/country living in cities (including a %).
   * The total population of the continent/region/country not living in cities (including a %).


## EXTENSIONS

3. **Continent or Region entered does not exist in database:**
    1. Error message informing user that entered input does not exist in the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0