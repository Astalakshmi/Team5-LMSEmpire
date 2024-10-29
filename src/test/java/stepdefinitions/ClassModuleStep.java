package stepdefinitions;



import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverManager.WebdriverManager;
import io.cucumber.java.en.*;
import pageObjects.ClassModulePage;
import utilities.ConfigFileReader;
import utilities.LoggerLoad;

public class ClassModuleStep {
	
	
	WebDriver driver = WebdriverManager.getDriver();
	ConfigFileReader configFileReader = WebdriverManager.configReader();
	ClassModulePage classModuleObj = new ClassModulePage();

//---------------------------@ClassPageValidation-----------------------------------------------------------
	
	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
	   classModuleObj.clickClassBtn();
	}
	@Then("Admin should land on the Manage class page")
	public void admin_should_land_on_the_manage_class_page() {
		String actualclassUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualclassUrl,configFileReader.getClassModulePageUrl());
		LoggerLoad.info("You are navigated to "+ actualclassUrl);
	}

	@Then("Admin should see in the {string} Title")
	public void admin_should_see_the_title(String string) {

		 Assert.assertEquals(classModuleObj.getActualTitle(),configFileReader.getPageTitle("classPageTitle"));
		 LoggerLoad.info("You are in "+ driver.getTitle() +" Page.");
	}
	
	@Then("Admin should see the {string} Header")
	public void admin_should_see_the_header(String string) {
		Assert.assertEquals(classModuleObj.setManageClassHeader(),configFileReader.getManageHeader("manageHeader"));
		LoggerLoad.info("Admin should see the \"Manage Class\" Header: "+ classModuleObj.setManageClassHeader());
	}

	@Then("Admin should see the Searchbar in Manage class page")
	public void admin_should_see_the_searchbar_in_manage_class_page() {

		boolean Searchbar = classModuleObj.setSearchbar();
	    Assert.assertTrue(Searchbar);
	    LoggerLoad.info("Searchbar in manage class page is visible : "+ Searchbar);
	}

	@Then("Admin should see the datatable heading like Batchname,class topic,class descrption,status,class Date,staff name,Edit\\/Delete")
	public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_descrption_status_class_date_staff_name_edit_delete(String expectedHeaders) {
		//bug	
		 List<String> actualHeaders = classModuleObj.tableHeaderTexts(); // Retrieve the actual header texts
		 List<String> expectedHeaderList = Arrays.asList(expectedHeaders.split(","));
		    Assert.assertEquals(actualHeaders,expectedHeaderList);
		    LoggerLoad.info("Datatable heading : "+ actualHeaders);
		
	}
	@Then("Admin should see the {string} and enabled pagination controls under the data table")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(String string) {
		
		boolean paginationText = classModuleObj.getPaginationText();
	    Assert.assertTrue(paginationText);
	    LoggerLoad.info("print pagination text: "+ paginationText);
	}

	@Then("Admin should see the Sort icon of all the field in the datatable.")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
		Assert.assertEquals(classModuleObj.isHeaderSortIconListVisible(), true);
		LoggerLoad.info("Sort icon is visible on the fields : "+ classModuleObj.isHeaderSortIconListVisible());
	}

	@Then("Admin should see the Delete button under the Manage class page header.")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
		Assert.assertEquals(classModuleObj.isDeleteAllBtnEnabled(), false);
		LoggerLoad.info("Delete button visible under the manage class page : "+ classModuleObj.isDeleteAllBtnEnabled());
	}

	@Then("Admin should see Total no of classes in below of the data table.")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
	
		String showStr = classModuleObj.totalNoOfClasses();
		System.out.println("ShowStr=" + showStr);
		String[] numbers = showStr.split("\\D+");
		if (numbers.length > 1) {
	        String classCount = numbers[1];
	        String expectedText = "In total there are " + classCount + " classes.";
	        System.out.println(expectedText);
	        // Use contains with toLowerCase() for case-insensitive partial match
	        Assert.assertTrue(showStr.toLowerCase().contains(expectedText.toLowerCase()));
	        LoggerLoad.info("Total number of classes:" + expectedText);
	    } else {
	        System.out.println("Class count number not found in the display text.");
	        LoggerLoad.error("Class count number not found in the display text.");
	     
	    }
	}
	
