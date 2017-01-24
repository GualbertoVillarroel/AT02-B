package org.funjala.automation.web.pages.erp.search;

import org.funjala.automation.web.model.erp.search.SearchModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Administrator on 1/24/2017.
 */
public class OESearch {
  @FindBy(xpath = SearchModel.searchArrow)
  WebElement searchArrow;

  @FindBy(xpath = SearchModel.advancedSearch)
  WebElement advancedSearchButton;

  @FindBy(xpath = SearchModel.advancedFilterType)
  WebElement advancedFilterType;

  @FindBy(xpath = SearchModel.advancedFilterOptions)
  List<WebElement> advancedFilterOptions;
}
