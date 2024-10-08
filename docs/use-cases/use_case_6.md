# USE CASE: 6 - Produce a report on top N populated capital cities in the chosen area (World, Continent or Region)

## CHARACTERISTIC INFORMATION

### Goal in Context

As an analyst I want to produce on the top `N` populated capital cities in the selected area (World, Continent or Region), with `N` being supplied by me, so that the capital cities with the highest populations in a given area can be examined.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

User knows area to be examined.\
User knows `N` to be entered.\
Database contains the relevant data.

### Success End Condition

Report on the top `N` populated capital cities in the selected area is produced.

### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

A report on the top `N` populated capital cities in specific area is requested.

## MAIN SUCCESS SCENARIO

1. Request for report on capital cities in specific area is received.
2. Analyst selects Capital Cities from menu
3. Analyst selects required area from menu
    1. If World is selected user moves to step 4
    2. If Continent is selected user is prompted to enter name of required continent
    3. If Region is selected user is prompted to enter name of required region
4. User prompted to enter `N`
5. Requested data on top N capital cities by population in selected area is retrieved from the database
6. Report containing the following information on the top `N` capital cities by population in selected area is generated
    * Name
    * Country
    * Population

## EXTENSIONS

3. **Continent or Region entered does not exist in database:**
    1. Error message informing user that entered input does not exist in the database.
4. **User enters invalid `N` when prompted e.g. -1 or 0:**
    1. Error message informing user that `N` is invalid displayed and user prompted to enter new N

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0