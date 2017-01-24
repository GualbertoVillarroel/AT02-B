package org.funjala.automation.web.mach2.steps.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.pages.mach2.HomePage;
import org.funjala.automation.web.pages.mach2.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class LoginStepsDefinitions {
  WebDriver driver;
  HomePage homePage;
  LoginPage loginPage;
  WebDriverWait wait;

  @Given("^I am on Mach 2 page$")
  public void onPivotalTrackerPage() throws IOException {
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    wait = new WebDriverWait(driver,10);
    loginPage = new LoginPage(driver);
  }

  @And("^I put a ([^\"]*) in user textfield$")
  public void putNameAndPressNextButton(String userName) {
    loginPage.setUsernameTextField(userName);
  }

  @And("^I put a ([^\"]*) in password textfield and press Submit button$")
  public void putPasswordAndPressSubmitButton(String password) {
    loginPage.setPasswordTextField(password);
    homePage = loginPage.clickNextButton();
    TopMenu topMenu = homePage.goToTopMenu();
    topMenu.clickOnLogOut();
  }
}
