Feature: Board
  Scenario: Create and delete a board
    Given I am on Mach2 web page
    And I put at02 as username
    And I put Automation123 as password and press LogIn button
    And I go to My Dashboard
    When I add a New Board
    And I click on the Config icon
    And I select the Delete option
    Then The New Board should be deleted