@tag
Feature: Create new Program

  Background: 
    When Admin enter valid credentials and clicks login button
    Then Admin should land on dashboard page
    When Admin clicks "Program" on the navigation bar
    And Admin clicks on "New Program" under the "Program" menu bar

  @tag18
  Scenario: Verify add New Program
    Then Admin should see pop up window for program details

  @tag19
  Scenario: Verify add New Program
    Then Admin should see window title as "Program Details"

  @tag20
  Scenario: Verify mandatory fields with red "*" mark
    Then Admin should see red "*" mark beside mandatory field "Name"

  @tag21
  Scenario: Verify empty form submission
    When Admin clicks save button without entering mandatory fields from the sheet "Program_Data"
    Then Admin gets message field is required

  @tag22
  Scenario: Verify cancel button
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears

  @tag23
  Scenario: Verify enter program name
    When Admin enters the Name in the text box from the sheet "Program_Data"
    Then Admin can see the text entered

  @tag24
  Scenario: Verify enter description
    When Admin enters the Description in text box from the sheet "Program_Data"
    Then Admin can see the text entered in description box

  @tag25
  Scenario: Verify select Status
    When Admin selects the status of the program from the sheet "Program_Data" by clicking on the radio button "(Active/InActive)"
    Then Admin can see 'Active/Inactive' status selected

  @tag26
  Scenario: Verify Admin is able to save the program details
    When Admin enter valid details for mandatory fields from the sheet "Program_Data" and Click on save button
    Then Admin gets message "Successful Program created"

  @tag29
  Scenario: Verify close window with "X"
    When Admin Click on "X" button
    Then Admin can see Program Details form disappears
