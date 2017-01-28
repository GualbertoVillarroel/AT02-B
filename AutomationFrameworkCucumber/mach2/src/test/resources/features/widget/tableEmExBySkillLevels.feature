Feature: Validate table of Employees Experience by Skill Levels



Scenario: Verify table of Employees Experience by specific Skill Levels - Advanced.
Given I am in Mach2 webpage mt
And I set username as "Sandra" mt
And I set password as "SRrf1991" and click Submit button mt
And I add a new Board to the Group mt
And I click on Widget button at the top menu bar mt
And I click on "Table" icon inside the Widget options mt
And I select "Open ERP" service icon. mt

And I select "Employees Experience" of Open ERP mt
When I click on Skills Levels combobox and select Advance. mt
And I click the Save button mt
Then I should see the table of Employees by Skill Levels: "Advanced" on E.E. category mt