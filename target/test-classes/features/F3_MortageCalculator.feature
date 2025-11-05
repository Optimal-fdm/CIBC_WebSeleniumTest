# Author: Jeesmon Cherian
# Date: October 23, 2025
Feature: Mortgage Payment Calculator
  As a user,
  I want to calculate my mortgage payment
  So that I can estimate my home financing costs.

  Scenario: Navigate to Mortgage Calculators
    Given the user has launched the application
    And the user can view the "Mortgages" menu
    When the user hovers over the "Mortgages" menu
    And the user clicks on "Mortgage Payment Calculator" option
    Then the user should be able to see the page title "Mortgage Payment Calculator | CIBC"

  Scenario Outline: Calculate the mortgage payment with different inputs
    Given the user navigated to the mortage payment  calculator.
    When the user scrolls to and clicks the buy a home button
    And the user clicks on the Skip to calculator link
    Then the user should be able to see the Mortgage Payment Calculator form
    When the user enters a purchase price of <purchasePrice>
    And the user enters a down payment of <downPayment>
    And the user enters an interest rate of <interestRate>
    And the user selects "<mortgageTerm>" as the term
    And the user selects "<paymentFrequency>" as the payment frequency
    And the user clicks the Calculate button
    Then the user should be able to scroll down and see the results section

    Examples:
      | purchasePrice | downPayment | interestRate | mortgageTerm           | paymentFrequency     |
      | 750000        | 25          | 3.8          | 7 year fixed closed    | Accelerated Biweekly |
      | 500000        | 20          | 5.2          | 5 year fixed closed    | Monthly              |
      | 850000        | 15          | 4.5          | 10 year fixed closed   | Weekly               |
      | 650000        | 10          | 6.0          | 3 year variable closed | Biweekly             |
      | 400000        | 5           | 5.8          | 2 year fixed closed    | Accelerated Weekly   |
