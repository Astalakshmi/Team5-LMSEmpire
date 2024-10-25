@EditNewclass
Feature: LMS Portal Edit New class feature in ClassModule Page Functionality

  Background: Admin is on the Manage Class page after login
    Given The Admin is on the login page
    And The Admin enters the valid username and password "LoginCredentials"
    And The Admin Is on the Dashboard page after login
    And Admin Is on the Manage class page after login

  @EditNewclassTest_001
  Scenario: Validate row level edit icon
    When Admin clicks on the edit icon
    Then A new pop up with class details appears

  @EditNewclassTest_002
  Scenario: Check disabled  batch name
    When Admin clicks on the edit icon
    Then Admin should see batch name field is disabled

  @EditNewclassTest_003
  Scenario: Check disabled class topic
    When Admin clicks on the edit icon
    Then Admin should see class topic field is disabled
