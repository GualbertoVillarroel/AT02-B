package org.funjala.automation.web.pages.mach2;

import org.funjala.automation.web.pages.mach2.content.BoardOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 1/24/2017.
 */
public class BoardPage {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = "//div[@class='icons-container']/child::div[3]/img")
  private WebElement boardConfig;

  public BoardPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public BoardOptions clickBoardConfig() {
    wait.until(ExpectedConditions.elementToBeClickable(boardConfig));
    boardConfig.click();
    return new BoardOptions(driver);
  }
}
