@tag
Feature: Purchase the order from e-commerce Web-site

  Background:
    Given I landed on e-commerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with user name "<name>" and password "<password>"
    When I add product "<productName>" and submit the order
    Then Checkout "<productName>" and submit the order
    Then "THANK YOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
      | name                     | password    | productName |
      | rahulshetty@gmail.com    | IamKing@000 | Product123  |