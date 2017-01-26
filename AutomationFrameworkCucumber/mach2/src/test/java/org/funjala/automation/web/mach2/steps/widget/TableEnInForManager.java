package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.funjala.automation.web.pages.mach2.dashboard.MyDashboard;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.testng.Assert.assertEquals;


public class TableEnInForManager {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  WidgetPage widget;
  MyDashboard dashboard;
  Log log = Log.getInstance();
  private int restult;

  @Given("^I am on Mach2 Web page$")
  public void iAmOnMac2WebPage() throws IOException {
    log.info("Step", "I am on Mach2 Web page", "Go to Mach2 web page");
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    loginPage = new LoginPage(driver);
  }

  @And("^I set a username as \"(.*)\"$")
  public void iSetAUsernameAs(String userName) {
    log.info("Step", "I set a username as " + userName, "Set a valid user name");
    loginPage.setUsernameTextField(userName);
  }

  @And("^I set a password as \"(.*)\" and press Login button$")
  public void iSetAPasswordAsAndPressLoginButton(String password) {
    log.info("Step", "I set a password as " + password + " and press Login button", "Set a valid password");
    loginPage.setPasswordTextField(password);
    topMenuPage = loginPage.clickNextButton();
  }

  @Given("^I add a board$")
  public void iAddABoard() {
    log.info("Step", "I add a board", "Add a new Board");
    topMenuPage.addNewBoard();
  }

  @When("^I add a \"(.*)\" Widget$")
  public void iAddAXWidget(String widgetType) {
    log.info("Step", "I add a " + widgetType + " Widget", "Add a new Widget");
    widget = topMenuPage.addNewWidget();
    widget.addWidget(widgetType);
  }

  @And("^I select \"(.*)\" service$")
  public void iSelectXService(String service) {
    log.info("Step", "I select " + service + " service", "Select Open ERP service");
    widget.clickOnService(service);
  }

  @And("^I select Engineer Information option$")
  public void iSelectXOption() {
    log.info("Step", "I select an Option of Open ERP ", "Select Engineer Information option");
    widget.selectEiOption();
  }

  @And("^I choose \"(.*)\" as value for Manager field$")
  public void iChooseXAsValueForManagerField(String manager) {
    log.info("Step", "I choose " + manager + " as value for Manager field", "Select a Manager");
    widget.setManagerName(manager);
  }

  @And("^I press Save button$")
  public void iClickOnSaveButton() {
    log.info("Step", "I press Save button", "Press Save button");
    widget.clickSaveButton();
  }

  @And("^I obtain a table with the Engineer Information for \"(.*)\" as manager$")
  public void iObtainATableWithTheEnngineerInformationForXAsManager(String manager) throws InterruptedException {
    log.info("Step", "I obtain a table with the Engineer Information for " + manager + " as manager", "Get Engineer Information for Manager in Mach2");
    restult = widget.verifyCant(manager);
    dashboard = new MyDashboard(driver);
    dashboard.deleteBoard();
    topMenuPage.clickOnLogOut();
  }

  @Then("^I should have the same result using Open ERP web page to search Engineer Information for \"(.*)\" as manager$")
  public void iShouldHaveTheSameResulUsingErpPageToSearchEngineerInformationForManager(String manager) throws IOException, InterruptedException {
    log.info("Step", "I should have the same result using Open ERP web page to search Engineer Information for " + manager + " as manager", "Mach Engineer Information for Manager between Mach2 and Open ERP");
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose6");
    loginERP.setPassword("jose6");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    //Go to Human Resources
    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go to Search
    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();

    //Make a search by manager
    searchERP.foundAndClickAdvancedFilterOptions("manager", "is equal to", manager);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();

    //Get elements of the list
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<WebElement> listManager = searchERP.listOfAllElements();

    assertEquals(listManager.size(), restult);

    //Logout Open ERP page
    homeERP.clickUserAccount();
    homeERP.clickLogOut();
  }
}