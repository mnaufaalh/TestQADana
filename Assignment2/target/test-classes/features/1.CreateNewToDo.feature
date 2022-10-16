Feature: Create New To Do
  Scenario: The user create new to do
    Given Open application
    Given Click icon plus
    Given Write title
    Given Write description
    When Click icon check
    Then The new to do added to list successfully