package org.funjala.automation.web.mach2.steps.scenario;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.funjala.automation.web.pages.mach2.board.BoardOptions;
import org.funjala.automation.web.pages.mach2.board.BoardPage;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class SceneStep {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  WidgetPage widget;
  BoardPage boardPage;
  BoardOptions boardOptions;

  @Given("^I am on Mach2 Web page$")
  public void iAmOnMac2WebPage() throws IOException {
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    loginPage = new LoginPage(driver);
  }

  @And("^I set a username as \"(.*)\"$")
  public void iSetAUsernameAs(String userName) {
    loginPage.setUsernameTextField(userName);
  }

  @And("^I set a password as \"(.*)\" and press Login button$")
  public void iSetAPasswordAsAndPressLoginButton(String password) {
    loginPage.setPasswordTextField(password);
    topMenuPage = loginPage.clickNextButton();
  }

  @Given("^I add a board$")
  public void iAddABoard() {
    topMenuPage.addNewBoard();
  }

  @When("^I add a \"(.*)\" Widget$")
  public void iAddAXWidget(String widgetType) {
    widget = topMenuPage.addNewWidget();
    widget.addWidget(widgetType);
  }

  @And("^I select \"(.*)\" service$")
  public void iSelectXService(String service) {
    widget.clickOnService(service);
  }

  @And("^I select Engineer Information option$")
  public void iSelectXOption() {
    widget.selectEiOption();
  }

  @And("^I choose \"(.*)\" as value for Manager field$")
  public void iChooseXAsValueForManagerField(String manager) {
    widget.setManagerName(manager);
  }

  @And("^I press Save button$")
  public void iClickOnSaveButton() {
    widget.clickSaveButton();
  }

  @Then("^I should have a table with \"(.*)\" filled$")
  public void iShouldHaveATableWithXFilled(String manager) throws IOException, InterruptedException {
    int actualResult = widget.verifyCant(manager);
    boardPage = topMenuPage.goToBoardPage();
    boardOptions = boardPage.clickBoardConfig();
    boardOptions.deleteBoardMach();
//    topMenuPage.clickOnLogOut();

    //Open ERP
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose6");
    loginERP.setPassword("jose6");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();
    searchERP.foundAndClickAdvancedFilterOptions("manager", "is equal to", manager);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<WebElement> listManager = searchERP.listOfAllElements();

    assertEquals(listManager.size(), actualResult);

    homeERP.clickUserAccount();
    homeERP.clickLogOut();
  }
}