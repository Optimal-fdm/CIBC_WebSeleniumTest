# Author: Jeesmon Cherian
# Date: October 24, 2025
Feature: Location Finder functionality on the CIBC website
  As a user
  I want to use the location feature
  So that I can find nearby CIBC branches and ATMs easily

  Scenario: Verify that the location feature is visible and opens correctly
    Given the user has launched the application
    And the user should be able to see location icon on the homepage
    When the user clicks on the location icon
    Then the user should be able to see the page title "CIBC Branch and ATM Locator | CIBC"

  Scenario Outline: Verify search results for different cities
    When the user enters "<city>" in the location search box
    And the user clicks the Search button
    Then A list of nearby branches or ATMs should be displayed for city name "<city>"

    Examples:
      | city      |
      | Toronto   |
      | Vancouver |
      | Montreal  |
