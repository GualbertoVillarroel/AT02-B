package org.funjala.automation.web.pages.mach2.widget;

import org.funjala.automation.web.model.mach2.widget.WidgetModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.StringJoiner;

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


//Corregir esto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-----------------------------------------------------
  @FindBy(xpath = ".//a/b[text()='ADVANCED CONFIGURATION']")
  private WebElement advanceConfiguration;

  @FindBy(xpath = ".//*[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[4]/div[2]/div/div[1]/div")
  private WebElement comboboxDepartment;
//*[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[4]/div[2]/div/div[1]/div/div[2]
  @FindBy(xpath = "//*[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[4]/div[2]/div/div[1]/div/div[2]")
  private List<WebElement> listOfDepartments;

  @FindBy(xpath = "//body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/table")
  private WebElement table;

  public int numberOfItems(){

    return table.findElements(By.cssSelector("tr")).size()-1;
  }

  private static final String departamentItem = "//div[contains(text(),'%s')]";
  //1
  public void clickOnAdvanceConfiguration(){
    wait.until(ExpectedConditions.visibilityOf(advanceConfiguration));
    advanceConfiguration.click();
  }
  //2
  public void clickOnComboboxDepartment(){
    comboboxDepartment.click();
  }
  //3
  public void setDepartmentName(String departmentName){
    wait.until(ExpectedConditions.visibilityOf(comboboxDepartment));
    wait.until(ExpectedConditions.elementToBeClickable(comboboxDepartment));

    comboboxDepartment.click();
    driver.findElement(By.xpath(String.format(departamentItem,departmentName))).click();
  }


  //hasta aqui!!!!!!!!!!!---------------------------------------------------------------------------------

  @FindBy(xpath = WidgetModel.menuDivisionsButton)
  WebElement menuDivisionsButton;

  @FindBy(xpath = WidgetModel.selectorDivisions)
  WebElement selectorDivisions;

  @FindBy(xpath = WidgetModel.accountItem)
  WebElement accountItem;

  @FindBy(xpath = WidgetModel.ListElementListWidget)
  private List<WebElement>  listElementListWidget;
  
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

  public void clickOnSpecificService(String specificService){
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mach-wizard\"]//*[@class=\"wizard-provider-panel\"]")));
    driver.findElement(By.xpath("//h4[@class='ui header' and text()=" + "\'" + specificService + "\'" + "]")).click();
  }

  public void clickOnSpecificCombobox() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mach-wizard\"]/div/div[3]/div/div/div[2]/div[4]/div")));
    driver.findElement(By.xpath("//*[@id=\"mach-wizard\"]/div/div[3]/div/div/div[2]/div[4]/div")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='field' and @data-key='Areas']//div[@class='item' and @data-value='33']")));
    driver.findElement(By.xpath("//div[@class='field' and @data-key='Areas']//div[@class='item' and @data-value='33']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wizard']/div")));
    driver.findElement(By.xpath("//*[@id='wizard']/div")).click();
  }



  public int verifyQtyEmployeeExperienceBySkillsCloud(String skillName) {
    int cant = 0;
    for (WebElement element : listElementListWidget ) {
      if (element.getText().toUpperCase().contains(skillName.toUpperCase())) {
        cant++;
      }
    }
    return cant;
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
