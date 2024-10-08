# USE CASE: 1 - Produce a report on all the countries in the world, sorted by population from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *analyst* I want to *produce a report on all the countries of the world, sorted by population from largest to smallest*, so that *the countries of the world can be examined by the organisation.*

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains the relevant data.

### Success End Condition

Report on the countries in the world, sorted by population from largest to smallest, is produced.

### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

A report on countries in the world is requested.

## MAIN SUCCESS SCENARIO

1. Request for report on countries in the world received
2. Analyst selects World from the menu
3. Requested data on countries in the world is retrieved from the database
4. Report containing the following information on each country, sorted by largest to smallest, is generated,
    * Code
    * Name
    * Continent
    * Region
    * Population
    * Capital

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0