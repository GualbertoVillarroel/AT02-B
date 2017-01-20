package org.funjala.automation.web.pages.mach2;

import org.funjala.automation.web.model.mach2.HomeModel;
import org.funjala.automation.web.pages.mach2.menu.TopMenu;
import org.funjala.automation.web.pages.mach2.sidebar.SideBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class HomePage {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(css = HomeModel.menuIcon)
  private WebElement menuIcon;

  public HomePage(WebDriver driver) {
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



}
