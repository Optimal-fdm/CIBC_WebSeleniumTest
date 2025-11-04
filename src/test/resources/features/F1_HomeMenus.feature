# Author: Jeesmon Cherian
# Date: October 24, 2025
Feature: Home Page Menus
As a user I want to acess all the menus on home page

  Scenario: Launch the application
    Given the user has launched the application
    Then the user should be able to see the page title "Personal Banking and Financial Services | CIBC"

  Scenario Outline: Verify the menu dropdown is displayed when hovered.
    Given the user should be able to see the page title "Personal Banking and Financial Services | CIBC"
    When the user hovers over the "<menuTitle>" menu
    Then the user should see the dropdown for "<menuTitle>"

    Examples:
      | menuTitle     |
      | Bank Accounts |
      | Credit Cards  |
      | Mortgages     |
      | Lending       |
      | Investments   |
      | Insurance     |
      | Ways to Bank  |
      | Smart Advice  |
