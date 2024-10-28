package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassModuleNavObject;
import pageObjects.HomePageObject;
import pageObjects.ProgramModule;

public class ClassModuleNavSteps {
	
	ClassModuleNavObject obj = new ClassModuleNavObject(); 

@When ("Admin clicks on Class Navigation bar")
public void admin_clicks_on_class_navigation_bar() {
	
	obj.ClickClassBtn();
   
}

@Then ("Admin is on Manage Class page")
public void admin_is_on_manage_class_page() {
	
	String ManageHeading = obj.GetManageClassHeading();
	System.out.println(ManageHeading);	
	   
}

@When("Admin clicks on Logout link on Manage class page")
public void admin_clicks_on_logout_link_on_manage_class_page() {
  
	obj.ClickLogout();
	
	}

@Then("Admin is re-directed to Login page")
public void admin_is_re_directed_to_login_page() {
	
	String LoginHeading = obj.GetTextLogin();
	System.out.print(LoginHeading);
   
}

@When("Admin clicks on Program link on Manage Class page")
public void admin_clicks_on_program_link_on_manage_class_page() {
   
	obj.ClickProgram();
}

@Then("Admin is re-directed to Manage Program")
public void admin_is_re_directed_to_manage_program() {
	
	String ProgramHeading=obj.GetProgramHeading();
	System.out.println(ProgramHeading);
  
}

@When("Admin clicks on Batch link on Manage Class page")
public void admin_clicks_on_batch_link_on_manage_class_page() {
	
	obj.ClickBatch();
}

@Then("Admin is re-directed to Manage Batch")
public void admin_is_re_directed_to_manage_batch() {
   
	String BatchHeading=obj.GetBatchHeading();
	System.out.println(BatchHeading);
}


@Then("Admin should see Class Name on Class Details page")
public void admin_should_see_batch_name_on_class_details_page() {

	String BatchName=obj.GetTextClassName();
	System.out.println(BatchName);
}


}
