@tag
Feature: Batch Page Navigation 

Scenario: Batch Login

 #Given Admin launch the browser
 When Admin enter valid credentials and clicks login button 
 Then Admin should land on dashboard page
 When Admin clicks "Batch" on the navigation bar
 
 import numpyninja.qa.lms.utils.LoggerLoad;