//------------------------------------@AddNewClass------------------------------------------------------------------------
		
	@Given("Admin is on the Manage class page")
	public void admin_is_on_the_manage_class_page_after_login() {
		String actualclassUrl = driver.getCurrentUrl();
		LoggerLoad.info("You are navigated to Manage class Page : "+ actualclassUrl);
	}
	
	@When("Admin clicks add new class under the class menu bar")
	public void admin_clicks_add_new_class_under_the_class_menu_bar() {
	    classModuleObj.clickAddNewClassBtn();
	    
	}
	
	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	   Assert.assertTrue(classModuleObj.Dialogbox());
	   LoggerLoad.info("DialogBox is opened");
	   List<WebElement> formFields = classModuleObj.forminputs;
	    for (WebElement field : formFields) {
	    	Assert.assertTrue(field.getText().isEmpty(), "Form field is not empty.");
	    	LoggerLoad.info("All the input form fields are Empty");
	    }
	    Assert.assertTrue(classModuleObj.cancelBtnDialogbox());
	    LoggerLoad.info("DialogBox in cancel button is visible");
	    Assert.assertTrue(classModuleObj.saveBtnDialogbox());
	    LoggerLoad.info("DialogBox in save button is visible");
	    Assert.assertTrue(classModuleObj.closeIconDialogbox());
	    LoggerLoad.info("DialogBox in close icon is visible");
	  
	}
	
	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
		 List<String> expectedFieldLabels = Arrays.asList("Class Topic", "Class Description", "No of Classes", "Comments", "Notes", "Recording");

		    List<WebElement> formFieldsText = classModuleObj.formTextInputs;
		    for (WebElement fieldText : formFieldsText) {
		        String fieldTextContent = fieldText.getText().trim();

		        LoggerLoad.info("Form field text found: [" + fieldTextContent + "]");

		        if (fieldTextContent.isEmpty()) {
		            LoggerLoad.warn("Warning: An empty field label was found. Check the locator or HTML structure.");
		            continue;
		        }

		        Assert.assertTrue(expectedFieldLabels.contains(fieldTextContent),
		                "Unexpected field found: " + fieldTextContent + " is not in the expected labels list.");
		    }
		    LoggerLoad.info("All expected form fields and their text boxes are displayed correctly in the class details window.");
		}
//--------------------------------------@AddNewClasspopup----------------------------------------

	@Given("Admin is on the Class Popup window")
	public void admin_is_on_the_class_popup_window() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Admin enters mandatory fields in the form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Validate Save button on class Details form")
	public void validate_save_button_on_class_details_form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Admin should see no of class value is added automatically")
	public void admin_should_see_no_of_class_value_is_added_automatically() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Admin clicks date picker")
	public void admin_clicks_date_picker() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Admin should see weekends dates are disabled to select")
	public void admin_should_see_weekends_dates_are_disabled_to_select() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Admin skips to add value in mandatory field and enter only the optional field")
	public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Admin enters invalid data in all of the  fields in the form and clicks on save button")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_save_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Admin gets error message and class is not created")
	public void admin_gets_error_message_and_class_is_not_created() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Admin clicks on save button without entering data")
	public void admin_clicks_on_save_button_without_entering_data() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("class cannot not be created and Admin gets error message")
	public void class_cannot_not_be_created_and_admin_gets_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Admin clicks Cancel or Close Icon on Admin Details form")
	public void admin_clicks_cancel_close_x_icon_on_admin_details_form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Class Details popup window should be closed without saving")
	public void class_details_popup_window_should_be_closed_without_saving() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Admin clicks save button")
	public void admin_clicks_save_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Admin can see the class details popup closed and adding new class")
	public void admin_can_see_the_class_details_popup_closed_and_adding_new_class() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
//------------------------------------------@EditNewclass-------------------------------
	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
	    classModuleObj.clickEditButton();
	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
		boolean headingClassDetails=classModuleObj.classDetailsAppear();
		Assert.assertEquals(headingClassDetails,true);
		LoggerLoad.info("new pop up with class details appear");
	}

	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
		boolean isDisabled = classModuleObj.disableBatchName();
	    Assert.assertTrue(isDisabled, "Batch name dropdown is not disabled.");
	}

	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		Assert.assertTrue(classModuleObj.disableClassTopic(), "class Topic field is not disabled.");
	    LoggerLoad.info("Admin should see class Topic field is disabled");
	}

}
