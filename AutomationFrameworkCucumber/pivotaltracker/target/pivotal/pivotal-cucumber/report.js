$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login/loginPivotal.feature");
formatter.feature({
  "line": 1,
  "name": "Sign-In to Pivotal Tracker as a newly created user",
  "description": "",
  "id": "sign-in-to-pivotal-tracker-as-a-newly-created-user",
  "keyword": "Feature"
});
formatter.before({
  "duration": 84635400,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Sign-in to Pivotal Tracker with valid username and password.",
  "description": "",
  "id": "sign-in-to-pivotal-tracker-as-a-newly-created-user;sign-in-to-pivotal-tracker-with-valid-username-and-password.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I navigate to Pivotal Tracker Website",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I set a valid username/email as at-02@outlook.com",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I press NEXT button a new password field should appear",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I set a valid password as Automation123",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I press the SIGN IN button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I should be redirected to the Pivotal Dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "loginStepDefinitions.openPivotalTracker()"
});
formatter.result({
  "duration": 7989286900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "at-02@outlook.com",
      "offset": 32
    }
  ],
  "location": "loginStepDefinitions.validUsernameOrEmailIsSet(String)"
});
formatter.result({
  "duration": 83909600,
  "status": "passed"
});
formatter.match({
  "location": "loginStepDefinitions.aNewPasswordFieldAppears()"
});
formatter.result({
  "duration": 807009200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automation123",
      "offset": 26
    }
  ],
  "location": "loginStepDefinitions.aValidPasswordIsSet(String)"
});
formatter.result({
  "duration": 478713400,
  "status": "passed"
});
formatter.match({
  "location": "loginStepDefinitions.signInButtonIsPressed()"
});
formatter.result({
  "duration": 182449300,
  "status": "passed"
});
formatter.match({
  "location": "loginStepDefinitions.redirectToPivotalTrackerDashboard()"
});
formatter.result({
  "duration": 12725036800,
  "status": "passed"
});
formatter.after({
  "duration": 108500,
  "status": "passed"
});
formatter.uri("task/task.feature");
formatter.feature({
  "line": 1,
  "name": "Task",
  "description": "In order to work with tasks on Pivotal Tracker\r\nAs an user\r\nI want to create, edit and delete tasks",
  "id": "task",
  "keyword": "Feature"
});
formatter.before({
  "duration": 413200,
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
  "duration": 2066075800,
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
  "duration": 94257200,
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
  "duration": 883684500,
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
  "duration": 3779589100,
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
  "duration": 135767400,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Create a Task",
  "description": "",
  "id": "task;create-a-task",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@task"
    }
  ]
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
  "duration": 6920145900,
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
  "duration": 549799400,
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
  "duration": 273436800,
  "status": "passed"
});
formatter.after({
  "duration": 46000,
  "status": "passed"
});
formatter.after({
  "duration": 12996322200,
  "status": "passed"
});
formatter.before({
  "duration": 743200,
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
  "duration": 2115360300,
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
  "duration": 98245700,
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
  "duration": 569889800,
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
  "duration": 3459396900,
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
  "duration": 111108100,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Update name a Task",
  "description": "",
  "id": "task;update-name-a-task",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@task"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "I create a story as a StoryTest",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I have a task taskOne and taskTwo created",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I change the name of taskTwo for TestTaskUpdated",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "The task should be change to TestTaskUpdated",
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
  "duration": 6096276200,
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
  "duration": 518224200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "taskTwo",
      "offset": 21
    },
    {
      "val": "TestTaskUpdated",
      "offset": 33
    }
  ],
  "location": "TaskSteps.editTask(String,String)"
});
formatter.result({
  "duration": 676112500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestTaskUpdated",
      "offset": 29
    }
  ],
  "location": "TaskSteps.taskEditVerification(String)"
});
formatter.result({
  "duration": 250389700,
  "status": "passed"
});
formatter.after({
  "duration": 51000,
  "status": "passed"
});
formatter.after({
  "duration": 8984883400,
  "status": "passed"
});
formatter.before({
  "duration": 504600,
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
  "duration": 2950009500,
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
  "duration": 94135400,
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
  "duration": 696811900,
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
  "duration": 3885668300,
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
  "duration": 114387800,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Create multiple Tasks with the same name",
  "description": "",
  "id": "task;create-multiple-tasks-with-the-same-name",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@task"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "I create a story as a StoryTest",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I add multiple tasks with the same name as TaskTest",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I click on save story with tasks",
  "keyword": "And "
});
formatter.step({
  "line": 28,
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
  "duration": 5547438500,
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
  "duration": 1218873600,
  "status": "passed"
});
formatter.match({
  "location": "TaskSteps.clickOnSaveStoryWithTasks()"
});
formatter.result({
  "duration": 344338000,
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
  "duration": 153008000,
  "status": "passed"
});
formatter.after({
  "duration": 39700,
  "status": "passed"
});
formatter.after({
  "duration": 9633203400,
  "status": "passed"
});
formatter.before({
  "duration": 450300,
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
  "duration": 1766175100,
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
  "duration": 87110100,
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
  "duration": 450584700,
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
  "duration": 3543989800,
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
  "duration": 132038800,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Delete a Task",
  "description": "",
  "id": "task;delete-a-task",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 29,
      "name": "@task"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "I create a story as a StoryTest",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "I have a task taskOne and taskTwo created",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I delete taskOne",
  "keyword": "When "
});
formatter.step({
  "line": 34,
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
  "duration": 5277005900,
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
  "duration": 535328500,
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
  "duration": 2185576900,
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
  "duration": 384282200,
  "status": "passed"
});
formatter.after({
  "duration": 59700,
  "status": "passed"
});
formatter.after({
  "duration": 8416946000,
  "status": "passed"
});
formatter.before({
  "duration": 455200,
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
  "duration": 2008030000,
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
  "duration": 132306900,
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
  "duration": 647546900,
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
  "duration": 3567199700,
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
  "duration": 117848200,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Create task without name",
  "description": "",
  "id": "task;create-task-without-name",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 35,
      "name": "@task"
    }
  ]
});
formatter.step({
  "line": 37,
  "name": "I create a story as a StoryTest",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "I press add new task without name",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I expect an alert message",
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
  "duration": 4403167700,
  "status": "passed"
});
formatter.match({
  "location": "TaskSteps.iPressAddNewTaskWithoutName()"
});
formatter.result({
  "duration": 149726900,
  "status": "passed"
});
formatter.match({
  "location": "TaskSteps.iExpectAnAlertMessage()"
});
formatter.result({
  "duration": 240267100,
  "status": "passed"
});
formatter.after({
  "duration": 43600,
  "status": "passed"
});
formatter.after({
  "duration": 8407509400,
  "status": "passed"
});
formatter.before({
  "duration": 355500,
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
  "duration": 2237029600,
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
  "duration": 155611500,
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
  "duration": 616265800,
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
  "duration": 3779756400,
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
  "duration": 113531700,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "Check a task as Done",
  "description": "",
  "id": "task;check-a-task-as-done",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 40,
      "name": "@task"
    }
  ]
});
formatter.step({
  "line": 42,
  "name": "I create a story as a StoryTest",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "I have a task taskOne and taskTwo created",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "I check in done the taskTwo created",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "A task status should be show TASKS (1/2)",
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
  "duration": 4862547800,
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
  "duration": 615975600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "taskTwo",
      "offset": 20
    }
  ],
  "location": "TaskSteps.doneTask(String)"
});
formatter.result({
  "duration": 341869400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TASKS (1/2)",
      "offset": 29
    }
  ],
  "location": "TaskSteps.verifyTheTaskIsDone(String)"
});
formatter.result({
  "duration": 253398100,
  "status": "passed"
});
formatter.after({
  "duration": 42300,
  "status": "passed"
});
formatter.after({
  "duration": 8611248100,
  "status": "passed"
});
});