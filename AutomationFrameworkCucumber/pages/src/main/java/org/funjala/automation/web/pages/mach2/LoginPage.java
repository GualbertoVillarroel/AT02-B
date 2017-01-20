package org.funjala.automation.web.pages.mach2;

import org.funjala.automation.web.model.mach2.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class LoginPage {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(name = LoginModel.userName)
  private WebElement usernameTextField;

  @FindBy(name = LoginModel.password)
  private WebElement passwordTextField;

  @FindBy(css = LoginModel.nextSigningButton)
  private WebElement nextSigningButton;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public void setUsernameTextField(final String username) {
    usernameTextField.clear();
    usernameTextField.sendKeys(username);
  }

  public void setPasswordTextField(final String password) {
    passwordTextField.clear();
    passwordTextField.sendKeys(password);
  }

  public HomePage clickNextButton() {
    nextSigningButton.click();
    return new HomePage(driver);
  }

  private HomePage loginAs(String userName, String password) {
    setUsernameTextField(userName);
    setPasswordTextField(password);
    return clickNextButton();
  }

}
