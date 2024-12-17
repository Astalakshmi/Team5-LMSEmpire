package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EditProgramPage;
import utilities.ExcelFileReader;

public class EditProgramSteps {

	EditProgramPage editProgramPage = new EditProgramPage();

	String programDataFilePath = "./src/test/resources/Program_Data.xlsx";
	ExcelFileReader fileReader = new ExcelFileReader();
	List<Map<String, String>> editProgramList = fileReader.getData(programDataFilePath, "EditProgram");
	Map<String, String> editProgram;

	String updatedName;
	String updatedDescription;
	String updatedStatus;

	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() throws InterruptedException {
		editProgramPage.getRandomEditButton();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {

		Assert.assertEquals(editProgramPage.getCreateProgramObj().isProgramDetailsVisible(), true);
	}

	@When("Admin edits the Program Name with data from the sheet \"Program_Data\"	 and click on save button")
	public void admin_edits_the_program_name_with_data_from_the_sheet_program_data_and_click_on_save_button() {
		editProgram = editProgramList.get(3);
		updatedName = editProgram.get("ProgramName");
		editProgramPage.getCreateProgramObj().txtProgramName(updatedName);
		System.out.println("updatedName = " + updatedName);
		WebElement saveBtn = editProgramPage.getCreateProgramObj().saveBtn();
		try {
			saveBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) editProgramPage.getDriver()).executeScript("arguments[0].click();", saveBtn);
		}
	}

	@Then("Updated Program Name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("Admin edits the Description text with data from the sheet {string} and click on save button")
	public void admin_edits_the_description_text_with_data_from_the_sheet_and_click_on_save_button(String string) {
		editProgram = editProgramList.get(3);
		updatedDescription = editProgram.get("Description");
		editProgramPage.getCreateProgramObj().txtDescription(updatedDescription);
		System.out.println("updatedDescription = " + updatedDescription);
		WebElement saveBtn = editProgramPage.getCreateProgramObj().saveBtn();
		try {
			saveBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) editProgramPage.getDriver()).executeScript("arguments[0].click();", saveBtn);
		}
	}

	@Then("Admin can see the Description is updated")
	public void admin_can_see_the_description_is_updated() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("Admin changes the status of the program and click on save button")
	public void admin_changes_the_status_of_the_program_and_click_on_save_button() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("Admin click on save button")
	public void admin_click_on_save_button() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@Then("Admin can see the updated program details")
	public void admin_can_see_the_updated_program_details() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("Admin click on cancel button")
	public void admin_click_on_cancel_button() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@Then("Admin can see the Program details form disappears")
	public void admin_can_see_the_program_details_form_disappears() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("Admin searches with newly updated Program Name")
	public void admin_searches_with_newly_updated_program_name() {
		// Write code here that turns the phrase above into concrete actions
	//	throw new io.cucumber.java.PendingException();
	}

	@Then("Admin verifies that the details are correctly updated")
	public void admin_verifies_that_the_details_are_correctly_updated() {
		// Write code here that turns the phrase above into concrete actions
	//	throw new io.cucumber.java.PendingException();
	}

}
