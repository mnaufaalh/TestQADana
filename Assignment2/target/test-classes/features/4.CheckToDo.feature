Feature: Check To Do
  Scenario: The user check to do
    Given Check task
    Given Click dropdown
    When click completed
    Then The to do checked successfully