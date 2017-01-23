package org.funjala.automation.web.mach2.steps.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.funjala.automation.web.pages.mach2.HomePage;
import org.funjala.automation.web.pages.mach2.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class LoginStepsDefinitions {
  WebDriver driver;
  HomePage homePage;
  LoginPage loginPage;

  @Given("^I am on Mach 2 page$")
  public void onPivotalTrackerPage() throws IOException {
    System.setProperty("webdriver.chrome.driver", "../tools/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    loginPage = new LoginPage(driver);
    driver.get("http://10.31.2.215:3666/");
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
    driver.quit();
  }
}
