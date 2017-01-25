package org.funjala.automation.web.model.erp.search;

/**
 * Created by Administrator on 1/24/2017.
 */
public class SearchModel {
  public static final String searchArrow = "//div[@class='oe_searchview_unfold_drawer']";
  public static final String advancedSearch = "//h4[contains(.,\"Advanced Search\")]";
  public static final String advancedFilterType = "//select[@class='searchview_extended_prop_field']";
  public static final String advancedFilterOptions = "//select[@class=\"searchview_extended_prop_field\"]/option";
  public static final String advancedConditions = "//select[@class='searchview_extended_prop_op']/option";
  public static final String valueOfSearch = "//span[@class='searchview_extended_prop_value']/input";
  public static final String applyButton = "//button[contains(.,'Apply')]";
  public static final String showMoreButton = "//div[@class='oe_kanban_show_more']/button[contains(.,'Show more')]";
  public static final String searchResult= "//div[@class='oe_fold_column oe_kanban_record']";
  public static final String switchListButton = "//a[@data-view-type='list']";
  public static final String searchList = "//div[2]/div/table/tbody/tr";
  public static final String quantityButton = "//span[@class='oe_list_pager_state']";
  public static final String unlimitedOption = "//option[contains(.,'Unlimited')]";
  public static final String numbersElement = "/html/body/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr[2]/td[2]/div/div/div/span";
}
