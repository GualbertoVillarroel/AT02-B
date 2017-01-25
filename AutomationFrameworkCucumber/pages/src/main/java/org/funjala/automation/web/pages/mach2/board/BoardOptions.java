package org.funjala.automation.web.pages.mach2.board;

import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 1/24/2017.
 */
public class BoardOptions {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = "//button[@data-action='save-wizard-config']")
  private WebElement shareBoard;

  @FindBy(css = "a[data-action=\"delete-board\"]")
  private WebElement deleteBoard;

  @FindBy(css = "div.ui.positive.button")
  private WebElement acceptDeleteButton;

  public BoardOptions(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public final void deleteBoardMach() {
    wait.until(ExpectedConditions.elementToBeClickable(deleteBoard));
    deleteBoard.click();
    wait.until(ExpectedConditions.elementToBeClickable(acceptDeleteButton));
    acceptDeleteButton.click();
  }

}