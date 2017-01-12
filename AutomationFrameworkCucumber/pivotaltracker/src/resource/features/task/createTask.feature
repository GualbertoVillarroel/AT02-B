Feature: Task
  I want to create a new task on Pivotal page

  Background: Login
    Given I am on Pivotal Tracker page
    And I put a at-02@outlook.com and press Next button
    And I put a Automation123 and press Submit button
    And I create a project as a TestProject
    And I select an account as a Jala

  Scenario: Create a new Task
    When I go to Create Story as StoryTest button and click
    And I add multiple tasks with the same name as TaskTest
    And I click on save story with tasks
    Then I should have created 5 tasks with the same name as TaskTest

  Scenario: Delete a Task
    When I go to Create Story as StoryTest button and click
    And I have a task taskOne and taskTwo created
    When I delete taskOne
    Then taskOne should be deleted