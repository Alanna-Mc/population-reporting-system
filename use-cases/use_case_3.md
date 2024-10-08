# USE CASE: 3 - Produce a report on all the countries in the chosen region, sorted by population from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *analyst* I want to *produce a report on all the countries in a chosen region, sorted by population from largest to smallest*, so that *the countries in a specific region can be examined by the organisation.*

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains the relevant data.

### Success End Condition

Report on the countries in the chosen region, sorted by population from largest to smallest, is produced.

### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

A report on countries in a specific region is requested.

## MAIN SUCCESS SCENARIO

1. Request for report on countries in specific region received
2. Analyst selects Region from the menu
3. User is asked to enter name of region required
4. Requested data on countries in selected region is retrieved from the database
5. Report containing the following information on each country, sorted by largest to smallest, is generated,
    * Code
    * Name
    * Continent
    * Region
    * Population
    * Capital

## EXTENSIONS

3. **Region entered does not exist in database:**
    1. Error message informing user that region entered does not exist in the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0