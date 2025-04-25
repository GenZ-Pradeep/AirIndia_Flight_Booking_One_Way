#Feature file with Scenario Outline configuration
Feature: Book a one way flight on AirIndia.com

  Scenario Outline: The user books a one-way flight
    Given user is on the Air India homepage
    And user clicks on Accept All cookies button
    And user accepts location dialog
    When user selects <tripType> trip type
    And user enters departure city as <fromCity> and selects <fromCityTxt>
    And user enters destination city as <toCity> and selects <toCityTxt>
    And user selects departure date as <depDateLabel> and <depDateTxt>
    And user selects passengers as one adult
    And user selects class as <selClass>
    And user clicks on Search button
    Then user should see a list of available flights
    Examples:
      | tripType     | fromCity | fromCityTxt |toCity | toCityTxt | depDateLabel | depDateTxt | selClass |
      | One Way | del | Delhi, India, IN      | bom | Mumbai, India, IN | Thursday, May 1, | ₹ | Business |