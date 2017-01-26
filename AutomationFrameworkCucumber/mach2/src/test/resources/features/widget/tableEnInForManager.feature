Feature: Widget using Open ERP service to show Engineer Information

  Background: Login to Mach2
    Given I am on Mach2 Web page
    And I set a username as "at02"
    And I set a password as "Automation123" and press Login button

  Scenario: Add a Table Widget using Open ERP service to show Engineer Information for a Manager
    Given I add a board
    When I add a "Table" Widget
    And I select "Open ERP" service
    And I select Engineer Information option
    And I choose "David Angeles Cambom" as value for Manager field
    And I press Save button
    And I obtain a table with the Engineer Information for "David Angeles Cambom" as manager
    Then I should have the same result using Open ERP web page to search Engineer Information for "David Angeles Cambom" as manager