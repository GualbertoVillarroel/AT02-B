package org.funjala.automation.web.pages.erp.search;

import org.funjala.automation.web.model.erp.search.SearchModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 1/24/2017.
 */
public class OESearch {
  private WebDriver driver;
  private WebDriverWait wait;

  public OESearch(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(xpath = SearchModel.searchArrow)
  WebElement searchArrow;

  @FindBy(xpath = SearchModel.advancedSearch)
  WebElement advancedSearchButton;

  @FindBy(xpath = SearchModel.advancedFilterType)
  WebElement advancedFilterType;

  @FindBy(xpath = SearchModel.advancedFilterOptions)
  List<WebElement> advancedFilterOptions;

  @FindBy(xpath = SearchModel.advancedConditions)
  List<WebElement> advancedConditions;

  @FindBy(xpath = SearchModel.valueOfSearch)
  WebElement valueOfSearch;

  @FindBy(xpath = SearchModel.applyButton)
  WebElement applyButton;

  @FindBy(xpath = SearchModel.showMoreButton)
  WebElement showMoreButton;

  @FindBy(xpath = SearchModel.switchListButton)
  WebElement switchListButton;

  @FindBy(xpath = SearchModel.searchList)
  List<WebElement> searchList;

  @FindBy(xpath = SearchModel.quantityButton)
  WebElement quantityButton;

  @FindBy(xpath = SearchModel.unlimitedOption)
  WebElement unlimitedOption;

  @FindBy(xpath = SearchModel.numbersElement)
  WebElement numberElement;


  public void clickSearchArrow() {
    searchArrow.click();
  }

  public void clickAdvancedSearch() {
    advancedSearchButton.click();
  }

  public void clickAdvancedFilterType() {
    advancedFilterType.click();
  }

  public void foundAndClickAdvancedFilterOptions(String filterType, String condition) {
    for (WebElement type : advancedFilterOptions) {

      if (type.getText().trim().equalsIgnoreCase(filterType.trim()))
        type.click();
    }

    for (WebElement option : advancedConditions) {
      if (option.getText().trim().equalsIgnoreCase(condition.trim()))
        option.click();
    }
  }

  public void foundAndClickAdvancedFilterOptions(String filterType, String condition, String value) {
    for (WebElement type : advancedFilterOptions) {

      if (type.getText().trim().equalsIgnoreCase(filterType.trim()))
        type.click();
    }

    for (WebElement option : advancedConditions) {
      if (option.getText().trim().equalsIgnoreCase(condition.trim()))
        option.click();
    }

    valueOfSearch.sendKeys(value);
  }

  public void clickApplySearch() {
    applyButton.click();
  }

  public void clickShowMoreButton() {
    showMoreButton.click();
  }

  public void clickShowMoreButtonUntilItDoesNotExist() {
    while (showMoreButton.isEnabled() && showMoreButton.isDisplayed()) {
      wait.until(ExpectedConditions.visibilityOf(showMoreButton));
      wait.until(ExpectedConditions.elementToBeClickable(showMoreButton));
      showMoreButton.click();
    }
  }

  public List<WebElement> searchResult() {

    List<WebElement> searchResult = driver.findElements(By.xpath(SearchModel.searchResult));
    wait.until(ExpectedConditions.visibilityOf(searchResult.get(searchResult.size() - 1)));
    return searchResult;
  }

  public void clickSwitchList() {
    switchListButton.click();
  }

  public void clickNumberElement() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    numberElement.click();
  }

  public void clickQuantityButton() {
    quantityButton.click();
  }

  public void clickUnlimitedOption() {
    unlimitedOption.click();
  }

  public List<WebElement> listOfAllElements() throws InterruptedException {

    Thread.sleep(500);
    List<WebElement> result = searchList;
    return result;
  }

}
