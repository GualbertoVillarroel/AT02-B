package org.funjala.automation.web.pivotal.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;


/**
 * Created by Angelica Rodriguez on 1/13/2017.
 */
public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("The Scenarie started:" + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            System.err.println("errorrrrrrrrr");
        }
        System.out.println("The Scenarie finished: "+ scenario.getName() +"and status is :"+scenario.getStatus());

    }
}
