package org.funjala.automation.web.pages.mach2.menu;

import org.funjala.automation.web.model.mach2.menu.TopMenuModel;
import org.funjala.automation.web.pages.mach2.container.WidgetPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenu;
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
public class TopMenuPage {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(css = TopMenuModel.menuIcon)
  private WebElement menuIcon;

  @FindBy(xpath = TopMenuModel.addBoard)
  private WebElement addBoard;

  @FindBy(css = TopMenuModel.addWidget)
  private WebElement addWidget;

  @FindBy(css = TopMenuModel.newBoard)
  private WebElement newBoard;

  public TopMenuPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public TopMenu goToTopMenu() {
    return new TopMenu(driver);
  }

  public SideBar goToSidebar() {
    menuIcon.click();
    return new SideBar(driver);
  }

  public WidgetPage addNewWidget() {
    wait.until(ExpectedConditions.elementToBeClickable(addWidget));
    addWidget.click();
    return new WidgetPage(driver);
  }

  public void addNewBoard() {
    newBoard.click();
    wait.until(ExpectedConditions.elementToBeClickable(addBoard));
    addBoard.click();
  }
}