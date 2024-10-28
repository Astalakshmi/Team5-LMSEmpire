
@tag
Feature: Delete Program
Background: 
    Given user is on the login page
    When user enters username as "Sdet@gmail.com" and password as "LmsHackathon@2024" and cliks Login button
    And user lands on Dashboard page
    When Admin clicks "Program" on the navigation bar
    And Admin clicks on delete button for a program
@tag40
  Scenario: Verify delete feature 
 	 	Then Admin gets delete confirmation popup																					

@tag41
  Scenario: Verify Admin is able to click 'Yes'	
 	 	When Admin clicks on "Yes" button
    Then Admin can see "Successful Program Deleted" message		

@tag42
  Scenario: Verify Admin is able to see deleted program
 	 	When Admin Searches for Deleted Program Name
    Then There should be zero results			
    
@tag43
  Scenario: Verify Admin is able to click 'No'	
 	 	When Admin clicks on "No" button
    Then Admin can see Confirmation form disappears			
    																					
@tag44
  Scenario: Verify Admin is able to close the window with "X"
 	 	When Admin Click on "X" button
    Then Admin can see Confirmation form disappears																				
 
			
 

 

  