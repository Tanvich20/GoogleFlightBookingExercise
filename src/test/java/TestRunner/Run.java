package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features", glue = "stepDefinition", dryRun = false, monochrome = true, tags = "", plugin = {
		"pretty", "html:target/cucumber-reports/reports.html"})
public class Run {

}
