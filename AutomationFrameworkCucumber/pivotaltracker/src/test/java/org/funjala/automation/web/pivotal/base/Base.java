//
//package org.fundacion.automation.org.funjala.automation.web.pivotal.base;

package org.funjala.automation.web.pivotal.base;

import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.objectReader.ReadObject;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 12/16/2016.
 */
public class Base {
  protected WebDriver driver;
  protected HomePage home;
  protected Log log = Log.getInstance();
  protected Properties configurationObj;

  @BeforeSuite
  public void setSingletonDriver() throws IOException {
    driver = Driver.getDriver().openBrowser();
    ReadObject object = new ReadObject();
    configurationObj = object.getObjectRepository();
  }

  @BeforeClass
  public void beforeClass() throws IOException {
    if (driver == null) {
      driver = Driver.getDriver().openBrowser();
      ReadObject object = new ReadObject();
      configurationObj = object.getObjectRepository();
    }
  }

  @AfterClass
  public void logOutProfile() {
    home.logOut();
  }
}