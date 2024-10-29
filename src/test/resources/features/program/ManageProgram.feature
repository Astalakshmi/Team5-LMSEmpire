@tag
Feature: Manage Program Page

  Background: 
    When Admin enter valid credentials and clicks login button
    Then Admin should land on dashboard page
    When Admin clicks "Program" on the navigation bar

  @tag1
  Scenario: Verify that Admin is able to navigate to Program module
    Then Admin should be navigated to Program module

  @tag2
  Scenario: Verify any broken links on program page
    Then Admin should not have any broken links for Program module

  @tag3
  Scenario: Verify heading in menu bar
    Then Admin should see the heading "LMS - Learning Management System"

  @tag4
  Scenario: Verify other modules name displayed in menu bar
    Then Admin should see the module names as in order "Home Program Batch Class Admin Assignment Attendance"

  @tag5
  Scenario: Verify Logout displayed in menu bar
    Then Admin should see Logout in menu bar

  @tag6
  Scenario: Verify sub menu displayed in program menu bar
    Then Admin should see sub menu in menu bar as "Add New Program"

  @tag7
  Scenario: Verify subheading in manage program
    Then Admin should see the subheading "Manage Program"

  @tag8
  Scenario: Verify view details of programs
    Then Admin should able to see Program name, description, and status for each program

  @tag9
  Scenario: Verify the Multiple Delete button state
    Then Admin should see a Delete button in left top is disabled

  @tag10
  Scenario: Verify the Search button
    Then Admin should see Search bar with text as "Search..."

  @tag11
  Scenario: Verify column header name of data table
    Then Admin should see data table with column header on the Manage Program Page as  "Program Name, Program Description, Program Status, Edit/Delete"

  @tag12
  Scenario: Verify checkbox default state beside Program Name column header
    Then Admin should see checkbox default state as unchecked beside Program Name column header

  @tag13
  Scenario: Verify checkboxes default state beside each Program names in the data table
    Then Admin should see check box default state as unchecked on the left side in all rows against program name

  @tag14
  Scenario: Verify Sort icon in manage program
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  @tag15
  Scenario: Verify edit and delete icon in manage program
    Then Admin should see the Edit and Delete buttons on each row of the data table

  @tag16
  Scenario: Verify pagination icons below data table in manage program
    Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table

  @tag17
  Scenario: Verify footer message in manage program
    Then Admin should see the footer as In total there are z programs

  @tag28
  Scenario: Verify added Program is created
    When Admin searches with newly created "<Program Name>"
    Then Records of the newly created  "<Program Name>" is displayed and match the data entered
