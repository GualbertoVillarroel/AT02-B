package org.funjala.automation.web.mach2.steps.board;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.pages.mach2.board.BoardPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.board.BoardOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static org.testng.Assert.assertTrue;


public class DeleteBoard {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  BoardPage boardPage;
  BoardOptions boardOptions;
  WebDriverWait wait;

  @Given("^I am on Mach2 web page$")
  public void iAmOnMach2WebPage() throws IOException {
    driver = Driver.getDriver().openBrowser(Driver.Mach2);
    wait = new WebDriverWait(driver, 10);
    loginPage = new LoginPage(driver);
  }

  @And("^I put (.*) as username$")
  public void iPutXAsUsername(String userName) {
    loginPage.setUsernameTextField(userName);
  }

  @And("^I put (.*) as password and press LogIn button$")
  public void iPutXAsPasswordAndPressLogInButton(String password) {
    loginPage.setPasswordTextField(password);
    topMenuPage = loginPage.clickNextButton();
  }

  @When("^I go to My Dashboard$")
  public void iGoToMyDashboard() {
    topMenuPage.clickJalaItem();
  }

  @And("^I add a New Board$")
  public void iAddANewBoard() {
    boardPage = topMenuPage.clickAddBoard();
  }

  @And("^I click on the Config icon$")
  public void iClickOnTheConfigIcon() {
    boardOptions = boardPage.clickBoardConfig();
  }

  @And("^I select the Delete option$")
  public void iSelectTheDeleteOption() {
    boardOptions.deleteBoardMach();
  }

  @Then("^The New Board should be deleted$")
  public void theNewBoardShouldBeDeleted() {
    assertTrue(driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[2]/div[not(a)]")).isDisplayed());
  }
}