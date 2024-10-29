@logout
Feature: Validation on Logout button

	@SkipHooks
	Scenario: Verify logout function
		Given Admin is in dashboard page
		When Admin clicks on the logout in the menu bar
		Then Admin should be redirected to login page

	@SkipHooks
	Scenario: Verify back button function
		Given Admin is in login page
		When Admin clicks  browser back button
		Then Admin should receive error message