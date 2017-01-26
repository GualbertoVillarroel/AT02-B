@table
Feature: Widget using Open ERP service to show Engineer Information

  Background: Login to Mach2
    Given I am on Mach2 Web page
    And I set a username as "Gualberto"
    And I set a password as "password123" and press Login button

  Scenario: Add a Table Widget using Open ERP service to show Engineer Information for a Manager
    Given I add a board
    When I add a "Table" Widget
    And I select "Open ERP" service
    And I select Engineer Information option
    And I choose "David Angeles Cambom" as value for Manager field
    And I press Save button
    Then I should have a table with "David Angeles Cambom" filled