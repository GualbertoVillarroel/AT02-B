@table
Feature: Add Table Widget

  All Employees Personal Information are displayed
  when add  “Table” widget by a specific “Manager” name

  Background: Login
    Given I am on Mach2 webpage
    And I fill username or mail textfield as "at02"
    And I fill password textfield as "Automation123" and press Submit button

  Scenario: Add Table Widget with Employees Personal Information
    Given I have a board created
    And I click on Widget button
    When I click on "Table" button on Widget displayed
    And I click on "Open ERP" service
    And I select an Option of Open ERP
    And I fill manager name on textfield as "Patricia Villagomez Montalvo"
    And I click on save button
    Then I have a table widget with "Patricia Villagomez Montalvo" filled