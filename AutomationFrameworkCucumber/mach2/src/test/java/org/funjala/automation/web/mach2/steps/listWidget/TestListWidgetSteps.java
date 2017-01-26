package org.funjala.automation.web.mach2.steps.listWidget;

import cucumber.api.PendingException;
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
 * Created by Administrator on 1/25/2017.
 */
public class TestListWidgetSteps {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  WidgetPage widget;


  @Given("^I am at Mach2 webpage$")
  public void iAmOnMachWebpage() throws IOException {
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    loginPage = new LoginPage(driver);
  }

  @And("^I set username or mail textfield as \"([^\"]*)\"$")
  public void iFillUsernameOrMailTextfieldAs(String userName) {
    loginPage.setUsernameTextField(userName);
  }

  @And("^I set password textfield as \"([^\"]*)\" and press Submit button$")
  public void iFillPasswordTextfieldAsAndPressSubmitButton(String password) {
    loginPage.setPasswordTextField(password);
    topMenuPage = loginPage.clickNextButton();
  }

  @And("^I add a new Board to the Group$")
  public void iHaveBoardCreated() {
    topMenuPage.addNewBoard();
  }

  @And("^I click on Widget button at the top menubar$")
  public void iClickOnWidgetButtonAtTheTopMenubar() {
    widget = topMenuPage.addNewWidget();
  }

  @And("^I click on \"([^\"]*)\" icon inside the Widget options$")
  public void iClickOnIconInsideTheWidgetOptions(String ListTypeIcon) {
    widget.addWidget(ListTypeIcon);
  }

  @And("^I select \"([^\"]*)\" service icon.$")
  public void iSelectServiceIcon(String ERPservice) {
    widget.clickOnService(ERPservice);
  }

  @And("^I select \"([^\"]*)\" of Open ERP$")
  public void iSelectOptionOfOpenERP(String specificService) {
    widget.clickOnSpecificService(specificService);
  }

  @When("^I click on Skills combobox and select Cloud.$")
  public void iChooseOnSkillsCombobox() {
    widget.clickOnSpecificCombobox();
  }

  @And("^I click the Save button$")
  public void iClickOnSaveButton()  {
    widget.clickSaveButton();
  }


  @Then("^I should see the list of Employees by Skill: \"([^\"]*)\" on E.E. category$")
  public void iShouldSeeTheListOfEmployeesBySkillCloudOnEECategory(String skillName)  throws IOException, InterruptedException {
    int actualResult = widget.verifyQtyEmployeeExperienceBySkillsCloud(skillName) ;
    System.out.println(">>>>>>>>>>>>>>>>>>>");
    System.out.println(actualResult);
    System.out.println(">>>>>>>>>>>>>>>>>>>");
    SideBarPage sideBarPage = topMenuPage.goToSidebar();
    sideBarPage.deleteAllBoards();

    //Login OPEN ERP

    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose4");
    loginERP.setPassword("jose4");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    //Go to Human Resources

    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go to Search
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

  }

}
