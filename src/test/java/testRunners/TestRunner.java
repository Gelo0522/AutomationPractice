package testRunners;

import utilities.FilePaths;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features={
				FilePaths.FeaturePath + "LoadAutomationPractice.feature",
		},
		glue = {"testStepDefinition"},
		dryRun = false
		)
public class TestRunner {
	
}

