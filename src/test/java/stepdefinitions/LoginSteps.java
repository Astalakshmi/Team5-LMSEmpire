package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginSteps {

//   LoginPage loginPage;
   LoginPage  loginPage = new LoginPage();
//    @Given("Admin launch the browser")
//    public void admin_launch_the_browser() {
//    	loginPage = new LoginPage();
//    }

    @When("Admin gives the correct LMS portal URL login")
    public void admin_gives_correct_url() {
        loginPage.enterURL(loginPage.validPortal);
    }

    @When("Admin gives the invalid LMS portal URL")
    public void admin_gives_invalid_url() {
        loginPage.enterURL(loginPage.invalidPortal);
    }

    @Then("Admin should land on the login page")
    public void admin_should_land_on_login_page() {
        Assert.assertTrue(loginPage.isOnLoginPage());
    }

    @Then("Admin should receive page not found error")
    public void admin_should_receive_page_not_found_error() {
        Assert.assertTrue(loginPage.is404ErrorDisplayed());
    }
    
    @Then("If HTTP response more than400 the link is broken")
    public void if_http_response_more_than400_the_link_is_broken() {
    	Assert.assertTrue(loginPage.is400ErrorDisplayed());
    }

    @Then("Admin should see correct spellings in all fields")
    public void admin_should_see_correct_spellings() {
        Assert.assertTrue(loginPage.verifySpelling());
    }
    

    @Then("Admin should see logo on the leftside")
    public void admin_should_see_logo_on_the_left_side() {
        Assert.assertTrue(loginPage.isLogoAlignedLeft());
    }

    @Then("Admin should see  LMS - Learning Management System")
    public void admin_should_see_lms_learning_management_system() {
        Assert.assertTrue(loginPage.getAppName());
    }

    @Then("Admin should see company name below the app name")
    public void admin_should_see_company_name() {
    	Assert.assertTrue(loginPage.getCompanyName());
    }

    @Then("Admin should see \"Please login to LMS application\"")
    public void admin_should_see_login_message() {
        Assert.assertTrue(loginPage.verifyLoginMessage());
    }

    @Then("Admin should see two text field")
    public void admin_should_see_two_text_field() {
    	Assert.assertTrue(loginPage.verifyTwoTextfieldsPresent());
    }
    
    @Then("Admin should {string} in the first text field")
    public void admin_should_in_the_first_text_field(String string) {
        Assert.assertEquals(loginPage.verifyUserNameText(),"User");
    }
    
    @Then("Admin should see field mandatory \\(*) symbol next to Admin text")
    public void admin_should_see_field_mandatory_symbol_next_to_admin_text() {
    	Assert.assertEquals(loginPage.verifyMandatorySymbol(),"true");
    }
    
    @Then("Admin should {string} in the second text field")
    public void admin_should_in_the_second_text_field(String string) {
    	Assert.assertEquals(loginPage.verifyPasswordText(), "Password");
    }
    
    @Then("Admin should see * symbol next to password text")
    public void admin_should_see_symbol_next_to_password_text() {
    	Assert.assertEquals(loginPage.verifyMandatorySymbolPassword(),"true");
    }
    
    @Then("Admin should see input field on the centre of the page")
    public void admin_should_see_input_field_on_the_centre_of_the_page() {
    	Assert.assertEquals(loginPage.verifyInputFieldatMiddle(),"true");
    }
    
    @Then("Admin should see login button")
    public void admin_should_see_login_button() {
    	Assert.assertTrue(loginPage.isLoginButtonPresent());
    }
    
    @Then("Admin should see login button on the centre of the page")
    public void admin_should_see_login_button_on_the_centre_of_the_page() {
    	Assert.assertTrue(loginPage.isLoginButtonPresent());
    }
    
    @Then("Admin should see Admin in gray color")
    public void admin_should_see_admin_in_gray_color() {
    	Assert.assertTrue(loginPage.isUsernameFieldGray());
    }
    
    @Then("Admin should see password in gray color")
    public void admin_should_see_password_in_gray_color() {
    	Assert.assertTrue(loginPage.isPasswordFieldGray());
    }
    
    @When("Admin enter valid credentials  and clicks login button")
    public void admin_enter_valid_credentials_and_clicks_login_button() {
    	loginPage.LoginWithValidCredentials();
    }
    
    @Given("Admin is in login Page")
    public void admin_is_in_login_page() {
    	loginPage = new LoginPage();
    	loginPage.enterURL(loginPage.validPortal);
    }

    @When("Admin enter invalid credentials  and clicks login button")
    public void admin_enter_invalid_credentials_and_clicks_login_button() {
    	loginPage.LoginWithInValidCredentials();
    }

    @Then("Error message please check Adminname\\/password")
    public void error_message_please_check_adminname_password() {
    	Assert.assertEquals(loginPage.IsLoginErrorDisplayed(), "Invalid username and password Please try again");
    }

    @When("Admin enter value only in password and clicks login button")
    public void admin_enter_value_only_in_password_and_clicks_login_button() {
    	loginPage.onlyEnterPassoword();
    }
    
    @When("Admin enter value only in Adminname and clicks login button")
    public void admin_enter_value_only_in_adminname_and_clicks_login_button() {
    	loginPage.onlyEnterUserName();
    }
    
    @When("Admin enter valid credentials  and clicks login button through keyboard")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
    	loginPage.LoginWithValidCredentials();
    }

    @When("Admin enter valid credentials  and clicks login button through mouse")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
    	loginPage.LoginWithValidCredentials();
    }
    
}