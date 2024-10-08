# USE CASE: 8 - Produce a report detailing the total population in a selected area (World, Continent, Region, Country, District or City)

## CHARACTERISTIC INFORMATION

### Goal in Context

As an analyst I want to produce a report detailing the total population of a selected area (World, Continent, Region, Country, District or City) so this information can be passed to the relevant people when requested.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

User knows the area required.\
Database contains the relevant data.

### Success End Condition

Report containing the total population is produced.

### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

Total population of a specific area is requested

## MAIN SUCCESS SCENARIO

1. Request for report on total population of specific area is received
2. Analyst selects Total Population from menu
3. Analyst selects required area from menu
   1. If World is selected user moves to step 4
   2. If Continent is selected user is prompted to enter name of required continent
   3. If Region is selected user is prompted to enter name of required region
   4. If Country is selected user is prompted to enter name of required country
   5. If District is selected user is prompted to enter name of required district
   6. If City is selected user is prompted to enter name of required city
4. Requested data on total population in selected area is retrieved from the database
5. Report containing the total population of selected area is generated,
    * The name of the selected area (World, Continent, Region, Country, District or City)
    * The total population of the continent/region/country.

## EXTENSIONS

3. **Continent, Region, Country, District or City entered does not exist in database:**
    1. Error message informing user that entered input does not exist in the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0