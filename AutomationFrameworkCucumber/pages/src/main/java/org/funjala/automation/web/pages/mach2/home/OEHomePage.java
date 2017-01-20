package org.funjala.automation.web.pages.mach2.home;

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

  @FindBy(xpath = "//tr[1]/td/span/span")
  WebElement userAccount;

  public boolean compare(String user) {
    wait.until(ExpectedConditions.visibilityOf(userAccount));
    return userAccount.getText().equalsIgnoreCase(user);
  }
}
