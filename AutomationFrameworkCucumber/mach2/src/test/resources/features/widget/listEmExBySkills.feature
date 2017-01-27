Feature: Validate list of Employees
This scenario should validate Employee Experience by a Skill search containing Cloud.


  Scenario: Verify list of Employees experience by specific Skill > Cloud.
    Given I am at Mach2 webpage
    And I set username as "at02"
    And I set password as "Automation123" and press Submit button
    And I add a new Board to the Group
    And I click on Widget button at the top menubar
    And I click on "List" icon inside the Widget options
    And I select "Open ERP" service icon.

    And I select "Employees Experience" of Open ERP
    When I click on Skills combobox and select Cloud.
    And I click the Save button
    Then I should see the list of Employees by Skill: "Cloud" on E.E. category
