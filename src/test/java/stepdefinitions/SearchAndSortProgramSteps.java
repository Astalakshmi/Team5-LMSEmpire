package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchAndSortProgramPage;

public class SearchAndSortProgramSteps {

	SearchAndSortProgramPage searchAndSortProgramPage = new SearchAndSortProgramPage();

	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
		searchAndSortProgramPage.clickPgmNameToSort();
	}

	@Then("Admin Sees the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_sees_the_program_name_is_sorted_in_ascending_order_descending_order() {
		Assert.assertTrue(searchAndSortProgramPage.isProgramNameSorted());
	}

	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() {
		searchAndSortProgramPage.clickPgmDescriptionToSort();
	}

	@Then("Admin Sees the program Description is sorted in Ascending order\\/Descending order")
	public void admin_sees_the_program_description_is_sorted_in_ascending_order_descending_order() {
		Assert.assertTrue(searchAndSortProgramPage.isProgramDescriptionSorted());
	}

	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
		searchAndSortProgramPage.clickPgmStatusToSort();
	}

	@Then("Admin Sees the  Program Status is sorted in Ascending order\\/Descending order")
	public void admin_sees_the_program_status_is_sorted_in_ascending_order_descending_order() {
		Assert.assertTrue(searchAndSortProgramPage.isProgramStatusSorted());
	}
}
