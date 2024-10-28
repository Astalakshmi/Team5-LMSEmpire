package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LogoutSteps {
	
	LoginPage loginPage;
	
	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
		loginPage = new LoginPage();
		loginPage.enterURL(loginPage.validPortal);
		loginPage.LoginWithValidCredentials();
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		loginPage.clickLogout();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		Assert.assertTrue(loginPage.isOnLoginPage());
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		loginPage = new LoginPage();
		loginPage.enterURL(loginPage.validPortal);
	}

	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
		loginPage.clickBackButton();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		Assert.assertFalse(loginPage.isOnLoginPage());
	}

}
