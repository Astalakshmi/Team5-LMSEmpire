@Login
Feature: User is able to navigate to Home Page and Login

	  Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Then Admin should land on the home page
		
		
  	Scenario: Validate login with valid credentials
    When Admin enter valid credentials and clicks login button 
    Then Admin should land on dashboard page
