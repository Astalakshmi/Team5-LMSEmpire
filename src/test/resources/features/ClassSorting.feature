Feature: Class Page sorting

Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin should land on the home page
    When Admin enter valid credentials and clicks login button 
    When Admin should land on dashboard page
    When Admin clicks on Class Navigation bar
    Then Admin is on Manage Class page
  
 Scenario: Sort Class by Batch name

 When Admin clicks on the Batchname sort icon
 Then Admin should see Class details are sorted by Batch Name
 
 #Scenario:   
 #Given Sort Class by Class topic
 #When Admin clicks on the Class topic sort icon
 #Then Admin should see Class details are sorted by Class Topic
 
 #Scenario:   
 #Given 
 #When 
 #Then 
 #
 #Scenario:   
 #Given 
 #When 
 #Then 
 #
 #Scenario:   
 #Given 
 #When 
 #Then 
 #
 #Scenario:   
 #Given 
 #When 
 #Then 