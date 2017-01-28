package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
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
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 1/25/2017.
 */
public class TablePerInForDepartmentsSteps {

  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  WidgetPage widget;

  OELoginPage oeLoginPage;
  OEHomePage homePage;
  OESearch oeSearch;
  List<ModelSearch> listModelSearch = new ArrayList<>();
  ModelSearch modelSearch;
  Log log = Log.getInstance();
  int x = 0;

  @Given("^I go to Mach2 web page$")
  public void iGoToMachWebPage() throws Throwable {
    log.info("Step", "I go to Mach2 web page", "Go to Mach2 web page");
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    loginPage = new LoginPage(driver);
  }

  @And("^I set user and password$")
  public void iSetUserAndPassword() {
    log.info("Step", "I set a username and a password ","Set a valid user name");
    loginPage.setUsernameTextField("at02");
    loginPage.setPasswordTextField("Automation123");
    topMenuPage = loginPage.clickNextButton();
  }

  @Given("^I have a board$")
  public void iHaveABoard() {
    log.info("Step", "I have a board ","create a board");
    topMenuPage.addNewBoard();
  }

  @And("^I click over Widget Button$")
  public void iClickOverWidgetButton() {
    log.info("Step", "I click over Widget Button","create a widget");
    widget = topMenuPage.addNewWidget();
  }

  @When("^I click on Table button on the Widget$")
  public void iClickOnTableButtonOnTheWidget() {
    log.info("Step", "I click on Table button on the Widget","select a table");
    widget.addWidget("Table");

  }

  @And("^I click on Open ERP service$")
  public void iClickOnOpenERPService() {
    log.info("Step", "I click on Open ERP service","select a service");
    widget.clickOnService("Open ERP");

  }

  @And("^I select Option of Open ERP$")
  public void iSelectOptionOfOpenERP() {
    log.info("Step", "I select Option of Open ERP","select a OPENERP");
    widget.selectErpOption();

  }

  @And("^I set department name with \"([^\"]*)\"$")
  public void iSetDepartmentNameWith(String arg0) {
    log.info("Step", "I set department name with a name","select a Security test");
    widget.clickOnAdvanceConfiguration();
    widget.setDepartmentName("Security test");

  }

  @And("^I save that option with the department \"([^\"]*)\" selected$")
  public void iSaveThatOption(String department) {
    log.info("Step", "I save that option with the department","save option");
    widget.clickSaveButton();
    x = widget.verifyCantDepartment(department);
  }

  @Then("^I have a table with employees filtered for a \"([^\"]*)\"$")
  public void iHaveATableWithEmployeesFilteredForA(String s) throws InterruptedException, IOException {
    log.info("Step", "I have a table with employees filtered","expected result");
    MyDashboard myDashboard = new MyDashboard(driver);
    myDashboard.deleteBoard();

    topMenuPage.clickOnLogOut();
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    oeLoginPage = new OELoginPage(driver);
    oeLoginPage.setUserName("jose7");
    oeLoginPage.setPassword("jose7");
    homePage = oeLoginPage.clickBtnSubmit();
    homePage.clickHumanResources();
    oeSearch = homePage.oeSearch();
    oeSearch.clickSearchArrow();
    oeSearch.clickAdvancedSearch();
    oeSearch.foundAndClickAdvancedFilterOptions("Department", "is equal to", "Security test");
    oeSearch.clickApplySearch();
    oeSearch.clickSwitchList();
    oeSearch.clickNumberElement();
    oeSearch.clickQuantityButton();
    oeSearch.clickUnlimitedOption();

    List<WebElement> result = oeSearch.listOfAllElements();
    SoftAssert sd = new SoftAssert();
    sd.assertEquals(result.size(), x, "Compare numbers of Items");
    homePage.clickUserAccount();
    homePage.clickLogOut();

    sd.assertAll();
  }
}
