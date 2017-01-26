Feature: Add widget table with Engineer Information search for division

  Background: Login
    Given I am on Mach2 Webpage
    And I fill username or Mail textfield as "at02"
    And I fill Password textfield as "Automation123" and press Submit button


  Scenario: Add widget table with employee information
    Given I have board created
    And I click on Widget Button
    When I click on "Table" Button on Widget displayed
    And I click on "Open ERP" services
    And In the option Most Used I click on the Engineer Information
    And In the option Division I click on "Cleaning - Night Shift"
    And I click on save Button
    Then I have a table widget with "Cleaning - Night Shift" Division filled