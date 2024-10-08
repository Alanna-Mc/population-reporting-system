# USE CASE: 5 - Produce a report on all capital cities in a chosen area (World, Continent or Region), sorted by population from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an analyst I want to produce a report on all capital cities in a chosen area (World, Continent or Region), sorted by population from largest to smallest, so that possible future markets can be explored.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

User knows area to be examined.\
Database contains the relevant data.

### Success End Condition

Report on capital cities in selected area is produced.

### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

A report on capital cities on a specific area is requested.

## MAIN SUCCESS SCENARIO

1. Request for report on capital cities in specific area is received.
2. Analyst selects Capital Cities from menu
3. Analyst selects required area from menu
    1. If World is selected user moves to step 4
    2. If Continent is selected user is prompted to enter name of required continent
    3. If Region is selected user is prompted to enter name of required region
4. Requested data on capital cities in selected area is retrieved from the database
5. Report containing the following information on each capital city, sorted by largest to smallest population, is generated,
    * Name
    * Country
    * Population

## EXTENSIONS

3. **Continent or Region entered does not exist in database:**
    1. Error message informing user that entered input does not exist in the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0