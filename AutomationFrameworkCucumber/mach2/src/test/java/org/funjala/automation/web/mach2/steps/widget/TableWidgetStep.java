package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.pages.mach2.container.WidgetPage;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

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

//  @Then("^I have a table widget with \"([^\"]*)\" filled$")
//  public void iHaveATableWidgetWithFilled(String managerName) {
//    System.setProperty("webdriver.chrome.driver", "../tools/chromedriver.exe");
//    driver = new ChromeDriver();
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.manage().window().maximize();
//
//    OESearchManagerPage searchManagerPage = new OESearchManagerPage(driver);
//    searchManagerPage.loginOpen();
//    searchManagerPage.searchManager(managerName);
//  }
}
