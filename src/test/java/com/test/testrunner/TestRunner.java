package com.test.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/test/feature/PlaceDemo.feature",
                  glue= {"com/test/stepdefinition"},monochrome = true,
                  plugin = "json:target/jsonReports/cucumber-report.json",
                  tags = "@GetPlace")
public class TestRunner {
}
