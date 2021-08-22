Feature: Deleting an existing employee

  @positive
  Scenario Outline: Validating the ability to delete an existing employee in an organization when valid employee id is provided
    When Siva requests to delete an employee with <id>
    Then he should be able to delete the employee successfully
    Examples:
      | id |
      | 1  |
      | 2  |

  @negative
  Scenario Outline: Validating the ability to restrict employee deletion in an organization when invalid employee id is provided
    When Siva requests to delete an employee with <id>
    Then he should be presented with an error
    Examples:
      | id    |
      | a     |
      | -1920 |
