package org.funjala.automation.web.mach2.steps.widget;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.funjala.automation.web.pages.mach2.dashboard.MyDashboard;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Angelica Rodriguez on 1/21/2017.
 */
public class TableEnInForDivision {
    WebDriver driver;
    TopMenuPage topMenuPage;
    LoginPage loginPage;
    WidgetPage widget;
    MyDashboard dashboard;
    Log log = Log.getInstance();

    @Given("^I am on Mach2 Webpage$")
    public void iAmOnMachWebpage() throws IOException {
        log.info("Step", "I am on Mach2 Webpage", "Go to Mach2 webpage");
        driver = Driver.getDriver().openBrowser(Driver.Mach2);
        loginPage = new LoginPage(driver);
    }

    @And("^I fill username or Mail textfield as \"([^\"]*)\"$")
    public void iFillUsernameOrMailTextfieldAs(String userName) {
        log.info("Step", "I fill username or Mail textfield as " + userName, "Fill a valid user name");
        loginPage.setUsernameTextField(userName);
    }

    @And("^I fill Password textfield as \"([^\"]*)\" and press Submit button$")
    public void iFillPasswordTextfieldAsAndPressSubmitButton(String password) {
        log.info("Step", "I fill Password textfield as " + password + " and press Submit button", "Fill a valid password");
        loginPage.setPasswordTextField(password);
        topMenuPage = loginPage.clickNextButton();
    }

    @Given("^I have board created$")
    public void iHaveABoardCreated() {
        log.info("Step", "I have board created", "Add a new Board");
        topMenuPage.addNewBoard();
    }

    @And("^I click on Widget Button$")
    public void iClickOnWidgetButton() {
        log.info("Step", "I click on Widget Button", "Add a Widget");
        widget = topMenuPage.addNewWidget();
    }

    @When("^I click on \"([^\"]*)\" Button on Widget displayed$")
    public void iClickOnTableButtonOnWidgetDisplayed(String widgetType) {
        log.info("Step", "I click on " + widgetType + " Button on Widget displayed", "Select Table Widget");
        widget.addWidget(widgetType);
    }

    @And("^I click on \"([^\"]*)\" services$")
    public void iClickOnOpenERPService(String service) {
        log.info("Step", "I click on Open ERP ", "Select service ERP");
        widget.clickOnService(service);
    }


    @And("^In the option Most Used I click on the Engineer Information$")
    public void inTheOptionMostUsedIClickOn() {
        log.info("Step", "In the option Most Used I click on the Engineer Information ", "Select Engineer Information");
        widget.selectEngineerInformationOption();
    }


    @And("^In the option Division I click on \"([^\"]*)\"$")
    public void iFillManagerNameOnTextfieldAs(String divisionName) {
        log.info("Step", "In the option Division I click on " + divisionName, "Select Division");
        widget.setDivisionName(divisionName);
    }

    @And("^I click on save Button$")
    public void iClickOnSaveButton() {
        log.info("Step", "I click on save Button", "Click on save Button");
        widget.clickSaveButton();
    }


    @Then("^I have a table widget with \"([^\"]*)\" Division filled$")
    public void iHaveATableWidgetWithFilled(String divisionName) throws IOException, InterruptedException {
        log.info("Step", "I have a table widget with Information filled", "Verification of datas");
        int actualResult = widget.verifyCant(divisionName);
        dashboard = new MyDashboard(driver);
        dashboard.deleteBoard();
        topMenuPage.clickOnLogOut();
        //ERP
        driver = Driver.getDriver().openBrowser(Driver.OpenERP);
        OELoginPage loginERP = new OELoginPage(driver);
        loginERP.setUserName("jose6");
        loginERP.setPassword("jose6");
        OEHomePage homeERP = loginERP.clickBtnSubmit();

        homeERP.clickHumanResources();
        OESearch searchERP = homeERP.oeSearch();

        searchERP.clickSearchArrow();
        searchERP.clickAdvancedSearch();
        searchERP.foundAndClickAdvancedFilterOptions("Division", "is equal to", divisionName);
        searchERP.clickApplySearch();
        searchERP.clickSwitchList();
        searchERP.clickNumberElement();
        searchERP.clickQuantityButton();
        searchERP.clickUnlimitedOption();
        List<WebElement> listManager = searchERP.listOfAllElements();
        assertEquals(listManager.size(), actualResult);
        homeERP.clickUserAccount();
        homeERP.clickLogOut();
    }

}
