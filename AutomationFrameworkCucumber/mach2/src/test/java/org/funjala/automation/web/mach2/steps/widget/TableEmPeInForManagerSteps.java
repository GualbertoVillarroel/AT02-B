package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.CucumberScreenshot;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.model.erp.search.ModelSearch;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.funjala.automation.web.pages.mach2.dashboard.MyDashboard;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.sidebar.SideBarPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by DavidVallejos on 1/21/2017.
 */
public class TableEmPeInForManagerSteps {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  WidgetPage widget;
  MyDashboard dashboard;
  Log log = Log.getInstance();

  @Given("^I am on Mach2 webpage$")
  public void iAmOnMachWebpage() throws IOException {
    log.info("Step", "I am on Mach2 webpage", "Go to Mach2 webpage");
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    loginPage = new LoginPage(driver);
  }

  @And("^I fill username or mail textfield as \"([^\"]*)\"$")
  public void iFillUsernameOrMailTextfieldAs(String userName) {
    log.info("Step", "I fill username or mail textfield as " + userName, "Fill a valid user name");
    loginPage.setUsernameTextField(userName);
  }

  @And("^I fill password textfield as \"([^\"]*)\" and press Submit button$")
  public void iFillPasswordTextfieldAsAndPressSubmitButton(String password) {
    log.info("Step", "I fill password textfield as " + password + " and press Submit button", "Fill a valid password");
    loginPage.setPasswordTextField(password);
    topMenuPage = loginPage.clickNextButton();
  }

  @Given("^I have a board created$")
  public void iHaveABoardCreated() {
    log.info("Step", "I have a board created", "Add a new Board");
    topMenuPage.addNewBoard();
  }

  @And("^I click on Widget button$")
  public void iClickOnWidgetButton() {
    log.info("Step", "I click on Widget button", "Add a Widget");
    widget = topMenuPage.addNewWidget();
  }

  @When("^I click on \"([^\"]*)\" button on Widget displayed$")
  public void iClickOnTableButtonOnWidgetDisplayed(String widgetType) {
    log.info("Step", "I click on " + widgetType + " button on Widget displayed", "Select Table Widget");
    widget.addWidget(widgetType);
  }

  @And("^I click on \"([^\"]*)\" service$")
  public void iClickOnOpenERPService(String service) {
    log.info("Step", "I click on " + service + " service", "Select Open ERP service");
    widget.clickOnService(service);
  }

  @And("^I select an Option of Open ERP$")
  public void iSelectAnOptionOfOpenERP() {
    log.info("Step", "I select an Option of Open ERP ", "Select Employees Personal Information");
    widget.selectErpOption();
  }

  @And("^I fill manager name on textfield as \"([^\"]*)\"$")
  public void iFillManagerNameOnTextfieldAs(String managerName) {
    log.info("Step", "I fill manager name on textfield as " + managerName, "Select Manager");
    widget.setManagerName(managerName);
  }

  @And("^I click on save button$")
  public void iClickOnSaveButton() {
    log.info("Step", "I click on save button", "Click on save button");
    widget.clickSaveButton();
  }

  @Then("^I have a table widget with \"([^\"]*)\" filled$")
  public void iHaveATableWidgetWithFilled(String managerName) throws IOException, InterruptedException {
    log.info("Step", "Verification on Mach2 and Open ERP", "Verification of datas");
    int actualResult = widget.verifyCant(managerName);

    //Clean up Widget and Board
    log.info("Clean", "Delete Widget and Board Mach2", "Clean up: Delete Mach2");
    dashboard = new MyDashboard(driver);
    dashboard.deleteBoard();

    //Logout Mach2
    log.info("Clean", "Logout Mach2", "Clean up: Logout");
    topMenuPage.clickOnLogOut();

    //Login OPEN ERP
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
    searchERP.foundAndClickAdvancedFilterOptions("manager", "is equal to", managerName);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();

    //Get elements of the list
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<WebElement> listManager = searchERP.listOfAllElements();

    log.info("Verification", "Verification on Mach2 and Open ERP", "Verification of Mach2 with OpenERP");
    assertEquals(listManager.size(), actualResult);

    //Logout Open ERP page
    log.info("Clean", "Logout OpenERP", "Clean up: Logout");
    homeERP.clickUserAccount();
    homeERP.clickLogOut();
  }

  @And("^I fill division textfield as \"([^\"]*)\"$")
  public void iFillDivisionTextfieldAs(String value) throws Throwable {
    widget.setDivisionName(value);
  }

  @Then("^I have a table widget with division \"([^\"]*)\"$")
  public void iHaveATableWidgetWithDivision(String value) throws Throwable {
    int actualResult = widget.verifyCant(value);
    System.out.println(actualResult);

    //Clean up Widget and Board
    dashboard = new MyDashboard(driver);
    dashboard.deleteBoard();

    //Logout Mach2
    topMenuPage.clickOnLogOut();

    //Login OPEN ERP
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose6");
    loginERP.setPassword("jose6");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

//    //Go to Human Resources
    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go to Search
    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();

    //Make a search by manager
    searchERP.foundAndClickAdvancedFilterOptions("division", "is equal to", value);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();

    //Get elements of the list
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<ModelSearch> listManager = searchERP.getResultOfSearch();

    assertEquals(listManager.size(), actualResult);

    //Logout Open ERP page
    homeERP.clickUserAccount();
    homeERP.clickLogOut();

  }
}
