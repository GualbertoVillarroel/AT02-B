$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/resource/features/task/task.feature");
formatter.feature({
  "line": 1,
  "name": "Task",
  "description": "In order to work with tasks on Pivotal Tracker\r\nAs an user\r\nI want to create, edit and delete tasks",
  "id": "task",
  "keyword": "Feature"
});
formatter.background({
  "line": 6,
  "name": "Login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I am on Pivotal Tracker page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I put a at-02@outlook.com and press Next button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I put a Automation123 and press Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I create a project as a TestProject",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I select an account as a Jala",
  "keyword": "And "
});
formatter.match({
  "location": "TaskSteps.onPivotalTrackerPage()"
});
formatter.result({
  "duration": 6539739500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "at-02@outlook.com",
      "offset": 8
    }
  ],
  "location": "TaskSteps.putNameAndPressNextButton(String)"
});
formatter.result({
  "duration": 1517537600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automation123",
      "offset": 8
    }
  ],
  "location": "TaskSteps.putPasswordAndPressSubmitButton(String)"
});
formatter.result({
  "duration": 2708610500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestProject",
      "offset": 24
    }
  ],
  "location": "TaskSteps.createProject(String)"
});
formatter.result({
  "duration": 234535000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jala",
      "offset": 25
    }
  ],
  "location": "TaskSteps.selectAccount(String)"
});
formatter.result({
  "duration": 283918900,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Create a Task",
  "description": "",
  "id": "task;create-a-task",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I create a story as a StoryTest",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I add a task as a TestTask",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "A task named TestTask should be created",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "StoryTest",
      "offset": 22
    }
  ],
  "location": "TaskSteps.createAStoryWithXName(String)"
});
formatter.result({
  "duration": 8293310100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestTask",
      "offset": 18
    }
  ],
  "location": "TaskSteps.addATaskWithXName(String)"
});
formatter.result({
  "duration": 369056200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestTask",
      "offset": 13
    }
  ],
  "location": "TaskSteps.taskCalledXShouldBeCreated(String)"
});
formatter.result({
  "duration": 281768700,
  "status": "passed"
});
formatter.after({
  "duration": 10877604400,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "Login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I am on Pivotal Tracker page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I put a at-02@outlook.com and press Next button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I put a Automation123 and press Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I create a project as a TestProject",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I select an account as a Jala",
  "keyword": "And "
});
formatter.match({
  "location": "TaskSteps.onPivotalTrackerPage()"
});
formatter.result({
  "duration": 166500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "at-02@outlook.com",
      "offset": 8
    }
  ],
  "location": "TaskSteps.putNameAndPressNextButton(String)"
});
formatter.result({
  "duration": 1906715400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automation123",
      "offset": 8
    }
  ],
  "location": "TaskSteps.putPasswordAndPressSubmitButton(String)"
});
formatter.result({
  "duration": 1951096800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestProject",
      "offset": 24
    }
  ],
  "location": "TaskSteps.createProject(String)"
});
formatter.result({
  "duration": 182951200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jala",
      "offset": 25
    }
  ],
  "location": "TaskSteps.selectAccount(String)"
});
formatter.result({
  "duration": 358382400,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Create multiple Tasks with the same name",
  "description": "",
  "id": "task;create-multiple-tasks-with-the-same-name",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "I create a story as a StoryTest",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I add multiple tasks with the same name as TaskTest",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I click on save story with tasks",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I should have created 5 tasks with the same name as TaskTest",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "StoryTest",
      "offset": 22
    }
  ],
  "location": "TaskSteps.createAStoryWithXName(String)"
});
formatter.result({
  "duration": 4367124200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TaskTest",
      "offset": 43
    }
  ],
  "location": "TaskSteps.addMultipleTasksWithSameName(String)"
});
formatter.result({
  "duration": 887973900,
  "status": "passed"
});
formatter.match({
  "location": "TaskSteps.clickOnSaveStoryWithTasks()"
});
formatter.result({
  "duration": 285521900,
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
  "location": "TaskSteps.verifyTasksWasCreate(int,String)"
});
formatter.result({
  "duration": 126149400,
  "status": "passed"
});
formatter.after({
  "duration": 8850941200,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "Login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I am on Pivotal Tracker page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I put a at-02@outlook.com and press Next button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I put a Automation123 and press Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I create a project as a TestProject",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I select an account as a Jala",
  "keyword": "And "
});
formatter.match({
  "location": "TaskSteps.onPivotalTrackerPage()"
});
formatter.result({
  "duration": 154200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "at-02@outlook.com",
      "offset": 8
    }
  ],
  "location": "TaskSteps.putNameAndPressNextButton(String)"
});
formatter.result({
  "duration": 764530700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automation123",
      "offset": 8
    }
  ],
  "location": "TaskSteps.putPasswordAndPressSubmitButton(String)"
});
formatter.result({
  "duration": 1877742500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestProject",
      "offset": 24
    }
  ],
  "location": "TaskSteps.createProject(String)"
});
formatter.result({
  "duration": 220112000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jala",
      "offset": 25
    }
  ],
  "location": "TaskSteps.selectAccount(String)"
});
formatter.result({
  "duration": 582825000,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Delete a Task",
  "description": "",
  "id": "task;delete-a-task",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "I create a story as a StoryTest",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I have a task taskOne and taskTwo created",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I delete taskOne",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "taskOne should be deleted",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "StoryTest",
      "offset": 22
    }
  ],
  "location": "TaskSteps.createAStoryWithXName(String)"
});
formatter.result({
  "duration": 4272449500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "taskOne",
      "offset": 14
    },
    {
      "val": "taskTwo",
      "offset": 26
    }
  ],
  "location": "TaskSteps.createTasks(String,String)"
});
formatter.result({
  "duration": 398660500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "taskOne",
      "offset": 9
    }
  ],
  "location": "TaskSteps.deleteTask(String)"
});
formatter.result({
  "duration": 209206800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "taskOne",
      "offset": 0
    }
  ],
  "location": "TaskSteps.taskDeletedVerification(String)"
});
formatter.result({
  "duration": 277357300,
  "status": "passed"
});
formatter.after({
  "duration": 6210796700,
  "status": "passed"
});
});