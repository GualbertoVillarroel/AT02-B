package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
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
public class TableWidgetStep {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  WidgetPage widget;

  @Given("^I am on Mach2 webpage$")
  public void iAmOnMachWebpage() throws IOException {
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    loginPage = new LoginPage(driver);
  }

  @And("^I fill username or mail textfield as \"([^\"]*)\"$")
  public void iFillUsernameOrMailTextfieldAs(String userName) {
    loginPage.setUsernameTextField(userName);
  }

  @And("^I fill password textfield as \"([^\"]*)\" and press Submit button$")
  public void iFillPasswordTextfieldAsAndPressSubmitButton(String password) {
    loginPage.setPasswordTextField(password);
    topMenuPage = loginPage.clickNextButton();
  }

  @Given("^I have a board created$")
  public void iHaveABoardCreated() {
    topMenuPage.addNewBoard();
  }

  @And("^I click on Widget button$")
  public void iClickOnWidgetButton() {
    widget = topMenuPage.addNewWidget();
  }

  @When("^I click on \"([^\"]*)\" button on Widget displayed$")
  public void iClickOnTableButtonOnWidgetDisplayed(String widgetType) {
    widget.addWidget(widgetType);
  }

  @And("^I click on \"([^\"]*)\" service$")
  public void iClickOnOpenERPService(String service) {
    widget.clickOnService(service);
  }

  @And("^I select an Option of Open ERP$")
  public void iSelectAnOptionOfOpenERP() {
    widget.selectErpOption();
  }

  @And("^I fill manager name on textfield as \"([^\"]*)\"$")
  public void iFillManagerNameOnTextfieldAs(String managerName) {
    widget.setManagerName(managerName);
  }

  @And("^I click on save button$")
  public void iClickOnSaveButton() {
    widget.clickSaveButton();
  }

  @Then("^I have a table widget with \"([^\"]*)\" filled$")
  public void iHaveATableWidgetWithFilled(String managerName) throws IOException, InterruptedException {
    int actualResult = widget.verifyCant(managerName);
    System.out.println(">>>>>>>>>>>>>>>>>>>");
    System.out.println(actualResult);
    System.out.println(">>>>>>>>>>>>>>>>>>>");
    SideBarPage sideBarPage = topMenuPage.goToSidebar();
    sideBarPage.deleteAllBoards();

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
    searchERP.foundAndClickAdvancedFilterOptions("manager", "is equal to", "Patricia Villagomez Montalvo");
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<WebElement> listManager = searchERP.listOfAllElements();

    assertEquals(listManager.size(), actualResult);
  }

}
