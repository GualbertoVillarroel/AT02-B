package org.funjala.automation.web.pages.mach2.sidebar;

import org.funjala.automation.web.model.mach2.SideBarModel;
import org.funjala.automation.web.pages.mach2.content.MyDashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class SideBar {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(linkText = SideBarModel.favoritesButton)
  private WebElement favoritesButton;

  @FindBy(linkText = SideBarModel.sharedWithMeButton)
  private WebElement sharedWithMeButton;

  @FindBy(css = SideBarModel.myDashboardButton)
  private WebElement myDashboardButton;


  public SideBar(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }


  public MyDashboard clickMyDashboardButton() {
    wait.until(ExpectedConditions.elementToBeClickable(myDashboardButton));
    myDashboardButton.click();
    return new MyDashboard(driver);
  }



}
