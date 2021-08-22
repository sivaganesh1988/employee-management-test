Feature: Viewing employee(s) details

  @positive
  Scenario Outline: Validating the ability to view an existing employee in an organization
    When Kalai requests to view an employee details with <id>
    Then she should be able to view the employee details "<name>",<age>,<salary> and "<profilepic>" successfully
    Examples:
      | id | name            | age | salary | profilepic |
      | 1  | Tiger Nixon     | 61  | 320800 |            |
      | 2  | Garrett Winters | 63  | 170750 |            |


  @positive
  Scenario: Validating the ability to view all existing employee in an organization
    When Kalai requests to view employee details of all existing employees
    Then she should be able to view the complete employee list with details

