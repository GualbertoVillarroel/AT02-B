package org.funjala.automation.web.mach2.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.pages.mach2.login.OELoginPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Created by Administrator on 1/19/2017.
 */
public class LoginOE {
  WebDriver driver;
  OELoginPage login;

  @Given("^I navigate to OpenERP web page$")
  public void iNavigateToOpenERPWebPage() throws Throwable {
    driver= Driver.getDriver().openBrowser();
    login=new OELoginPage(driver);
  }

  @When("^I put the next data$")
  public void iPutTheNextData(Map<String,String> table) {
    login.setUserName(table.get("username"));
    login.setPassword(table.get("password"));
  }

  @And("^I press the button submit$")
  public void iPressTheButtonSubmit() {
    login.clickBtnSubmit();
  }

  @Then("^I expect redirect to the main page$")
  public void iExpectRedirectToTheMainPage() throws Throwable {
    System.out.println("--------------------------------works----"+driver.getTitle());
  }
}
