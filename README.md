# Population Reporting System

The **Population Reporting System** is a group project for the Software Engineering Methods module at Edinburgh Napier University.
This project aims to design and implement a system that allows access to population information from an SQL database.

## Technologies Used

- Java (JDK 11)
- SQL Database
- Maven
- Docker
- Git/GitHub
- CodeCov
- JUnit

## Badges

#### Master Build Status
![GitHub Workflow Status (master)](https://img.shields.io/github/actions/workflow/status/Alanna-Mc/population-reporting-system/main.yml?branch=master)

#### Develop Build Status
![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/Alanna-Mc/population-reporting-system/main.yml?branch=develop)

#### Codecov Coverage
[![codecov](https://codecov.io/gh/Alanna-Mc/population-reporting-system/graph/badge.svg?token=S9P990Z9TP)](https://codecov.io/gh/Alanna-Mc/population-reporting-system)

#### Release Status
[![Releases](https://img.shields.io/github/release/Alanna-Mc/population-reporting-system/all.svg?style=flat-square)](https://github.com/Alanna-Mc/population-reporting-system/releases)

#### License Status
[![LICENSE](https://img.shields.io/github/license/Alanna-Mc/population-reporting-system.svg?style=flat-square)](https://github.com/Alanna-Mc/population-reporting-system/blob/main/LICENSE)

## Requirements Met:

| ID  | Name                                                                                                                                                                                               | Met | Screenshot                                                                                                                       |
|-----|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----|----------------------------------------------------------------------------------------------------------------------------------|
| 1   | All the countries in the world organised by largest population to smallest.                                                                                                                        | Yes | ![ID1_screenshot](docs/requirements_screenshots/ID_1.1.png)<br/> ![ID1_screenshot](docs/requirements_screenshots/ID_1.2.png)     |
| 2   | All the countries in a continent organised by largest population to smallest.                                                                                                                      | Yes | ![ID2_screenshot](docs/requirements_screenshots/ID_2.1.png)<br/> ![ID2_screenshot](docs/requirements_screenshots/ID_2.2.png)     |
| 3   | All the countries in a region organised by largest population to smallest.                                                                                                                         | Yes | ![ID3_screenshot](docs/requirements_screenshots/ID_3.png)                                                                        |
| 4   | The top `N` populated countries in the world where `N` is provided by the user.                                                                                                                    | Yes | ![ID4_screenshot](docs/requirements_screenshots/ID_4.png)                                                                        |
| 5   | The top `N` populated countries in a continent where `N` is provided by the user.                                                                                                                  | Yes | ![ID5_screenshot](docs/requirements_screenshots/ID_5.png)                                                                        |
| 6   | The top `N` populated countries in a region where `N` is provided by the user.                                                                                                                     | Yes | ![ID6_screenshot](docs/requirements_screenshots/ID_6.png)                                                                        |
| 7   | All the cities in the world organised by largest population to smallest.                                                                                                                           | Yes | ![ID7_screenshot](docs/requirements_screenshots/ID_7.1.png)<br/> ![ID7_screenshot](docs/requirements_screenshots/ID_7.2.png)     |
| 8   | All the cities in a continent organised by largest population to smallest.                                                                                                                         | Yes | ![ID8_screenshot](docs/requirements_screenshots/ID_8.1.png)<br/> ![ID8_screenshot](docs/requirements_screenshots/ID_8.2.png)     |
| 9   | All the cities in a region organised by largest population to smallest.                                                                                                                            | Yes | ![ID9_screenshot](docs/requirements_screenshots/ID_9.1.png)<br/> ![ID9_screenshot](docs/requirements_screenshots/ID_9.2.png)     |
| 10  | All the cities in a country organised by largest population to smallest.                                                                                                                           | Yes | ![ID10_screenshot](docs/requirements_screenshots/ID_10.1.png)<br/> ![ID10_screenshot](docs/requirements_screenshots/ID_10.2.png) |
| 11  | All the cities in a district organised by largest population to smallest.                                                                                                                          | Yes | ![ID11_screenshot](docs/requirements_screenshots/ID_11.png)                                                                      |
| 12  | The top `N` populated cities in the world where `N` is provided by the user.                                                                                                                       | Yes | ![ID12_screenshot](docs/requirements_screenshots/ID_12.png)                                                                      |
| 13  | The top `N` populated cities in a continent where `N` is provided by the user.                                                                                                                     | Yes | ![ID13_screenshot](docs/requirements_screenshots/ID_13.png)                                                                      |
| 14  | The top `N` populated cities in a region where `N` is provided by the user.                                                                                                                        | Yes | ![ID14_screenshot](docs/requirements_screenshots/ID_14.png)                                                                      |
| 15  | The top `N` populated cities in a country where `N` is provided by the user.                                                                                                                       | Yes | ![ID15_screenshot](docs/requirements_screenshots/ID_15.png)                                                                      |
| 16  | The top `N` populated cities in a district where `N` is provided by the user.                                                                                                                      | Yes | ![ID16_screenshot](docs/requirements_screenshots/ID_16.png)                                                                      |
| 17  | All the capital cities in the world organised by largest population to smallest.                                                                                                                   | Yes | ![ID17_screenshot](docs/requirements_screenshots/ID_17.1.png)<br/> ![ID17_screenshot](docs/requirements_screenshots/ID_17.2.png) |
| 18  | All the capital cities in a continent organised by largest population to smallest.                                                                                                                 | Yes | ![ID18_screenshot](docs/requirements_screenshots/ID_18.1.png)<br/> ![ID18_screenshot](docs/requirements_screenshots/ID_18.2.png) |
| 19  | All the capital cities in a region organised by largest to smallest.                                                                                                                               | Yes | ![ID19_screenshot](docs/requirements_screenshots/ID_19.png)                                                                      |
| 20  | The top `N` populated capital cities in the world where `N` is provided by the user.                                                                                                               | Yes | ![ID20_screenshot](docs/requirements_screenshots/ID_20.png)                                                                      |
| 21  | The top `N` populated capital cities in a continent where `N` is provided by the user.                                                                                                             | Yes | ![ID21_screenshot](docs/requirements_screenshots/ID_21.png)                                                                      |
| 22  | The top `N` populated capital cities in a region where `N` is provided by the user.                                                                                                                | Yes | ![ID22_screenshot](docs/requirements_screenshots/ID_22.png)                                                                      |
| 23  | The population of people, people living in cities, and people not living in cities in each continent.                                                                                              | Yes | ![ID23_screenshot](docs/requirements_screenshots/ID_23.png)                                                                      |
| 24  | The population of people, people living in cities, and people not living in cities in each region.                                                                                                 | Yes | ![ID24_screenshot](docs/requirements_screenshots/ID_24.png)                                                                      |
| 25  | The population of people, people living in cities, and people not living in cities in each country.                                                                                                | Yes | ![ID25_screenshot](docs/requirements_screenshots/ID_25.1.png)<br/> ![ID25_screenshot](docs/requirements_screenshots/ID_25.2.png) |
| 26  | The population of the world.                                                                                                                                                                       | Yes | ![ID26_screenshot](docs/requirements_screenshots/ID_26.png)                                                                      |
| 27  | The population of a continent.                                                                                                                                                                     | Yes | ![ID27_screenshot](docs/requirements_screenshots/ID_27.png)                                                                      |
| 28  | The population of a region.                                                                                                                                                                        | Yes | ![ID28_screenshot](docs/requirements_screenshots/ID_28.png)                                                                      |
| 29  | The population of a country.                                                                                                                                                                       | Yes | ![ID29_screenshot](docs/requirements_screenshots/ID_29.png)                                                                      |
| 30  | The population of a district.                                                                                                                                                                      | Yes | ![ID30_screenshot](docs/requirements_screenshots/ID_30.png)                                                                      |
| 31  | The population of a city                                                                                                                                                                           | Yes | ![ID31_screenshot](docs/requirements_screenshots/ID_31.png)                                                                      |
| 32  | The number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population: Chinese, English, Hindi, Spanish, Arabic. | No  | N/A                                                                                                                              |