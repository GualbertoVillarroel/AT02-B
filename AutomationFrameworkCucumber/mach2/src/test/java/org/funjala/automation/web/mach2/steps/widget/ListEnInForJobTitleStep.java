package org.funjala.automation.web.mach2.steps.widget;

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
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by JorgeForero on 1/25/2017.
 */
public class ListEnInForJobTitleStep {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  WidgetPage widget;
  Log log = Log.getInstance();

  @Given("^I am login on Mach2 webpage with user: \"([^\"]*)\" and password: \"([^\"]*)\"$")
  public void loginOnMachWebpage(String userName, String password) throws IOException {
    log.info("Step", "I am login on Mach2 webpage", "Go to Mach2 webpage");
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    loginPage = new LoginPage(driver);
    loginPage.setUsernameTextField(userName);
    loginPage.setPasswordTextField(password);
    topMenuPage = loginPage.clickNextButton();
  }

  @Given("^I have a board created with a widget$")
  public void iHaveABoardWithWidget() {
    log.info("Step", "I have a board created with a widget", "created board and widget");
    topMenuPage.addNewBoard();
    widget = topMenuPage.addNewWidget();
  }

  @When("^I select \"([^\"]*)\" on Widgets options$")
  public void iClickOnListButtonOnWidgetDisplayed(String widgetType) {
    log.info("Step", "I click on Widget button", "Add a Widget");
    widget.addWidget(widgetType);
  }

  @And("^I select \"([^\"]*)\" services$")
  public void iClickOnOpenERPService(String service) {
    log.info("Step", "I click on " + service + " service", "Select Open ERP service");
    widget.clickOnService(service);
  }

  @And("^I select Engineer Information$")
  public void iSelectOpenERP() {
    log.info("Step", "I select Engineer Information ", "Engineer Information");
    widget.selectEngineerInformationOption();
  }

  @And("^I fill Job Title with \"([^\"]*)\" option and I click on save$")
  public void iFillJobTitle(String jobTitle) {
    log.info("Step", "I fill Job Title with " + jobTitle, "Select Job Title");
    widget.clickAdvanceConfiguration();
    widget.selectCFO();
    widget.clickSaveButton();
  }

  @Then("^I have a List widget with \"([^\"]*)\"$")
  public void iHaveAListWidgetWithFilled(String name) throws IOException, InterruptedException {
    log.info("Step", "Verification on Mach2 and Open ERP", "Verification of datas");
    boolean mach2 = widget.verifyList(name);
    Thread.sleep(5000);
    MyDashboard dashboard = new MyDashboard(driver);
    dashboard.deleteBoard();

    //Logout Mach2
    topMenuPage.clickOnLogOut();
    assertEquals(openERPVerification(name), mach2);
  }

  private boolean openERPVerification(String name) throws IOException, InterruptedException {
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose7");
    loginERP.setPassword("jose7");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    //Go to Human Resources

    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go to Search
    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();
    searchERP.foundAndClickAdvancedFilterOptions("Job Title", "is equal to", "CFO");
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    boolean result = false;
    List<ModelSearch> list = searchERP.getResultOfSearch();
    if (list.get(0).getName().equals(name)) {
      result = true;
    }
    homeERP.clickUserAccount();
    homeERP.clickLogOut();
    return result;
  }
}
