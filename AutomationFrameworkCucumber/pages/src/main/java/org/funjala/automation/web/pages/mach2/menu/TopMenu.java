package org.funjala.automation.web.pages.mach2.menu;

import org.funjala.automation.web.model.mach2.menu.TopMenuModel;
import org.funjala.automation.web.model.mach2.menu.AccountModel;
import org.funjala.automation.web.pages.mach2.BoardPage;
import org.funjala.automation.web.pages.mach2.sidebar.SideBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class TopMenu {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(css = AccountModel.userMenu)
  private WebElement userMenu;

  @FindBy(css = AccountModel.logOutButton)
  private WebElement logOutButton;

  @FindBy(css = "a.dash.tablet.computer.only.ui.needsclick.dropdown.item")
  private WebElement menuBoard;

  @FindBy(css = "div.menu.transition.visible > div[data-action='add-board']")
  private WebElement addBoard;

  @FindBy(xpath = "//div/a[@class='brand item']/child::img")
  private WebElement jalaItem;

  @FindBy(css = TopMenuModel.menuIcon)
  private WebElement menuIcon;


  public TopMenu(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public void clickOnLogOut() {
    userMenu.click();
    logOutButton.click();
    driver.get("http://10.31.2.215:3666/");
  }

  public void clickMenuBoard() {
    wait.until(ExpectedConditions.elementToBeClickable(menuBoard));
    menuBoard.click();
  }

  public BoardPage clickAddBoard() {
    clickMenuBoard();
    wait.until(ExpectedConditions.elementToBeClickable(addBoard));
    addBoard.click();
    return new BoardPage(driver);
  }

  public SideBar goToSidebar() {
    menuIcon.click();
    return new SideBar(driver);
  }

  public void clickJalaItem() {
    wait.until(ExpectedConditions.visibilityOf(jalaItem));
    wait.until(ExpectedConditions.elementToBeClickable(jalaItem));
    jalaItem.click();
  }
}