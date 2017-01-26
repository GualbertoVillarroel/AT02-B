Feature: Add widget table with employee information

  Background: Login
    Given I am on Mach2 Webpage
    And I fill username or Mail textfield as "Angelica.Rodriguez@fundacion-jala.org"
    And I fill Password textfield as "At24062406" and press Submit button


  Scenario: Add widget table with employee information
    Given I have board created
    And I click on Widget Button
    When I click on "Table" Button on Widget displayed
    And I click on "Open ERP" services
    And I select an Option of OpenERP
    And In the option Divisions I select "Jalasoft Technologies"
    And In the option Manager "Juan Carlos Martines Castro"
    And I click on save Button
    Then I have a table widget with "Jalasoft Technologies" Division and "Juan Carlos Martines Castro" Manager filled