package org.funjala.automation.web.mach2.steps.search_erp;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.model.erp.search.ModelSearch;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 1/25/2017.
 */
public class search {
  WebDriver driver;
  OELoginPage login;
  OEHomePage homePage;
  OESearch oeSearch;
  List<ModelSearch> listModelSearch = new ArrayList<>();
  ModelSearch modelSearch;

  @Given("^I am on OpenERP$")
  public void iAmOnOpenERP() throws Throwable {
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    login = new OELoginPage(driver);
  }

  @When("^I logout$")
  public void iLogout() throws Throwable {
    login.setUserName("jose7");
    login.setPassword("jose7");
    homePage = login.clickBtnSubmit();
  }

  @And("^I search by something$")
  public void iSearchBySomething() throws Throwable {
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


    for (WebElement index : result) {
      modelSearch = new ModelSearch();
      modelSearch.setInternalId(index.findElement(By.xpath(".//td[@data-field='internal_number']")).getText());
      modelSearch.setName(index.findElement(By.xpath(".//td[@data-field='name']")).getText());
      modelSearch.setDepartment(index.findElement(By.xpath(".//td[@data-field='department_id']")).getText());
      modelSearch.setJobTitle(index.findElement(By.xpath(".//td[@data-field='job_id']")).getText());
      modelSearch.setLocation(index.findElement(By.xpath(".//td[@data-field='location_id']")).getText());
      modelSearch.setLead(index.findElement(By.xpath(".//td[@data-field='lead_id']")).getText());
      modelSearch.setManager(index.findElement(By.xpath(".//td[@data-field='parent_id']")).getText());
      listModelSearch.add(modelSearch);

    }
  }

  @Then("^I expect the list$")
  public void iExpectTheList() throws Throwable {
    System.out.println("ok");
  }
}
