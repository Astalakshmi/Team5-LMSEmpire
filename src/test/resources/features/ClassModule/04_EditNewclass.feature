@EditNewclass
Feature: LMS Portal Edit New class feature in ClassModule Page Functionality

   Background: Admin is on the Manage Class page after login
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    When Admin should land on the home page
    When Admin enter valid credentials and clicks login button 
    When Admin should land on dashboard page
    When Admin clicks the Class Navigation bar in the Header
    When Admin is on the Manage class page
    

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
