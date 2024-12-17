package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverManager.WebdriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObject;
import utilities.ConfigFileReader;

public class HomePageSteps {
	
	WebDriver driver;
	HomePageObject homepageobject;
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		
		ConfigFileReader.getBrowserType();
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	    
		
	}
	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
	   

		//driver = WebdriverManager.getDriver();		
		homepageobject = new HomePageObject();
	
		Assert.assertTrue(homepageobject.getPageURL().contains("/login"));
	}

 

}
