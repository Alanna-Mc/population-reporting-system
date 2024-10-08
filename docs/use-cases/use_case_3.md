# USE CASE: 3 - Produce a report on all cities in a chosen area (World, Continent, Region, Country, District), sorted by population from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an analyst I want to produce a report on all cities in a chosen area (World, Continent, Region, Country, District), sorted by population from largest to smallest, so that future office locations can be examined

### Scope

Organisation.

### Level

Primary task.

### Preconditions

User knows area to be examined.\
Database contains the relevant data.

### Success End Condition

Report on cities in selected area is produced.

### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

A report on cities on a specific area is requested.

## MAIN SUCCESS SCENARIO

1. Request for report on cities in specific area is received.
2. Analyst selects Cities from menu
3. Analyst selects required area from menu
   1. If World is selected user moves to step 4
   2. If Continent is selected user is prompted to enter name of required continent
   3. If Region is selected user is prompted to enter name of required region
   4. If Country is selected user is prompted to enter name of required city 
   5. If District is selected user is prompted to enter name of required district
4. Requested data on cities in selected area is retrieved from the database
5. Report containing the following information on each city, sorted by largest to smallest population, is generated,
    * Name
    * Country
    * District
    * Population

## EXTENSIONS

3. **Continent, Region, Country or District entered does not exist in database:**
    1. Error message informing user that entered input does not exist in the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0