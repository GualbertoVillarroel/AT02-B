$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/resource/features/task/createTask.feature");
formatter.feature({
  "line": 1,
  "name": "Task",
  "description": "I want to create a new task on Pivotal page",
  "id": "task",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "Login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on Pivotal Tracker page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I put a at-02@outlook.com and press Next button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I put a Automation123 and press Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I create a project as a TestProject",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I select an account as a Jala",
  "keyword": "And "
});
formatter.match({
  "location": "CreateTaskSteps.onPivotalTrackerPage()"
});
formatter.result({
  "duration": 6672298101,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "at-02@outlook.com",
      "offset": 8
    }
  ],
  "location": "CreateTaskSteps.putNameAndPressNextButton(String)"
});
formatter.result({
  "duration": 969210600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automation123",
      "offset": 8
    }
  ],
  "location": "CreateTaskSteps.putPasswordAndPressSubmitButton(String)"
});
formatter.result({
  "duration": 7240892601,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestProject",
      "offset": 24
    }
  ],
  "location": "CreateTaskSteps.createProject(String)"
});
formatter.result({
  "duration": 182078200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jala",
      "offset": 25
    }
  ],
  "location": "CreateTaskSteps.selectAccount(String)"
});
formatter.result({
  "duration": 570306401,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Create a new Task",
  "description": "",
  "id": "task;create-a-new-task",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "I go to Create Story as StoryTest button and click",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I add multiple tasks with the same name as TaskTest",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click on save story with tasks",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I should have created 5 tasks with the same name as TaskTest",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "StoryTest",
      "offset": 24
    }
  ],
  "location": "CreateTaskSteps.goToCreateStory(String)"
});
formatter.result({
  "duration": 8753980601,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TaskTest",
      "offset": 43
    }
  ],
  "location": "CreateTaskSteps.addMultipleTasksWithSameName(String)"
});
formatter.result({
  "duration": 926978901,
  "status": "passed"
});
formatter.match({
  "location": "CreateTaskSteps.clickOnSaveStoryWithTasks()"
});
formatter.result({
  "duration": 251064601,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 22
    },
    {
      "val": "TaskTest",
      "offset": 52
    }
  ],
  "location": "CreateTaskSteps.verifyTasksWasCreate(int,String)"
});
formatter.result({
  "duration": 162241000,
  "status": "passed"
});
formatter.after({
  "duration": 7871380200,
  "status": "passed"
});
});