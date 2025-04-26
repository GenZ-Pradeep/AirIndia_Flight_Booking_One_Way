Feature: Book a one-way flight on AirIndia.com

  tags="@smokeTest"
  Scenario: User books a one-way flight

    Given the user is on the Air India homepage
    And the user clicks on Accept All cookies button
    And the user accepts location dialog
    When the user selects One Way trip type
    And the user enters departure city as del
    And the user enters destination city as bom
    And the user selects departure date as <depDate>
    And the user selects passengers as one adult
    And the user selects class as business
    And the user clicks on Search button
    Then the user should see a list of available flights
