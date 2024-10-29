Feature: Navigation Validation from Manage Class to other Pages

Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin should land on the home page
    When Admin enter valid credentials and clicks login button 
    When Admin should land on dashboard page
    When Admin clicks on Class Navigation bar
    Then Admin is on Manage Class page
   

    Scenario: Logout link on navigation bar
    When Admin clicks on Logout link on Manage class page
    Then Admin is re-directed to Login page

    Scenario: Class link to other Program on navigation bar
    When Admin clicks on Program link on Manage Class page
    Then Admin is re-directed to Manage Program
   
    Scenario: Class link to other Batch on navigation bar
    When Admin clicks on Batch link on Manage Class page
    Then Admin is re-directed to Manage Batch 
    
    Scenario: Validate Batch Name on Class Detail Pop up window
 #	   When Admin clicka add new class under the class menu bar
    Then Admin should see Class Name on Class Details page
