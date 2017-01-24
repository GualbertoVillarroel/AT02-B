$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Login into Mach 2",
  "description": "",
  "id": "login-into-mach-2",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Sign-in to Mach 2 with valid username and password.",
  "description": "",
  "id": "login-into-mach-2;sign-in-to-mach-2-with-valid-username-and-password.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I am on Mach 2 page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I put a at02 in user textfield",
  "keyword": "And "
});
formatter.step({
  "line": 5,
  "name": "I put a Automation123 in password textfield and press Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepsDefinitions.onPivotalTrackerPage()"
});
formatter.result({
  "duration": 6655156500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "at02",
      "offset": 8
    }
  ],
  "location": "LoginStepsDefinitions.putNameAndPressNextButton(String)"
});
formatter.result({
  "duration": 94224800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automation123",
      "offset": 8
    }
  ],
  "location": "LoginStepsDefinitions.putPasswordAndPressSubmitButton(String)"
});
formatter.result({
  "duration": 992890800,
  "status": "passed"
});
formatter.uri("loginOE.feature");
formatter.feature({
  "line": 1,
  "name": "Sign-in to OpenERP",
  "description": "",
  "id": "sign-in-to-openerp",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Sign-in to OpenERP with a valid account",
  "description": "",
  "id": "sign-in-to-openerp;sign-in-to-openerp-with-a-valid-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I navigate to OpenERP web page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I put the next data",
  "rows": [
    {
      "cells": [
        "username",
        "jose7"
      ],
      "line": 5
    },
    {
      "cells": [
        "password",
        "jose7"
      ],
      "line": 6
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I press the button submit",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I expect redirect to the main page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "OpenERP",
      "offset": 14
    }
  ],
  "location": "LoginOE.iNavigateToOpenERPWebPage(String)"
});
formatter.result({
  "duration": 2995192500,
  "status": "passed"
});
formatter.match({
  "location": "LoginOE.iPutTheNextData(String,String\u003e)"
});
formatter.result({
  "duration": 115209300,
  "status": "passed"
});
formatter.match({
  "location": "LoginOE.iPressTheButtonSubmit()"
});
formatter.result({
  "duration": 608796400,
  "status": "passed"
});
formatter.match({
  "location": "LoginOE.iExpectRedirectToTheMainPage()"
});
formatter.result({
  "duration": 1965741500,
  "status": "passed"
});
});