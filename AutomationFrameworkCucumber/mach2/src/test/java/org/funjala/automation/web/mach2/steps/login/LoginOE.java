package org.funjala.automation.web.mach2.steps.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 1/19/2017.
 */
public class LoginOE {
  WebDriver driver;
  OELoginPage login;
  OEHomePage homePage;

  OESearch oeSearch;


  @Given("^I navigate to ([^\"]*) web page$")
  public void iNavigateToOpenERPWebPage(String page) throws Throwable {
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    login = new OELoginPage(driver);
  }

  @When("^I put the next data$")
  public void iPutTheNextData(Map<String, String> table) {
    login.setUserName(table.get("username"));
    login.setPassword(table.get("password"));
  }

  @And("^I press the button submit$")
  public void iPressTheButtonSubmit() {
    homePage = login.clickBtnSubmit();
  }

  @Then("^I expect redirect to the main page$")
  public void iExpectRedirectToTheMainPage() throws Throwable {
    assertTrue(homePage.compare("Jose7"));
    //search
    homePage.clickHumanResources();
    oeSearch = homePage.oeSearch();
    oeSearch.clickSearchArrow();
    oeSearch.clickAdvancedSearch();
    oeSearch.foundAndClickAdvancedFilterOptions("billable", "is false");
    oeSearch.clickApplySearch();
    oeSearch.clickSwitchList();
    oeSearch.clickNumberElement();
    oeSearch.clickQuantityButton();
    oeSearch.clickUnlimitedOption();

    List<WebElement> result = oeSearch.listOfAllElements();
    System.out.println(result.size());
    for (WebElement index: result) {
      System.out.println(index.getText());
    }



//    homePage.clickUserAccount();
//    homePage.clickLogOut();
  }
}
