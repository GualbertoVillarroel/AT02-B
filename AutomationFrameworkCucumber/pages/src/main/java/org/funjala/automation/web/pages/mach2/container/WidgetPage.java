package org.funjala.automation.web.pages.mach2.container;

import org.funjala.automation.web.model.mach2.container.WidgetModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DavidVallejos on 1/21/2017.
 */
public class WidgetPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(css = WidgetModel.erpOption)
  private WebElement erpOption;

  @FindBy(css = WidgetModel.managerInput)
  private WebElement managerInput;

  @FindBy(css = WidgetModel.saveButton)
  private WebElement saveButton;

  public WidgetPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  public void addWidget(String type) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-component='widget']")));
    driver.findElement(By.xpath("//div[@class='name' and text()=" + "\'" + type + "\'" + "]")).click();
  }

  public void clickOnService(String service) {
    driver.findElement(By.xpath("//span[text()=" + "\'" + service + "\'" + "]")).click();
  }

  public void selectErpOption() {
    wait.until(ExpectedConditions.elementToBeClickable(erpOption));
    erpOption.click();
  }

  public void setManagerName(String managerName) {
    wait.until(ExpectedConditions.elementToBeClickable(managerInput));
    WebElement manager = driver.findElement(By.cssSelector("#mach-wizard > div > div.wizard-container > div > div > div.ui.form.params-container > div:nth-child(2) > div"));
    manager.click();
    managerInput.sendKeys(managerName);
    managerInput.sendKeys(Keys.ENTER);
  }

  public void clickSaveButton() {
    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    saveButton.click();
  }
}
