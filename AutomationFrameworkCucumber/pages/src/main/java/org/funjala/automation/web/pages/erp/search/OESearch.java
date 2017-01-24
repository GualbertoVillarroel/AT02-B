package org.funjala.automation.web.pages.erp.search;

import org.funjala.automation.web.model.erp.search.SearchModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Administrator on 1/24/2017.
 */
public class OESearch {
  private WebDriver driver;
  private WebDriverWait wait;

  public OESearch(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
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

  public void clickSearchArrow(){
    searchArrow.click();
  }

  public void clickAdvancedSearch(){
    advancedSearchButton.click();
  }

  public void clickAdvancedFilterType(){
    advancedFilterType.click();
  }

  public void foundAndClickAdvancedFilterOptions(String parameter){
    for (WebElement option:advancedFilterOptions){
      if(option.getText().equalsIgnoreCase(parameter)){
        option.click();
      }
    }


  }
}
