@AddNewClass
Feature: LMS Portal Add New Class feature in ClassModule Page Functionality

  Background: Admin Is on the Manage class page after login
    Given The Admin is on the login page
    And The Admin enters the valid username and password "LoginCredentials"
    And The Admin Is on the Dashboard page after login
    And Admin Is on the Manage class page after login
    When Admin clicks add new class under the class menu bar

  @AddNewClassTest_001
  Scenario: Validate Class Details Popup window
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

  @AddNewClassTest_002
  Scenario: Validate input fields and their text boxes in Class details form
    Then Admin should see few input fields and their respective text boxes in the class details window
