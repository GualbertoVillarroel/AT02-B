package org.funjala.automation.web.pivotal.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


/**
 * Created by Angelica Rodriguez on 1/13/2017.
 */
public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("The Scenarie started: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
           System.out.println("The Scenarie finished: "+ scenario.getName() +", Status is :"+scenario.getStatus());
    }
}
