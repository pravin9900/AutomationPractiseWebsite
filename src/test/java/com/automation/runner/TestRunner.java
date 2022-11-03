package com.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)

@CucumberOptions(features = "Features", glue = { "com.automation.stepDefinations" },
plugin = {"html:target/cucumber-reports1/cucumber-html-reports.html",
		"html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json",
		"junit:target/cucumber-reports/cucumber.xml", },
        monochrome = true,
        tags = "@Shopping")

public class TestRunner {

}
