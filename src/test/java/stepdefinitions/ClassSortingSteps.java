package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassSortingPage;

public class ClassSortingSteps {
	
	ClassSortingPage Sortingpage=new ClassSortingPage();
	

	@When("Admin clicks on the Batchname sort icon")
	public void admin_clicks_on_the_batchname_sort_icon() {
		Sortingpage.BatchNameSorting();
	   
	}

	@Then("Admin should see Class details are sorted by Batch Name")
	public void admin_should_see_class_details_are_sorted_by_batch_name() {
	
	}


}
