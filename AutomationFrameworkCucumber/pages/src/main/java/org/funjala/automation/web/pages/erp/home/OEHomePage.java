package org.funjala.automation.web.pages.erp.home;

import org.funjala.automation.web.model.erp.home.HomeModel;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 1/20/2017.
 */
public class OEHomePage {
  private WebDriver driver;
  private WebDriverWait wait;

  public OEHomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(xpath = HomeModel.userAccount)
  WebElement userAccount;

  @FindBy(xpath = HomeModel.logOut)
  WebElement logOut;

  @FindBy(xpath = HomeModel.humanResources)
  WebElement humanResourcesButton;


  public boolean compare(String user) {
    wait.until(ExpectedConditions.visibilityOf(userAccount));
    return userAccount.getText().equalsIgnoreCase(user);
  }

  public void clickUserAccount() {
    userAccount.click();
  }

  public void clickLogOut() {
    logOut.click();
  }

  public void clickHumanResources() {
    humanResourcesButton.click();
  }

  public OESearch oeSearch(){
    return new OESearch(driver);
  }

}
