@sortProgram
Feature: Search and sort Program

  Background: 
    When Admin enter valid credentials and clicks login button
    Then Admin should land on dashboard page
    When Admin clicks "Program" on the navigation bar

  @tag55
  Scenario: Verify sorting of Program name in Ascending order/Descending order
    When Admin clicks on Arrow next to program Name
    Then Admin Sees the Program Name is sorted in Ascending order/Descending order

  @tag56
  Scenario: Verify sorting of Program Description in Ascending order/Descending order
    When Admin clicks on Arrow next to Program Description
    Then Admin Sees the program Description is sorted in Ascending order/Descending order

  @tag57
  Scenario: Verify sorting of Program status in Ascending order/Descending order
    When Admin clicks on Arrow next to Program status
    Then Admin Sees the  Program Status is sorted in Ascending order/Descending order
