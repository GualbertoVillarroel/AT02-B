@table
Feature: Add Table Widget

  All Employees Personal Information are displayed
  when add  “Table” widget by a specific “Manager” name

  Background: Login
    Given I am on Mach2 webpage
    And I fill username or mail textfield as "ariel.vallejos@fundacion-jala.org"
    And I fill password textfield as "wolfyAT02" and press Submit button

  Scenario: Add Table Widget with Employees Personal Information
    Given I have a board created
    And I click on Widget button
    When I click on "List" button on Widget displayed
    And I click on "Pivotal Tracker" service
    And I select an Option of Open ERP
    And I fill manager name on textfield as "David Angeles Cambom"
    And I click on save button
#    Then I have a table widget with "David Angeles Cambom" filled