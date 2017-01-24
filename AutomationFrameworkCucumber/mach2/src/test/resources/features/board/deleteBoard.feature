Feature: Widget
  Scenario: Create a widget
    Given I am on Mach2 web page
    And I put Gualberto as username
    And I put password123 as password and press LogIn button
    And I go to My Dashboard
    When I add a new Board
    And I click on the Config icon
    And I select the Delete option