@ClassPageValidation
Feature: LMS Portal Class Page feature Validation in ClassModule Page Functionality
 
	Background: Admin Is on the Dashboard page after login
    Given The Admin is on the login page
    And The Admin enters the valid username and password "LoginCredentials"
    And The Admin Is on the Dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    
  @ClassPageValidationTest_001
  Scenario: Validating the class manage page
    Then Admin should land on the Manage class page
    
   @ClassPageValidationTest_002
 	 Scenario: Validating the Title in the Manage class page
    Then Admin should see the "LMS-Learning Management System" Title
    
   @ClassPageValidationTest_003
 	 Scenario: Validating the Header in the Manage class page
    Then Admin should see the "Manage Class" Header
    
   @ClassPageValidationTest_004
 	 Scenario: Validating Search bar in class page
    Then Admin should see the Searchbar in Manage class page
    
   @ClassPageValidationTest_005
 	 Scenario: Validating the data table headers in the class page
    Then Admin should see the datatable heading like Batchname,class topic,class descrption,status,class Date,staff name,Edit/Delete 
    
   @ClassPageValidationTest_006
 	 Scenario: Validating the text and pagination icon in the classpage
    Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table
    
   @ClassPageValidationTest_007
 	 Scenario: Validate the sort icon of all the field in datatable
    Then Admin should see the Sort icon of all the field in the datatable.
    
   @ClassPageValidationTest_008
 	 Scenario: Validating the Delete button under the Manage class 
    Then Admin should see the Delete button under the Manage class page header.
    
   @ClassPageValidationTest_009
 	 Scenario: Validate the total no of classes in manage class page
    Then Admin should see Total no of classes in below of the data table.