Feature: Updating existing employee details

  @positive
  Scenario Outline: Validating the ability to update existing employee details in an organization
    When Aadhav requests to update <salary> of an employee who has an <id>
    Then he should be able to update the employee details successfully
    Examples:
      | id | salary |
      | 1  | 320800 |
      | 2  | 170750 |

