
@tag
Feature: Edit Program
  Background: 
    Given user is on the login page
    When user enters username as "Sdet@gmail.com" and password as "LmsHackathon@2024" and cliks Login button
    And user lands on Dashboard page
    When Admin clicks "Program" on the navigation bar
    And Admin clicks on Edit option for particular program
 @tag30
  Scenario: Verify Edit option
  	Then Admin lands on Program details form
 					
 @tag31
  Scenario: Verify title of the pop up window
   Then Admin should see window title as "Program Details"																					
 					
 @tag32
  Scenario: Verify mandatory fields with red "*" mark
  	Then Admin should see red "*" mark beside mandatory field "Name"																				
				
 @tag33
  Scenario: Verify edit Program Name
  	When Admin edits the Program Name with data from the sheet "Program_Data"	 and click on save button
    Then Updated Program Name is seen by the Admin
   
@tag34
  Scenario: Verify edit Description
  	When Admin edits the Description text with data from the sheet "Program_Data" and click on save button
    Then Admin can see the Description is updated																					
	  
 @tag35
  Scenario: Verify edit Status
 	  When Admin changes the status of the program and click on save button
    Then Status updated can be viewed by the Admin

@tag36
  Scenario: Verify Admin is able to click Save
 	  When Admin click on save button
    Then Admin can see the updated program details	

@tag37
  Scenario: Verify Admin is able to click Cancel
 	 When Admin click on cancel button
    Then Admin can see the Program details form disappears		

@tag38
  Scenario: Verify edited Program details
 	 	When Admin searches with newly updated Program Name
    Then Admin verifies that the details are correctly updated		
    
@tag39
  Scenario: Verify close the window with "X" 
 	 	When Admin Click on "X" button
    Then Admin can see program details form disappear		

