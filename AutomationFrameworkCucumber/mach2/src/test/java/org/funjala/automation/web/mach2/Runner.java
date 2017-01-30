package org.funjala.automation.web.mach2;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Angelica Rodriguez on 1/19/2017.
 */

@CucumberOptions(tags = {"~@tableEe"},
        features = "src/test/resources/features/",
        format = {"json:target/mach2.json", "html:target/mach2/mach2-cucumber"})
public class Runner extends AbstractTestNGCucumberTests {}