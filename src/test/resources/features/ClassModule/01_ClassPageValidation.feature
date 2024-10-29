@ClassPageValidation
Feature: LMS Portal Class Page feature Validation in ClassModule Page Functionality

  Background: Admin Is on the Dashboard page after login
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    When Admin should land on the home page
    When Admin enter valid credentials and clicks login button
    When Admin should land on dashboard page

  @ClassPageValidationTest_001
  Scenario: Validating the class manage page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should land on the Manage class page

  @ClassPageValidationTest_002
  Scenario: Validating the Title in the Manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see in the "LMS-Learning Management System" Title

  @ClassPageValidationTest_003
  Scenario: Validating the Header in the Manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "Manage Class" Header

  @ClassPageValidationTest_004
  Scenario: Validating Search bar in class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Searchbar in Manage class page

  @ClassPageValidationTest_005
  Scenario: Validating the data table headers in the class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the datatable heading like Batchname,class topic,class descrption,status,class Date,staff name,Edit/Delete

  @ClassPageValidationTest_006
  Scenario: Validating the text and pagination icon in the classpage
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table

  @ClassPageValidationTest_007
  Scenario: Validate the sort icon of all the field in datatable
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Sort icon of all the field in the datatable.

  @ClassPageValidationTest_008
  Scenario: Validating the Delete button under the Manage class
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Delete button under the Manage class page header.

  @ClassPageValidationTest_009
  Scenario: Validate the total no of classes in manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see Total no of classes in below of the data table.
