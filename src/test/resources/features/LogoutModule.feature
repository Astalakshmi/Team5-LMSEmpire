Feature: Validation on Logout button

Scenario: Verify logout function
Background Admin is logged into the appilcation
  Given Admin is in dashboard page
	When Admin clicks on the logout in the menu bar
	Then Admin should be redirected to login page

Scenario: Verify back button function 
Background Admin is logged out of the application
	Given Admin is in login page
	When Admin clicks  browser back button
	Then Admin should receive error message

