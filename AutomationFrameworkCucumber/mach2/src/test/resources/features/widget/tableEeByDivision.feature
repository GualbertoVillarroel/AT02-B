@tableEe
Feature: Table widget with Employees Experience

  Scenario: Table widget using Open ERP service to show Employees Experience searched by Divisions
    Given I am login on Mach2 with credentials
      | user      | password    |
      | Gualberto | password123 |
    And I have a board and widget created
    When I select "Table" icon on Widget options
    And I select "Open ERP" service
    And I select "Employees Experience" of Open ERP
    And I select "MT02" on "Divisions" option
    And I click on save button
    And I obtain a table with the Employees Experience for "MT02" Division
    Then I should have the same result using Open ERP web page to search Employees Experience for "MT02" Division in which "Dennis Ariel Gamboa Veliz" is one of the found names