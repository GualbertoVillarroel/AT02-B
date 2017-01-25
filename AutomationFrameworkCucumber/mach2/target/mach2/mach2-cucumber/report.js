$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("deleteBoard.feature");
formatter.feature({
  "line": 1,
  "name": "Board",
  "description": "",
  "id": "board",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Create and delete a board",
  "description": "",
  "id": "board;create-and-delete-a-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I am on Mach2 web page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I put at02 as username",
  "keyword": "And "
});
formatter.step({
  "line": 5,
  "name": "I put Automation123 as password and press LogIn button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I go to My Dashboard",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I add a New Board",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I click on the Config icon",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I select the Delete option",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "The New Board should be deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "DeleteBoard.iAmOnMach2WebPage()"
});
formatter.result({
  "duration": 8300868600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "at02",
      "offset": 6
    }
  ],
  "location": "DeleteBoard.iPutXAsUsername(String)"
});
formatter.result({
  "duration": 129249400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automation123",
      "offset": 6
    }
  ],
  "location": "DeleteBoard.iPutXAsPasswordAndPressLogInButton(String)"
});
formatter.result({
  "duration": 165588500,
  "status": "passed"
});
formatter.match({
  "location": "DeleteBoard.iGoToMyDashboard()"
});
formatter.result({
  "duration": 116539200,
  "status": "passed"
});
formatter.match({
  "location": "DeleteBoard.iAddANewBoard()"
});
formatter.result({
  "duration": 407887500,
  "status": "passed"
});
formatter.match({
  "location": "DeleteBoard.iClickOnTheConfigIcon()"
});
formatter.result({
  "duration": 1013694400,
  "status": "passed"
});
formatter.match({
  "location": "DeleteBoard.iSelectTheDeleteOption()"
});
formatter.result({
  "duration": 595039700,
  "status": "passed"
});
formatter.match({
  "location": "DeleteBoard.theNewBoardShouldBeDeleted()"
});
formatter.result({
  "duration": 86261700,
  "status": "passed"
});
});