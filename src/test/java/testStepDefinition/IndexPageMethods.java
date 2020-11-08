package testStepDefinition;

import java.net.UnknownHostException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.IndexPageElements;
import pageObjects.PageBase;

public class IndexPageMethods extends PageBase {
	
	IndexPageElements indexPageElements;
	
	@Given("^I navigated to Automation Practice using (.*) and (.*)$")
	public void navigateAutomationPractice(String browser, String url) {
		try {
			initialize(browser, url);
			indexPageElements = new IndexPageElements();
			System.out.println("Successful Launch");
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
	}
	
	@Then("^User click signin button$")
	public void signIN() {
		indexPageElements.clickSignIn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^User ends the test scenarios$")
	public void endScenario() {
		driver.quit();
	}
}
