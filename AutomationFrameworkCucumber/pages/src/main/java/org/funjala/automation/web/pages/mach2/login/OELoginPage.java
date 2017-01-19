package org.funjala.automation.web.pages.mach2.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OELoginPage {
  private WebDriver driver;
  private WebDriverWait wait;

  public OELoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(id = "username")
  WebElement userName;

  @FindBy(id = "password")
  WebElement password;

  @FindBy(xpath = "//*[@id='fm1']/section[3]/input[4]")
  WebElement btnSubmit;

  public void setUserName(String user) {
    userName.sendKeys(user);
  }

  public void setPassword(String pass) {
    password.sendKeys(pass);
  }

  public void clickBtnSubmit() {
    btnSubmit.click();
  }
}
