package stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverManager.WebdriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginValidPage;
import utilities.ConfigFileReader;
import utilities.LoggerLoad;
public class LoginValidSteps {

	WebDriver driver = WebdriverManager.getDriver();
	ConfigFileReader configFileReader = WebdriverManager.configReader();
	       LoginValidPage loginvalidpage;
		    @When("Admin enter valid credentials and clicks login button")
		    public void admin_enter_valid_credentials_and_clicks_login_button() {
		    	loginvalidpage= new LoginValidPage();
		 		ConfigFileReader ConfReader =  new ConfigFileReader();	
		 		loginvalidpage.LoginValid(ConfReader.getUser(), ConfReader.getPassword());
		    	
		   }

		    @Then("Admin should land on dashboard page")

		      
		    	String Heading = loginvalidpage.GetText();
		       	System.out.println("I am in dashboard page"+Heading);

		    }
	}
