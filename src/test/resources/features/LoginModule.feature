Feature: Login  Page Verification

	Scenario: Verify Admin is able to land on login page
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
		Then Admin should land on the login page
	
	Scenario: Verify Admin is able to land on home page with invalid URL
		Given Admin launch the browser
		When Admin gives the invalid LMS portal URL
		Then Admin should recieve 404 page not found error
	
	Scenario: Verify for broken link
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
		Then If HTTP response >= 400 Then the link is broken
	 
	Scenario: Verify the text spelling in the page 
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
		Then Admin should see correct spellings in all fields 
	
	Scenario: Verify the company logo
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should see logo on the left  side
	
	Scenario: Verify application name
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should see  LMS - Learning Management System
	
	Scenario: Verify company name
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should see company name below the app name
	
	Scenario: Validate sign in content
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should see "Please login to LMS application"
	
	Scenario: Verify text field is present
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should see two text field
	
	Scenario: Verify text on the first text field
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should "User" in the first text field
	
	Scenario: Verify asterik next to Admin text
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should see field mandatory (*) symbol next to Admin text
	
	Scenario: Verify text on the second text field
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should "Password" in the second text field
	
	Scenario: Verify asterik next to password text
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
			Then Admin should see * symbol next to password text
	
	Scenario: Verify the alignment input field for the login
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
		Then Admin should see input field on the centre of the page
   
	Scenario: Verify Login button is present
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
		Then Admin should see login button 
	
	Scenario: Verify the alignment of the login button
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
		Then Admin should see login button on the centre of the page
	
	Scenario: Verify input descriptive test in Admin field
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
		Then Admin should see Admin in gray color
	
	Scenario: Verify input descriptive test in password field
		Given Admin launch the browser
		When Admin gives the correct LMS portal URL
		Then Admin should see password in gray color	
	
	Scenario: Validate login with valid credentials
		Backgroud Admin gives the correct LMS portal URL
		Given Admin is in login Page
		When Admin enter valid credentials  and clicks login button 
		Then Admin should land on dashboard page  
	
	Scenario: Validate login with invalid credentials
	Backgroud Admin gives the correct LMS portal URL
		Given Admin is in login Page
		When Admin enter invalid credentials  and clicks login button 
		Then Error message please check Adminname/password
	
	Scenario: Validate login credentials with null Adminname
	Backgroud Admin gives the correct LMS portal URL
		Given Admin is in login Page
		When Admin enter value only in password and clicks login button 
		Then Error message please check Adminname/password
	
	Scenario: Validate login credentials with null password
	Backgroud Admin gives the correct LMS portal URL
		Given Admin is in login Page
		When Admin enter value only in Adminname and clicks login button 
		Then Error message please check Adminname/password
	
	Scenario: verify login button action through keyboard
	Backgroud Admin gives the correct LMS portal URL
		Given Admin is in login Page
		When Admin enter valid credentials  and clicks login button through keyboard
		Then Admin should land on dashboard page
	
	Scenario: verify login button action through mouse
	Backgroud Admin gives the correct LMS portal URL
		Given Admin is in login Page
		When Admin enter valid credentials  and clicks login button through mouse
		Then Admin should land on dashboard page