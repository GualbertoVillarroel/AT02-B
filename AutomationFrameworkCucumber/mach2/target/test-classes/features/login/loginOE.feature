@loginOE
Feature: Sign-in to OpenERP
  Scenario: Sign-in to OpenERP with a valid account
    Given I navigate to OpenERP web page
    When I put the next data
    |username|jose7|
    |password|jose7|
    And I press the button submit
    Then I expect redirect to the main page
