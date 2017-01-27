package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.PendingException;
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
import org.funjala.automation.web.pages.mach2.sidebar.SideBarPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Administrator on 1/25/2017.
 */
public class ListEmExBySkillsSteps {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  WidgetPage widget;
  Log log = Log.getInstance();

  @Given("^I am at Mach2 webpage$")
  public void iAmOnMachWebpage() throws IOException {
    log.info("Step", "I am at Mach2 webpage", "and prepare to Login");
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    loginPage = new LoginPage(driver);
  }

  @And("^I set username as \"([^\"]*)\"$")
  public void iFillUsernameOrMailTextfieldAs(String userName) {
    log.info("Step", "I set username as ", userName);
    loginPage.setUsernameTextField(userName);
  }

  @And("^I set password as \"([^\"]*)\" and press Submit button$")
  public void iFillPasswordTextfieldAsAndPressSubmitButton(String password) {
    log.info("Step", "I set password as ",  password + "and press submit");
    loginPage.setPasswordTextField(password);
    topMenuPage = loginPage.clickNextButton();
  }

  @And("^I add a new Board to the Group$")
  public void iHaveBoardCreated() {
    log.info("Step", "I add a mew Board to the group", "My Dashboard");
    topMenuPage.addNewBoard();
  }

  @And("^I click on Widget button at the top menubar$")
  public void iClickOnWidgetButtonAtTheTopMenubar() {
    log.info("Step", "I click on Widget button", "at the top menu bar");
    widget = topMenuPage.addNewWidget();
  }

  @And("^I click on \"([^\"]*)\" icon inside the Widget options$")
  public void iClickOnIconInsideTheWidgetOptions(String ListTypeIcon) {
    log.info("Step", "I click on ",  ListTypeIcon + "icon inside the Widget options");
    widget.addWidget(ListTypeIcon);
  }

  @And("^I select \"([^\"]*)\" service icon.$")
  public void iSelectServiceIcon(String ERPservice) {
    log.info("Step", "I select ",  ERPservice + "service icon and click on it");
    widget.clickOnService(ERPservice);
  }

  @And("^I select \"([^\"]*)\" of Open ERP$")
  public void iSelectOptionOfOpenERP(String specificService) {
    log.info("Step", "I select ", specificService + "service of Open ERP");
    widget.clickOnSpecificService(specificService);
  }

  @When("^I click on Skills combobox and select Cloud.$")
  public void iChooseOnSkillsCombobox() {
    log.info("Step", "I click on Skills combobox", " and select Cloud");
    widget.clickOnSpecificCombobox();
  }

  @And("^I click the Save button$")
  public void iClickOnSaveButton()  {
    log.info("Step", "I click the save button ", "to confirm search type by list and widget should display a List by Cloud Skills");
    widget.clickSaveButton();
  }


  @Then("^I should see the list of Employees by Skill: \"([^\"]*)\" on E.E. category$")
  public void iShouldSeeTheListOfEmployeesBySkillCloudOnEECategory(String skillName)  throws IOException, InterruptedException {
    int actualResult = widget.verifyQtyEmployeeExperienceBySkillsCloud(skillName) ;
    System.out.println("****************** Result of items found in the List**********");
    System.out.println("The number of Employees found is: " + actualResult+ " by Skill: " + skillName);
    MyDashboard dashboard = new MyDashboard(driver);
    dashboard.deleteBoard();

    //Logout Mach2
    topMenuPage.clickOnLogOut();

    //Login to OPEN ERP web app

    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose4");
    loginERP.setPassword("jose4");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    //Go and Click on Human Resources top menu button

    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go and Click on Human Resources text field
    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();
    searchERP.foundAndClickAdvancedFilterOptions("Skills", "contains", "Cloud");
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
