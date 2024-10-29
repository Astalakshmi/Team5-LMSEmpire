@AddNewClasspopup
Feature: LMS Portal Add New Class popup feature in ClassModule Page Functionality

  Background: Admin is on the Manage Class page after login
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    When Admin should land on the home page
    When Admin enter valid credentials and clicks login button 
    When Admin should land on dashboard page
    When Admin clicks the Class Navigation bar in the Header
    When Admin is on the Manage class page
    

  @AddNewClasspopupTest_001
  Scenario: Check if class is created when only mandatory fields are entered with valid data
    Given Admin is on the Class Popup window
    When Admin enters mandatory fields in the form and clicks on save button
    Then Admin gets message Class added Successfully

  @AddNewClasspopupTest_002
  Scenario: Check no classes value added when selecting class dates
    Given Admin is on the Class Popup window
    When Validate Save button on class Details form
    Then Admin should see no of class value is added automatically

  @AddNewClasspopupTest_003
  Scenario: Check weekend dates are disabled in calender
    Given Admin is on the Class Popup window
    When Admin clicks date picker
    Then Admin should see weekends dates are disabled to select

  @AddNewClasspopupTest_004
  Scenario: Check if class is created when only optional fields are entered with valid data
    Given Admin is on the Class Popup window
    When Admin skips to add value in mandatory field and enter only the optional field
    Then Admin should see error message below the test field and the field will be highlighed in red color

  @AddNewClasspopupTest_005
  Scenario: check if class is created when invalid data is entered in all of the fields
    Given Admin is on the Class Popup window
    When Admin enters invalid data in all of the  fields in the form and clicks on save button
    Then Admin gets error message and class is not created

  @AddNewClasspopupTest_006
  Scenario: Empty form submission
    Given Admin is on the Class Popup window
    When Admin clicks on save button without entering data
    Then class cannot not be created and Admin gets error message

  @AddNewClasspopupTest_007
  Scenario: Validate Cancel or Close(X) icon on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks Cancel or Close Icon on Admin Details form
    Then Class Details popup window should be closed without saving

  @AddNewClasspopupTest_008
  Scenario: Validate Save button on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks save button
    Then Admin can see the class details popup closed and adding new class
