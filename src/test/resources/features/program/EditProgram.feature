@tag
Feature: Edit Program

  Background: 
    When Admin enter valid credentials and clicks login button
    Then Admin should land on dashboard page
    When Admin clicks "Program" on the navigation bar
    And Admin clicks on Edit option for particular program

  @tag35
  Scenario: Verify edit Status
    When Admin changes the status of the program and click on save button
    Then Status updated can be viewed by the Admin

  @tag36
  Scenario: Verify Admin is able to click Save
    When Admin click on save button
    Then Admin can see the updated program details

  @tag37
  Scenario: Verify Admin is able to click Cancel
    When Admin click on cancel button
    Then Admin can see the Program details form disappears

  @tag38
  Scenario: Verify edited Program details
    When Admin searches with newly updated Program Name
    Then Admin verifies that the details are correctly updated

  @tag39
  Scenario: Verify close the window with "X"
    When Admin Click on "X" button
    Then Admin can see program details form disappear
