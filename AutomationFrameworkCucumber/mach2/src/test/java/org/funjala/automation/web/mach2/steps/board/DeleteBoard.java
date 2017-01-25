package org.funjala.automation.web.mach2.steps.board;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.pages.mach2.BoardPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.container.BoardOptions;
import org.funjala.automation.web.pages.mach2.menu.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class DeleteBoard {
  WebDriver driver;
  TopMenuPage topMenuPage;
  LoginPage loginPage;
  TopMenu topMenu;
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
    topMenu = topMenuPage.goToTopMenu();
    topMenu.clickJalaItem();
  }

  @And("^I add a new Board$")
  public void iAddANewBoard() {
    boardPage = topMenu.clickAddBoard();
  }

  @And("^I click on the Config icon$")
  public void iClickOnTheConfigIcon() {
    boardOptions = boardPage.clickBoardConfig();
  }

  @And("^I select the Delete option$")
  public void iSelectTheDeleteOption() {
    boardOptions.deleteBoardMach();
  }
//
//  @Then("^A new board should be displayed$")
//  public void aNewWidgetShouldBeDisplayed() {
//
//  }
}
