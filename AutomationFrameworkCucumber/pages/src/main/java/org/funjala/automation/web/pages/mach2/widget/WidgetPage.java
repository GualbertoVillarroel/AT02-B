package org.funjala.automation.web.pages.mach2.widget;

import org.funjala.automation.web.model.mach2.widget.WidgetModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by DavidVallejos on 1/21/2017.
 */
public class WidgetPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = WidgetModel.dropdownIcon)
  private WebElement dropdownIcon;

  @FindBy(css = WidgetModel.erpOption)
  private WebElement erpOption;

  @FindBy(xpath = WidgetModel.eiOption)
  private WebElement eiOption;

  @FindBy(xpath = WidgetModel.managerInput)
  private List<WebElement> managerInput;

  @FindBy(css = WidgetModel.saveButton)
  private WebElement saveButton;

  @FindBy(xpath = WidgetModel.listElementTable)
  private List<WebElement> listElementTable;

  @FindBy(xpath = WidgetModel.menuDivisionsButton)
  WebElement menuDivisionsButton;

  @FindBy(xpath = WidgetModel.selectorDivisions)
  WebElement selectorDivisions;

  @FindBy(xpath = WidgetModel.accountItem)
  WebElement accountItem;

  public WidgetPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  public void addWidget(String type) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-component='widget']")));
    driver.findElement(By.xpath("//div[@class='name' and text()=" + "\'" + type + "\'" + "]")).click();
  }

  public void setDivisionName(String divisionName) {
    wait.until(ExpectedConditions.elementToBeClickable(menuDivisionsButton));
    menuDivisionsButton.click();
    selectorDivisions.findElement(By.xpath("//div[text()= '" + divisionName + "']"));
    accountItem = selectorDivisions.findElement(By.xpath("//div[text()= '" + divisionName + "']"));
    accountItem.click();
    menuDivisionsButton.click();
  }

  public void clickOnService(String service) {
    driver.findElement(By.xpath("//span[text()=" + "\'" + service + "\'" + "]")).click();
  }

  public void selectEiOption() {
    wait.until(ExpectedConditions.visibilityOf(eiOption));
    wait.until(ExpectedConditions.elementToBeClickable(eiOption));
    eiOption.click();
  }

  public void selectErpOption() {
    wait.until(ExpectedConditions.elementToBeClickable(erpOption));
    erpOption.click();
  }

  public void setManagerName(String managerName) {
    wait.until(ExpectedConditions.visibilityOf(dropdownIcon));
    wait.until(ExpectedConditions.elementToBeClickable(dropdownIcon));
    dropdownIcon.click();

//    System.out.println(">>>>>>>>>>>>>>>>>>>");
//    System.out.println(managerInput.size());
//    System.out.println(">>>>>>>>>>>>>>>>>>>");

    for (WebElement element : managerInput) {
      if (element.getText().equals(managerName)) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
      }
    }
    dropdownIcon.click();
  }

  public int verifyCant(String managerName) {
    int cant = 0;
    for (WebElement element : listElementTable) {
      if (element.getText().equals(managerName)) {
        cant++;
      }
    }
    return cant;
  }

  public void clickSaveButton() {
    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    saveButton.click();
  }
}
