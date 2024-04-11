# Google Flight Automation Tests

This repository contains automated tests for the Google Flights website using a Behavior-Driven Development (BDD) approach with Cucumber and Java.

## Setup Instructions

### Prerequisites
- Java JDK 8 or above installed
- Maven installed

### Steps to Run Tests
1. Clone this repository to your local machine.
2. Open a terminal and navigate to the project directory.
3. Execute the following command to run the tests:
mvn clean test

## Project Structure
- `Features`: Contains feature files written in Gherkin syntax.
- `src/test/java`: Contains step definition, page object, test runner and utilities classes.
- `stepDefinition`: Step definition class.
- `pageObject`: Page object class.
- `testRunner`: Run class.
- `utilities`: Utility classes for common functionalities-ReadConfig class.
- `target`: Contains test reports- Reports.html.

## Test Scenarios
- **Search for Flights**
- User searches for one-way flight
- User searches for round-trip flight
- User filters search results for specific Airline

## Test Execution
Tests are executed using Cucumber by running the `Run` class located at `src/test/java/testRunner`. This class initializes the Cucumber options and runs the feature files.

## Dependencies
- Cucumber: BDD framework for writing test scenarios in Gherkin syntax.
- Selenium WebDriver: Used for browser automation.
- JUnit: Test framework for running automated tests.
- Maven: Build automation tool for managing project dependencies and executing tests.

## Contributing
Feel free to contribute to this project by forking it and submitting pull requests.

## Issues
If you encounter any issues or have suggestions for improvement, please open an issue on GitHub.
