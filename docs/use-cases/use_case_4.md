# USE CASE: 4 Produce a report on top N populated countries in the world

## CHARACTERISTIC INFORMATION

### Goal in Context

As an analyst I want to produce on the top N populated countries in the world, with N being supplied by me, so that the countries with the highest populations can be examined. 

### Scope

Organisation.

### Level

Primary task.

### Preconditions

User knows N to be entered. Database contains the relevant data.

### Success End Condition

Report on the top N populated countries in the world is produced.

### Failed End Condition

No report is produced and user returned to menu.

### Primary Actor

Analyst

### Trigger

A report on the top N populated countries in the world is requested.

## MAIN SUCCESS SCENARIO

1. Request for report on top N populated countries in the world received
2. Analyst selects World from the menu
3. User is asked to enter N
4. Requested data on top N countries in the world is retrieved from the database
5. Report containing the following information on the top N countries is generated
    * Code
    * Name
    * Continent
    * Region
    * Population
    * Capital

## EXTENSIONS

3. **User enters invalid number when prompted e.g. -1 or 0:**
    1. Error message informing user that N is invalid displayed and user prompted to enter new N

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0