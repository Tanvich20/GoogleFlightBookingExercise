Feature: Search for Flights
		@regression
  	Scenario: User searches for one-way flight
    Given I want to launch the chrome browser
    And I want to load the URL
    When Flight page is displyed
    And I want to book "One way" trip
    Then Enter details for "One way" trip
    | whereFrom | whereTo | departure | return |
    | Sydney | New Delhi, India | 12/03/2024 | |
    And Click on search button
    Then I can see the list of flights
    And Close browser
    
    @sanity
    Scenario: User searches for round-trip flight
    Given I want to launch the chrome browser
    And I want to load the URL
    When Flight page is displyed
    And I want to book "Round trip" trip
    Then Enter details for "Round trip" trip
    | whereFrom | whereTo | departure | return |
    | Sydney | New Delhi, India | 12/03/2024 | 01/22/2025 |
    And Click on search button
    Then I can see the list of flights
    And Close browser
    
    @system
    Scenario: User filters search results for specific Airline
    Given I want to launch the chrome browser
    And I want to load the URL
    When Flight page is displyed
    And I want to book "One way" trip
    Then Enter details for "One way" trip
    | whereFrom | whereTo | departure | return |
    | Sydney | New Delhi, India | 12/03/2024 | |
    And Click on search button
    When User applies a filter for "Air India" flight
    Then User should see only "Air India" flight options
    And Close browser