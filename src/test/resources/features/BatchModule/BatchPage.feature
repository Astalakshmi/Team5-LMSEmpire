

Feature: Batch Page Navigation 

Background: Batch Login

 Given Admin is in login Page
 When Admin enter valid credentials and clicks login button 
 Then Admin should land on dashboard page and click on Batch module

   #Batch Page Navigation 

  Scenario: Verify Admin Navigate to Batch page successfully
    #Given Admin is on the Dashboard Page
    #When Admin Clicks on the Batch menu from the header 
    Then Admin should be in the Manage Batch Page
    
   #Batch Page Validation
  Scenario: Validate "Title" in Batch Page
    Then Admin should see the "LMS-Learning Management System" Title
    
    
   Scenario: Validate "heading" in the Batch Page
     Then Admin should see the "Manage Batch" Heading
    
   Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    Then Admin should see the disabled "Delete Icon" under the header
    
   Scenario: Validate pagination in the Batch Page
    Then Admin should see the enabled pagination controls under the data table
    
  Scenario: Validate edit icon in each data rows
    Then Admin should see the edit icon in each row
    
   Scenario: validate delete icon in each data rows
    Then Admin should see the delete icon in each row
    
  Scenario: validate checkbox in each data rows
    Then Admin should the checkbox in each row
    
  Scenario: Validate Datatable headers
    Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete
    
  Scenario: Validate "Checkbox" in the Datatable header row
    Then Admin should see the checkbox  in the datatable header row
    
  Scenario: Validate "sort icon" next to all the datatable header
    Then Admin should see the sort icon next to all Datatable headers
    
    #Add New Batch
    
  Scenario: Verify sub menu displayed in batch menu bar
    Then Admin should see sub menu in menu bar as "Add New Batch"
    
  Scenario: Validate Admin able to click on the Add new Batch Option
    When Admin clicks on "Add New batch" under the "batch" menu bar  
    Then Admin should see the Batch Details pop up window
    
    #Edit icon Validation
    
  Scenario: Validate Edit icon feature in any row
    When Admin clicks the edit icon    
    Then Admin should see the Batch details pop up window
    
  Scenario: Validate program name  value is disabled to edit
    When Admin clicks the edit icon 
    Then Admin should see Program name value field is disabled for editing
    
  Scenario: Validate batch name  value is disabled to edit	Admin is on the Batch page
    When Admin clicks the edit icon 
    Then Admin should see batch name value field is disabled for editing
    
  Scenario: Validate editing description and No. of classes fields with invalid data in the pop up
    Given Admin is on the Batch Details Page
    When Admin Updates any fields with invalid data and click save button
    Then Admin should get a error message under the respective field
    
   Scenario: validate save button in Batch details pop up
    Given Admin is on the Batch Details Page
    When Admin enters the valid data to all the mandatory fields and click save button 
    Then Admin should get a succesesful message for editing the batch
    
   Scenario: validate cancel button in Batch details pop up
    When Admin enters the valid data to all the mandatory fields and click cancel button 
    Then Admin can see the batch details popup closes without editing the batch
    
    
    #Pagination
       Scenario: validate last page link
    When Admin clicks last page link on the data table
    Then Admin should see the last page link with next page link disabled on the table 
    
          Scenario: validate the backward page link
    
    When Admin clicks backward page link on the data table
    Then Admin should see the previous page on the table
    
          Scenario: validate the first page link
   
    When Admin clicks first page link on the data table
    Then Admin should see the very first page on the data table
    
    #Search Text box validation
    
          Scenario: validate serach box functionality
   
    When Admin enters the batch name in the serach text box
    Then Admin should see the filtered batches in the data table
    
    #LogOut of the application from the batch page
    
            Scenario: Validate logout option in the header is visible and enabled from the batch page
    
    When Admin clicks on the logout button
    Then Admin should see the Login screen Page
    
    
    
    
    
    
    
    
    
    