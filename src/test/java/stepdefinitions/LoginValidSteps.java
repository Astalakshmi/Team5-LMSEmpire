package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigFileReader;
import pageObjects.*;
public class LoginValidSteps {

	       LoginValidPage loginvalidpage;
		    @When("Admin enter valid credentials and clicks login button")
		    public void admin_enter_valid_credentials_and_clicks_login_button() {
		    	loginvalidpage= new LoginValidPage();
		 		ConfigFileReader ConfReader =  new ConfigFileReader();	
		 		loginvalidpage.LoginValid(ConfReader.getUser(), ConfReader.getPassword());
		    	
		   }

		    @Then("Admin should land on dashboard page")
		    public void admin_should_land_on_dashboard_page() {
		    	
		    	String Heading= loginvalidpage.GetText();
		       	System.out.println(Heading);
		    	
		    }

}
