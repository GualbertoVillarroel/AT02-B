$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/widget/tableEnInForManager.feature");
formatter.feature({
  "line": 1,
  "name": "Widget using Open ERP service to show Engineer Information",
  "description": "",
  "id": "widget-using-open-erp-service-to-show-engineer-information",
  "keyword": "Feature"
});
formatter.before({
  "duration": 843148300,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to Mach2",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I am on Mach2 Web page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I set a username as \"at02\"",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I set a password as \"Automation123\" and press Login button",
  "keyword": "And "
});
formatter.match({
  "location": "TableEnInForManager.iAmOnMac2WebPage()"
});
formatter.result({
  "duration": 66470019000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "at02",
      "offset": 21
    }
  ],
  "location": "TableEnInForManager.iSetAUsernameAs(String)"
});
formatter.result({
  "duration": 100238000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automation123",
      "offset": 21
    }
  ],
  "location": "TableEnInForManager.iSetAPasswordAsAndPressLoginButton(String)"
});
formatter.result({
  "duration": 159081600,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Add a Table Widget using Open ERP service to show Engineer Information for a Manager",
  "description": "",
  "id": "widget-using-open-erp-service-to-show-engineer-information;add-a-table-widget-using-open-erp-service-to-show-engineer-information-for-a-manager",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I add a board",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I add a \"Table\" Widget",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I select \"Open ERP\" service",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I select Engineer Information option",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I choose \"David Angeles Cambom\" as value for Manager field",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I press Save button",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I obtain a table with the Engineer Information for \"David Angeles Cambom\" as manager",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I should have the same result using Open ERP web page to search Engineer Information for \"David Angeles Cambom\" as manager",
  "keyword": "Then "
});
formatter.match({
  "location": "TableEnInForManager.iAddABoard()"
});
formatter.result({
  "duration": 723596200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Table",
      "offset": 9
    }
  ],
  "location": "TableEnInForManager.iAddAXWidget(String)"
});
formatter.result({
  "duration": 126309500,
  "error_message": "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document\n  (Session info: chrome\u003d55.0.2883.87)\n  (Driver info: chromedriver\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed),platform\u003dWindows NT 6.3.9600 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 90 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/stale_element_reference.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:49:13 -0700\u0027\nSystem info: host: \u0027at02guvi01\u0027, ip: \u002710.28.104.136\u0027, os.name: \u0027Windows Server 2012 R2\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.3\u0027, java.version: \u00271.8.0_101\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed), userDataDir\u003dC:\\Users\\ADMINI~1\\AppData\\Local\\Temp\\2\\scoped_dir13472_3763}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d55.0.2883.87, platform\u003dWIN8_1, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 30540b97b878c5c3ced005836744f865\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:274)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.isDisplayed(RemoteWebElement.java:315)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy19.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:302)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$100(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:288)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:285)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:684)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:677)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat org.funjala.automation.web.pages.mach2.menu.TopMenuPage.addNewWidget(TopMenuPage.java:71)\r\n\tat org.funjala.automation.web.mach2.steps.widget.TableEnInForManager.iAddAXWidget(TableEnInForManager.java:64)\r\n\tat ✽.When I add a \"Table\" Widget(src/test/resources/features/widget/tableEnInForManager.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Open ERP",
      "offset": 10
    }
  ],
  "location": "TableEnInForManager.iSelectXService(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TableEnInForManager.iSelectXOption()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "David Angeles Cambom",
      "offset": 10
    }
  ],
  "location": "TableEnInForManager.iChooseXAsValueForManagerField(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TableEnInForManager.iClickOnSaveButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "David Angeles Cambom",
      "offset": 52
    }
  ],
  "location": "TableEnInForManager.iObtainATableWithTheEnngineerInformationForXAsManager(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "David Angeles Cambom",
      "offset": 90
    }
  ],
  "location": "TableEnInForManager.iShouldHaveTheSameResulUsingErpPageToSearchEngineerInformationForManager(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 223920400,
  "status": "passed"
});
});