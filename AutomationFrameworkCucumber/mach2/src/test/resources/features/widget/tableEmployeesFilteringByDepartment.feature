@table
Feature: Add Table Widget

  Background: Login
    Given I go to Mach2 web page
    And I set user and password

  Scenario: Add Table Widget with Employees Personal Information
    Given I have a board
    And I click over Widget Button
    When I click on Table button on the Widget
    And I click on Open ERP service
    And I select Option of Open ERP
    And I set department name with "Security test"
    And I save that option with the department "Security test" selected
    Then I have a table with employees filtered for a "Security test"