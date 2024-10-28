@AddNewClass
Feature: LMS Portal Add New Class feature in ClassModule Page Functionality

  Background: Admin Is on the Manage class page after login
   	Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    When Admin should land on the home page
    When Admin enter valid credentials and clicks login button 
    When Admin should land on dashboard page
    When Admin clicks the Class Navigation bar in the Header
    
    
  @AddNewClassTest_001
  Scenario: Validate Class Details Popup window
    Given Admin is on the Manage class page
    When Admin clicks add new class under the class menu bar
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

  @AddNewClassTest_002
  Scenario: Validate input fields and their text boxes in Class details form
    Given Admin is on the Manage class page
    When Admin clicks add new class under the class menu bar
    Then Admin should see few input fields and their respective text boxes in the class details window
