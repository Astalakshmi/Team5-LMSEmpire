package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CreateProgramPage;
import utilities.ExcelFileReader;
import utilities.LoggerLoad;

public class CreateProgramSteps {

	CreateProgramPage createProgramPage = new CreateProgramPage();
	String inputName;
	String inputDescription;
	String programStatus;

	String programDataFilePath = "./src/test/resources/Program_Data.xlsx";
	ExcelFileReader fileReader = new ExcelFileReader();
	List<Map<String, String>> createProgramList = fileReader.getData(programDataFilePath, "CreateProgram");
	Map<String, String> newProgram;

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
		createProgramPage.getProgramModuleObj().addNewProgramClick();
	}

	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() {
		// System.out.println("isProgramDetailsVisible? "+
		// createProgramPage.isProgramDetailsVisible());
		Assert.assertEquals(createProgramPage.isProgramDetailsVisible(), true);
	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String title) {
		// System.out.println("window title = "+ createProgramPage.getWindowtitle());
		Assert.assertEquals(title, createProgramPage.getWindowtitle());
	}

	@Then("Admin should see red {string} mark beside mandatory field {string}")
	public void admin_should_see_red_mark_beside_mandatory_field(String sign, String name) {
		System.out.println("is label visible?  " + createProgramPage.isMandatorySignForNameVisible());
		Assert.assertEquals(createProgramPage.isMandatorySignForNameVisible(), true);
	}

	@When("Admin clicks save button without entering mandatory fields from the sheet {string}")
	public void admin_clicks_save_button_without_entering_mandatory_fields_from_the_sheet(String sheetName) {
		String programName;
		newProgram = createProgramList.get(0);
		programName = newProgram.get("ProgramName");
		inputDescription = newProgram.get("Description");
		// System.out.println("program name and description are:" + programName+" and
		// "+inputDescription);
		createProgramPage.txtProgramName(programName);
		createProgramPage.saveButtonClick();
	}

	@Then("Admin gets message field is required")
	public void admin_gets_message_field_is_required() {
		System.out.println("is label visible?  " + createProgramPage.isLblNameFieldRqedVisible());
		Assert.assertEquals(createProgramPage.isLblNameFieldRqedVisible(), true);
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		createProgramPage.cancelButtonClick();
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() throws InterruptedException {
		// System.out.println("isProgramDetailsVisible? "+
		// createProgramPage.isProgramDetailsVisible());
		Thread.sleep(1000);
		// System.out.println("isProgramDetailsVisible? "+
		// createProgramPage.isProgramDetailsVisible());

		try {
			Assert.assertEquals(createProgramPage.isProgramDetailsVisible(), false);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			LoggerLoad.info("Element not found");
		}

	}

	@When("Admin enters the Name in the text box from the sheet {string}")
	public void admin_enters_the_name_in_the_text_box_from_the_sheet(String string) {

		newProgram = createProgramList.get(1);
		inputName = newProgram.get("ProgramName");
		createProgramPage.txtProgramName(inputName);
	}

	@Then("Admin can see the text entered")
	public void admin_can_see_the_text_entered() {
		String nameReturned = createProgramPage.readNameEntered();
		// System.out.println("nameReturned = "+nameReturned);
		Assert.assertEquals(inputName, nameReturned);
	}

	@When("Admin enters the Description in text box from the sheet {string}")
	public void admin_enters_the_description_in_text_box_from_the_sheet(String string) {
		newProgram = createProgramList.get(2);
		inputDescription = newProgram.get("Description");
		createProgramPage.txtDescription(inputDescription);
	}

	@Then("Admin can see the text entered in description box")
	public void admin_can_see_the_text_entered_in_description_box() {
		String descriptionReturned = createProgramPage.readDescriptionEntered();

		// System.out.println("descriptionReturned = "+descriptionReturned);
		Assert.assertEquals(inputDescription, descriptionReturned);
	}

	@When("Admin selects the status of the program from the sheet {string} by clicking on the radio button {string}")
	public void admin_selects_the_status_of_the_program_from_the_sheet_by_clicking_on_the_radio_button(String string,
			String string2) {
		newProgram = createProgramList.get(1);
		programStatus = newProgram.get("Status");
		System.out.println("input status = " + programStatus);
		if (programStatus.equals("Active")) {
			createProgramPage.activeButtonClick();
			System.out.println("status is Active");
		} else {
			createProgramPage.inActiveButtonClick();
			System.out.println("status is inactive");
		}
	}

	@Then("Admin can see {string} status selected")
	public void admin_can_see_status_selected(String string) {
		if (programStatus.equals("Active")) {
			System.out.println("Active");
			Assert.assertEquals(createProgramPage.isActiveBtnClicked(), true); // check if active button is clicked
			System.out.println("Active button is clicked!");
		} else {
			System.out.println("InActive");
			Assert.assertEquals(createProgramPage.isInActiveBtnClicked(), true); // check if inactive button is clicked
			System.out.println("Inactive button is clicked!");
		}
	}

	@When("Admin enter valid details for mandatory fields from the sheet {string} and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_from_the_sheet_and_click_on_save_button(String string) {
		newProgram = createProgramList.get(3);

		inputName = newProgram.get("ProgramName");
		createProgramPage.txtProgramName(inputName);

		inputDescription = newProgram.get("Description");
		createProgramPage.txtDescription(inputDescription);

		programStatus = newProgram.get("Status");
		System.out.println("input status = " + programStatus);
		if (programStatus.equals("Active")) {
			createProgramPage.activeButtonClick();
			System.out.println("status is Active");
		} else {
			createProgramPage.inActiveButtonClick();
			System.out.println("status is inactive");
		}

		createProgramPage.saveButtonClick();
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String string) {
		LoggerLoad.info("Check if program is created when only mandatory fields are entered with valid data");
		Assert.assertEquals(createProgramPage.programCreatedMessage(), "Successful");
	}

	@When("Admin Click on cancel button")
	public void admin_click_on_cancel_button() {
		
	}

	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {
		
	}

	@When("Admin Click on {string} button")
	public void admin_click_on_button(String string) {
		createProgramPage.cancelButtonClick();
	}

}
