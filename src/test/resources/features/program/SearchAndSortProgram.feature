
@tag
Feature: Search and sort Program
Background:
	Given user is on the login page
	When user enters username as "Sdet@gmail.com" and password as "LmsHackathon@2024" and cliks Login button
	And user lands on Dashboard page
	Then Admin clicks "Program" on the navigation bar
  @tag51
  Scenario: 	Verify Admin is able to search results found for program name 
  	When Admin enter the program to search By Program Name from the sheet "Program_Data"	
    Then Admin should able to see Program name, description, and status for searched program name
    
@tag52
  Scenario: Verify Admin is able to search results found for program description 
  	When Admin enter the program to search By program Description from the sheet "Program_Data"	
    Then Admin should able to see Program name, description, and status for searched program name
    
@tag53
  Scenario: Verify Admin is able to search results not found 
  	When Admin enter the program to search By Program Name that does not exist from the sheet "Program_Data"	
    																							
 @tag54
  Scenario: Verify Admin is able to search with partial program name 
  	When Admin enter the program to search By partial name of program Program Name from the sheet "Program_Data"	
    Then Admin should able to see Program name, description, and status for searched program name
    
 @tag55
  Scenario: Verify sorting of Program name in Ascending order/Descending order
  	When Admin clicks on Arrow next to program Name
    Then Admin Sees the Program Name is sorted in Ascending order/Descending order
 
@tag56
  Scenario: Verify sorting of Program Description in Ascending order/Descending order
  	When Admin clicks on Arrow next to Program Description
    Then Admin Sees the program Description is sorted in Ascending order/Descending order																					
	 
@tag57
  Scenario: Verify sorting of Program status in Ascending order/Descending order
  	When Admin clicks on Arrow next to Program status
    Then Admin Sees the  Program Status is sorted in Ascending order/Descending order
 