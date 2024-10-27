
Feature: Program Page
  Background:
	When Admin enter valid credentials and clicks login button 
    Then Admin should land on dashboard page
    When Admin clicks "Program" on the navigation bar


@tag45
  Scenario: Verify Admin is able to select multiple programs
 	 	When Admin selects more than one program by clicking on the checkbox
    Then Programs get selected																									
 
@tag46
  Scenario: Verify Admin is able to delete Multiple programs
  	Given Admin selects more than one program by clicking on the checkbox
 	 	When Admin clicks on the delete button on the left top of the program page
    Then Admin lands on Confirmation form	
    @tag47
  Scenario: Verify Admin is able to click 'Yes'
  	When Admin clicks on "Yes" button	
    Then Admin can see "Successful  program deleted" message				

@tag48
  Scenario: Verify Admin is able to see deleted program
  	When Admin Searches for "Deleted Program names"
    Then There should be zero results		

@tag49
  Scenario: Verify Admin is able to click 'No'	
  	Given Admin is on Confirm deletion form
 	 	When Admin clicks on "No" button		
    Then Admin can see Programs are still selected and not deleted																								

@tag50
  Scenario: Verify Admin is able to close the window with "X" 
  	Given Admin is on Confirm deletion form
 	 	When Admin Click on "X" button
    Then Admin can see Confirm Deletion form disappear



@tag58
  Scenario: Verify Admin is able to click Next page link
  	When Admin clicks Next page link on the program table
    Then Admin should see the Pagination has "Next" active link																							
 
@tag59
  Scenario: Verify Admin is able to click  Last page link
  	When Admin clicks Last page link	
    Then Admin should see the last page record on the table with Next page link are disabled

@tag60
  Scenario: Verify Admin is able to click Previous page link	
  	Given Admin is on last page of Program module table
  	When Admin clicks Previous page link
    Then Admin should see the previous page record on the table with pagination has previous page link
 
@tag61
  Scenario: Verify Admin is able to click  First page link
  	Given Admin is on Previous Program page
  	When Admin clicks First page link
    Then Admin should see the very first page record on the table with Previous page link are disabled
	
@tag62
  Scenario: Verify pagination when there are no records
  	Then Admin should not see any pagination icons and message "No records found"
 
@tag63
  Scenario: Verify pagination when there are no records
  	Then Admin should see pagination icons disabled
	

 																				
 
    