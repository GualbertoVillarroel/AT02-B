@list
Feature: Add List Widget for Job Title

  All Employees Personal Information with "CFO" kb title are displayed
  when add  “List” widget

  Scenario: Add List Widget with Employees Personal Information for Job Title
    Given I am login on Mach2 webpage with user: "jorgeforero" and password: "jb&11235"
    Given I have a board created with a widget
    When I select "List" on Widgets options
    And I select "Open ERP" services
    And I select Engineer Information
    And I fill Job Title with "CFO" option and I click on save
    Then I have a List widget with "Javier Zenon Sena Gutierrez"

