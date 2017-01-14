package org.funjala.automation.web.pivotal.steps.task;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src\\resource\\features\\task\\task.feature",
        format = {"json:target/pivotal.json","html:target/pivotal/pivotal-cucumber"})
public class TaskFeatureRunner extends AbstractTestNGCucumberTests{

}
