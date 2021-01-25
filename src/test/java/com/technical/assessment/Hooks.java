package com.technical.assessment;

import com.technical.assessment.drivers.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    private DriverManager driverManager;
    private String url = System.getProperty("url") == null ? "https://cartaxcheck.co.uk" : System.getProperty("url");

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }


    @Before
    public void setUp() {
        driverManager.openBrowser();
        driverManager.maxBrowser();
        driverManager.navigateTo(url);
        driverManager.applyImplicit();
        driverManager.acceptCookies();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            driverManager.takeScreenShot(scenario);
        }
        driverManager.closeBrowser();
    }

}
