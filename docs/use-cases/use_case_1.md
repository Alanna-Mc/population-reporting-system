# USE CASE: 1 - Produce a report on all the countries in a chosen area (World, Continent or Region), sorted by population from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an analyst I want to produce a report on all the countries in a chosen area (World, Continent or Region), sorted by population from largest to smallest, so that the countries in the chosen area can be examined by the organisation.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains the relevant data.

### Success End Condition

Report on the countries in chosen area (World, Continent or Region), sorted by population from largest to smallest, is produced.

### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

A report on countries in a specific area (World, Continent or Region) is requested.

## MAIN SUCCESS SCENARIO

1. Request for report on countries in specific area is received.
2. Analyst selects Countries from menu
3. Analyst selects required area from menu
   1. If World is selected user moves to step 4
   2. If Continent is selected user is prompted to enter name of required continent
   3. If Region is selected user is prompted to enter name of required region
4. Requested data on countries in selected area is retrieved from the database
5. Report containing the following information on each country, sorted by largest to smallest, is generated,
    * Code
    * Name
    * Continent
    * Region
    * Population
    * Capital

## EXTENSIONS

3. **Continent or Region entered does not exist in database:**
   1. Error message informing user that continent or region entered does not exist in the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0