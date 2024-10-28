package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramModule;
import utilities.ConfigFileReader;

public class ProgramModuleSteps {

	ProgramModule programModule = new ProgramModule();
	//ConfigFileReader confReader =  new ConfigFileReader();

@When("Admin clicks {string} on the navigation bar")
public void admin_clicks_on_the_navigation_bar(String string) {
	System.out.println("Testing..");
	programModule.programBtn();
}
@Then("Admin should be navigated to Program module")
public void admin_should_be_navigated_to_program_module() {
   //System.out.println("Page title=="+ WebdriverManager.getDriver().getTitle());
   Assert.assertEquals(programModule.isManagePorgramDisplayed(), true);
  // System.out.println("manage program page");

}

@Then("Admin should not have any broken links for Program module")
public void admin_should_not_have_any_broken_links_for_program_module() {
	Assert.assertEquals(programModule.isManagePorgramDisplayed(), true);
}

@Then("Admin should see the heading {string}")
public void admin_should_see_the_heading(String heading) {
    Assert.assertEquals(heading, programModule.lmsHeading());
}

@Then("Admin should see the module names as in order {string}")
public void admin_should_see_the_module_names_as_in_order(String names) {
    System.out.println("expected names = "+ programModule.moduleNames());
	String expectedNames = programModule.moduleNames();
	 Assert.assertEquals(names,expectedNames);
}

@Then("Admin should see Logout in menu bar")
public void admin_should_see_logout_in_menu_bar() {
	Assert.assertEquals(programModule.isLogoutBtnDisplayed(), true);
}

@Then("Admin should see the subheading {string}")
public void admin_should_see_the_subheading(String subheading) {
	System.out.println("expected subheading = "+ programModule.managePorgramText());
    Assert.assertEquals(subheading, programModule.managePorgramText());
}

@Then("Admin should see a Delete button in left top is disabled")
public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
	Assert.assertEquals(programModule.isDeleteAllBtnEnabled(), false);
}

@Then("Admin should see Search bar with text as {string}")
public void admin_should_see_search_bar_with_text_as(String placeHolder) {
	//System.out.println("placeHolder text = "+ programModule.searchBoxPlaceHolder());
    Assert.assertEquals(placeHolder, programModule.searchBoxPlaceHolder());
}

@Then("Admin should see data table with column header on the Manage Program Page as  {string}")
public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as(String headers) {
	System.out.println("actual headers = "+ programModule.dataTableHeaders());
	String expectedNames = programModule.dataTableHeaders();
	 Assert.assertEquals(expectedNames,headers);
}
@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
	//System.out.println("chkBxHeaderState is enabled;"+ programModule.isChkBxHeaderSelected());
	Assert.assertEquals(programModule.isChkBxHeaderSelected(), false);

}

@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
	System.out.println("chkBoxListState is enabled;"+ programModule.isChkBoxListSelected());
		Assert.assertEquals(programModule.isChkBoxListSelected(), false);
}

@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	//System.out.println("headerSortIconListState is enabled;"+ programModule.isHeaderSortIconListVisible());
		Assert.assertEquals(programModule.isHeaderSortIconListVisible(), true);

}

@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table")
public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {
	//programModule.getTotalProgramsText();
	String paginationText = programModule.getPaginationText();
   int totalPrograms = programModule.totalNoOfPrograms();
   System.out.println(paginationText);
   System.out.println(programModule.getTotalProgramsText());
   String sub = "of "+totalPrograms + " entries";
   System.out.println("sub Text = "+ sub);
   Assert.assertTrue(paginationText.contains(sub));
}

@Then("Admin should see the footer as In total there are z programs")
public void admin_should_see_the_footer_as_in_total_there_are_z_programs() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the Edit and Delete buttons on each row of the data table")
public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
	System.out.println("isEditAndDeleteListVisible?"+ programModule.isEditAndDeleteListVisible());
			Assert.assertEquals(programModule.isEditAndDeleteListVisible(), true);
}





@Then("Admin should see sub menu in menu bar as {string}")
public void admin_should_see_sub_menu_in_menu_bar_as(String subMenu) {
	System.out.println("submenu = "+programModule.addNewProgram());
	 Assert.assertEquals(subMenu, programModule.addNewProgram());
}

@Then("Admin should able to see Program name, description, and status for each program")
public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin searches with newly created {string}")
public void admin_searches_with_newly_created(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Records of the newly created  {string} is displayed and match the data entered")
public void records_of_the_newly_created_is_displayed_and_match_the_data_entered(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}




}
