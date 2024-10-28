package stepdefinitions;

import java.time.Duration;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;


import driverManager.WebdriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import utilities.LoggerLoad;

public class BatchPage_Step {
	
	private WebDriver driver;
	private BatchPage  batchpage= new BatchPage(WebdriverManager.getDriver());
	
	@When("Admin clicks Batch on the navigation bar")
	public void Admin_clicks_Batch_on_the_navigation_bar() throws InterruptedException {
	   
		batchpage.BatchClickMd();
		Thread.sleep(3000);
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
	   batchpage.ManageBatchVerify();
	   System.out.println("Verifying manage batch page " );
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String Header) {
		batchpage.HeaderValidation(Header);
		System.out.println("Admin is able to see LMS-Learning Management System in the header");
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String headerBatch) {
		batchpage.HeaderValidationBatch(headerBatch);
		System.out.println("Admin is able to see Manage Batch Page in the header");
	}

	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String string) {
		Assert.assertFalse(batchpage.DeletetopIconValidation());
		LoggerLoad.info("Admin is able to see the Delete icon button that is disabled on Manage Batch Page");
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		
        batchpage.PaginationValidation();
        
        
        
        
        LoggerLoad.info("Admin should see the enabled pagination controls under the data table");
    	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		 boolean editIconPresent = batchpage.isEditIconPresentInEachRow();
	        Assert.assertTrue(editIconPresent, "Edit icon is not present in each row as expected.");

	        LoggerLoad.info("Admin should see the edit icon in each row");
	    
	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		boolean deleteIconPresent = batchpage.isDeleteIconPresentInEachRow();
        Assert.assertTrue(deleteIconPresent, "Delete icon is not present in each row as expected.");

        LoggerLoad.info("Admin should see the delete icon in each row");
    
	}

	@Then("Admin should the checkbox in each row")
	public void admin_should_the_checkbox_in_each_row() {
		boolean checkboxPresent = batchpage.isCheckboxPresentInEachRow();
        Assert.assertTrue(checkboxPresent, "Checkbox is not present in each row as expected.");

        LoggerLoad.info("Admin should see the checkbox in each row");
    
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		boolean headersVisible = batchpage.areHeadersVisible();
        Assert.assertTrue(headersVisible, "One or more of the expected headers are not visible in the data table.");

        LoggerLoad.info("Admin should see the datatable headers Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit/Delete");
	}

	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		// Check if the checkbox element is displayed using the BatchPage object
	    boolean isCheckboxVisible = batchpage.isHeaderCheckboxVisible();
	    
	    // Assert to validate the checkbox is visible
	    Assert.assertTrue(isCheckboxVisible, "Checkbox in the datatable header row is not visible.");

	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		boolean areAllSortIconsVisible = batchpage.areAllSortIconsVisible();
	    
	    
	    Assert.assertTrue(areAllSortIconsVisible,"Not all datatable headers have the sort icon next to them.");
	
	}

	@Then("Admin1 should see sub menu in menu bar as {string}")
	public void admin1_should_see_sub_menu_in_menu_bar_as(String string) {
		
		
		batchpage.isSubmenuVisible(string);
		LoggerLoad.info("Admin should see sub menu in menu bar as Add New Batch");
	    
	}

	@When("Admin clicks on {string} under the {string} menu bar1")
	public void admin_clicks_on_under_the_menu_bar1(String string, String string2) {
		batchpage.clickAddNewBatchButton();
	}

	@Then("Admin should see the Batch Details pop up window1")
	public void admin_should_see_the_batch_details_pop_up_window1() {
		batchpage.batchdetailPOP();
		System.out.println("Admin should see the Batch Details pop up window1");
	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
	    batchpage.editButton();
	}
	@Then("Admin should see the Batch details pop up window2")
	public void admin_should_see_the_batch_details_pop_up_window2() {
		batchpage.batchdetailPOP();
		System.out.println("Admin should see the Batch Details pop up window2");
	}
	
	@When("Admin clicks the edit icon1")
	public void admin_clicks_the_edit_icon1() {
	    batchpage.editButton();
	}
	
	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
		boolean isDisabled = batchpage.isProgramNameFieldDisabled();
	    Assert.assertTrue(isDisabled, "The Program name field is not disabled for editing.");
	}
	
	@When("Admin clicks the edit icon2")
	public void admin_clicks_the_edit_icon2() {
	    batchpage.editButton();
	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		boolean isDisabled = batchpage.isBatchNameFieldDisabled();
	    Assert.assertTrue(isDisabled,"The Batch name field is not disabled for editing.");
	}

	@Given("Admin is on the Batch Details Page")
	public void admin_is_on_the_batch_details_page() {
		batchpage.editButton();
	}

	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {
		batchpage.enterInvalidDataInDescription("Invalid Data!@#");  // Replace with the desired invalid data
	    batchpage.clickSaveButton();
	}

	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
	    
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {
	   
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should get a succesesful message for editing the batch")
	public void admin_should_get_a_succesesful_message_for_editing_the_batch() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks backward page link on the data table")
	public void admin_clicks_backward_page_link_on_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enters the batch name in the serach text box")
	public void admin_enters_the_batch_name_in_the_serach_text_box() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the filtered batches in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
