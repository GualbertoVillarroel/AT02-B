package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.model.erp.search.ModelSearch;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.funjala.automation.web.pages.mach2.dashboard.MyDashboard;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TableEeByDivision {
  WidgetPage widget;
  Log log = Log.getInstance();
  private int result;


  @And("^I choose \"(.*)\" as value for Division field$")
  public void step_i_ChooseXAsValueForXField(String value) {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "I choose " + value + " as value for field", "Select a Division");
    widget.setDivisionName(value);
  }

  @And("^I obtain a table with the Employees Experience for \"(.*)\" Division$")
  public void step_i_ObtainATableWithTheEnngineerInformationForXAsManager(String division) throws InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    MyDashboard dashboard = new MyDashboard(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);

    log.info("Step", "I obtain a table with the Employees Experience for " + division + " as Division$", "Get Employees Experiencen for Manager in Mach2");
    result = widget.verifyCant(division);
    dashboard.deleteBoard();
    topMenuPage.clickOnLogOut();
  }

  @Then("^I should have the same result using Open ERP web page to search Employees Experience for \"(.*)\" Division in which \"(.*)\" is one of the found names$")
  public void step_i_ShouldHaveTheSameResulUsingErpPageToSearchEngineerInformationForManager(String division, String value) throws IOException, InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver;
    log.info("Step", "I should have the same result using Open ERP web page to search Employees Experience for " + division + " as Division in which " + value + " is one of the found names", "Mach Employees Experience by Division between Mach2 and Open ERP");
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

    //Make a search by division
    searchERP.foundAndClickAdvancedFilterOptions("division", "is equal to", division);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();

    //Get elements of the list
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();

    List<WebElement> listManager = searchERP.listOfAllElements();
    int expectResult = listManager.size();

    boolean res = false;
    List<ModelSearch> listDivision = searchERP.getResultOfSearch();
    for (ModelSearch modelSearch : listDivision) {
      if (modelSearch.getName().equals(value)) {
        res = true;
        break;
      }
    }

    //Logout Open ERP page
    homeERP.clickUserAccount();
    homeERP.clickLogOut();
    assertEquals(expectResult, result);
    assertTrue(res);
  }
}