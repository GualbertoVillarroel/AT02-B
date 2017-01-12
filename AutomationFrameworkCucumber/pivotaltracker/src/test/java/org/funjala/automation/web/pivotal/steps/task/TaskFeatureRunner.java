package org.funjala.automation.web.pivotal.steps.task;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src\\resource\\features\\task\\createTask.feature",
        format = {"pretty", "html:reports/cucumber"})
public class TaskFeatureRunner extends AbstractTestNGCucumberTests{

}
