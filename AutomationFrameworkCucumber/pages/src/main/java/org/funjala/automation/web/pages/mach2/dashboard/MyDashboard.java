package org.funjala.automation.web.pages.mach2.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class MyDashboard {
  private WebDriver driver;
  private WebDriverWait wait;

  public MyDashboard(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }
}
