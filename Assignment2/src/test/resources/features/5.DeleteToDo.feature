Feature: Delete To Do
  Scenario: The user delete to do
    Given Choose task
    When Click delete task
    Then The task deleted success